package com.allianz.example.controller;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("PersonDTO")
public class PersonController {


    //endpoint->son nokta-bitis noktası

    //localhost:8080/example

    @Autowired
    PersonService personService;


    @GetMapping("hello-world")
    public ResponseEntity<String> helloWorldApi() {


        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }


    @GetMapping("PersonDTO")
    public ResponseEntity<PersonDTO> PersonDTOApi() {

        PersonDTO PersonDTO = new PersonDTO();
        PersonDTO.setName("Furkan");
        PersonDTO.setSurname("Yalçındağ");
        PersonDTO.setBirthYear(1992);
        PersonDTO.setTc("kosdkshdjks");

        return new ResponseEntity<>(PersonDTO, HttpStatus.OK);
    }


    //pathVariable localhost:8080/PersonDTO/12


    @GetMapping("PersonDTO/{PersonDTOId}")
    public ResponseEntity<PersonDTO> PersonDTOGetByPersonDTOIdApi(@PathVariable int PersonDTOId) {
        PersonDTO PersonDTO = new PersonDTO();
        if (PersonDTOId == 1) {
            PersonDTO.setName("Furkan");
            PersonDTO.setSurname("Yalçındağ");
            PersonDTO.setBirthYear(1992);
            PersonDTO.setTc("kosdkshdjks");
        } else {
            PersonDTO.setName("Gizem");
            PersonDTO.setSurname("Kısa");
            PersonDTO.setBirthYear(1992);
            PersonDTO.setTc("jkfdkjghjkdfhgd");
        }


        return new ResponseEntity<>(PersonDTO, HttpStatus.OK);
    }


    @GetMapping("PersonDTO-list")
    public ResponseEntity<List<PersonDTO>> getPersonDTOList() {

        List<PersonDTO> list = new ArrayList<>();

        PersonDTO PersonDTO = new PersonDTO();
        PersonDTO.setName("Furkan");
        PersonDTO.setSurname("Yalçındağ");
        PersonDTO.setBirthYear(1992);
        PersonDTO.setTc("kosdkshdjks");

        list.add(PersonDTO);

        PersonDTO PersonDTO2 = new PersonDTO();
        PersonDTO2.setName("Gizem");
        PersonDTO2.setSurname("Kısa");
        PersonDTO2.setBirthYear(1992);
        PersonDTO2.setTc("jkfdkjghjkdfhgd");

        list.add(PersonDTO2);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @GetMapping("PersonDTO-by-request-param")
    public ResponseEntity<PersonDTO> PersonDTOGetByPersonDTOIdRequestParamApi(@RequestParam int PersonDTOId, @RequestParam String tc) {

        System.out.println(tc);
        PersonDTO PersonDTO = new PersonDTO();
        if (PersonDTOId == 1) {
            PersonDTO.setName("Furkan");
            PersonDTO.setSurname("Yalçındağ");
            PersonDTO.setBirthYear(1992);
            PersonDTO.setTc("kosdkshdjks");
        } else {
            PersonDTO.setName("Gizem");
            PersonDTO.setSurname("Kısa");
            PersonDTO.setBirthYear(1992);
            PersonDTO.setTc("jkfdkjghjkdfhgd");
        }


        return new ResponseEntity<>(PersonDTO, HttpStatus.OK);
    }

    @PostMapping("PersonDTO")
    public ResponseEntity<PersonEntity> createPersonDTO(@RequestBody PersonDTO PersonDTO) throws Exception {

        PersonEntity PersonDTO1 = personService.createPerson(PersonDTO.getName(), PersonDTO.getSurname(),
                PersonDTO.getTc(), PersonDTO.getBirthYear());

        //throw new Exception("slşdkaslşdkşlaskdas");

        return new ResponseEntity<>(PersonDTO1, HttpStatus.CREATED);
    }

    @DeleteMapping("PersonDTO/{uuid}")
    public ResponseEntity<Boolean> deletePersonDTO(@PathVariable UUID uuid) {

        Boolean isDeleted = personService.deletePersonByUUID(uuid);
        if (isDeleted) {
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("PersonDTO-list-by-name-start-with/{key}")
    public ResponseEntity<List<PersonEntity>> getPersonDTOListByNameStartWith(@PathVariable String key) {

        return new ResponseEntity<>(personService.getPersonNameStartWith(key), HttpStatus.OK);
    }


    @GetMapping("PersonDTO-list-by-name-i-contains/{key}")
    public ResponseEntity<List<PersonEntity>> getPersonDTOListByNameICOntains(@PathVariable String key) {
        return new ResponseEntity<>(personService.getPersonNameIContains(key), HttpStatus.OK);
    }


    @GetMapping("PersonDTO-list-by-name-surname-start-with/name/{name}/surname/{surname}")
    public ResponseEntity<List<PersonEntity>> getPersonDTOListByNameICOntains(
            @PathVariable String name, @PathVariable String surname) {
        return new ResponseEntity<>(
                personService.getPersonNameStartWithAndSurnameStartWith(name, surname), HttpStatus.OK);
    }


    @GetMapping("PersonDTO-by-uuid/{uuid}")
    public ResponseEntity<PersonEntity> getPersonDTOByUUID(@PathVariable UUID uuid) {

        PersonEntity PersonEntity = personService.getPersonByUUID(uuid);

        if (PersonEntity != null) {

            return new ResponseEntity<>(PersonEntity, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }


    }

    @PutMapping("PersonDTO/{uuid}")
    public ResponseEntity<PersonEntity> updatePersonDTOByUUID(@PathVariable UUID uuid,
                                                              @RequestBody PersonEntity PersonEntityNew) {
        PersonEntity PersonEntity = personService.updatePersonByUUID(uuid, PersonEntityNew);
        if (PersonEntity != null) {

            return new ResponseEntity<>(PersonEntity, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }


}