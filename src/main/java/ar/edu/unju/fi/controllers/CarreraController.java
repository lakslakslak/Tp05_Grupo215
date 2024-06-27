package ar.edu.unju.fi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.DTO.CarreraDTO;
import ar.edu.unju.fi.repository.CarreraRepository;
import ar.edu.unju.fi.service.CarreraService;

@Controller
public class CarreraController {
	
	@Autowired
	CarreraDTO nuevaCarreraDTO;
	
	@Autowired
	CarreraService carreraService;
	
	@GetMapping("/formularioCarrera")
	public ModelAndView getFormCarrera() {
		//vista formCarrera.html
		ModelAndView modelView = new ModelAndView("formCarrera");
		//agrega el objeto
		//nuevaCarrera.setNombre("Ingenieria");
		modelView.addObject("nuevaCarrera", nuevaCarreraDTO );	
		modelView.addObject("band", false);
		return modelView;
	}
	
	@PostMapping("/guardarCarrera")
	public ModelAndView saveCarrera(@ModelAttribute("nuevaCarrera") CarreraDTO carreraParaGuardar) {
					
		//guardar
		//ListadoCarreras.agregarCarrera(carreraParaGuardar);
		carreraService.guardarCarrera(carreraParaGuardar);
		
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		//modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());	
		modelView.addObject("listadoCarreras", carreraService.mostrarCarreras());
		
		return modelView;		
	}
	
	@GetMapping("/borrarCarrera/{codigo}")
	public ModelAndView deleteCarreraDelListado(@PathVariable(name="codigo") String codigo) {
		//borrar
		//ListadoCarreras.eliminarCarrera(codigo);
		System.out.println("este es el codigo: "+codigo);
		carreraService.borrarCarrera(codigo);
		
		//mostrar el nuevo listado
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoCarreras", carreraService.mostrarCarreras());	
		
		return modelView;		
		}
	
	@GetMapping("/modificarCarrera/{codigo}")
	public ModelAndView editCarrera(@PathVariable(name="codigo") String codigo) {
		//buscar
		
		CarreraDTO carreraParaModificar =  carreraService.buscarCarrera(codigo);
		
		//mostrar el nuevo formulario
		ModelAndView modelView = new ModelAndView("formCarrera");
		modelView.addObject("nuevaCarrera", carreraParaModificar);	
		modelView.addObject("band", true);
		return modelView;		
		}
	
	@PostMapping("/modificarCarrera")
	public ModelAndView updateCarrera(@ModelAttribute("nuevaCarrera") CarreraDTO carreraModificada) {
					
		//guardar
		carreraService.modificarCarrera(carreraModificada);
		carreraModificada.setEstado(true);
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoCarreras", carreraService.mostrarCarreras());	
		
		return modelView;		
	}

}