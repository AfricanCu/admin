package cn.fungo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fungo.domain.W12Windows;
import cn.fungo.domain.W3MerchOperationAuth;
import cn.fungo.domain.WindowAuthVO;
import cn.fungo.mapper.WindowAuthMapper;
import cn.fungo.service.WindowAuthService;

@Service(value = "WindowAuthService")
public class WindowAuthServiceImpl implements WindowAuthService{

	@Autowired
	private WindowAuthMapper mapper;
	
	@Override
	public List<WindowAuthVO> findAuth(Map<String, Object> map) {
		return mapper.findAuth(map);
	}

	@Override
	public int getWindowId() {
		return mapper.getWindowId();
	}

	@Override
	public int addWindows(W12Windows model) {
		return mapper.addWindows(model);
	}

	@Override
	public W12Windows getWindowById(String id) {
		return mapper.getWindowById(id);
	}

	@Override
	public int updateWindow(W12Windows model) {
		return mapper.updateWindow(model);
	}

	@Override
	public List<W12Windows> findWindow() {
		return mapper.findWindow();
	}

	@Override
	public int addAuth(W3MerchOperationAuth model) {
		return mapper.addAuth(model);
	}

	@Override
	public int getAuthId() {
		return mapper.getAuthId();
	}

	@Override
	public W3MerchOperationAuth getAuthById(String id) {
		return mapper.getAuthById(id);
	}

	@Override
	public int updateAuth(W3MerchOperationAuth model) {
		return mapper.updateAuth(model);
	}

	@Override
	public int removeAuth(String id) {
		return mapper.removeAuth(id);
	}

	@Override
	public int removeWindow(String id) {
		return mapper.removeWindow(id);
	}

}
