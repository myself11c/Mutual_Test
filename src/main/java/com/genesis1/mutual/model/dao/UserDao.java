package com.genesis1.mutual.model.dao;


import com.genesis1.mutual.model.entity.User;
import org.springframework.data.repository.CrudRepository;
public interface UserDao  extends CrudRepository<User, Integer>{
}
