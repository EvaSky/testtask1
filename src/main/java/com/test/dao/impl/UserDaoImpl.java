package com.test.dao.impl;

import com.test.dao.UserDao;
import com.test.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by NotePad on 14.11.2015.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveUser(User user) {

        getSession().merge(user);
    }

    public List<User> listUsers() {

        return getSession().createCriteria(User.class).list();
    }

    public User getUser(int id) {
        return (User) getSession().get(User.class, id);
    }

    public void deleteUser(int id) {

        User user = getUser(id);

        if (null != user) {
            getSession().delete(user);
        }
    }
    public List<User> listUsersPaging(Integer offset, Integer maxResults) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.setFirstResult(offset!=null?offset:0);
        criteria.setMaxResults(maxResults!=null?maxResults:10);

        return criteria.list();
    }
    public Long count(){
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.setProjection(Projections.rowCount());

        return (Long)criteria.uniqueResult();
    }

    public List<User> listUsersFilter(String name){
        Criteria criteria = getSession().createCriteria(User.class);
        Criterion c = Restrictions.like("name", name, MatchMode.START);
        criteria.add(c);
        return criteria.list();
    }

    private Session getSession() {
        Session sess = getSessionFactory().getCurrentSession();
        if (sess == null) {
            sess = getSessionFactory().openSession();
        }
        return sess;
    }

    private SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
