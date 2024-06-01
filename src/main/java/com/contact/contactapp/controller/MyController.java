package com.contact.contactapp.controller;


import com.contact.contactapp.entity.MyEntity;
import com.contact.contactapp.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class MyController {

    @Autowired
    MyService myservice;

    @GetMapping
    public ResponseEntity<List<MyEntity>> getAllContacts(){
        return new ResponseEntity<>(myservice.getAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<MyEntity> postMethod(@RequestBody MyEntity myentity){
        return new ResponseEntity<>(myservice.post(myentity),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MyEntity> findBy(@PathVariable int id){
        return new ResponseEntity<>(myservice.findById(id),HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<MyEntity> putMethod(@PathVariable(name = "id") int id,@RequestBody MyEntity myentity){
        return new ResponseEntity<>(myservice.put(id,myentity),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMethod(@PathVariable int id){
        myservice.delete(id);
        return new ResponseEntity<>("Deleted Sucessfully",HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllMethod(){
        myservice.deleteAll();
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.ACCEPTED);
    }
}
