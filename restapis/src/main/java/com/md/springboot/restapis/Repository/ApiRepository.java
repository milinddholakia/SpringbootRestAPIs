package com.md.springboot.restapis.Repository;

import com.md.springboot.restapis.Pojos.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRepository extends JpaRepository <Persons,String>{
}
