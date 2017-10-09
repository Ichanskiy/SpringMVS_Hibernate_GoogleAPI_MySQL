package com.dao.implementation;

import com.dao.interfaces.UserExpensesDao;
import com.entity.UserExpenses;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

@Repository
public class UserExpensesDaoImpl extends GenericDao implements UserExpensesDao {

    private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public void saveUserExpenses(UserExpenses userExpenses) {
        Session session = getSessionFactory().getCurrentSession();
        session.persist(userExpenses);
        log.info("userExpenses successfully saved. Details: " + userExpenses);
    }

    public List<UserExpenses> getExpensesForTag(Date firstDate, Date secondDate, String phone) {
        CriteriaBuilder builder = getSessionFactory().getCriteriaBuilder();
        CriteriaQuery<UserExpenses> query = builder.createQuery(UserExpenses.class);
        Root<UserExpenses> root = query.from(UserExpenses.class);
        Predicate predicate = builder.between(root.<Date>get(UserExpenses.USEREXPERSES_DATE), firstDate, secondDate);
        query.where(predicate);
        return getSessionFactory().createEntityManager().createQuery(query).getResultList();
    }

    @Override
    public boolean getUserExpensesById(int id) {
        return false;
    }
}
