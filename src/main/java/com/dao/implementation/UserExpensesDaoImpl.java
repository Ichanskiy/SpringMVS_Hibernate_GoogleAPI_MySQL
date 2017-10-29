package com.dao.implementation;

import com.dao.interfaces.UserExpensesDao;
import com.entity.User;
import com.entity.UserExpenses;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

@Repository
@Slf4j
public class UserExpensesDaoImpl extends GenericDao implements UserExpensesDao {

    @Override
    public void saveUserExpenses(UserExpenses userExpenses) {
        Session session = getSessionFactory().getCurrentSession();
        session.persist(userExpenses);
        log.info("userExpenses successfully saved. Details: " + userExpenses);
    }

    public List<UserExpenses> getUserExpensesForTag(Date firstDate, Date secondDate, String phone) {
        CriteriaBuilder builder = getSessionFactory().getCriteriaBuilder();
        CriteriaQuery<UserExpenses> query = builder.createQuery(UserExpenses.class);
        Root<UserExpenses> root = query.from(UserExpenses.class);
        Predicate predicate1 = builder.between(root.<Date>get(UserExpenses.USEREXPERSES_DATE), firstDate, secondDate);
        Predicate predicate2 = builder.equal(root.get(UserExpenses.USER).get(User.USER_PHONE), phone);
        query.where(predicate1, predicate2);
        return getSessionFactory().createEntityManager().createQuery(query).getResultList();
    }

    @Override
    public List<UserExpenses> getUserExpensesById(int id) {
        CriteriaBuilder builder = getSessionFactory().getCriteriaBuilder();
        CriteriaQuery<UserExpenses> query = builder.createQuery(UserExpenses.class);
        Root<UserExpenses> root = query.from(UserExpenses.class);
        Predicate predicate = builder.equal(root.get(UserExpenses.USEREXPENSES_ID), id);
        query.where(predicate);
        return getSessionFactory().createEntityManager().createQuery(query).getResultList();
    }

    @Override
    public List<UserExpenses> getUserExpensesAll() {
        CriteriaBuilder builder = getSessionFactory().getCriteriaBuilder();
        CriteriaQuery<UserExpenses> query = builder.createQuery(UserExpenses.class);
        Root<UserExpenses> root = query.from(UserExpenses.class);
        query.select(root);
        return getSessionFactory().createEntityManager().createQuery(query).getResultList();
    }
}