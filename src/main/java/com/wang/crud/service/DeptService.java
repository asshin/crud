package com.wang.crud.service;

import com.wang.crud.bean.Dept;
import com.wang.crud.bean.Msg;
import com.wang.crud.dao.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zsw
 * @create 2021-12-03 17:05
 */
@Service
public class DeptService {
    @Autowired
    DeptMapper deptMapper;
    public List<Dept> getDepts(){
        List<Dept> depts = deptMapper.selectByExample(null);

        return depts;
    }

}
