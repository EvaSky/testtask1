package com.test.service;

import com.test.model.User;

import java.util.List;

/**
 * Created by NotePad on 14.11.2015.
 */
public interface UserService {
    /*
         * CREATE and UPDATE
         */
    public void saveUser(User user); // create and update

    /*
     * READ
     */
    public List<User> listUsers();
    public List<User> listUsersPaging(Integer offset, Integer maxResults);
    public User getUser(int id);

    /*
     * DELETE
     */
    public void deleteUser(int id);
    public Long count();
    public List<User> listUsersFilter(String name);
}
