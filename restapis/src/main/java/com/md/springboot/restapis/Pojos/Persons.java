package com.md.springboot.restapis.Pojos;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name ="PERSONS")
public class Persons {
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
  @SequenceGenerator(name = "SEQ", sequenceName = "PERSON_SEQ",allocationSize = 1)
  @Id
  @Column(name = "PERSONID")
  private Integer personid;

  @Column(name = "LASTNAME")
  private String lastname;
  @Column(name = "FIRSTNAME")

  private String firstname;
  @Column(name = "ADDRESS")
  private String address;
  @Column(name = "CITY")
  private String city;

  public Persons(int personid, String lastname, String firstname, String address, String city) {
    super();
    this.personid = personid;
    this.lastname = lastname;
    this.firstname = firstname;
    this.address = address;
    this.city = city;
  }

  public Persons() {

  }


  public Integer getPersonid() {
    return personid;
  }

  public void setPersonid(Integer personid) {
    this.personid = personid;
  }


  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }


  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }


  public String getAddress() {
    return address;
  }

  @Override
  public String toString() {
    return "Persons{" +
            "personid='" + personid + '\'' +
            ", lastname='" + lastname + '\'' +
            ", firstname='" + firstname + '\'' +
            ", address='" + address + '\'' +
            ", city='" + city + '\'' +
            '}';
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Persons)) return false;
    Persons persons = (Persons) o;
    return getPersonid().equals(persons.getPersonid()) && getLastname().equals(persons.getLastname()) && getFirstname().equals(persons.getFirstname()) && getAddress().equals(persons.getAddress()) && getCity().equals(persons.getCity());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getPersonid(), getLastname(), getFirstname(), getAddress(), getCity());
  }
}
