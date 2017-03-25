package com.hexstudio;

import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

@Controller
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView user() {
		return new ModelAndView("login", "command", new UserInfo());
	}

	@RequestMapping(value = "/loginresult", method = RequestMethod.POST)
	public String showResult(@ModelAttribute("HEXStudio") UserInfo user, ModelMap model) {
		String userName = user.getUsername();
		String password = user.getPassword();
		String loginresult = "login fail!";
		if(userName.equals("bla") && password.equals("bla")) {
			loginresult = "login success!";
		}
		model.addAttribute("loginresult", loginresult);
		return "loginresult";
	}
	/*
	 * public String user() { return "login";//new ModelAndView("login",
	 * "command", new User()); }
	 */
}