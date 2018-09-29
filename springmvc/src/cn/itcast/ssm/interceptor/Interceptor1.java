package cn.itcast.ssm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hujtb
 * @create on 2018-09-25-10:11
 */
public class Interceptor1 implements HandlerInterceptor{
    //进入Handler方法之前
    //用于身份认证，身份授权
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("interceptor1...preHandle");
        return true;
    }

    //进入Handler方法之后，返回ModelAndView之前
    //将公用的模型数据（比如菜单导航）在这里传到视图，也可以在这里统一指定视图
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("interceptor1...postHandle");
    }

    //执行Handler方法之后执行该方法
    //统一异常处理，统一日志处理
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("interceptor1...afterCompletion");
    }
}
