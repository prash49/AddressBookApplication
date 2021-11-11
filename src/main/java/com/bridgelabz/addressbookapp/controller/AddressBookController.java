package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.Contact;
import com.bridgelabz.addressbookapp.service.IAddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressbookservice")
@Slf4j
public class AddressBookController {

    @Autowired
    private IAddressBookService addressbookservice;

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getContactData() {

        List<Contact> contactList = addressbookservice.getContact();
        ResponseDTO response = new ResponseDTO("Get call success", contactList);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @GetMapping("/get/{contactId}")
    public ResponseEntity<ResponseDTO> getContactData(@PathVariable("contactId") int contactId) {
        Contact contact = addressbookservice.getContactById(contactId);
        ResponseDTO response = new ResponseDTO("Get call success for id", contact);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addContactData(@Valid @RequestBody ContactDTO contactDTO) {
        Contact contact = addressbookservice.createContact(contactDTO);
        log.debug("Address Book DTO: " + contactDTO.toString());
        ResponseDTO response = new ResponseDTO("Created contact data for", contact);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

    }

    @PutMapping("/update/{contactId}")
    public ResponseEntity<ResponseDTO> updateContactData(@PathVariable("contactId") int contactId,
                                                         @Valid @RequestBody ContactDTO contactDTO) {
        Contact contact = addressbookservice.updateContact(contactId, contactDTO);
        log.debug("AddressBook Contact After Update " + contact.toString());
        ResponseDTO response = new ResponseDTO("Updated contact data for", contact);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<ResponseDTO> deleteContactData(@PathVariable("contactId") int contactId) {
        addressbookservice.deleteContact(contactId);
        ResponseDTO response = new ResponseDTO("Delete call success for id ", "deleted id:" + contactId);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<ResponseDTO> deleteAllAddressBookData() {
        String message = addressbookservice.deleteAllAddressBookData();
        ResponseDTO respDTO = new ResponseDTO("Deleteall:", message);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}
