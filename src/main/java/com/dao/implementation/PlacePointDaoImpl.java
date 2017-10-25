package com.dao.implementation;

import com.dao.interfaces.PlacePointDao;
import com.entity.PlacePoint;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

@Repository
@Slf4j
public class PlacePointDaoImpl extends GenericDao implements PlacePointDao {

    @Override
    public int savePlacePoint(PlacePoint placePoint) {
        Session session = getSessionFactory().getCurrentSession();
        session.saveOrUpdate(placePoint);
        log.info("placePoint successfully saved. Details: " + placePoint);
        return placePoint.getPlacepoint_id();
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

    @Override
    public PlacePoint getAddressById(int id) {
        CriteriaBuilder builder = getSessionFactory().getCriteriaBuilder();
        CriteriaQuery<PlacePoint> query = builder.createQuery(PlacePoint.class);
        Root<PlacePoint> root = query.from(PlacePoint.class);
        Predicate predicate = builder.equal(root.get(PlacePoint.PLACEPOINT_ID), id);
        query.where(predicate);
        return getSessionFactory().createEntityManager().createQuery(query).getSingleResult();
    }
}
