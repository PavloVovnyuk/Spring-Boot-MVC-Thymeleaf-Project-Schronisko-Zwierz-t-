package zadaniedomowe20.schronisko.repository;

import org.springframework.stereotype.Repository;
import zadaniedomowe20.schronisko.model.Animal;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnimalRepository {

    List<Animal> listOfAnimals = new ArrayList<>();

    public AnimalRepository() {
        listOfAnimals.add(new Animal(1, "Azor", "Azor to 4-letni pies pozucony przez poprzedniego wlascicielia", "Psy", "https://img.shmbk.pl/rimgspr/58569320_pad_640_400_dla-domu-dekoracje-naklejki-obrazek-na-okno-mopsig-pies-rasy-psow-przyjaciol-zwierzat-domowych-figure-naklejka-okienna-folia-okienna-naklejka-na-okno-naklejki-na-tatuaz-na-szklo-de.jpg"));
        listOfAnimals.add(new Animal(2, "Rudy", "Rydu to kod indywidualista", "Koty", "http://ulubionykolor.pl/images/normal/07012013/b7de639d722df5ac814d2240007012013161642.jpg"));
    }

    public List<Animal> findAll() {
        return listOfAnimals;
    }

    public Animal getAnimalById(int id) {
        return listOfAnimals.get(id - 1);
    }

    public List<Animal> createCategoryPsy() {
        List<Animal> psy = new ArrayList<>();
        for (Animal comparison : listOfAnimals) {
            if (comparison.getCategory().equals("Psy")) {
                psy.add(comparison);
            }
        }
        return psy;
    }

    public List<Animal> createCategoryKoty() {
        List<Animal> koty = new ArrayList<>();
        for (Animal comparison1 : listOfAnimals) {
            if (comparison1.getCategory().equals("Koty")) {
                koty.add(comparison1);
            }
        }
        return koty;
    }

    public List<Animal> createCategoryWszystkie() {
        List<Animal> wszystkie = new ArrayList<>();
        for (Animal comparison2 : listOfAnimals) {
            if (comparison2.getCategory().equals("Koty") || comparison2.getCategory().equals("Psy")) {
                wszystkie.add(comparison2);
            }
        }
        return wszystkie;
    }
    public List<Animal> createCategoryInne() {
        List<Animal> inne = new ArrayList<>();
        for (Animal comparison3 : listOfAnimals) {
            if (!(comparison3.getCategory().equals("Koty") || comparison3.getCategory().equals("Psy"))) {
                inne.add(comparison3);
            }
        }
        return inne;
    }
    public void add(Animal animal) {
       animal.setId(listOfAnimals.size() + 1);
        listOfAnimals.add(animal);
    }
}
