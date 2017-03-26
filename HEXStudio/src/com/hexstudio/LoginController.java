package com.hexstudio;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView user(@RequestParam(value="url", required=false) String url, ModelMap model) {
		model.addAttribute("url", url);
		System.out.println("before login: "+ url);
		return new ModelAndView("login", "command", new UserInfo());
	}

	@RequestMapping(value = "/loginoutresult", method = RequestMethod.POST)
	public String loginResult(@ModelAttribute("HEXStudio") UserInfo user, ModelMap model, HttpServletRequest request) {
		String userName = user.getUsername();
		String password = user.getPassword();
		
		String url = request.getParameter("url");
		System.out.println("url: " + url);
		
		String loginresult = "login fail!";
		if(userName.equals("bla") && password.equals("bla")) {
			GlobalVariableObject instance = GlobalVariableObject.getInstance();
			instance.setCurrentUser("bla");
			loginresult = "login success!";
		} else {
			url = "/login?url="+url;
		}
		
		model.addAttribute("url", url);
		model.addAttribute("loginoutresult", loginresult);
		return "loginoutresult";
	}
	
	@RequestMapping(value = "/loginoutresult", method = RequestMethod.GET)
	public String logoutResult(ModelMap model, HttpServletRequest request) {
		String url = request.getParameter("url");
		
		GlobalVariableObject instance = GlobalVariableObject.getInstance();
		instance.setCurrentUser(null);
		String logoutresult = "logout success!";
		
		model.addAttribute("url", url);
		model.addAttribute("loginoutresult", logoutresult);
		return "loginoutresult";
	}
	/*
	 * public String user() { return "login";//new ModelAndView("login",
	 * "command", new User()); }
	 */
}