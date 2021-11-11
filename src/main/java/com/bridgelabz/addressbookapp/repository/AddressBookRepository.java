package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<Contact, Integer> {
}
