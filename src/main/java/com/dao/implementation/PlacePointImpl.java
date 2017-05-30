package com.dao.implementation;

import com.dao.interfaces.PlacePointDao;
import com.entity.PlacePoint;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
public class PlacePointImpl implements PlacePointDao {

    private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void savePlacePoint(PlacePoint placePoint) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(placePoint);
        log.info("placePoint successfully saved. Details: " + placePoint);
    }

    @Override
    public boolean getPalacePointByAddress(String address) {
        Session session = this.sessionFactory.getCurrentSession();
        System.out.println(address);
        PlacePoint placePoint = (PlacePoint) session.get(PlacePoint.class, address);
        System.out.println(placePoint);
        if (placePoint  == null) {
            return  true;
        }else return false;
    }

    @Override
    public boolean getPalacePointById(int id) {
        System.out.println(id);
        Session session = this.sessionFactory.getCurrentSession();
        PlacePoint placePoint = (PlacePoint) session.get(PlacePoint.class, id);
        System.out.println(placePoint);
        if (placePoint  == null) {
            return  true;
        }else return false;
    }
}
