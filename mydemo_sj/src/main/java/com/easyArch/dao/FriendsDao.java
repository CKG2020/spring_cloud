package com.easyArch.dao;

import com.easyArch.entity.BoardMsg;
import com.easyArch.entity.FriendRequest;
import com.easyArch.entity.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public interface FriendsDao {

    int countFriends(String sno);
    List<User> friendList(String sno);
    List<User> friendRequestList(String sno);
    User findUserBySno(String sno);
    boolean delFriends(FriendRequest del);

    boolean insertBoardMsg(BoardMsg msg);



}
