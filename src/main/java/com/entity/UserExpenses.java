package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
@Entity
@Table(name = "userexpenses")
public class UserExpenses {

    @Id
    @Column(name = "userexpenses_id")
    private int userExpensesId;

    @Column(name = "user_phone_fk")
    private String userPhoneFk;

    @Column(name = "placepoint_id_fk")
    private int placePointIdFk;

    @Column(name = "userexperses_count")
    private double userExpensesCount;

    @Column(name = "userexperses_date")
    private Date userExpensesDate;

    public UserExpenses() {
    }

    public UserExpenses(int userExpensesId, String userPhoneFk, int placePointIdFk, double userExpensesCount, Date userExpensesDate) {
        this.userExpensesId = userExpensesId;
        this.userPhoneFk = userPhoneFk;
        this.placePointIdFk = placePointIdFk;
        this.userExpensesCount = userExpensesCount;
        this.userExpensesDate = userExpensesDate;
    }

    public int getUserExpensesId() {
        return userExpensesId;
    }

    public void setUserExpensesId(int userExpensesId) {
        this.userExpensesId = userExpensesId;
    }

    public String getUserPhoneFk() {
        return userPhoneFk;
    }

    public void setUserPhoneFk(String userPhoneFk) {
        this.userPhoneFk = userPhoneFk;
    }

    public int getPlacePointIdFk() {
        return placePointIdFk;
    }

    public void setPlacePointIdFk(int placePointIdFk) {
        this.placePointIdFk = placePointIdFk;
    }

    public double getUserExpensesCount() {
        return userExpensesCount;
    }

    public void setUserExpensesCount(double userExpensesCount) {
        this.userExpensesCount = userExpensesCount;
    }

    public Date getUserExpensesDate() {
        return userExpensesDate;
    }

    public void setUserExpensesDate(Date userExpensesDate) {
        this.userExpensesDate = userExpensesDate;
    }

    @Override
    public String toString() {
        return "UserExpenses{" +
                "userExpensesId=" + userExpensesId +
                ", userPhoneFk='" + userPhoneFk + '\'' +
                ", placePointIdFk=" + placePointIdFk +
                ", userExpensesCount=" + userExpensesCount +
                ", userExpensesDate=" + userExpensesDate +
                '}';
    }
}
