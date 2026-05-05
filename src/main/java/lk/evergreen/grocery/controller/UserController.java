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

}
