package cn.itcast.ssm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author hujtb
 * @create on 2018-09-25-10:11
 */
public class LoginInterceptor implements HandlerInterceptor{

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url = httpServletRequest.getRequestURI();
        //如果url是公开的url则放行
        if(url.indexOf("/login.action") >= 0){
            return true;
        }

        //判断session
        HttpSession session = httpServletRequest.getSession();
        //从session取出用户信息
        String username = (java.lang.String)session.getAttribute("username");
        //身份存在，放行
        if(username != null){
            return true;
        }
        //***注意WEB-INF前面一定要有/，否则404
        httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/login.jsp")
                .forward(httpServletRequest, httpServletResponse);

        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("interceptor1...postHandle");
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("interceptor1...afterCompletion");
    }
}
