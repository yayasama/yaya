package com.yaya.demo.service.Impl.admin;

import com.yaya.demo.dal.impl.admin.AdminDAOImpl;
import com.yaya.demo.persistence.entities.Admin;
import com.yaya.demo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "adminService")
public class AdminService implements BaseService<Admin> {


    private AdminDAOImpl adminDAO;

    @Autowired
    public AdminService(AdminDAOImpl adminDAO) {
        this.adminDAO = adminDAO;
    }
}
