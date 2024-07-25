package com.example.app.auth.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.auth.service.AuthService;
import com.example.app.user.dto.UserInfoVO;

@Controller
@RequestMapping(value="/login")
public class AuthController {

  private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);
	
	// private static String WEB_PRIFIX_URL = "web/login";
  @Autowired
  private AuthService authService;
  
	@RequestMapping(value="/signUpPage")
	public ModelAndView signUp() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("templates/login/register");

		return mv;
	}

	@RequestMapping(value="/signUp")
	public ModelAndView signUp(ModelAndView mv,UserInfoVO userInfo, RedirectAttributes redirectAttributes,HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {

		}catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

}
