package com.aktheraja.demo.students;

import java.util.UUID;

public class Student {
    private final UUID studentId;
    private final String FirstName;
    private final String LastName;
    private final String UserName;
    private final String Email;
    private final String City;
    private final String State;
    private final String Zip;
    private String PhotoUrl;

    public Student(
            UUID studentId,
//            @JsonProperty("firstName")
           String firstName,
//            @JsonProperty("lastName")
            String lastName,
//            @JsonProperty("userName")
            String userName,
//            @JsonProperty("email")
            String email,
//            @JsonProperty("city")
            String city,
//            @JsonProperty("state")
            String state,
//            @JsonProperty("zip")
            String zip,
//            @JsonProperty("photoUrl")
            String photoUrl) {
        this.studentId = studentId;
        FirstName = firstName;
        LastName = lastName;
        UserName = userName;
        Email = email;
        City = city;
        State = state;
        Zip = zip;
        PhotoUrl = photoUrl;
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

        return  "StudentId" + studentId+" FirstName: " +FirstName + "Email: "+ Email + "LastName: " +LastName + " UserName"+ UserName +
               " City: "+ City + " State: " +State + " Zip: " + Zip + "PhotoUrl: " + PhotoUrl;
    }

    public String getPhotoUrl() {
        return PhotoUrl;
    }

    public String getEmail() {
        return Email;
    }

    public UUID getStudentId() {
        return studentId;
    }
    public void setPath(String path){
        this.PhotoUrl = path;
    }
}
