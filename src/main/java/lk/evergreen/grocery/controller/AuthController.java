package lk.evergreen.grocery.controller;

import lk.evergreen.grocery.entity.User;
import lk.evergreen.grocery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import lk.evergreen.grocery.entity.User;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        // Set a default role for new signups
        user.setRole("CUSTOMER");

        // Save the user using our service
        userService.saveUser(user);

        // After successful signup, send them to the login page
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            HttpSession session,
                            Model model) {

        // 1. Verify user with your service
        User user = userService.authenticate(email, password);

        if (user != null) {
            // 2. This is the critical part for Thymeleaf!
            // It saves the user object so ${session.loggedInUser} works.
            session.setAttribute("loggedInUser", user);
            return "redirect:/"; // Go back to home page
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login"; // Stay on login page if it fails
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Clears the session
        return "redirect:/login";
    }

}
