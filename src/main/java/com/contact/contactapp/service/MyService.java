package com.contact.contactapp.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.contact.contactapp.entity.MyEntity;
import com.contact.contactapp.repository.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {

    ContactRepo contactrepo;
    @Autowired
    public MyService(ContactRepo contactrepo) {
        this.contactrepo = contactrepo;
    }

    @Autowired
    MyEntity myentity;


    //get
    public ResponseEntity<List<MyEntity>> getAll() {
        return new ResponseEntity<>(contactrepo.findAll(),HttpStatus.OK);
    }

    //post
    public ResponseEntity<String> post(String name,String number) {
        myentity.setName(name);
        myentity.setNumber(number);
        contactrepo.save(myentity);
        return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
    }

    //post
    public ResponseEntity<String> post(MyEntity myentity) {
        contactrepo.save(myentity);
        return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);

    }

    //put
    public ResponseEntity<String> put(int id,MyEntity myentity) {
        myentity.setId(id);
        contactrepo.save(myentity);
        return new ResponseEntity<>("Updated",HttpStatus.CREATED);
    }

    //delete
    public ResponseEntity<String> delete(int id) {
        contactrepo.deleteById(id);
        return new ResponseEntity<>("Deleted",HttpStatus.ACCEPTED);
    }
}
