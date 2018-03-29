package cn.fungo.service;

import cn.fungo.domain.W11OperatorBill;
import cn.fungo.domain.W12User;

import java.util.List;

public interface LoginService {

    List<W11OperatorBill> login(String username, String password);
}
