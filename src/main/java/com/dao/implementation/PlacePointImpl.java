package com.dao.implementation;

import com.dao.interfaces.PlacePointDao;
import com.entity.PlacePoint;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PlacePointImpl extends GenericDao implements PlacePointDao {

    private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public int savePlacePoint(PlacePoint placePoint) {
        System.out.println("1");
        System.out.println(placePoint);
        Session session = getSessionFactory().getCurrentSession();
        System.out.println("2");
        session.persist(placePoint);
        System.out.println("3");
        //Serializable id = session.save(placePoint);
        System.out.println("id = " + placePoint.getPlacePointId());
        log.info("placePoint successfully saved. Details: " + placePoint);
        return placePoint.getPlacePointId();
    }

    @Override
    public boolean getPalacePointByAddress(String address) {
        Session session = getSessionFactory().getCurrentSession();
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
        Session session = getSessionFactory().getCurrentSession();
        PlacePoint placePoint = (PlacePoint) session.get(PlacePoint.class, id);
        System.out.println(placePoint);
        if (placePoint  == null) {
            return  true;
        }else return false;
    }
}
