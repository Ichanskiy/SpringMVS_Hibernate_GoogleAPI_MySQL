package com.dao.implementation;

import com.dao.interfaces.TagDao;
import com.entity.Tag;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class TagDaoImpl extends GenericDao implements TagDao {

    @Override
    public void saveTag(Tag tag) {
        Session session = getSessionFactory().getCurrentSession();
        System.out.println(tag.getTagName());
        if (!getTagByTagName(tag.getTagName())){
            session.save(tag);
            log.info("tag successfully saved. Details: " + tag);
        } else {
            log.info("Tag isn`t new - it don`t save. Detail: " + tag);
        }
    }

    @Override
    public boolean getTagByTagName(String name) {
        Session session = getSessionFactory().getCurrentSession();
        System.out.println(name);
        Tag tag = (Tag) session.get(Tag.class, name);
        System.out.println(tag);
        if (tag  == null) {
            return  false;
        }else return true;
    }
}
