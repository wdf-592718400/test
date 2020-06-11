package com.test.service.impl;

import com.test.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    SqlSession sqlSession;

    public void insert(Object params){
        sqlSession.selectList("user.insert", params);
    }

    public void insertKey(Object params){
        sqlSession.selectList("user.insertKey", params);
    }

    public  void deleteKey(Object params){
        sqlSession.selectList("user.deleteKey", params);
    }

    public  void delete(Object params){
        sqlSession.selectList("user.delete", params);
    }

    public List<Map<String, Object>> select(Object params){
        return sqlSession.selectList("user.select", params);
    }

    public List<Map<String, Object>> selectKey(Object params){
        return sqlSession.selectList("user.selectKey", params);
    }

    public List<Map<String, Object>> selectAll(Object params){
        return sqlSession.selectList("user.selectAll", params);
    }

    public List<Map<String, Object>> selectId(Object params){
        return sqlSession.selectList("user.selectId", params);
    }

    public List<Map<String, Object>> forgetPassword(Object params){
        return sqlSession.selectList("user.forgetPassword", params);
    }

    public void resetPassword(Object params){
        sqlSession.selectList("user.resetPassword", params);
    }

    public void update(Object params){
        sqlSession.selectList("user.update", params);
    }
}
