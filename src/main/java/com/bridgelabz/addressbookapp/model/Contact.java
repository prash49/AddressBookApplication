package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import lombok.Data;


@Data
public class Contact {
    private int contactId;
    private String firstName;
    private String lastName;
    private String address;
    private String state;
    private String city;
    private String zip;
    private String phone;


    public Contact(int contactId, ContactDTO contactDTO) {
        this.contactId = contactId;
        this.updateContact(contactDTO);
    }

    private void updateContact(ContactDTO contactDTO) {
        this.firstName = contactDTO.firstName;
        this.lastName = contactDTO.lastName;
        this.address = contactDTO.address;
        this.city = contactDTO.city;
        this.state = contactDTO.state;
        this.zip = contactDTO.zip;
        this.phone = contactDTO.phone;


    }


}