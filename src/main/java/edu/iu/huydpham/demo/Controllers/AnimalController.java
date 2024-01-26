package edu.iu.huydpham.demo.Controllers;

import edu.iu.huydpham.demo.Model.AnimalData;
import edu.iu.huydpham.demo.Repository.AnimalRepository;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {
    private AnimalRepository animalRespository;
    public AnimalController (AnimalRepository animalRespository) {
        this.animalRespository = animalRespository;
    }

    @PostMapping
    public boolean add(@RequestBody AnimalData data) {
        try {
            System.out.println("Successfully added." + data.getLocation() + data.getPicture() + data.getName());
            return animalRespository.add(data);
        } catch (IOException e) {
            return false;
        }
    }

    @GetMapping()
    public List<AnimalData> findAll() {
        try {
            return animalRespository.findAll();
        } catch (IOException e) {
            return null;
        }
    }
    @GetMapping("/search")
    public List<AnimalData> search(@RequestParam String name,
                                   @RequestParam String picture,
                                   @RequestParam String location) {
        try {
            System.out.println(name);
            System.out.println(picture);
            System.out.println(location);
            return animalRespository.find(name, picture, location);
        } catch (IOException e) {
            return null;
        }
    }
}
