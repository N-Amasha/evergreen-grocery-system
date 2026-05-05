package lk.evergreen.grocery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import lk.evergreen.grocery.entity.User;

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

    @GetMapping("/signup")
    public String showSignupPage(Model model) {
        model.addAttribute("user", new User()); // This creates the "user" object for the form
        return "signup";
    }

    @GetMapping("/index")
    public String showHomePage() {
        return "index";
    }


}
