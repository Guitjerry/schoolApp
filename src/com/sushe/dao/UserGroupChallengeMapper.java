package com.sushe.dao;


import com.sushe.entity.UserGroupChallenge;

public interface UserGroupChallengeMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserGroupChallenge record);

    int insertSelective(UserGroupChallenge record);

    UserGroupChallenge selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserGroupChallenge record);

    int updateByPrimaryKey(UserGroupChallenge record);
}