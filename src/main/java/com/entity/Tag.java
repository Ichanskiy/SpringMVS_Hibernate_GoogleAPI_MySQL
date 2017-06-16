package com.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
@ToString
public class Tag {

    @Id
    @Column(name = "tag_name")
    private String tagName;

    @Column(name = "tag_name_parent_fk")
    private String tagNameParent;

    @Column(name = "tag_discription")
    private String tagDiscripton;

    @OneToMany(mappedBy = "tag",cascade = CascadeType.ALL)
    private Set<UserExpensesTag> userExpensesTagSet = new HashSet<UserExpensesTag>(0);

    public Tag() {
    }

    public Tag(String tagName, String tagNameParent, String tagDiscripton) {
        this.tagName = tagName;
        this.tagNameParent = tagNameParent;
        this.tagDiscripton = tagDiscripton;
    }
}
