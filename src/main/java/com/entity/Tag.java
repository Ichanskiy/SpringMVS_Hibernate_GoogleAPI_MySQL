package com.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
@Entity
@Table(name = "tag")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "userExpenses")
public class Tag {

    public static final String TAG_NAME = "tag_name";
    public static final String TAG_NAME_PARENT_FK = "tag_name_parent_fk";
    public static final String TAG_DISCRIPTON = "tag_discription";

    @Id
    @Column(name = TAG_NAME)
    private String tagName;

    @Column(name = TAG_NAME_PARENT_FK)
    private String tagNameParent;

    @Column(name = TAG_DISCRIPTON)
    private String tagDiscripton;


    /*@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "userexpenses",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "userexpenses_id"))
    Set<UserExpenses> userExpenses;*/

//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tagSet")

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tag",cascade = CascadeType.ALL)
    Set<UserExpenses> userExpenses;

}
