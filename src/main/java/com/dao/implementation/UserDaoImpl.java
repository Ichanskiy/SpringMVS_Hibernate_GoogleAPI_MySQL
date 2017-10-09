package com.dao.implementation;

import com.dao.interfaces.UserDao;
import com.entity.subsidary.AuthorisationUser;
import com.entity.User;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Repository
public class UserDaoImpl extends GenericDao implements UserDao<User> {

    private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public void saveUser(User user) {
        Session session = getSessionFactory().getCurrentSession();
        session.persist(user);
        log.info("User successfully saved. Details: " + user);
    }

    @Override
    public boolean getUserByPhone(String phone) {
        CriteriaBuilder builder = getSessionFactory().getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.where(builder.equal(root.get(User.USER_PHONE), phone));
        Long count = getCountFromQuery(query);
        if(count == null)
            return true;
        else
            return false;
    }

    @Override
    public boolean getUser(AuthorisationUser authorisationUser) {
        CriteriaBuilder builder = getSessionFactory().getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Predicate predicate1 = builder.and(builder.equal(root.get(User.USER_PHONE), authorisationUser.getUser_phone()));
        Predicate predicate2 = builder.and(builder.equal(root.get(User.USER_EMAIL), authorisationUser.getUser_email()));
        query.where(predicate1, predicate2);
        return !getSessionFactory().createEntityManager().createQuery(query).getResultList().isEmpty();
    }

    @Override
    public User getUserById(String id) {
        CriteriaBuilder builder = getSessionFactory().getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.where(builder.equal(root.get(User.USER_PHONE), id));
        return getSessionFactory().createEntityManager().createQuery(query).getSingleResult();
    }
}
