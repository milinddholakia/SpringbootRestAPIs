package com.md.springboot.restapis.ApiController;

import com.md.springboot.restapis.Pojos.Persons;
import com.md.springboot.restapis.Repository.ApiRepository;
import com.md.springboot.restapis.Service.ApiServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        apiServices.addValue("3");
    }
    @GetMapping("/getById")
    public Optional<Persons> getById( String id) {
        return apiServices.getById("1");
    }
    }
