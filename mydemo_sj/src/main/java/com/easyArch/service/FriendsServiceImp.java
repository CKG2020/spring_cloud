package com.easyArch.service;

import com.easyArch.dao.FriendsDao;
import com.easyArch.dao.FriendsDaoImp;
import com.easyArch.entity.BoardMsg;
import com.easyArch.util.dateUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendsServiceImp implements FriendsService {

    FriendsDao friendsDao = new FriendsDaoImp();


    public int countFriends(String sno) {
        return 0;
    }

    public boolean addFriend(String sno1, String sno2) {
        return false;
    }


    public String tipsMessage() {
        return null;
    }

    public String friendhandler() {
        return null;
    }


    public List<String> showAdd() {
        return null;
    }


    public boolean addBoardMsg(BoardMsg msg) {
        msg.setDate_time(dateUtil.sendDate());
        return friendsDao.insertBoardMsg(msg);
    }
}
