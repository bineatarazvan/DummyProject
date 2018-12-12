package curs.ecenta.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import curs.ecenta.beans.ProdusBean;
import curs.ecenta.dao.ProdusDAO;

@Controller
public class ProdusController {
	@RequestMapping("/showProducts")
	public String show(Model model) {
		ProdusDAO produsDAO = new ProdusDAO();
		ArrayList<ProdusBean> pro = produsDAO.GetProducts();
		model.addAttribute("produse", pro);
		return "produseList";

}
}

