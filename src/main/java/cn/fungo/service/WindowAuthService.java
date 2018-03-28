package cn.fungo.service;

import java.util.List;
import java.util.Map;

import cn.fungo.domain.W12Windows;
import cn.fungo.domain.W3MerchOperationAuth;
import cn.fungo.domain.WindowAuthVO;

public interface WindowAuthService {
	List<WindowAuthVO> findAuth(Map<String, Object> map);
	
	int getWindowId();
	
	int addWindows(W12Windows model);
	
	W12Windows getWindowById(String id);
	
	int updateWindow(W12Windows model);
	
	List<W12Windows> findWindow();
	
	int addAuth(W3MerchOperationAuth model);
	
	int getAuthId();
	
	W3MerchOperationAuth getAuthById(String id);
	
	int updateAuth(W3MerchOperationAuth model);
	
	int removeAuth(String id);
	
	int removeWindow(String id);
	
}
