package com.easyArch.dao;


import com.easyArch.entity.*;
import com.easyArch.entity.*;
import com.easyArch.util.mybatis;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class UserDaoImp implements UserDAO{

    public static SqlSession sqlSession ;

    static {
        sqlSession=mybatis.getSqlSession();
    }

    public int addUser(User user, UserBoard userBoard) {
        int s=sqlSession.insert("UserMapper.addUser",user);
        sqlSession.insert("UserBoard.addUserBoard",userBoard);
        sqlSession.commit();
        return s;
    }

    public boolean deleteUser(String sno) {
        sqlSession.delete("UserMapper.delpyq",sno);
        sqlSession.delete("UserMapper.delb",sno);
        sqlSession.delete("UserMapper.delUser", sno);
        sqlSession.commit();
        return true;

    }

    public List<UserShow> findAll() {
        return sqlSession.selectList("UserMapper.findUserShow");
    }


    public List<UserShow> findUsersBySno(String Sno) {
        return sqlSession.selectList("UserMapper.findbysno",Sno);
    }


    public List<UserShow> findUsersByName(String name) {
        return sqlSession.selectList("UserMapper.findbyName",name);
    }


    public List<UserShow> findUsersByAge(int age) {
        return sqlSession.selectList("UserMapper.findbyAge",age);
    }


    public List<UserShow> findUsersByCollage(String collage) {
        return sqlSession.selectList("UserMapper.findbyCollage",collage);
    }

    public List<UserShow> findUsersByClass(String sclass) {
        return sqlSession.selectList("UserMapper.findbyClass",sclass);
    }

    public String findUserNameBySno(String sno) {
        return sqlSession.selectOne("UserMapper.findUserNameBySno",sno);
    }


    public User login(String Sno, String pwd) {
        return sqlSession.selectOne("UserMapper.selectUser",Sno);
    }


    public Admin adminlogin(String username, String pwd) {
        return sqlSession.selectOne("UserMapper.selectAdmin",username);
    }

    public boolean updateUser(User user) {
        sqlSession.update("UserMapper.updateUser",user);
        sqlSession.update("UserMapper.updateBirth",user);
        sqlSession.commit();
        return true;
    }

    public int findSnoCount(String sno) {
        return sqlSession.selectOne("UserMapper.findSnoCount",sno);
    }


    public int findallcount(){
        return sqlSession.selectOne("UserMapper.findallcount");
    }


    public int findAllFinished(){
        return sqlSession.selectOne("UserBoard.allFinished");
    }

    public int findAgeCount(int age){
        return sqlSession.selectOne("UserMapper.findAgeCount",age);
    }

    public int findNameCount(String name) {
        return sqlSession.selectOne("UserMapper.findNameCount",name);
    }

    public int findCollageCount(String collage) {
        return sqlSession.selectOne("UserMapper.findCollageCount",collage);
    }


    public int findClassCount(String sclass) {
        return sqlSession.selectOne("UserMapper.findClassCount",sclass);
    }

    public int findFriendsCount(String sno) {
        return sqlSession.selectOne("UserBoard.countFriends",sno);
    }

    public UserBoard setScores(String sno,int scores) {
        UserBoard userBoard = new UserBoard();
        userBoard.setSno(sno);
        userBoard.setIsFinishedQuestion(true);
        userBoard.setScores(scores);
        sqlSession.update("updateFinishedQuestion",userBoard);
        sqlSession.commit();
        return userBoard;
    }

    public int searchScore(String sno){
        return sqlSession.selectOne("UserBoard.searchScore",sno);
    }

    public boolean isFinished(String sno) {
        if(sqlSession.selectOne("UserBoard.isFinished", sno)==null){
            return false;
        }
        return sqlSession.selectOne("UserBoard.isFinished", sno);
    }


    public List<BoardMsg> showBoardMsg(String sno) {
        return sqlSession.selectList("UserBoard.showBoardMsg",sno);
    }


    public User findUserBySno(String sno) {
        return sqlSession.selectOne("UserMapper.findUserBySno",sno);
    }
    //实现对数据库操作的接口中的方法

    public List<Integer> findScore(){
        return sqlSession.selectList("UserBoard.findScore");
    }

    public boolean insertBoardMsg(BoardMsg msg) {
        sqlSession.insert("UserBoard.insertBoardMsg",msg);
        sqlSession.commit();
        return true;
    }


    public int countBoardMsg(String sno) {
        return sqlSession.selectOne("UserBoard.boardMsgCount",sno);
    }

    public int historyMsgCount(String sno) {
        return sqlSession.selectOne("UserBoard.historyMsgCount",sno);
    }

    public int historyRequestCount(String sno) {
        return sqlSession.selectOne("UserBoard.historyRequestCount",sno);
    }

    public int setHistoryMsgCount(Tips tips) {
        System.out.println(tips);
        sqlSession.update("UserBoard.setHistoryMsgCount", tips);
        sqlSession.commit();
        return 0;
    }

    public int setHistoryRequestCount(Tips tips) {
        sqlSession.update("UserBoard.setHistoryRequestCount", tips);
        sqlSession.commit();
        return 0;
    }

    public boolean addRequest(FriendRequest request) {
        sqlSession.insert("UserBoard.addFriendRequest",request);
        sqlSession.commit();
        return true;
    }

    public boolean acceptRequest(FriendRequest request) {
        sqlSession.update("UserBoard.acceptAdd",request);
        sqlSession.insert("UserBoard.addFriend",request);
        sqlSession.commit();
        return true;
    }


    public boolean refuseRequest(FriendRequest request) {
        sqlSession.delete("UserBoard.refuseAdd",request);
        sqlSession.commit();
        return true;
    }


    public int countRequest(String sno) {
        return sqlSession.selectOne("UserBoard.countRequest",sno);
    }


    public void close() {
        sqlSession.close();
    }


    public void getSession() {
        sqlSession=mybatis.getSqlSession();
    }

    public List<UserBoard> findUserBoard(String sno) {
        return sqlSession.selectOne("UserBoard.findUserBoard",sno);
    }
}
