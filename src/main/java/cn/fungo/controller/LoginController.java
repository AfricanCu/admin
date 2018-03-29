package cn.fungo.controller;

import cn.fungo.domain.W11OperatorBill;
import cn.fungo.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private LoginService service;

    @ResponseBody
    @RequestMapping(value = "login")
    public Integer login(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        logger.info("----> username:{}, password:{}",username,password);
        if("".equals(username) || "".equals(password)){
            return 0;
        }
        List<W11OperatorBill> userList = service.login(username, password);
        if(userList == null || userList.size() < 1){
            return 0;
        }else {
            return 1;
        }
    }
}
