package com.contact.contactapp.service;

import com.contact.contactapp.entity.MyEntity;
import com.contact.contactapp.repository.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {

    ContactRepo contactrepo;
    @Autowired
    public MyService(ContactRepo contactrepo) {
        this.contactrepo = contactrepo;
    }

    //get
    public List<MyEntity> getAll() {
        return contactrepo.findAll();
    }

    //find by Id
    public MyEntity findById(int id) {
        return contactrepo.findById(id).get();
    }

    //create
    public MyEntity post(MyEntity myentity) {
        return contactrepo.save(myentity);

    }

    //update
    public MyEntity put(int id,MyEntity myentity) {
        myentity.setId(id);
        return contactrepo.save(myentity);

    }

    //delete
    public void delete(int id) {
        contactrepo.deleteById(id);

    }

    //delete all
    public void deleteAll() {
        contactrepo.deleteAll();
    }
}
