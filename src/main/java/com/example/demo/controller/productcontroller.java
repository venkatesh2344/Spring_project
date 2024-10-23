package com.example.demo.controller;

import com.example.demo.Model.Student;
import com.example.demo.Model.products;
import com.example.demo.ProductRepostry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class productcontroller {
    @Autowired
    private ProductRepostry productRepostry;


    @PostMapping("/")
    public products createUser(@RequestBody products user) {
        return productRepostry.save(user);
    }
    @GetMapping("/")
    public @ResponseBody Iterable<products> getStudents(){
        return productRepostry.findAll();
    }
}
