package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressBookRepository extends JpaRepository<Contact, Integer> {
    @Query(value = "select * from addressbook where city= :city", nativeQuery = true)
    List<Contact> findContactListByCity(String city);

    @Query(value = "select * from addressbook where first_Name= :firstName", nativeQuery = true)
    List<Contact> findContactListByFirstName(String firstName);

    @Query(value = "select * from addressbook where last_Name= :lastName", nativeQuery = true)
    List<Contact> findContactListByLastName(String lastName);

    @Query(value = "select * from addressbook where zip= :zip", nativeQuery = true)
    List<Contact> findContactListByZip(String zip);

    @Query(value = "select * from addressbook order by first_name;", nativeQuery = true)
    List<Contact> sortByName();

    @Query(value = "select * from addressbook order by city;", nativeQuery = true)
    List<Contact> sortByCity();

    @Query(value = "select * from addressbook order by zip;", nativeQuery = true)
    List<Contact> sortByPincode();
}
