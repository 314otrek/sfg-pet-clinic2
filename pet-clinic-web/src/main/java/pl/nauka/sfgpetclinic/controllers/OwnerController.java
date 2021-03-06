package pl.nauka.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.nauka.sfgpetclinic.services.OwnerService;
@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"index.html","/index","/",""})
    public String listOwners(Model model){
        model.addAttribute("owners",ownerService.findAll());
        return "owners/index.html";
    }
    @RequestMapping("/find")
    public String findOwners(){
        return "Not implemented yet!";
    }


}
