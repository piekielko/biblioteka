package pl.altkom.magazyn.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.altkom.magazyn.dao.MagazynDao;
import pl.altkom.magazyn.model.Towar;

@Controller
public class MagazynController {

	@Autowired
	private MagazynDao md;
	
	@RequestMapping(value = "/magazyn", method = RequestMethod.GET)
	public String magazyn(Locale locale, Model model) {
		
		md.addTowar(new Towar(0,"Buty","Letnie",200.0,30,"Obuwie"));
		model.addAttribute("magazyn", md.getAllSortedTowar(0, ""));
		
		return "magazyn";
	}
	
}
