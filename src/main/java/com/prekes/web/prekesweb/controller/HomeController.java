package com.prekes.web.prekesweb.controller;

import com.prekes.web.prekesweb.model.Item;
import com.prekes.web.prekesweb.model.Role;
import com.prekes.web.prekesweb.model.User;
import com.prekes.web.prekesweb.model.UserRole;
import com.prekes.web.prekesweb.payload.response.MessageResponse;
import com.prekes.web.prekesweb.payload.response.UserInfoResponse;
import com.prekes.web.prekesweb.repository.RoleRepository;
import com.prekes.web.prekesweb.repository.UserRepository;
import com.prekes.web.prekesweb.security.jwt.JwtUtils;
import com.prekes.web.prekesweb.security.services.UserDetailsImpl;
import com.prekes.web.prekesweb.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    private ItemService itemService;

    @GetMapping("/home")
    public String showHomePage(ModelMap model) {
        List<Item> items = itemService.findAll();
        model.put("itemsList", items);
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
        if (userRepository.existsByUsername(userModel.getUsername())) {
            return "redirect:/error";
        }

        if (userRepository.existsByEmail(userModel.getEmail())) {
            return "redirect:/error";
        }

        // Create new user's account
        User user = new User(userModel.getUsername(),
                userModel.getEmail(),
                encoder.encode(userModel.getPassword()));

        Set<String> strRoles = userModel.getRoles().stream().map(c -> c.getName().toString()).collect(Collectors.toSet());
        Set<Role> roles = new HashSet<>();

        if (strRoles.isEmpty()) {
            Role userRole = roleRepository.findByName(UserRole.USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                if ("admin".equals(role)) {
                    Role adminRole = roleRepository.findByName(UserRole.ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(adminRole);
                } else {
                    Role userRole = roleRepository.findByName(UserRole.USER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return "redirect:/home";
    }

    //todo: implement this view
    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser(HttpServletResponse response) {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        response.addCookie(new Cookie(cookie.getName(), cookie.getValue()));
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse("You've been signed out!"));
    }
}
