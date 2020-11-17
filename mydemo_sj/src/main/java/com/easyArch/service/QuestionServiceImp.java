package com.easyArch.service;

import com.easyArch.dao.QuestionDao;
import com.easyArch.dao.QuestionDaoImp;
import com.easyArch.util.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImp implements QuestionService {

     static QuestionDao questionDao = new QuestionDaoImp();
     static List list =questionDao.questionList();


    public List showQuestion(int curr,int pageSize) {
        return Page.pageDiv(curr,pageSize,list);
    }


}
