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

    public  void delete(Object params){
        sqlSession.selectList("user.delete", params);
    }

    public List<Map<String, Object>> select(Object params){
        return sqlSession.selectList("user.select", params);
    }

    public void update(Object params){
        sqlSession.selectList("user.update", params);
    }
}
