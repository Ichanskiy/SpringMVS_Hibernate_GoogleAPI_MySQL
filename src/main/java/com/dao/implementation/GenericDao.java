package com.dao.implementation;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;

@Getter
@Setter
@Repository
public class GenericDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Long getCountFromQuery(CriteriaQuery query) {
        try {
            return (Long) sessionFactory.createEntityManager().createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void executeUpdate(CriteriaDelete query) {
        try {
            sessionFactory.createEntityManager().createQuery(query).executeUpdate();
        } finally {
            sessionFactory.close();
        }
    }
}
