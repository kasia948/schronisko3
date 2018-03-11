package com.schronisko.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class AnimalController {
    public AnimalsRepository animalsRepository;

    public AnimalController(AnimalsRepository animalsRepository1) {
        this.animalsRepository = animalsRepository1;
    }

    @GetMapping("/")
    public String animals(Model model) {
        List<Animal> zwierzaki = animalsRepository.findAll();
        model.addAttribute("all", zwierzaki);
        return "all"; // doklej.html i połącz model z templates/all.html
    }

    @GetMapping("/animal")
    public String animal(@RequestParam Long id, Model model) {
        Animal animal = animalsRepository.findById(id);
        model.addAttribute("animal", animal);
        return "AnimalDetails";// doklej.html i połącz model z templates/AnimalDetails.html
    }

    @GetMapping("/dodaj")
    public String addAnimalForm(Model model) {
        model.addAttribute("newAnimal", new Animal());
        return "addAnimalForm"; //templates/addAnimalForm.html
    }

    @PostMapping("/addAnimal")
    public String addAnimal(Animal newAnimal) {
        animalsRepository.add(newAnimal);
        return "redirect:/";
    }
}
