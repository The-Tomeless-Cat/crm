package com.dao.system;

import java.util.List;

import com.model.system.UserMsg;

public interface UserMsgMapper {
    int deleteByPrimaryKey(String userMsgId);

    int insert(UserMsg record);

    int insertSelective(UserMsg record);

    UserMsg selectByPrimaryKey(String userMsgId);

    int updateByPrimaryKeySelective(UserMsg record);

    int updateByPrimaryKey(UserMsg record);

	List<UserMsg> selectAlluserMsg();
}