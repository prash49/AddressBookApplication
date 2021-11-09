package com.bridgelabz.addressbookapp.dto;

public class ContactDTO {

    public String firstName;
    public String lastName;
    public String address;
    public String state;
    public String city;
    public String zip;
    public String phone;

    public ContactDTO(String firstName, String lastName, String address, String state, String city, String zip,
                      String phone) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.state = state;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
    }



    @Override
    public String toString() {
        return "ContactDTO [First Name =" + firstName + ", Last Name =" + lastName + ", Address =" + address
                + ", State =" + state + ", City =" + city + ", Zip =" + zip + ", Phone =" + phone + "]";
    }

}
