package com.yaya.demo.service.Impl.customer;

import com.yaya.demo.dal.impl.customer.CustomerDAOImpl;
import com.yaya.demo.persistence.entities.Customer;
import com.yaya.demo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 管理员业务逻辑层
 *
 * @author ChW 2016-03-22 13:34:56
 */
@Service(value = "customerService")
public class CustomerService implements BaseService<Customer> {

    private CustomerDAOImpl customerDAO;

    @Autowired
    public CustomerService(CustomerDAOImpl customerDAO) {
        this.customerDAO = customerDAO;
    }


    public void save(Customer customer) {
        customerDAO.saveEntity(customer);
    }
}
