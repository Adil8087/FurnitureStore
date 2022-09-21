package com.OnWeb.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OnWeb.demo.service.ICartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private ICartService cartService;
	

}
