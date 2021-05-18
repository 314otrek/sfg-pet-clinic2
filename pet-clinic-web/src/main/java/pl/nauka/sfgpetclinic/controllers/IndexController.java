package pl.nauka.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping({"/","index","", "index.html"})
    public String index(){
        return "index.html";
    }

    @RequestMapping({"/owners/find","/vets.html", "oups"})
    public String notImplemented(){
        return "notImplemented.html";
    }
}
