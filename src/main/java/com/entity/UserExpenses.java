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

    public static final String USEREXPENSES_ID = "userexpenses_id";
    public static final String USEREXPERSES_COUNT = "userexperses_count";
    public static final String USEREXPERSES_DATE = "userexperses_date";
    public static final String USER_PHONE_FK = "user_phone_fk";

    @Id
    @Column(name = USEREXPENSES_ID)
    private int userexpenses_id;

    @Column(name = USEREXPERSES_COUNT)
    private double userexperses_count;

    @Column(name = USEREXPERSES_DATE)
    private Date userexperses_date;

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


    public UserExpenses(double userExpensesCount, Date userexperses_date) {
        this.userexperses_count = userExpensesCount;
        this.userexperses_date = userexperses_date;
    }

    public UserExpenses(UserExpenses userExpenses) {
    }
}
