package com.exact.buzon.configuration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;


@Component
public class FeignClientInterceptor implements RequestInterceptor {
	
	@Autowired
	private HttpServletRequest request;
	
	
	@Override
	public void apply(RequestTemplate template) {
		template.header("Authorization", request.getHeader("Authorization"));
	}

}
