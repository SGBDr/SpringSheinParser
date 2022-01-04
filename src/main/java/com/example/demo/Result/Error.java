package com.example.demo.Result;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "oo")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Error {
    @GetMapping(path = "mod/4")
    String Get() {
    	return "Well Good";
    }
}
