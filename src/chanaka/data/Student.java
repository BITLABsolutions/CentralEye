package chanaka.data;

import java.sql.Date;

public class Student {

    String admissionNumber;
    String fullNameEnglish;
    String fullNameSinhala;
    Date birthDate;
    String house;
    String religion;
    String address;
    String telephoneNumber;
    Date dateOfAdmission;
    String classOfAdmission;
    String gender;
    String nameWithInitials;

    public Student(String admissionNumber, String fullNameEnglish, String fullNameSinhala, Date birthDate, String house, String religion, String address, String telephoneNumber, Date dateOfAdmission, String classOfAdmission, String gender, String nameWithInitials) {
        this.admissionNumber = admissionNumber;
        this.fullNameEnglish = fullNameEnglish;
        this.fullNameSinhala = fullNameSinhala;
        this.birthDate = birthDate;
        this.house = house;
        this.religion = religion;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.dateOfAdmission = dateOfAdmission;
        this.classOfAdmission = classOfAdmission;
        this.gender = gender;
        this.nameWithInitials=nameWithInitials;
    }

    public String getClassOfAdmission() {
        return classOfAdmission;
    }

    public void setClassOfAdmission(String ClassOfAdmission) {
        this.classOfAdmission = ClassOfAdmission;
    }

    public String getAdmissionNumber() {
        return admissionNumber;
    }

    public String getFullNameEnglish() {
        return fullNameEnglish;
    }

    public void setAdmissionNumber(String admissionNumber) {
        this.admissionNumber = admissionNumber;
    }

    public void setFullNameEnglish(String fullNameEnglish) {
        this.fullNameEnglish = fullNameEnglish;
    }

    public void setFullNameSinhala(String fullNameSinhala) {
        this.fullNameSinhala = fullNameSinhala;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setDateOfAdmission(Date dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setNameWithInitials(String nameWithInitials) {
        this.nameWithInitials = nameWithInitials;
    }

    public String getFullNameSinhala() {
        return fullNameSinhala;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getHouse() {
        return house;
    }

    public String getReligion() {
        return religion;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public Date getDateOfAdmission() {
        return dateOfAdmission;
    }

    public String getGender() {
        return gender;
    }

    public String getNameWithInitials() {
        return nameWithInitials;
    }


}
