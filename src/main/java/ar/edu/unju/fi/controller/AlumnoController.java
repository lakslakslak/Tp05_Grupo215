package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.service.IAlumnoService;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
	@Autowired
	AlumnoDTO alumnoDTO;
	
	@Autowired
	IAlumnoService alumnoService;
	
	@GetMapping("formularioAlumno")
    public ModelAndView getFormulario() {
        ModelAndView mv = new ModelAndView("formAlumno");
        mv.addObject("alumno", alumnoDTO);
        mv.addObject("isEdit", false);
        return mv;
    }
	
	@GetMapping("listaAlumnos")
    public ModelAndView getListaAlumnos() {
        ModelAndView mv = new ModelAndView("listaAlumnos");
        mv.addObject("alumnos", alumnoService.getListaAlumnos());
        return mv;
    }
	
	@PostMapping("guardarAlumno")
    public ModelAndView guardarAlumno(@ModelAttribute("alumno") AlumnoDTO alumnoDTO) {
		if (alumnoDTO.getLu() != null) {
            alumnoService.actualizarAlumno(alumnoDTO);
        } else {
            alumnoService.agregarUnAlumno(alumnoDTO);
        }
        return new ModelAndView("redirect:listaAlumnos");
    }
	
	@GetMapping("/modificar/{lu}")
    public ModelAndView modificarAlumno(@PathVariable("lu") Long lu) {
        ModelAndView mv = new ModelAndView("formAlumno");
        mv.addObject("alumno", alumnoService.findAlumnoByLu(lu));
        mv.addObject("isEdit", true);
        return mv;
    }

    @GetMapping("/borrarAlumno/{lu}")
    public ModelAndView deleteAlumno(@PathVariable("lu") Long lu) {
        alumnoService.eliminarUnAlumno(lu);
        return new ModelAndView("redirect:/alumno/listaAlumnos");
    }
}