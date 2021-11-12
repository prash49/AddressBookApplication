package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.Contact;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;


    @Override
    public List<Contact> getContact() {

        return addressBookRepository.findAll();
    }

    @Override
    public Contact getContactById(int contactId) {
        return addressBookRepository.findById(contactId)
                .orElseThrow(() -> new AddressBookException("Contact with id " + contactId + " does not exist..!"));
    }

    @Override
    public Contact createContact(ContactDTO contactDTO) {
        Contact contact = new Contact();
        contact.createContact(contactDTO);
        return addressBookRepository.save(contact);
    }

    @Override
    public Contact updateContact(int contactId, ContactDTO contactDTO) {
        Contact contact = this.getContactById(contactId);
        contact.updateContact(contactDTO);
        return addressBookRepository.save(contact);
    }

    @Override
    public void deleteContact(int contactId) {
        Contact contact = this.getContactById(contactId);
        addressBookRepository.delete(contact);
    }

    @Override
    public String deleteAllAddressBookData() {
        addressBookRepository.deleteAll();
        return "Successfully deleted all the Contacts from AddressBook";
    }

    @Override
    public List<Contact> getContactByCity(String city) {
        return addressBookRepository.findContactListByCity(city);
    }

    @Override
    public List<Contact> getContactByFirstName(String firstName) {
        return addressBookRepository.findContactListByFirstName(firstName);
    }

    @Override
    public List<Contact> getContactByLastName(String lastName) {
        return addressBookRepository.findContactListByLastName(lastName);
    }

    @Override
    public List<Contact> getContactByPincode(String zip) {
        return addressBookRepository.findContactListByZip(zip);
    }

    @Override
    public List<Contact> sortByName() {
        return addressBookRepository.sortByName();
    }

    @Override
    public List<Contact> sortByCity() {
        return addressBookRepository.sortByCity();
    }

    @Override
    public List<Contact> sortByPincode() {
        return addressBookRepository.sortByPincode();
    }
}
