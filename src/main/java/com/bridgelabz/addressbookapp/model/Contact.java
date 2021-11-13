package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import lombok.Data;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "addressbook")
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Contact_Id")
    private int contactId;
    @Column(name = "First_Name")
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;


    private LocalDateTime registerDate;


    private LocalDateTime updateDate;


    public Contact() {
    }


    public void updateContact(ContactDTO contactDTO) {
        this.firstName = contactDTO.firstName;
        this.lastName = contactDTO.lastName;
        this.address = contactDTO.address;
        this.city = contactDTO.city;
        this.state = contactDTO.state;
        this.zip = contactDTO.zip;
        this.phone = contactDTO.phone;
        this.updateDate = LocalDateTime.now();
    }


    public void createContact(ContactDTO contactDTO) {

        this.registerDate = LocalDateTime.now();
        this.firstName = contactDTO.firstName;
        this.lastName = contactDTO.lastName;
        this.address = contactDTO.address;
        this.city = contactDTO.city;
        this.state = contactDTO.state;
        this.zip = contactDTO.zip;
        this.phone = contactDTO.phone;

    }
}