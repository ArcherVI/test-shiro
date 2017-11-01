package com.wh51net.test.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wh51net.test.entity.User;
import com.wh51net.test.exception.LoginException;

@Controller
@RequestMapping("/sys")
public class UserController {
	
	@RequestMapping("/login")
	public String login(User user) {
		try {
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
			subject.login(token);
		}catch (UnknownAccountException e) {
			throw new LoginException(e.getMessage());
		}catch (IncorrectCredentialsException e) {
			throw new LoginException("账号或密码不正确");
		}catch (LockedAccountException e) {
			throw new LoginException("账号已被锁定，请联系管理员");
		}catch (AuthenticationException e) {
			throw new LoginException("账户验证失败");
		}
		return "success";
	}
}
