package com.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
@Entity
@Table(name = "userexpenses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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

  /*  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_PHONE_FK", nullable = false)
    private User user;*/
/*

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userExpenses",cascade = CascadeType.ALL)
    private Set<PlacePoint> placePointSet = new HashSet<PlacePoint>(0);
*/

  /*  @OneToMany(fetch = FetchType.LAZY, mappedBy = "userExpenses", cascade = CascadeType.ALL)
    private Set<UserExpensesTag> userExpensesTags = new HashSet<UserExpensesTag>(0);*/

    public UserExpenses(double userExpensesCount, Date userExpensesDate) {
        this.userExpensesCount = userExpensesCount;
        this.userExpensesDate = userExpensesDate;
    }

    public UserExpenses(UserExpenses userExpenses) {
    }
}
