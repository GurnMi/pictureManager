package com.dgit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dgit.service.MemberService;

@Controller
@RequestMapping("/member/*")	
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService service;
	
	@RequestMapping("/home")
	public String home(){
		logger.info("home");
		return "/member/home";
	}
	
	@RequestMapping("/join")
	public String join(){
		logger.info("join");
		return "/member/join";
	}
	
}
