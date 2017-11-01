package com.wh51net.test.realm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.wh51net.test.entity.User;
import com.wh51net.test.service.UserService;

public class UserRealm extends AuthorizingRealm{

	@Resource
	private UserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authozitionInfo = new SimpleAuthorizationInfo();
		List<String> permsList = userService.allPremissons(username);
		for(String perms:permsList) {

			System.out.println("perms:"+perms);

		}
		Set<String> permsSet = new HashSet<String>();
		for(String perms:permsList) {
			//permsSet.addAll(Arrays.asList(perms.trim().split(",")));
			String[] perm = perms.trim().split(",");
			System.out.println("len:"+perm.length);
			for(int i=0;i<perm.length;i++) {
				System.out.println("perm:"+perm[i]);
				permsSet.add(perm[i]);
			}
		}
		System.out.println(permsSet);
		authozitionInfo.setStringPermissions(permsSet);
		return authozitionInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String)token.getPrincipal();
		System.out.println("username:"+username);
		User user = userService.queryByUsername(username);
		System.out.println("user:"+user);
		if(user != null) {
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),"");
			return authcInfo;
		}else {
			return null;
		}
	}

}
