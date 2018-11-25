package com.lll.shop.config;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CORS configuration 配置全局跨域
 */
@Configuration
@ConfigurationProperties(prefix = "cors")
public class WebMvcConfig implements WebMvcConfigurer {

	private static final Logger log = LoggerFactory.getLogger(WebMvcConfig.class);

	@Autowired
	private UserInterceptor userInterceptor;
	
	private List<String[]> patchs;
	private String[] ip;

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// 设置了可以被跨域访问的路径和可以被哪些主机跨域访问
 		for (String[] patch : patchs) {
			log.info("设置了可以被跨域访问的路径：" + patch[0] + "  可以被：" + patch[1] +","+ Arrays.toString(ip) + "主机跨域访问");
			registry.addMapping(patch[0]).allowedOrigins(patch[1]).allowedOrigins(ip);
		}
	}

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(userInterceptor).addPathPatterns("/user/**").excludePathPatterns("/user/register").excludePathPatterns("/user/login"); 
	}
	@Override
	public String toString() {
		return "CorsConfig [patchs=" + patchs + ", ip=" + Arrays.toString(ip) + "]";
	}

	public String[] getIp() {
		return ip;
	}

	public void setIp(String[] ip) {
		this.ip = ip;
	}

	public List<String[]> getPatchs() {
		return patchs;
	}

	public void setPatchs(List<String[]> patchs) {
		this.patchs = patchs;
	}

}