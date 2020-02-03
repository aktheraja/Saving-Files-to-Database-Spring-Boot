package com.aktheraja.demo.students;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    private final String FirstName;
    private final String LastName;
    private final String UserName;
    private final String Email;
    private final String City;
    private final String State;
    private final String Zip;
    private final String PhotoUrl;

    public Student(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("userName") String userName,
            String email, @JsonProperty("city") String city,
            @JsonProperty("state") String state,
            @JsonProperty("zip") String zip, String photURl) {
        FirstName = firstName;
        LastName = lastName;
        UserName = userName;
        Email = email;
        City = city;
        State = state;
        Zip = zip;
        PhotoUrl = photURl;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getUserName() {
        return UserName;
    }

    public String getCity() {
        return City;
    }

    public String getState() {
        return State;
    }

    public String getZip() {
        return Zip;
    }
    public String toString(){

        return   "FirstName: " +FirstName + " LastName: " +LastName + " UserName"+ UserName +
               " City: "+ City + " State: " +State + " Zip: " + Zip;
    }

    public String getPhotoUrl() {
        return PhotoUrl;
    }

    public String getEmail() {
        return Email;
    }
}
