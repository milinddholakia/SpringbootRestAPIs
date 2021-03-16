package com.md.springboot.restapis.Service;

import com.md.springboot.restapis.Pojos.Persons;
import com.md.springboot.restapis.Repository.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApiServices {

    @Autowired
    ApiRepository apiRepository;




    public List<Persons> getAll(){
        List<Persons> persons ;
        persons =  apiRepository.findAll();

        return  persons;
    }

    public Optional<Persons> getById(String Id){
        Optional<Persons> persons ;
        persons =  apiRepository.findById(Id);

        return  persons;
    }

    public void addValue(Integer p){
        Persons persons = new Persons();
        persons.setPersonid(p);
        apiRepository.save(persons);
    }

}
