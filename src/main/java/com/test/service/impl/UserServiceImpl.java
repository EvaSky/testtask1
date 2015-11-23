package com.test.service.impl;

import com.test.dao.UserDao;
import com.test.model.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by NotePad on 14.11.2015.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Transactional( readOnly = true)
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional( readOnly = true)
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @SuppressWarnings("unchecked")
    @Transactional( readOnly = true)
    public List<User> listUsersPaging(Integer offset, Integer maxResults) {
        return userDao.listUsersPaging(offset, maxResults);
    }
    @Transactional( readOnly = true)
    public Long count(){
        return userDao.count();
    }
    @Transactional( readOnly = true)
    public List<User> listUsersFilter(String name){
        return userDao.listUsersFilter(name);
    }
}
