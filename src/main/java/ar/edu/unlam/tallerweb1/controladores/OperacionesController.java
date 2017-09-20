package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OperacionesController {
	
	@RequestMapping("{operacion}/{operando1}/{operando2}")
	public ModelAndView sumar(	@PathVariable("operacion") String operacion, 
								@PathVariable("operando1") Double operando1, 
								@PathVariable("operando2") Double operando2){
		
			if(operacion.equals("sumar")){
				Double resultado = operando1 + operando2;
				ModelMap modelo = new ModelMap();
				modelo.put("resultado", resultado);
				return new ModelAndView("operaciones", modelo);
			}else if(operacion.equals("restar")){
				Double resultado = operando1 - operando2;
				ModelMap modelo = new ModelMap();
				modelo.put("resultado", resultado);
				return new ModelAndView("operaciones", modelo);
			}else{
				return new ModelAndView("error");
			}
	}
}
