package com.yaxing.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @author yx
 * @date 2022/12/6
 */
@Component
@ConfigurationProperties(prefix = "jwt")
public class JWTUtil {
    // 返回头部
    public static String header;
    // token 前缀
    public static String tokenPrefix;
    // 签名密钥
    public static String secret;
    // 有效期
    public static long expireTime;
    // 存进客户端的 token 的 key 名
    // public static final String USER_LOGIN_TOKEN = "token";

    public void setHeader(String header) {
        JWTUtil.header = header;
    }

    public void setTokenPrefix(String tokenPrefix) {
        JWTUtil.tokenPrefix = tokenPrefix;
    }

    public void setSecret(String secret) {
        JWTUtil.secret = secret;
    }

    public void setExpireTime(int expireTimeInt) {
        JWTUtil.expireTime = expireTimeInt;
    }

    public static String createToken(Map<String, String> map) {

        // 创建jwt builder
        JWTCreator.Builder builder = JWT.create();

        // payload
        map.forEach(builder::withClaim);

        return tokenPrefix + builder.withExpiresAt(new Date(System.currentTimeMillis() + expireTime)) // 指定令牌过期时间
                .sign(Algorithm.HMAC256(secret));
    }

    /**
     * 验证token  合法性
     */
    public static DecodedJWT verify(String token) {
        return JWT.require(Algorithm.HMAC256(secret)).build().verify(token);
    }
}
