package com.example.project;

public class Home {
    private String gender,ownerName , homeName , ownerNumber , price , location ;
    Home()
    {

    }
    Home(String gender ,String ownerName ,String homeName , String ownerNumber , String location , String price)
    {
        this.gender = gender ;
        this.ownerName = ownerName ;
        this.ownerNumber = ownerNumber ;
        this.homeName = homeName ;
        this.location = location ;
        this.price = price ;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public String getOwnerNumber() {
        return ownerNumber;
    }

    public void setOwnerNumber(String ownerNumber) {
        this.ownerNumber = ownerNumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return ownerName + "   "  +homeName + "   "  + ownerNumber + "   "  + price + "   "  + location ;
    }
}
