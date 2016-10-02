package com.yaya.demo.web.handler;


import com.yaya.demo.persistence.entities.Customer;
import com.yaya.demo.plugin.utils.JSONUtil;
import com.yaya.demo.service.Impl.customer.CustomerService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 用户中心控制层
 *
 * @author ChW 2016-03-26 22:06:02
 */
@Controller
public class CustomerHandler {

    private CustomerService customerService;

    @Autowired
    public CustomerHandler(CustomerService customerService) {
        this.customerService = customerService;
    }


    /**
     * 用户登录
     *
     * @param name 用户名
     * @param email 邮箱
     * @param phone 手机号
     * @param password 密码
     * @return json
     */
    @ResponseBody
    @RequestMapping(value = "/customer/login", method = RequestMethod.POST)
    public JSONObject login(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone,
            @RequestParam String password
    ) {


        return JSONUtil.jsonEncode(0, "用户名或密码不正确");
    }


    /**
     * 用户注册
     *
     * @param phone 手机号
     * @param email 邮箱
     * @param password 密码
     * @param name 用户名
     * @return json
     */
    @ResponseBody
    @RequestMapping(value = "/customer/register", method = RequestMethod.POST)
    public JSONObject register(
            @RequestParam String phone,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String name
    ) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(Integer.valueOf(phone));
        customer.setPassword(password);

        customerService.save(customer);

        return JSONUtil.jsonEncode(0, "用户注册成功");
    }


    /**
     * 更新密码
     *
     * @param identifier  用户账号
     * @param originalPwd 旧密码
     * @param newPwd      新密码
     * @return json
     */
    @ResponseBody
    @RequestMapping(value = "/customer/updatePassword")
    public JSONObject updatePassword(@RequestParam String identifier, @RequestParam String originalPwd, @RequestParam String newPwd) {
        return JSONUtil.jsonEncode(0, "update failed");
    }


}
