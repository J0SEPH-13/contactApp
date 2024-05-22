package com.contact.contactapp.repository;

import com.contact.contactapp.entity.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends JpaRepository<MyEntity,Integer> {
}
