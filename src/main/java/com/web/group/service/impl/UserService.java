package com.web.group.service.impl;

import com.web.group.dao.operator.UserOperator;
import com.web.group.entity.User;
import com.web.group.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserOperator userOperator;

    @Override
    public User getUserInfoByUserId(Integer id) {
        return userOperator.getUserInfoByUserId(id);
    }

    public List<User> getUserInfoByUserName(String userName) {
        return userOperator.getUserInfoByUserName(userName);
    }

    public boolean insertUser(User user) {
        return userOperator.insertUser(user);
    }

    public User getUserInfo(String userName, String userPassword) {
        return userOperator.getUserInfo(userName, userPassword);
    }

    @Transactional( propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public boolean updatePassword(String userName, String newPassword) {
        return userOperator.updatePassword(userName, newPassword);
    }
}
