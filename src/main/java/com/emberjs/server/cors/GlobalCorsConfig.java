package com.emberjs.server.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 全局跨域设置，所有IP都可以访问
 * @author ubuntuvim
 *
 */
@Configuration
public class GlobalCorsConfig {

	@Bean
    public CorsFilter corsFilter() {
		 // 添加CORS配置信息
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 放行哪些原始域
        corsConfiguration.addAllowedOrigin("*");
        // 是否发送cookie信息
        corsConfiguration.setAllowCredentials(false);
        // 放行哪些原始域（请求方式）
        corsConfiguration.addAllowedMethod("*");
        // 放行哪些原始域（头部信息）
        corsConfiguration.addAllowedHeader("*");
        // 暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
        corsConfiguration.addExposedHeader(HttpHeaders.ACCEPT);
 
        // 添加映射路径
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",corsConfiguration);
 
        // 返回新的CorsFileter
        return new CorsFilter(source);
    }
	
}