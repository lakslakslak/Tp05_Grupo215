package ar.edu.unju.fi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.DTO.DocenteDTO;
import ar.edu.unju.fi.service.*;


@Controller
public class DocenteController {
	
	@Autowired
	DocenteDTO nuevoDocenteDTO;
	
	@Autowired
	DocenteService docenteService;
	
	@GetMapping ("/formularioDocente")
	public ModelAndView getFormDocente() {
		//vista formCarrera.html
		ModelAndView modelView = new ModelAndView("formDocente");
		//Agrega el Objeto
		modelView.addObject("nuevoDocente", nuevoDocenteDTO);
		modelView.addObject("band", false);
		return modelView;
	}
	
	@PostMapping("/guardarDocente")
	public ModelAndView saveDocente(@ModelAttribute("nuevoDocente") DocenteDTO docenteParaGuardar) {
		
		//guardar el docente en la lista
		
		//ListadoDocentes.agregarDocente(docenteParaGuardar);
		docenteService.guardarDocente(docenteParaGuardar);
		//Mostrar Listado
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		//modelView.addObject("listadoDocentes" , ListadoDocentes.listarDocentes());
		modelView.addObject("listadoDocentes", docenteService.mostrarDocentes());
		
		return modelView;
	}
	
	@GetMapping("/eliminarDocente/{legajo}")
	public ModelAndView deleteDocenteDelListado(@PathVariable(name="legajo") String legajo) {
		//borrar
		//ListadoDocentes.eliminarDocente(legajo);
		System.out.println("este es el legajo: "+legajo);
		docenteService.borrarDocente(legajo);
		
		//mostrar el nuevo listado
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		modelView.addObject("listadoDocentes", docenteService.mostrarDocentes());	
		
		return modelView;		
		}
	
	@GetMapping("/modificarDocente/{legajo}")
	public ModelAndView editDocente(@PathVariable(name="legajo") String legajo) {
		//buscar
		
		DocenteDTO docenteParaModificar =  docenteService.buscarDocente(legajo);
		
		//mostrar el nuevo formulario
		ModelAndView modelView = new ModelAndView("formDocente");
		modelView.addObject("nuevoDocente", docenteParaModificar);	
		modelView.addObject("band", true);
		return modelView;		
		}
	
	@PostMapping("/modificarDocente")
	public ModelAndView updateDocente(@ModelAttribute("nuevoDocente") DocenteDTO docenteModificada) {
					
		//guardar
		docenteService.modificarDocente(docenteModificada);
		docenteModificada.setEstado(true);
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		modelView.addObject("listadoDocentes", docenteService.mostrarDocentes());	
		
		return modelView;		
	}
}