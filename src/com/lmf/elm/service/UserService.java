package com.lmf.elm.service;

import com.lmf.elm.vo.User;

public interface UserService {
    User findUserByUserIdAndPassword(String userId,String password);
    int registerUser(User user);
}
