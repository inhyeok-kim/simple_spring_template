package com.seaweed.simple.common.component.http.session;

import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;

public class SessionAuthenticationContext {
    private static final String SESSION_LOGIN_NAME = "LOGIN_ID";
    private static final String SESSION_LOGIN_TYPE = "LOGIN_TYPE";

    public static long getLoginId(HttpSession session){
        return (long) session.getAttribute(SESSION_LOGIN_NAME);
    }

    public static boolean isAuthenticated(HttpSession session){
        return StringUtils.hasText((String) session.getAttribute(SESSION_LOGIN_NAME));
    }

    public static void authenticate(HttpSession session, long userId, String loginType) throws Exception {
        SimpleSessionContext.addLoginSession(userId,session);
        session.setAttribute(SESSION_LOGIN_NAME, userId);
        session.setAttribute(SESSION_LOGIN_TYPE, loginType);
    }
}
