package com.example.st.myapplication.Quesionnaire;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Sergei on 14.06.2016.
 */
public class Questionnaire {
    private String firstName;
    private String lastName;
    private Date dateAndTimeOfArrive;
    private int nights;
    private String sex;
    private boolean breakFast;
    private boolean dinner;
    private boolean supper;
    private boolean fullBoard;
    private String city;
    private String suggestions;

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

    public Date getDateAndTimeOfArrive() {
        return dateAndTimeOfArrive;
    }

    public void setDateAndTimeOfArrive(Date dateAndTimeOfArrive) {
        this.dateAndTimeOfArrive = dateAndTimeOfArrive;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isBreakFast() {
        return breakFast;
    }

    public void setBreakFast(boolean breakFast) {
        this.breakFast = breakFast;
    }

    public boolean isDinner() {
        return dinner;
    }

    public void setDinner(boolean dinner) {
        this.dinner = dinner;
    }

    public boolean isSupper() {
        return supper;
    }

    public void setSupper(boolean supper) {
        this.supper = supper;
    }

    public boolean isFullBoard() {
        return fullBoard;
    }

    public void setFullBoard(boolean fullBoard) {
        this.fullBoard = fullBoard;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }
}
