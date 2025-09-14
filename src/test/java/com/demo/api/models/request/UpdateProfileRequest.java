package com.demo.api.models.request;

public class UpdateProfileRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;



    public UpdateProfileRequest(String firstName,String lastName,String email,String mobileNumber){
        this.firstName= firstName;
        this.lastName= lastName;
        this.email= email;
        this.mobileNumber= mobileNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "UpdateProfileRequest [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", mobileNumber=" + mobileNumber + "]";
    }
}
