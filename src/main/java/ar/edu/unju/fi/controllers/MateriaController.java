package ar.edu.unju.fi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.service.MateriaService;
import ar.edu.unju.fi.DTO.MateriaDTO;


@Controller
public class MateriaController {
	
	@Autowired
	Materia nuevaMateria;
	
	@Autowired
	MateriaService materiaService;
	
	@GetMapping("/formularioMateria")
	public ModelAndView getFormMateria() {
		ModelAndView modelView = new ModelAndView("formMateria");
		modelView.addObject("nuevaMateria", nuevaMateria);	
		modelView.addObject("band", false);
		return modelView;
	}

    @PostMapping("/guardarMateria")
	public ModelAndView saveMateria(@ModelAttribute("nuevaMateria") MateriaDTO materiaParaGuardar) {

		materiaService.guardarMateria(materiaParaGuardar);

		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		modelView.addObject("listadoMateria", materiaService.mostrarMateria());

		return modelView;		
	}
    
	@GetMapping("/borrarMateria/{codigo}")
	public ModelAndView deleteMateriaDelListado(@PathVariable(name="codigo") String codigo) {
		System.out.println("este es el codigo: "+codigo);
		materiaService.borrarMateria(codigo);
		
		//mostrar el nuevo listado
		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		modelView.addObject("listadoMateria", materiaService.mostrarMateria());	
		
		return modelView;		
		}
	
	@GetMapping("/modificarMateria/{codigo}")
	public ModelAndView editMateria(@PathVariable(name="codigo") String codigo) {
		//buscar
		
		MateriaDTO materiaParaModificar =  materiaService.buscarMateria(codigo);
		
		//mostrar el nuevo formulario
		ModelAndView modelView = new ModelAndView("formMateria");
		modelView.addObject("nuevaMateria", materiaParaModificar);	
		modelView.addObject("band", true);
		return modelView;		
		}
	
	@PostMapping("/modificarMateria")
	public ModelAndView updateMateria(@ModelAttribute("nuevaMateria") MateriaDTO materiaModificada) {
					
		materiaService.modificarMateria(materiaModificada);
		materiaModificada.setEstado(true);
		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		modelView.addObject("listadoMateria", materiaService.mostrarMateria());	
		
		return modelView;		
	}
}