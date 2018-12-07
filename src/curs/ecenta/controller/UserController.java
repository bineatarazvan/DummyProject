package curs.ecenta.controller;

import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import curs.ecenta.beans.UserBean;
import curs.ecenta.dao.UserDAO;
import curs.ecenta.interfaces.Human;

@Controller
public class UserController {

	@RequestMapping("/")
	public String showHelloPage() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Human userBean = context.getBean("userBean", Human.class);
		System.out.println(userBean.getBehavior());
		return "userPage";

	}
	@RequestMapping("/showUsers")
	public String showUsers(Model model) {
		UserDAO userDAO = new UserDAO();
		ArrayList<UserBean> users = userDAO.GetUsers();
		model.addAttribute("users", users);
		return "usersList";

	}
	@RequestMapping("/showPassword")
	public String showPassword(Model model) {
		UserDAO userDAO = new UserDAO();
		ArrayList<UserBean> users = userDAO.GetUsers();
		model.addAttribute("users", users);
		return "usersList2";

	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	  public String show(Model model) {
	    model.addAttribute("msg", "Please Enter Your Login Details");
	    return "login";
	  }
	
	  @RequestMapping(value = "/login", method = RequestMethod.POST)
	  public String init(Model model) {
	    model.addAttribute("msg", "Please Enter Your Login Details");
	    return "login";
	  }

}
