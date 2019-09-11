package org.swufefic.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.swufefic.domain.User;
import org.swufefic.domain.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String create(@RequestBody User user) {
        userRepository.save(user);
        return "SUCCESS";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable Long id) {
        User user = userRepository.getOne(id);
        return user;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public User getUserByName(@PathVariable String name) {
        User user = userRepository.findByName(name);
        return user;
    }
}
