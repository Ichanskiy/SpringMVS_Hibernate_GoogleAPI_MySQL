package com.dao.implementation;

import com.dao.interfaces.UserExpensesDao;
import com.entity.UserExpenses;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.*;

@Repository
public class UserExpensesDaoImpl extends GenericDao implements UserExpensesDao {

    private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public void saveUserExpenses(UserExpenses userExpenses) {
        Session session = getSessionFactory().getCurrentSession();
        session.persist(userExpenses);
        log.info("userExpenses successfully saved. Details: " + userExpenses);
    }

    @Override
    public List<UserExpenses> getExpensesForTag(Date firstDate, Date secondDate, String phone) {
        CriteriaBuilder builder = getSessionFactory().getCriteriaBuilder();
        CriteriaQuery<UserExpenses> query = builder.createQuery(UserExpenses.class);
        Root<UserExpenses> root = query.from(UserExpenses.class);
        builder.between(root.get(UserExpenses.USER_EXPENSES_DATE).as(Date.class), firstDate, secondDate);
        return getSessionFactory().createEntityManager().createQuery(query).getResultList();

//        Session session = getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(UserExpenses.class, "ue").setCacheable(false);
//        criteria.createAlias("ue.user","u");
//        criteria.createAlias("ue.tag","t");
//        criteria.add(Restrictions.eq("u.user_phone", phone));
//        criteria.add(Restrictions.between("userexperses_date", firstDate, secondDate));
//        criteria.setProjection(Projections.projectionList()
////                .add(Projections.groupProperty("t.tag_name")));
//                .add(Projections.groupProperty("ue.tag")));
////                .add(Projections.sum("ue.userexperses_count")));

    }

    @Override
    public boolean getUserExpensesById(int id) {
        return false;
    }
}
