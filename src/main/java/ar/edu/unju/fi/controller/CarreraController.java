package ar.edu.unju.fi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.service.ICarreraService;

@Controller
@RequestMapping("/carrera")
public class CarreraController {

	@Autowired
	private CarreraDTO nuevaCarrera;

	@Autowired
	private ICarreraService carreraService;

	@GetMapping("/formularioCarrera")
	public ModelAndView getFormCarrera() {
		ModelAndView modelAndView = new ModelAndView("formCarrera");
		modelAndView.addObject("nuevaCarrera", nuevaCarrera);
		modelAndView.addObject("pageTitle", "Formulario de Carrera");
		return modelAndView;
	}

	@PostMapping("/guardarCarrera")
	public String saveCarrera(@ModelAttribute("nuevaCarrera") CarreraDTO carreraParaGuardar) {
		carreraParaGuardar.setEstado(true); // Asume que una carrera nueva siempre está activa
		carreraService.agregarUnaCarrera(carreraParaGuardar);
		return "redirect:/carrera/listaCarreras";
	}

	@GetMapping("/borrarCarrera/{id}")
	public String deleteCarrera(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		carreraService.eliminarUnaCarrera(id);
		redirectAttributes.addFlashAttribute("mensaje", "La carrera ha sido eliminada exitosamente.");
		return "redirect:/carrera/listaCarreras";
	}

	@GetMapping("/listaCarreras")
	public ModelAndView listarCarreras() {
		List<CarreraDTO> carrerasActivas = carreraService.getListaCarreras();
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoCarreras", carrerasActivas);
		return modelView;
	}

	@GetMapping("/editarCarrera/{id}")
	public ModelAndView getFormEditarCarrera(@PathVariable Long id) {
		CarreraDTO carreraParaModificar = carreraService.findCarreraById(id);
		if (carreraParaModificar == null) {
			return new ModelAndView("redirect:/carrera/listaCarreras");
		}
		ModelAndView modelView = new ModelAndView("formCarrera");
		modelView.addObject("nuevaCarrera", carreraParaModificar);
		modelView.addObject("pageTitle", "Editar Carrera");
		return modelView;
	}

	@PostMapping("/modificarCarrera")
	public String saveCarreraModificada(@ModelAttribute("nuevaCarrera") CarreraDTO carreraModificada,
			RedirectAttributes redirectAttributes) {
		if (carreraModificada.getId() == null) {
			throw new RuntimeException("El ID de la carrera no puede ser nulo.");
		}
		carreraService.actualizarCarrera(carreraModificada);
		redirectAttributes.addFlashAttribute("mensaje", "La carrera ha sido modificada exitosamente.");
		return "redirect:/carrera/listaCarreras";
	}
}
