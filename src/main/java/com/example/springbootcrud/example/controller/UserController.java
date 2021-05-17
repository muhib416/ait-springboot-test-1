package com.example.springbootcrud.example.controller;

import com.example.springbootcrud.example.entity.User;
import com.example.springbootcrud.example.entity.UserDummy;
import com.example.springbootcrud.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/add")
    public String submitForm(@ModelAttribute("user") UserDummy user) {
        User users = new User();
        users.setName(user.getName());
        users.setHp(user.getHp());
        users.setEmail(user.getEmail());

        System.out.println(user.getName());
        String listString = "";

        for (String s : user.getAlamat())
        {
            listString += s + "\t";
        }

        users.setAlamat(listString);
        userService.saveUser(users);

        return "";
    }

    @GetMapping("/user/list")
    public String showUser(Model model) {
        User user = new User();
        List<User> listUser = new ArrayList<User>();
        listUser = userService.getUser();

        if (listUser == null || listUser.size() ==  0) {
            return "";
        }
        else {
            model.addAttribute("user", user);
            model.addAttribute("users", listUser);
            return "";
        }
    }

    @PostMapping("/user/find")
    public String submitSearchUser(@ModelAttribute("user") User user, Model model) {
        List<User> listUser = new ArrayList<User>();
        listUser =  userService.getUserByName(user.getName());

        if (user.getName() == null || user.getName().equals("") ) {
            model.addAttribute("users", userService.getUser());
        }
        else  {
            model.addAttribute("users",listUser);
        }

        return "";
    }

}
