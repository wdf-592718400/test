package com.test.service;


import java.util.List;
import java.util.Map;

public interface UserService {
    void insert(Object params);
    void delete(Object params);
    List<Map<String, Object>> select(Object params);
    void update(Object params);
}
