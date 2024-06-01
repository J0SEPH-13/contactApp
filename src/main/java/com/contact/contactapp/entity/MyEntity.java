package com.contact.contactapp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Contact")
@Component
public class MyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String name;
    private String phone;
    private String city;

}
