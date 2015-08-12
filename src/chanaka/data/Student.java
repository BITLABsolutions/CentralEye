package data;

import java.sql.Date;

public class Student {

    String AdmissionNumber;
    String FullNameEnglish;
    String FullNameSinhala;
    Date BirthDate;
    String House;
    String Religion;
    String Address;
    String TelephoneNumber;
    Date DateOfAdmission;
    String ClassOfAdmission;
    String Gender;

    public Student(String AdmissionNumber, String FullNameEnglish, String FullNameSinhala, Date BirthDate, String House, String Religion, String Address, String TelephoneNumber, Date DateOfAdmission, String ClassOfAdmission, String Gender) {
        this.AdmissionNumber = AdmissionNumber;
        this.FullNameEnglish = FullNameEnglish;
        this.FullNameSinhala = FullNameSinhala;
        this.BirthDate = BirthDate;
        this.House = House;
        this.Religion = Religion;
        this.Address = Address;
        this.TelephoneNumber = TelephoneNumber;
        this.DateOfAdmission = DateOfAdmission;
        this.ClassOfAdmission = ClassOfAdmission;
        this.Gender = Gender;
    }

    public String getClassOfAdmission() {
        return ClassOfAdmission;
    }

    public void setClassOfAdmission(String ClassOfAdmission) {
        this.ClassOfAdmission = ClassOfAdmission;
    }

    public String getAdmissionNumber() {
        return AdmissionNumber;
    }

    public String getFullNameEnglish() {
        return FullNameEnglish;
    }

    public String getFullNameSinhala() {
        return FullNameSinhala;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public String getHouse() {
        return House;
    }

    public String getReligion() {
        return Religion;
    }

    public String getAddress() {
        return Address;
    }

    public String getTelephoneNumber() {
        return TelephoneNumber;
    }

    public Date getDateOfAdmission() {
        return DateOfAdmission;
    }

    public String getGender() {
        return Gender;
    }

    public void setAdmissionNumber(String AdmissionNumber) {
        this.AdmissionNumber = AdmissionNumber;
    }

    public void setFullNameEnglish(String FullNameEnglish) {
        this.FullNameEnglish = FullNameEnglish;
    }

    public void setFullNameSinhala(String FullNameSinhala) {
        this.FullNameSinhala = FullNameSinhala;
    }

    public void setBirthDate(Date BirthDate) {
        this.BirthDate = BirthDate;
    }

    public void setHouse(String House) {
        this.House = House;
    }

    public void setReligion(String Religion) {
        this.Religion = Religion;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setTelephoneNumber(String TelephoneNumber) {
        this.TelephoneNumber = TelephoneNumber;
    }

    public void setDateOfAdmission(Date DateOfAdmission) {
        this.DateOfAdmission = DateOfAdmission;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

}
