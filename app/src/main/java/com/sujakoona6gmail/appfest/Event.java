package com.sujakoona6gmail.appfest;

/**
 * Created by sys on 15-03-2018.
 */

public class Event {
    String evenntname;
    String collegename;
    String eventtype;
    String state;
    String district;
    String localty;
    String coordinatorname;
    String contactno;
    String email_id;
    String url;
    String description;

    public Event() {
    }

    public Event(String evenntname, String collegename, String eventtype, String state, String district, String localty, String coordinatorname, String contactno, String email_id, String url, String description) {
        this.evenntname = evenntname;
        this.collegename = collegename;
        this.eventtype = eventtype;
        this.state = state;
        this.district = district;
        this.localty = localty;
        this.coordinatorname = coordinatorname;
        this.contactno = contactno;
        this.email_id = email_id;
        this.url = url;
        this.description = description;
    }

    public String getEvenntname() {
        return evenntname;
    }

    public void setEvenntname(String evenntname) {
        this.evenntname = evenntname;
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    public String getEventtype() {
        return eventtype;
    }

    public void setEventtype(String eventtype) {
        this.eventtype = eventtype;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLocalty() {
        return localty;
    }

    public void setLocalty(String localty) {
        this.localty = localty;
    }

    public String getCoordinatorname() {
        return coordinatorname;
    }

    public void setCoordinatorname(String coordinatorname) {
        this.coordinatorname = coordinatorname;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
