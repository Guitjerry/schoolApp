package com.sushe.dao;


import com.sushe.entity.UserChallenge;

public interface UserChallengeMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserChallenge record);

    int insertSelective(UserChallenge record);

    UserChallenge selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserChallenge record);

    int updateByPrimaryKey(UserChallenge record);
}