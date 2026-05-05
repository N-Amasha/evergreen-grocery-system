package lk.evergreen.grocery.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import lk.evergreen.grocery.entity.User;
import lk.evergreen.grocery.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

<<<<<<< Updated upstream
    @PostMapping
    public User register(@RequestBody User user) {
        return service.register(user);
=======
    @GetMapping("/profile")
    public String showProfilePage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) {
            // If no one is logged in, send them to login instead of crashing
            return "redirect:/login";
        }
        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("/profile/update")
    public String updateProfile(@ModelAttribute("user") User user, HttpSession session) {
        userService.updateUserProfile(user);
        // Update the session so the UI reflects the new name immediately
        session.setAttribute("loggedInUser", user);
        return "redirect:/profile?success";
>>>>>>> Stashed changes
    }

    @GetMapping
    public List<User> getUsers() {
        return service.getAllUsers();
    }
}
