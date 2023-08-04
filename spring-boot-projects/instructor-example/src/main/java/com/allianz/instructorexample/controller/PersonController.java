package com.allianz.instructorexample.controller;

import com.allianz.instructorexample.database.entity.PersonEntity;
import com.allianz.instructorexample.model.Person;
import com.allianz.instructorexample.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("hello-world")
    public ResponseEntity<String> helloWorldApi() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @GetMapping("person")
    public ResponseEntity<Person> personApi() {
        Person person = new Person();
        person.setName("Berk");
        person.setSurname("Gunes");
        person.setBirthYear(1999);
        person.setTc("23531434930");

        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping("person/{personId}")
    public ResponseEntity<Person> personGetByPersonIdApi(@PathVariable int personId) {
        Person person = new Person();

        if (personId == 1) {
            person.setName("Berk");
            person.setSurname("Gunes");
            person.setBirthYear(1999);
            person.setTc("23531434930");
        } else {
            person.setName("Gizem");
            person.setSurname("Kisa");
            person.setBirthYear(1992);
            person.setTc("23531467730");
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping("person-list")
    public ResponseEntity<List<Person>> getPersonList() {
        List<Person> list = new ArrayList<>();
        Person person = new Person();
        Person person1 = new Person();

        person.setName("Berk");
        person.setSurname("Gunes");
        person.setBirthYear(1999);
        person.setTc("23531434930");

        person1.setName("Gizem");
        person1.setSurname("Kisa");
        person1.setBirthYear(1992);
        person1.setTc("23531467730");

        list.add(person);
        list.add(person1);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("person-by-request-param")
    public ResponseEntity<Person> personGetByPersonIdRequestParamApi(@RequestParam int personId, @RequestParam String tc) {

        System.out.println(tc);
        Person person = new Person();
        if (personId == 1) {
            person.setName("Ali");
            person.setSurname("Kaya");
            person.setBirthYear(1999);
            person.setTc("23531434930");
        } else {
            person.setName("Gizem");
            person.setSurname("Kisa");
            person.setBirthYear(1992);
            person.setTc("23531467730");
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("person")
    public ResponseEntity<PersonEntity> createPerson(@RequestBody Person person) {
        PersonEntity person1 = personService.createPerson(person.getName(), person.getSurname(), person.getTc(), person.getBirthYear());
        return new ResponseEntity<>(person1, HttpStatus.CREATED);
    }

    @PutMapping("person/{tc}")
    public ResponseEntity<Person> createPerson(@RequestBody Person person, @PathVariable String tc) {
        List<Person> personList = new ArrayList<>();

        Person personExist = new Person();
        personExist.setName("Jack");
        personExist.setSurname("Sparrow");
        personExist.setBirthYear(1982);
        personExist.setTc("23531467730");

        personList.add(personExist);

        for (Person p : personList) {
            if (p.getTc().equals(tc)) {
                p.setTc(person.getTc());
                p.setName(person.getName());
                p.setSurname(person.getSurname());
                p.setBirthYear(person.getBirthYear());

                return new ResponseEntity<>(person, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("person/{uuid}")
    public ResponseEntity<Boolean> deletePerson(@PathVariable UUID uuid) {
        Boolean isDeleted = personService.deletePersonByUUID(uuid);
        if (isDeleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @GetMapping("person-list-by-name-start-with/{key}")
    public ResponseEntity<List<PersonEntity>> getPersonListByNameStartWith(@PathVariable String key) {
        return new ResponseEntity<>(personService.getPersonNameStartWith(key), HttpStatus.OK);
    }

    @GetMapping("person-list-by-name-i-contains/{key}")
    public ResponseEntity<List<PersonEntity>> getPersonListByNameContains(@PathVariable String key) {
        return new ResponseEntity<>(personService.getPersonNameIContains(key), HttpStatus.OK);
    }

    @GetMapping("person-list-by-name-surname-start-with/name/{name}/surname/{surname}")
    public ResponseEntity<List<PersonEntity>> getPersonListByNameContains(@PathVariable String name, @PathVariable String surname) {
        return new ResponseEntity<>(personService.getPersonNameStartWithAndSurnameStartWith(name, surname), HttpStatus.OK);
    }

    @GetMapping("person-uuid/{uuid}")
    public ResponseEntity<PersonEntity> getPersonByUUID(@PathVariable UUID uuid) {
        PersonEntity personEntity = personService.getPersonByUUID(uuid);
        if (personEntity != null) {
            return new ResponseEntity<>(personEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("person/{uuid}")
    public ResponseEntity<PersonEntity> updatePersonByUUID(@PathVariable UUID uuid, @RequestBody PersonEntity newPersonEntity) {
        PersonEntity personEntity = personService.updatePersonByUUID(uuid, newPersonEntity);
        if (personEntity != null) {
            return new ResponseEntity<>(personEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


}
