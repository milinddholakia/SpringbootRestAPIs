package com.md.springboot.restapis.ApiController;

import com.md.springboot.restapis.Exceptions.PersonNotFoundException;
import com.md.springboot.restapis.Pojos.Persons;
import com.md.springboot.restapis.Repository.ApiRepository;
import com.md.springboot.restapis.Service.ApiServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Api")
public class ApiController {

    @Autowired
    ApiRepository apiRepository;

    @Autowired
    ApiServices apiServices;

    @GetMapping("/getAll")
    public List<Persons> personData(){
        return apiServices.getAll();

    }

    @GetMapping("/save")
    public void saveId(){
        apiServices.addValue(3);
    }

    @PostMapping("/persons")
    Persons newPersons(@RequestBody Persons newPerson) {
        return apiRepository.save(newPerson);
    }
//    @GetMapping("/getById")
//    public Optional<Persons> getById( String id) {
//        return apiServices.getById("1");
//    }
//

    @GetMapping("/persons/{id}")
    Persons one(@PathVariable String id) {

        return apiRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }
    @PutMapping("/persons/{id}")
    Persons replacePersons(@RequestBody Persons newPersons, @PathVariable Long id) {

        return apiRepository.findById(String.valueOf(id))
                .map(persons -> {
                    persons.setFirstname(newPersons.getFirstname());
                    persons.setLastname(newPersons.getLastname());
                    return apiRepository.save(persons);
                })
                .orElseGet(() -> {
                    newPersons.setPersonid(Math.toIntExact(id));
                    return apiRepository.save(newPersons);
                });
    }

    @DeleteMapping("/persons/{id}")
    void deletePersons(@PathVariable Long id) {
        apiRepository.deleteById(String.valueOf(id));
    }
}

