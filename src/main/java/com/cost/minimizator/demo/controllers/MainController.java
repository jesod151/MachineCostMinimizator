package com.cost.minimizator.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class MainController {

    @RequestMapping("/hello")
	public String heloWorld() {
		return "Hello world!";
	}

}
