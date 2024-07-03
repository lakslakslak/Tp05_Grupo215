package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.service.IDocenteService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/docente")
public class DocenteController {

    @Autowired
    DocenteDTO docenteDTO;

    @Autowired
    IDocenteService docenteService;

    @GetMapping("formularioDocente")
    public ModelAndView getFormulario() {
        ModelAndView mv = new ModelAndView("formDocente");
        mv.addObject("maestro", docenteDTO);
        mv.addObject("isEdit", false);
        return mv;
    }

    @GetMapping("listaDocentes")
    public ModelAndView getListaDocentes() {
        ModelAndView mv = new ModelAndView("listaDocentes");
        mv.addObject("docentes", docenteService.getListaDocentes());
        return mv;
    }

    @PostMapping("guardarDocente")
    public ModelAndView guardarDocente(@Valid @ModelAttribute("maestro") DocenteDTO docenteDTO, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("formDocente");
            mv.addObject("maestro", docenteDTO);
            mv.addObject("isEdit", docenteDTO.getLegajo() != null);
            return mv;
        } else {
            if (docenteDTO.getLegajo() != null) {
                // Si legajo no es nulo, actualizamos el docente existente
                docenteService.actualizarDocente(docenteDTO);
            } else {
                // Si legajo es nulo, agregamos un nuevo docente
                docenteService.agregarUnDocente(docenteDTO);
            }
            return new ModelAndView("redirect:/docente/listaDocentes");
        }
    }



    @GetMapping("/modificar/{legajo}")
    public ModelAndView modificarDocente(@PathVariable("legajo") Long legajo) {
        ModelAndView mv = new ModelAndView("formDocente");
        mv.addObject("maestro", docenteService.findDocenteByLegajo(legajo));
        mv.addObject("isEdit", true);
        return mv;
    }

    @GetMapping("/borrarDocente/{legajo}")
    public ModelAndView deleteDocente(@PathVariable("legajo") Long legajo) {
        docenteService.eliminarUnDocente(legajo);
        return new ModelAndView("redirect:/docente/listaDocentes");
    }
}