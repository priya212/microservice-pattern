package com.stackroute.zuulgateway;

import com.stackroute.zuulgateway.filters.ErrorFilter;
import com.stackroute.zuulgateway.filters.PostFilter;
import com.stackroute.zuulgateway.filters.PreFilter;
import com.stackroute.zuulgateway.filters.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableZuulProxy
public class ZuulGatewayApplication {

	public static void main(String[] args) {

		SpringApplication.run(ZuulGatewayApplication.class, args);

	}

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
}
