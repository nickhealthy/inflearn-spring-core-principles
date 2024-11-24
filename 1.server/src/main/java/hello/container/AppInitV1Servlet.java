package hello.container;

import hello.servlet.HelloServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;

/**
 * http://localhost:8080/hello-servlet
 * - 프로그래밍 방식으로 HelloServlet 서블릿을 서블릿 컨테이너에 직접 등록한다.
 * - @WebServlet 애노테이션 하나로 서블릿을 쉽게 등록할 수 있지만 아래와 같은 이유로 프로그래밍 방식을 사용한다.
 * - 유연함을 가져갈 수 있다.
 *   - /hello-servlet 경로를 상황에 따라서 바꾸어 외부 설정을 읽어서 등록할 수 있다.
 *   - 서블릿 자체도 특정 조건에 따라서 if 문으로 분기해서 등록하거나 뺼 수 있다.
 *   - 서블릿을 내가 직접 생성하기 때문에 생성자에 필요한 정보를 넘길 수 있다.
 *
 */
public class AppInitV1Servlet implements AppInit {

    @Override
    public void onStartup(ServletContext servletContext) {
        System.out.println("AppInitV1Servlet.onStartup");

        // 순수 프로그래밍 방식으로 서블릿 등록
        ServletRegistration.Dynamic helloServlet =
                servletContext.addServlet("helloServlet", new HelloServlet());
        helloServlet.addMapping("/hello-servlet");
    }
}
