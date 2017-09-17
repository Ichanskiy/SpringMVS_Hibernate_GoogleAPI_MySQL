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
@ToString(exclude = {"user","placePointSet","placePointSet"})
public class UserExpenses {

    public static final String USER_EXPENSES_ID = "userexpenses_id";
    public static final String USER_EXPENSES_COUNT = "userexperses_count";
    public static final String USER_EXPENSES_DATE = "userexperses_date";
    private static final String USER_PHONE_FK = "user_phone_fk";

    @Id
    @Column(name = USER_EXPENSES_ID)
    private int userExpensesId;

    @Column(name = USER_EXPENSES_COUNT)
    private double userExpensesCount;

    @Column(name = USER_EXPENSES_DATE)
    private Date userExpensesDate;

    @ManyToOne//(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = USER_PHONE_FK, nullable = false)
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userExpenses",cascade = CascadeType.ALL)
    private Set<PlacePoint> placePointSet = new HashSet<PlacePoint>(0);


   /* @ManyToMany
    @JoinTable(name = "tagexpanses", joinColumns = {@JoinColumn(name = "tag_id")}, inverseJoinColumns = {@JoinColumn(name = "userexpenses_id")})
    Set<Tag> tags;*/
//
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "tagexpanses", joinColumns =
//            @JoinColumn(name = "userexpenses_id"),
//            inverseJoinColumns =  @JoinColumn(name = "tag_name",
//                    nullable = false, updatable = false) )

    @ManyToOne
    @JoinColumn(name = "tag_name_fk", nullable = false)
    private Tag tag;


    public UserExpenses(double userExpensesCount, Date userExpensesDate) {
        this.userExpensesCount = userExpensesCount;
        this.userExpensesDate = userExpensesDate;
    }

    public UserExpenses(UserExpenses userExpenses) {
    }
}
