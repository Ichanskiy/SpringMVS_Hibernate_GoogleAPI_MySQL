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

    @Id
    @Column(name = "tag_name")
    private String tagName;

    @Column(name = "tag_name_parent_fk")
    private String tagNameParent;

    @Column(name = "tag_discription")
    private String tagDiscripton;


    /*@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "userexpenses",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "userexpenses_id"))
    Set<UserExpenses> userExpenses;*/

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tagSet")
    Set<UserExpenses> userExpenses;

}
