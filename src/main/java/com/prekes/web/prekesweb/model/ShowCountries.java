package com.prekes.web.prekesweb.model;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/register")
public class ShowCountries extends HttpServlet {

    public ShowCountries() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String[] countryCodes = Locale.getISOCountries();

        Map<String, String> mapCountries = new TreeMap<>();

        for (String countryCode : countryCodes) {
            Locale locale = new Locale("", countryCode);
            String code = locale.getCountry();
            String name = locale.getDisplayCountry();
            mapCountries.put(code, name);
        }

        request.setAttribute("mapCountries", mapCountries);

        String registerForm = "frontend/register_form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(registerForm);
        dispatcher.forward(request, response);

    }


}
