package com.schronisko.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DogsController {

    @RequestMapping("/dogs")
    public String dogs(Model model) {

        List<Dog> pieski = new ArrayList<>();
        pieski.add(new Dog("Sonia"));
        pieski.add(new Dog("Azor"));
        pieski.add(new Dog("Oskar"));
        pieski.add(new Dog("Czaruś"));
        pieski.add(new Dog("Burek"));
        pieski.add(new Dog("Pirat"));
        pieski.add(new Dog("Murzyn"));
        pieski.add(new Dog("Misiek"));

        model.addAttribute("dogs", pieski);


        return "index"; //dokleja .html i połączy z templates/index.html
    }


//    @RequestMapping("/")
//    String main (){
//        return "/index.html";
//    }

    @RequestMapping("/azor")
    @ResponseBody
    public String printInfoAzor(){
        return "Opis Azora- Azorek to dwuletni piesek";
    }

    @RequestMapping("/bella")
    @ResponseBody
    public String printInfoBella(){
        return "Opis Belli";
    }

    @RequestMapping("/oskar")
    @ResponseBody
    public String printInfoOskar(){
        return "Opis Oskara- Oskarek to dwuletni piesek";
    }

}
