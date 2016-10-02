package com.yaya.demo.web.handler;

import com.yaya.demo.service.Impl.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class AdminHandler {

    private AdminService adminService;

    @Autowired
    public AdminHandler(AdminService adminService) {
        this.adminService = adminService;
    }
}
