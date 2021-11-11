package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

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
    private String state;
    private String city;

    private String zip;
    private String phone;

    private LocalDate registerDate;
    private LocalDate updateDate;


    public Contact(ContactDTO contactDTO) {

        this.updateContact(contactDTO);
    }

    public Contact() {

    }


    public void updateContact(ContactDTO contactDTO) {
        this.contactId = contactId;
        this.firstName = contactDTO.firstName;
        this.lastName = contactDTO.lastName;
        this.address = contactDTO.address;
        this.city = contactDTO.city;
        this.state = contactDTO.state;
        this.zip = contactDTO.zip;
        this.phone = contactDTO.phone;
        this.registerDate = contactDTO.registerDate;
        this.updateDate = contactDTO.updateDate;


    }


}