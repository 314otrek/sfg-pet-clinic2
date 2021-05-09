package pl.nauka.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.nauka.sfgpetclinic.services.VetService;

@RequestMapping("/vets")
@Controller
public class VetController {

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    private  final VetService vetService;


    @RequestMapping({"index.html","/index"})
    public String listVets(Model model){
        model.addAttribute("vets",vetService.findAll());
        return "vets/index.html";
    }
}
