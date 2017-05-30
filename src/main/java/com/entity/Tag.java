package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @Column(name = "tag_name")
    private String tagName;

    @Id
    @Column(name = "tag_name_parent_fk")
    private String tagNameParent;

    @Column(name = "tag_discription")
    private String tagDiscripton;


    public Tag() {
    }

    public Tag(String tagName, String tagNameParent, String tagDiscripton) {
        this.tagName = tagName;
        this.tagNameParent = tagNameParent;
        this.tagDiscripton = tagDiscripton;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagNameParent() {
        return tagNameParent;
    }

    public void setTagNameParent(String tagNameParent) {
        this.tagNameParent = tagNameParent;
    }

    public String getTagDiscripton() {
        return tagDiscripton;
    }

    public void setTagDiscripton(String tagDiscripton) {
        this.tagDiscripton = tagDiscripton;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagName='" + tagName + '\'' +
                ", tagNameParent='" + tagNameParent + '\'' +
                ", tagDiscripton='" + tagDiscripton + '\'' +
                '}';
    }
}
