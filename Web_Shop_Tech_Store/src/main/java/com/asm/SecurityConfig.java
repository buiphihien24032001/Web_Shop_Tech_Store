package com.asm;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.asm.service.AccountService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	BCryptPasswordEncoder pe;
	//cơ chế mã hoá mật khẩu
		@Bean
		public BCryptPasswordEncoder getPasswordEncoder() {
			return new BCryptPasswordEncoder();
			
		}
	// cung cấp nguồn dữ liệu đăng nhập
	@Autowired
	AccountService accountService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(accountService);
	}
	
	//phân quyền sử dụng
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().disable();
		http.authorizeRequests()
			.antMatchers("/order/**").authenticated()
			.antMatchers("/admin/**").hasAnyRole("STAFF","ADMIN")
			.antMatchers("/rest/authorities").hasRole("ADMIN")
			.anyRequest().permitAll();
		
		http.formLogin()
			.loginPage("/security/login/form")
			.loginProcessingUrl("/security/login")
			.defaultSuccessUrl("/security/login/success", false)
			.failureUrl("/security/login/error");
		
	
		
		http.rememberMe()
			.tokenValiditySeconds(86400);
		http.exceptionHandling()
			.accessDeniedPage("/security/unauthoried");
		
		http.logout()
			.logoutUrl("/security/logoff")
			.logoutSuccessUrl("/security/logoff/success");
	}
	
	
	
	//cho phép truy xuất REST API từ bên ngoài (domain khác)
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}
	
}
