package com.yaya.demo.dal.impl.admin;

import com.yaya.demo.dal.BaseDAO;
import com.yaya.demo.dal.impl.BaseDAOImpl;
import com.yaya.demo.persistence.entities.Admin;
import org.springframework.stereotype.Repository;

@Repository(value = "adminDAO")
public class AdminDAOImpl extends BaseDAOImpl<Admin> implements BaseDAO<Admin> {


}
