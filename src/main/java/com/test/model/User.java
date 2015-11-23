package com.test.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * Created by NotePad on 14.11.2015.
 */
@Entity
@Table(name = "user")
public class User {

        private int id;
        private String name;
        private int age;
        private boolean isAdmin;
        private Date createdDate;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        public int getId() {
            return id;
        }

        @Column(nullable = false)
        public String getName() {
            return name;
        }

        @Column(nullable = false)
        public int getAge() {
            return age;
        }

        @Column(nullable = false)
        public boolean isAdmin() {
            return isAdmin;
        }

        @Column(nullable = false)
        public Date getCreatedDate() {
            return createdDate;
        }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
