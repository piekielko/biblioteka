package pl.altkom.biblioteka.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.altkom.biblioteka.dao.BibliotekaDao;
import pl.altkom.biblioteka.model.Ksiazka;

@Controller
public class BibliotekaController {

	@Autowired
	private BibliotekaDao md;

	@RequestMapping(value = "/biblioteka", method = RequestMethod.GET)
	public String magazyn(Locale locale, Model model, HttpServletRequest request) {
		boolean zmiana = false;
		int id = 0;
		int atrybut = 0;
		String wyrazenie = "";
		
		if (request.getParameter("filter") != null) {
			System.out.println(request.getParameter("wyrazenie"));
			atrybut = Integer.parseInt(request.getParameter("kategoria"));
			wyrazenie = request.getParameter("wyrazenie");
		}
		
		if ((request.getParameter("sort") != null)) {
			md.setSort(Integer.parseInt(request.getParameter("sort")));
		}

		if ((request.getParameter("id") != null)
				&& (request.getParameter("action") != null)) {
			if (request.getParameter("action").equals("delete")) {
				md.removeKsiazka(Integer.parseInt(request.getParameter("id")));
			}
			if (request.getParameter("action").equals("update")) {
				zmiana = true;
				id = Integer.parseInt(request.getParameter("id"));
				model.addAttribute("ksiazka", md.getKsiazka(id));
			}
		}

		// md.addKsiazka(new Ksiazka(0,"Buty","Letnie",200.0,30,"Obuwie"));
		model.addAttribute("biblioteka", md.getAllSortedKsiazka(atrybut, wyrazenie));
		model.addAttribute(new Ksiazka());
		return "biblioteka";
	}

	@RequestMapping(value = "/biblioteka", method = RequestMethod.POST)
	public String bibliotekaDodaj(Locale locale, @ModelAttribute Ksiazka ksiazka,
			Model model) {

		md.addKsiazka(ksiazka);
		model.addAttribute("biblioteka", md.getAllSortedKsiazka(0, ""));
		model.addAttribute(new Ksiazka());
		return "biblioteka";
	}

	@RequestMapping(value = "/bibliotekazmien", method = RequestMethod.GET)
	public String bibliotekaDodaj(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		model.addAttribute(md.getKsiazka(id));
		return "bibliotekazmien";
	}

	@RequestMapping(value = "/bibliotekazmien", method = RequestMethod.POST)
	public String bibliotekaDodaj(@ModelAttribute Ksiazka ksiazka, Model model) {
		md.updateKsiazka(ksiazka);
		model.addAttribute(new Ksiazka());
		model.addAttribute("biblioteka", md.getAllSortedKsiazka(0, ""));
		model.addAttribute(new Ksiazka());
		return "biblioteka";
	}

}
