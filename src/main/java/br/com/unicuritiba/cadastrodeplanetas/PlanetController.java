package br.com.unicuritiba.cadastrodeplanetas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.unicuritiba.cadastrodeplanetas.models.Planet;
import br.com.unicuritiba.cadastrodeplanetas.repositories.PlanetRepository;

@Controller
public class PlanetController {
	
	@Autowired
	private PlanetRepository repository;
	
	@GetMapping("/")
	public ModelAndView home() {
		
			List<Planet> planets = repository.findAll();

			ModelAndView view = new ModelAndView("index");
			view.addObject("planets", planets);
		
			return view;
		
	}
	
	@GetMapping("/cadastro")
	public ModelAndView create() {
		
			ModelAndView view = new ModelAndView("create");
			view.addObject("planet", new Planet());
			
			return view;
	}
	
	@PostMapping("/cadastro") 
		
	public String createPlanet(
			Planet planet,
			Model model,
			BindingResult result) { 
		
		repository.save(planet);
		
		return "redirect:/";
	}

	
}
