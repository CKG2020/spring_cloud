package com.easyArch.dao;

import com.easyArch.util.LoadTxt;
import com.easyArch.util.mybatis;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class QuestionDaoImp implements QuestionDao{

    private SqlSession sqlSession ;
    {
        sqlSession= mybatis.getSqlSession();
    }


    public List questionList() {
        String str = sqlSession.selectOne("loadAnswers");
        System.out.println(LoadTxt.ReadQuestions(str));
        return LoadTxt.ReadQuestions(str);
    }

}
