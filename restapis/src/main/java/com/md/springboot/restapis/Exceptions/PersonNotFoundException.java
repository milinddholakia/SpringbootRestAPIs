package com.md.springboot.restapis.Exceptions;

public class PersonNotFoundException extends RuntimeException{
    public PersonNotFoundException(String id) {
        super("Could not find person " + id);
    }

}
