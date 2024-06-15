package com.sena.back_1076502369.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tickets")
public class Tickets extends ABaseEntity {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;
    
    @Column(name = "passport_number")
    private String passportNumber;
    
    @Column(name = "passport_country_id")
    private String passportCountryId;
    
    @Column(name = "passport_photo")
    private String passportPhoto;
    
    @Column(name = "booking_reference")
    private String bookingReference;
    
    @Column(name = "confirmed")
    private Boolean confirmed;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Users userId;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "schedule_id")
    private Schedules scheduleId;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cabintype_id")
    private CabinTypes cabinTypeId;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPassportCountryId() {
        return passportCountryId;
    }

    public void setPassportCountryId(String passportCountryId) {
        this.passportCountryId = passportCountryId;
    }

    public String getPassportPhoto() {
        return passportPhoto;
    }

    public void setPassportPhoto(String passportPhoto) {
        this.passportPhoto = passportPhoto;
    }

    public String getBookingReference() {
        return bookingReference;
    }

    public void setBookingReference(String bookingReference) {
        this.bookingReference = bookingReference;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Schedules getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Schedules scheduleId) {
        this.scheduleId = scheduleId;
    }

    public CabinTypes getCabinTypeId() {
        return cabinTypeId;
    }

    public void setCabinTypeId(CabinTypes cabinTypeId) {
        this.cabinTypeId = cabinTypeId;
    }
    
}
