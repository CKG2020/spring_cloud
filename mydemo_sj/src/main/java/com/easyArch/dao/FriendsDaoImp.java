package com.easyArch.dao;

import com.easyArch.entity.BoardMsg;
import com.easyArch.entity.FriendRequest;
import com.easyArch.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

public class FriendsDaoImp implements FriendsDao{

    private SqlSession sqlSession ;
    {
        sqlSession= UserDaoImp.sqlSession;
    }


    public int countFriends(String sno) {
        return sqlSession.selectOne("UserBoard.countFriends",sno);
    }


    public List<User> friendList(String sno) {
        return sqlSession.selectList("UserBoard.myFriends",sno);
    }

    public List<User> friendRequestList(String sno) {

        return sqlSession.selectList("UserBoard.friendsRequest",sno);
    }

    public User findUserBySno(String sno) {
        return sqlSession.selectOne("UserMapper.findUserBySno");
    }

    public boolean delFriends(FriendRequest del) {
        sqlSession.delete("UserBoard.delFriend1",del);
        sqlSession.delete("UserBoard.delFriend2",del);
        sqlSession.commit();
        return true;
    }


    public boolean insertBoardMsg(BoardMsg msg) {
        sqlSession.insert("UserBoard.insertBoardMsg",msg);
        sqlSession.commit();
        return true;
    }


}
