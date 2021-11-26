package com.example.demo.Result;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "springbot")
public class ResultController {

	private final ResultService rService;

	@Autowired
	public ResultController(ResultService rService) {
		this.rService = rService;
	}
	
    @GetMapping(path = "{precision}/{price}")
    List<Result> getMembers(@PathVariable("precision") String precision, @PathVariable("price") double price ){
        return rService.getResult(precision, price);
    }
}
