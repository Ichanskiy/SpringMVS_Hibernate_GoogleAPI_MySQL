package com.entity;

import javax.persistence.*;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
@Entity
@Table(name = "userexpensestag")
public class UserExpensesTag {

    @Column(name = "tag_name_fk")
    private String tagNameFk;

    @Id
    @Column(name = "user_expenses_id_fk")
    private int userExpensesIdFk;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_EXPENSES_ID_FK")
    private UserExpenses userExpenses;

    @ManyToOne
    @JoinColumn(name = "TAG_NAME_FK")
    private Tag tag;

    public UserExpensesTag() {
    }

    public String getTagNameFk() {
        return tagNameFk;
    }

    public void setTagNameFk(String tagNameFk) {
        this.tagNameFk = tagNameFk;
    }

    public int getUserExpensesIdFk() {
        return userExpensesIdFk;
    }

    public void setUserExpensesIdFk(int userExpensesIdFk) {
        this.userExpensesIdFk = userExpensesIdFk;
    }

    @Override
    public String toString() {
        return "UserExpensesTag{" +
                "tagNameFk='" + tagNameFk + '\'' +
                ", userExpensesIdFk=" + userExpensesIdFk +
                '}';
    }
}
