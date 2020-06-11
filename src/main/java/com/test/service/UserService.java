package com.test.service;


import java.util.List;
import java.util.Map;

public interface UserService {
    void insert(Object params);
    void insertKey(Object params);
    void deleteKey(Object params);
    void delete(Object params);
    List<Map<String, Object>> select(Object params);
    List<Map<String, Object>> selectKey(Object params);
    List<Map<String, Object>> selectAll(Object params);
    List<Map<String, Object>> selectId(Object params);
    List<Map<String, Object>> forgetPassword(Object params);
    void resetPassword(Object params);
    void update(Object params);
}
