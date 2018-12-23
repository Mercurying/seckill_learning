package com.mercury.service;


import com.mercury.error.BusinessException;
import com.mercury.service.model.UserModel;

public interface UserService {
    UserModel getUserById(Integer id);

    void register(UserModel userModel) throws BusinessException;

    UserModel login(String telphone, String encryptedPassword) throws BusinessException;
}
