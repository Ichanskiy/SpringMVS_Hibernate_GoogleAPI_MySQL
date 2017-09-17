package com.dao.implementation;

import com.dao.interfaces.TagDao;
import com.entity.Tag;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TagDaoImpl extends GenericDao implements TagDao {

    private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

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
