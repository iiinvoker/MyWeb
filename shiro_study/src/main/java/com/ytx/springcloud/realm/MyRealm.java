package com.ytx.springcloud.realm;

import com.ytx.springcloud.entity.User;
import com.ytx.springcloud.service.UserService;
import jakarta.annotation.Resource;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    /**
     * @param principalCollection
     * @return 自定义授权方法
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * @param authenticationToken
     * @return
     * @throws AuthenticationException 自定义登录认证方法
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.获取用户信息
        String name=authenticationToken.getPrincipal().toString();
        //2.获取业务层的用户信息（数据库）
        User user=userService.getUserInfoByName(name);
        //3.判断并封装返回
        if(user!=null){
            return new SimpleAuthenticationInfo(
                    authenticationToken.getPrincipal(),
                    user.getPwd(),
                    ByteSource.Util.bytes("salt"),
                    authenticationToken.getPrincipal().toString()
            );
        }
        return null;
    }
}
