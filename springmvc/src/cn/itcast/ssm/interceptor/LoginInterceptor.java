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
        //���url�ǹ�����url�����
        if(url.indexOf("/login.action") >= 0){
            return true;
        }

        //�ж�session
        HttpSession session = httpServletRequest.getSession();
        //��sessionȡ���û���Ϣ
        String username = (java.lang.String)session.getAttribute("username");
        //��ݴ��ڣ�����
        if(username != null){
            return true;
        }
        //***ע��WEB-INFǰ��һ��Ҫ��/������404
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
