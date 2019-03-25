package zadaniedomowe20.schronisko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zadaniedomowe20.schronisko.model.Animal;
import zadaniedomowe20.schronisko.repository.AnimalRepository;

import java.util.List;

@Controller
public class AnimalController {

    AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }


    @GetMapping("/")
    public String lista(Model model) {
        List<Animal> all = animalRepository.findAll();
        model.addAttribute("allAnimals", all);
        return "home";
    }

    @GetMapping("/opisAzor")
    public String azorDescription(Model model) {
        Animal animalAzor = animalRepository.getAnimalById(1);
        model.addAttribute("animalAzor", animalAzor);
        return "opisAzor";
    }

    @GetMapping("/opisRudy")
    public String rudyDescription(Model model) {
        Animal animalRudy = animalRepository.getAnimalById(2);
        model.addAttribute("animalRudy", animalRudy);
        return "opisRudy";
    }

    @GetMapping("/categoryDog")
    public String dogCategory(Model model) {
        List<Animal> dogList = animalRepository.createCategoryPsy();
        model.addAttribute("dogList", dogList);
        return ("dogCategory");
    }

    @GetMapping("/categoryKoty")
    public String catCategory(Model model) {
        List<Animal> catList = animalRepository.createCategoryKoty();
        model.addAttribute("catList", catList);
        return ("catCategory");
    }

    @GetMapping("/categoryAll")
    public String wszystkieCategory(Model model) {
        List<Animal> allCategoryList = animalRepository.createCategoryWszystkie();
        model.addAttribute("allCategoryList", allCategoryList);
        return ("AllCategory");
    }

    @GetMapping("/categoryAnother")
    public String inneCategory(Model model) {
        List<Animal> inneCategoryList = animalRepository.createCategoryInne();
        model.addAttribute("inneCategoryList", inneCategoryList);
        return ("AnotherCategory");
    }

    @GetMapping("/addAnimal")
    public String showForm() {
        return "addAnimal";
    }

    @PostMapping("/addAnimal")
    public String addAnimal(@RequestParam
                                    String name,
                            String description,
                            String category,
                            String imgUrl,
                            Model model) {
        Animal animal = new Animal(name, description, category, imgUrl);
        animalRepository.add(animal);
        model.addAttribute("animal",animal);
        return "opisNowegoZwiezaka";
    }
}
