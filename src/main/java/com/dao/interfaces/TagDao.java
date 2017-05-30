package com.dao.interfaces;

import com.entity.Tag;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
public interface TagDao {
    void saveTag(Tag tag);
    boolean getTagByTagName(String name);
}
