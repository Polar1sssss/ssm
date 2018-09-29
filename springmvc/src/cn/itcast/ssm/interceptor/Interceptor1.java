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
    //����Handler����֮ǰ
    //���������֤�������Ȩ
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("interceptor1...preHandle");
        return true;
    }

    //����Handler����֮�󣬷���ModelAndView֮ǰ
    //�����õ�ģ�����ݣ�����˵������������ﴫ����ͼ��Ҳ����������ͳһָ����ͼ
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("interceptor1...postHandle");
    }

    //ִ��Handler����֮��ִ�и÷���
    //ͳһ�쳣����ͳһ��־����
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("interceptor1...afterCompletion");
    }
}
