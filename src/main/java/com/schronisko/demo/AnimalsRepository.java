package com.schronisko.demo;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AnimalsRepository {
    private Map<Long, Animal> animals;

    public AnimalsRepository() {
        animals = new HashMap<>();

        animals.put(555L, new Animal(555L, "Sonia", "Pogodna sunia", "https://st-lento.pl/adpics/original/12_2017/19/645e06_piekna-suczka-po-przejsciach-zdjecia.jpg"));
        animals.put(444L, new Animal(444L, "Azor", "Żywiołowy dwulatek", "http://www.newsweek.pl/g/i.aspx/910/-512/newsweek/635697254369194089.jpg"));
        animals.put(333L, new Animal(333L, "Oskar", "Kochający dzieci weteran", "https://cowsierscipiszczy.pl/wp-content/uploads/2017/12/ile-zyje-pies.jpg"));
        animals.put(222L, new Animal(222L, "Czaruś", "Radosny szczeniak", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGv9P12KLCuFQO0-xZFaX9eQAm-jrHhdwk2DeXze5hwVZ96z0FWg"));
    }

    public Animal findById(Long id) {
        return animals.get(id);
    }

    public List<Animal> findAll() {
        return new ArrayList<>(animals.values());
    }

    public void add(Animal animal) {
        // przekombinowany sposób przygotowania ID dla zwierzaka:
        // 1. Pobieramy ile jest zwierzaków
        // 2. Pobieramy zwierzaki w formie listy
        // 3. Pobieramy ostatniego zwirzaka
        // 4. Bierzemy id ostatniego zwierzaka i dodajemy 1

        int count = animals.values().size();
        List<Animal> all = findAll();
        Animal lastAnimal = all.get(count - 1);
        Long id = lastAnimal.getId() + 1;
        animal.setId(id);
        animals.put(id, animal);
    }
}
