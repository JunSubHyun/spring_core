package hello.core;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;
//필터를 적용할 경로
@WebFilter(urlPatterns = "/version/*")
public class WebFilterConfig implements Filter {

    private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // FilterConfig를 통한 filter 설정
        // 서블릿 컨테이너가 필터 인스턴스 생성한 후
        // 초기화 하기 위해서 사용 전 호출하는 메소드
        this.filterConfig = filterConfig;
        System.out.println("=================Filter-lnit==================");
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 필터에서 구현해야 하는 로직을 작성하는 메소드
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        //여기에 로직 구현

        chain.doFilter(request, response);

    }
    @Override
    public void destroy() {
        // 필터 인스턴스를 종료시키기 전에 호출하는 메소드
        System.out.println("===================Filter-Destroy======================");
    }

}