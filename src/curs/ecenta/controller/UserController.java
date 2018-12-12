package curs.ecenta.controller;

import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	//se apeleaza cand actionam linkul de login si ne va returna pagina login.jsp
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	  public String show(Model model) {
	    model.addAttribute("msg", "Please Enter Your Login Details");
	    return "login";
	  }
	
	//se apeleaza cand se actioneaza butonul de Submit de pe pagina de login
	  @POST
	  @RequestMapping(value = "/login")
	  public String submit(Model model, @FormParam("userName") String userName, @FormParam("password") String password) {
		
		UserBean loginUser = new UserBean();
		loginUser.setUsername(userName);
		loginUser.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		String firstName = userDAO.getLoginUser(loginUser);
		if(firstName == null) {
			model.addAttribute("error", " User or password incorrect.");
			return "login";
		}
		else {
			model.addAttribute("msg", " You have successfully logged in.");
			model.addAttribute("firstName", firstName);
			return "succes";
		}
	  }

}
