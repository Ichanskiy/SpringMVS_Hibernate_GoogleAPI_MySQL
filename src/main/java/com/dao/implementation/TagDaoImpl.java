package com.dao.implementation;

import com.dao.interfaces.TagDao;
import com.entity.Tag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
public class TagDaoImpl implements TagDao {

    private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveTag(Tag tag) {
        Session session = this.sessionFactory.getCurrentSession();
        System.out.println(tag.getTagName());
        if (!getTagByTagName(tag.getTagName())){
            session.save(tag);
            log.info("tag successfully saved. Details: " + tag);
        } else {
            log.info("tag successfully saved. Details: " + tag);
            System.out.println("tag not save");
        }
    }

    @Override
    public boolean getTagByTagName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        System.out.println(name);
        Tag tag = (Tag) session.get(Tag.class, name);
        System.out.println(tag);
        if (tag  == null) {
            return  false;
        }else return true;
    }
}
