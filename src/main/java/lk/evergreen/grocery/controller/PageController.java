package lk.evergreen.grocery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//According to MVC (Model-View-Controller) pattern
@Controller
public class PageController {

    // Route for the Landing Page (index.html)
    @GetMapping("/")
    public String home() {
        return "index"; // Looks for index.html in templates folder
    }

    // Route for the Login Page
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Route for the Admin Dashboard
    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "admin/admin-dashboard"; // Templates/admin/ folder
    }
}
