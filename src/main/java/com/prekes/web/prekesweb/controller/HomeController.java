package com.prekes.web.prekesweb.controller;

import com.prekes.web.prekesweb.model.Item;
import com.prekes.web.prekesweb.model.Role;
import com.prekes.web.prekesweb.model.User;
import com.prekes.web.prekesweb.model.UserRole;
import com.prekes.web.prekesweb.security.jwt.JwtUtils;
import com.prekes.web.prekesweb.security.services.UserDetailsImpl;
import com.prekes.web.prekesweb.service.ItemService;
import com.prekes.web.prekesweb.service.RoleService;
import com.prekes.web.prekesweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private ItemService itemService;

    @GetMapping("/home")
    public String showHomePage(ModelMap model) {
        checkCurrentUser(model);
        List<Item> items = itemService.findAll();
        model.put("itemsList", items);
        return "home";
    }

    @GetMapping("/home/{filterName}")
    public String showHomePageWithFilter(ModelMap model, @PathVariable String filterName) {
        checkCurrentUser(model);
        List<Item> items = itemService.findAll();

        items = items.stream()
                .filter(item -> item.category.equals(filterName))
                .collect(Collectors.toList());

        model.put("filteredItemsList", items);
        return "home";
    }

    @GetMapping("/login")
    public String showLoginPage(ModelMap model) {
        User user = new User();
        user.setId(new Random().nextLong());
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/login")
    public String userLogin(ModelMap model, @ModelAttribute("user") User user, BindingResult result, HttpServletResponse response) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        response.addCookie(new Cookie(jwtCookie.getName(), jwtCookie.getValue()));

        return "redirect:/home";
    }

    @GetMapping("/signup")
    public String showSignUpPage(ModelMap model) {
        User user = new User();
        user.setId(new Random().nextLong());
        model.addAttribute("user", user);
        return "signup";
    }

    @PostMapping("/signup")
    public String userSignup(ModelMap model, @ModelAttribute("user") User userModel, BindingResult result, HttpServletResponse response) {
        if (userService.existsByUsername(userModel.getUsername())) {
            return "redirect:/error";
        }

        if (userService.existsByEmail(userModel.getEmail())) {
            return "redirect:/error";
        }

        // Create new user's account
        User user = new User(userModel.getUsername(),
                userModel.getEmail(),
                encoder.encode(userModel.getPassword()));

        Set<String> strRoles = userModel.getRoles().stream().map(c -> c.getName().toString()).collect(Collectors.toSet());
        Set<Role> roles = new HashSet<>();

        if (strRoles.isEmpty()) {
            Role userRole = roleService.findByName(UserRole.USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                if ("admin".equals(role)) {
                    Role adminRole = roleService.findByName(UserRole.ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(adminRole);
                } else {
                    Role userRole = roleService.findByName(UserRole.USER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userService.add(user);

        return "redirect:/home";
    }

    @GetMapping("/signout")
    public String logoutUser(ModelMap model, HttpServletResponse response) {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        response.addCookie(new Cookie(cookie.getName(), cookie.getValue()));

        return "redirect:/home";
    }

    public static void checkCurrentUser(ModelMap model) {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user instanceof UserDetailsImpl && ((UserDetailsImpl) user).getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
            model.addAttribute("role", "admin");
            model.addAttribute("username", ((UserDetailsImpl) user).getUsername());
        } else if (user instanceof UserDetailsImpl && ((UserDetailsImpl) user).getAuthorities().contains(new SimpleGrantedAuthority("USER"))) {
            model.addAttribute("role", "user");
            model.addAttribute("username", ((UserDetailsImpl) user).getUsername());
        }
    }
}
