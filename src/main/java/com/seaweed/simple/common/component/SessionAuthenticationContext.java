package com.seaweed.simple.common.component;

import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;

public class SessionAuthenticationContext {
    private static final String SESSION_LOGIN_NAME = "LOGIN_UID";
    private static final String SESSION_LOGIN_TYPE = "LOGIN_TYPE";
    public static String getUid(HttpSession session){
        return (String) session.getAttribute(SESSION_LOGIN_NAME);
    }

    public static boolean isAuthenticated(HttpSession session){
        return StringUtils.hasText((String) session.getAttribute(SESSION_LOGIN_NAME));
    }

    public static void authenticate(HttpSession session, String loginUid, String loginType){
        session.setAttribute(SESSION_LOGIN_NAME, loginUid);
        session.setAttribute(SESSION_LOGIN_TYPE, loginType);
    }
}
