package com.test.controller;
import com.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.test.service.UserService;

import java.util.Date;
import java.util.Map;

/**
 * Created by NotePad on 14.11.2015.
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

        /*@RequestMapping(value = { "/", "/listUsers" })
         public String listUsers(Map<String, Object> map) {

        map.put("user", new User());

        map.put("userList", userService.listUsers());

        return "/user/listUsers";
        }*/

    @RequestMapping("/get/{userId}")
    public String getUser(@PathVariable int userId, Map<String, Object> map) {

        User user = userService.getUser(userId);

        map.put("user", user);

        return "/user/userForm";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user, Map<String, Object> map) {

        if (user.getAge() <= 0 || user.getAge() > 120){
            map.put("errorMessage", "Invalid age!");

            return "/user/error";
        }
        if (user.getCreatedDate().after(new Date())){
            map.put("errorMessage", "Invalid date!");

            return "/user/error";
        }
        userService.saveUser(user);

              /*
               * Note that there is no slash "/" right after "redirect:"
               * So, it redirects to the path relative to the current path
               */
        return "redirect:listUsers";
    }

    @RequestMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId") int id) {

        userService.deleteUser(id);

              /*
               * redirects to the path relative to the current path
               */
        // return "redirect:../listUsers";

              /*
               * Note that there is the slash "/" right after "redirect:"
               * So, it redirects to the path relative to the project root path
               */
        return "redirect:/user/listUsers";
    }
    @RequestMapping(value = { "/", "/listUsers" })
    public String listUsersPaging(Map<String, Object> map, Integer offset, Integer maxResults, @RequestParam(required = false) String name) {

        map.put("user", new User());
        if (name == null) {
            map.put("userListPaging", userService.listUsersPaging(offset, maxResults));
            map.put("count", userService.count());
            map.put("offset", offset);
        }
        else{
            map.put("userListPaging", userService.listUsersFilter(name));
        }

        return "/user/listUsers";
    }

    /*@RequestMapping(value = "/filter", method = RequestMethod.POST)
    public String listUsersFilter(Map<String, Object> map, String name) {
        name = "Olga";
        map.put("user", new User());
        return "redirect:listUsers";
    }*/
}
