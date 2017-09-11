package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PrimerEjemploController {
	
	@RequestMapping ("/mi-primera-vista") 
	public ModelAndView irAMiVista(){
		return new ModelAndView ("PrimeraVista");
	}
	
	@RequestMapping("/mi-segunda-vista")
	public ModelAndView mostrarNombre() {
		ModelMap modelo = new ModelMap();
		//El nombre lo estamos seteando a mano
		modelo.put("nombre", "Morita");
		return new ModelAndView ("PrimeraVista", modelo);
		
	}
	
	@RequestMapping("/listar-nombres")
	public ModelAndView mostrarLista() {
		ModelMap modelo = new ModelMap();
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Morita");
		lista.add("Homero");
		lista.add("Alex");
		lista.add("Vause");
		modelo.put("listar", lista);
		return new ModelAndView("Lista",modelo);
	}

}
