package cn.fungo.mapper;

import cn.fungo.domain.W11OperatorBill;

import java.util.List;

public interface LoginMapper {
    List<W11OperatorBill> login(W11OperatorBill user);
}
