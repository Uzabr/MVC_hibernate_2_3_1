package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUsers(ModelMap map) {
        map.addAttribute("users", new User());
        map.addAttribute("userslist", userService.getAllUsers());
        return "users";
    }

    @PostMapping(value = "/add")
    public String addUsers(@ModelAttribute("users") User users) {
        userService.addUsers(users);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String showUpdateUsers(@ModelAttribute("users") User users) {
        userService.updateUsers(users);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String updateUsers(ModelMap map, @PathVariable("id") long id) {
        map.addAttribute("users", userService.getUsersById(id));
        return "updateUsers";
    }

    @PostMapping("/remove/{id}")
    public String removeUsers(@PathVariable("id") long id) {
        userService.removeUsers(id);
        return "redirect:/";
    }

}
