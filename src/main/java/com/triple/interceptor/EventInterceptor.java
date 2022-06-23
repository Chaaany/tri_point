package com.triple.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class EventInterceptor implements HandlerInterceptor{
	
	public static final Logger logger = LoggerFactory.getLogger(EventInterceptor.class);
	
	private static final String HEADER_AUTH = "auth-token";

//	@Autowired
//	private JwtService jwtService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		final String token = request.getHeader(HEADER_AUTH);
		return false;

//		if(token != null && jwtService.isUsable(token)){
//			logger.info("토큰 사용 가능 : {}", token);
//			return true;
//		}else{
//			logger.info("토큰 사용 불가능 : {}", token);
//			throw new UnauthorizedException();
//		}

	}
}
