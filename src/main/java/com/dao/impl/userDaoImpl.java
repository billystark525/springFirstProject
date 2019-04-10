package com.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.dao.userDao;
import com.dao.VO.userVO;

public class userDaoImpl implements userDao {

	private static final Map<String, userVO> userMap = new HashMap<String, userVO>();
    static {
    	userVO userVO = new userVO();
        userVO.setUsername("liyd");
        userVO.setPassword("123456");
        userVO.setRole("user");
        userMap.put(userVO.getUsername(), userVO);
        userVO = new userVO();
        userVO.setUsername("admin");
        userVO.setPassword("123456");
        userVO.setRole("admin");
        userMap.put(userVO.getUsername(), userVO);
    }
    @Override
    public userVO getUser(String username) {
        return userMap.get(username);
    }
}
