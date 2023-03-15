package model;


import lombok.Data;

@Data
public class User {

    private long idUser;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String department;
    private String zipCode;
}