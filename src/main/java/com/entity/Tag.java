package com.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
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
@ToString
public class Tag {

    @Id
    @Column(name = "tag_name")
    private String tagName;

    @Column(name = "tag_name_parent_fk")
    private String tagNameParent;

    @Column(name = "tag_discription")
    private String tagDiscripton;

    /*@OneToMany(mappedBy = "tag",cascade = CascadeType.ALL)
    private Set<UserExpensesTag> userExpensesTagSet = new HashSet<UserExpensesTag>(0);*/
}
