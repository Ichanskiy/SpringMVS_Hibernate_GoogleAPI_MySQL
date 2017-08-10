package com.dao.implementation;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Getter
@Setter
@Repository
public class GenericDao {

    @Autowired
    private SessionFactory sessionFactory;

}
