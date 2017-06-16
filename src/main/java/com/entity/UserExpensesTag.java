package com.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
@Entity
@Table(name = "userexpensestag")
@Getter
@Setter
@ToString
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
}
