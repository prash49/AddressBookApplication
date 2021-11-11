package com.bridgelabz.addressbookapp.dto;


import lombok.ToString;

import javax.validation.constraints.NotEmpty;


import javax.validation.constraints.Pattern;


@ToString
public class ContactDTO {
    @Pattern(regexp = "^[A-Z]{1,}[a-zA-z\\s]{2,}$", message = "FirstName is invalid")
    @NotEmpty(message = "Name can not be NULL")
    public String firstName;
    @Pattern(regexp = "^[A-Z]{1,}[a-zA-z\\s]{2,}$", message = "LastName is invalid")
    @NotEmpty(message = "Name can not be NULL")
    public String lastName;
    public String address;
    @NotEmpty(message = "city can not be NULL")
    public String city;
    @NotEmpty(message = "State can not be NULL")
    public String state;
    @Pattern(regexp = "^[0-9]{3}\\s{0,1}[0-9]{3}$", message = "Invalid Zip")
    public String zip;
    @Pattern(regexp = "^^[0-9]{2}?[\\s,-]{0,1}[7-9]{1}[0-9]{9}$", message = "Invalid Phone number")
    public String phone;

}
