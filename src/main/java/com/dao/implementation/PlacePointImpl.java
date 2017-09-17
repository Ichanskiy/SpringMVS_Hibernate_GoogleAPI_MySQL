package com.dao.implementation;

import com.dao.interfaces.PlacePointDao;
import com.entity.PlacePoint;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class PlacePointImpl extends GenericDao implements PlacePointDao {

    private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public int savePlacePoint(PlacePoint placePoint) {
        Session session = getSessionFactory().getCurrentSession();
        session.saveOrUpdate(placePoint);
        log.info("placePoint successfully saved. Details: " + placePoint);
        return placePoint.getPlacePointId();
    }

    @Override
    public boolean getPalacePointByAddress(String address) {
        CriteriaBuilder builder = getSessionFactory().getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        Root<PlacePoint> root = query.from(PlacePoint.class);
        query.select(builder.count(root));
        query.where(builder.equal(root.get(PlacePoint.PLACEPOINT_ADDRESS), address));
        long count =  getSessionFactory().createEntityManager().createQuery(query).getSingleResult();
        return count > 1;
//        Session session = getSessionFactory().getCurrentSession();
//        System.out.println(address);
//        PlacePoint placePoint = (PlacePoint) session.get(PlacePoint.class, address);
//        System.out.println(placePoint);
//        if (placePoint  == null) {
//            return  true;
//        }else return false;
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
