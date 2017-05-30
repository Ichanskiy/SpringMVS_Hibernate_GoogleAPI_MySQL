package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
@Entity
@Table(name = "userexpensestag")
public class UserExpensesTag {

    @Id
    @Column(name = "tag_name_fk")
    private String tagNameFk;

    @Id
    @Column(name = "user_expenses_id_fk")
    private int userExpensesIdFk;

}
