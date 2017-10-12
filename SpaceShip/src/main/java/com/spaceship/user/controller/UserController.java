package com.spaceship.user.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spaceship.user.domain.UserVO;
import com.spaceship.user.dto.LoginDTO;
import com.spaceship.user.service.UserService;

@Controller
@RequestMapping("/user/*")
public class UserController {
	
	private static final Logger logger =
			LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private UserService service;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto) {

	}
	
	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception {
		UserVO vo = service.login(dto);
		
		if (vo == null) {
			return;
		}
		
		model.addAttribute("userVO", vo);
	}
	
	@RequestMapping(value = "/userModify", method = RequestMethod.GET)
	public void userModifyGET(@ModelAttribute("vo") UserVO vo) throws Exception {
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/userModify/{uid}", method = RequestMethod.PUT)
	public int userModify(@PathVariable("uid") String uid, @RequestBody UserVO vo) throws Exception {
		return service.updateUser(vo);
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		Object obj = session.getAttribute("login");
		
		if (obj != null) {
			UserVO vo = (UserVO) obj;
			
			session.removeAttribute("login");
			session.invalidate();
		}
		
		return "redirect:/user/login";
	}
	
	@ResponseBody
	@RequestMapping("/duplCheck")
	public UserVO duplCheck(UserVO vo) throws Exception{
		System.out.println("컨트롤러 duplCheck");
		vo = service.duplcheck(vo);
		System.out.println(vo);
		return vo;
	}
	
	@ResponseBody
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public int addUser(UserVO vo)throws Exception{
		return service.insertUser(vo);
	}

}
