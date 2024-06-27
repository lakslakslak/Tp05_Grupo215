package ar.edu.unju.fi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.DTO.AlumnoDTO;
import ar.edu.unju.fi.service.AlumnoService;

@Controller
public class AlumnoController {
	
	@Autowired
	AlumnoDTO nuevoAlumnoDTO;
	
	@Autowired
	AlumnoService alumnoService;
	
	@GetMapping("/formularioAlumno")
	public ModelAndView getFormAlumno() {
		//vista formCarrera.html
		ModelAndView modelView = new ModelAndView("formAlumno");
		//agrega el objeto
		//nuevaCarrera.setNombre("Ingenieria");
		modelView.addObject("nuevoAlumno", nuevoAlumnoDTO );	
		modelView.addObject("band", false);
		return modelView;
	}
	
	@PostMapping("/guardarCarrera")
	public ModelAndView saveAlumno(@ModelAttribute("nuevoAlumno") AlumnoDTO alumnoParaGuardar) {
					
		//guardar
		//ListadoCarreras.agregarCarrera(carreraParaGuardar);
		alumnoService.guardarAlumno(alumnoParaGuardar);
		
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		//modelView.addObject("listadoAlumnos", ListadoAlumnos.listarAlumnos());	
		modelView.addObject("listadoCarreras", alumnoService.mostrarAlumnos());
		
		return modelView;		
	}
	
	@GetMapping("/borrarAlumno/{lu}")
	public ModelAndView deleteCarreraDelListado(@PathVariable(name="lu") String lu) {
		//borrar
		//ListadoAlumnos.eliminarAlumno(lu);
		System.out.println("esta es la libreta: "+lu);
		alumnoService.borrarAlumno(lu);
		
		//mostrar el nuevo listado
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumnos", alumnoService.mostrarAlumnos());	
		
		return modelView;		
		}
	
	@GetMapping("/modificarCarrera/{codigo}")
	public ModelAndView editAlumno(@PathVariable(name="lu") String lu) {
		//buscar
		
		AlumnoDTO alumnoParaModificar =  alumnoService.buscarAlumno(lu);
		
		//mostrar el nuevo formulario
		ModelAndView modelView = new ModelAndView("formAlumno");
		modelView.addObject("nuevoAlumno", alumnoParaModificar);	
		modelView.addObject("band", true);
		return modelView;		
		}
	
	@PostMapping("/modificarAlumno")
	public ModelAndView updateAlumno(@ModelAttribute("nuevoAlumno") AlumnoDTO alumnoModificado) {
					
		//guardar
		alumnoService.modificarAlumno(alumnoModificado);
		alumnoModificado.setEstado(true);
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumnos", alumnoService.mostrarAlumnos());	
		
		return modelView;		
	}

}