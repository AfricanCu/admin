package cn.fungo.service.impl;

import cn.fungo.domain.W11OperatorBill;
import cn.fungo.domain.W12User;
import cn.fungo.mapper.LoginMapper;
import cn.fungo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "LoginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper mapper;

    @Override
    public List<W11OperatorBill> login(String username, String password) {
        W11OperatorBill user = new W11OperatorBill();
        user.setOperatorName(username);
        user.setOperatorPwd(password);
        List<W11OperatorBill> userList = mapper.login(user);
        return userList;
    }
}
