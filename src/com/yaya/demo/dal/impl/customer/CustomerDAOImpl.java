package com.yaya.demo.dal.impl.customer;

import com.yaya.demo.dal.BaseDAO;
import com.yaya.demo.dal.impl.BaseDAOImpl;
import com.yaya.demo.persistence.entities.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 管理员对象数据访问层
 *
 * @author ChW 2016-03-22 11:41:44
 */
@Repository(value = "customerDAO")
public class CustomerDAOImpl extends BaseDAOImpl<Customer> implements BaseDAO<Customer> {


    /**
     * 同时根据用户名和密码查找管理员
     *
     * @param customer 传入管理员
     * @return customer
     */
    public Customer findByInfo(Customer customer) {
        String jpql = "FROM Customer u WHERE u.identifier=?1 and u.password=?2";
        List<Customer> customers = this.getEntitiesByJPQL(jpql, customer.getId(), customer.getPassword());
        if (customers.size() > 0) {
            return customers.get(0);
        } else {
            return null;
        }
    }


}
