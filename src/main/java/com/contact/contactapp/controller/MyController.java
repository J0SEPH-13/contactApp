package com.contact.contactapp.controller;


import com.contact.contactapp.entity.MyEntity;
import com.contact.contactapp.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/index")
public class MyController {

    MyService myservice;
    @Autowired
    public MyController(MyService myservice) {
        this.myservice = myservice;
    }

    @GetMapping("get")
    public ResponseEntity<List<MyEntity>> getMethod(){
        return myservice.getAll();
    }


    @PostMapping("/post")
    public ResponseEntity<String> postMethod(@RequestBody MyEntity myentity){
        return myservice.post(myentity);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<String> putMethod(@PathVariable(name = "id") int id,@RequestBody MyEntity myentity){
        return myservice.put(id,myentity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMethod(@PathVariable int id){
        return myservice.delete(id);
    }

}
