package hello.container;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

import java.util.Set;

/**
 * 서블릿 컨테이너를 초기화 하는 인터페이스를 구현
 * - 예전엔 서블릿 컨테이너를 초기화하기 위해서 web.xml을 사용했지만, 요즘은 자바 코드로 ServletContainerInitializer를 구현하면 초기화를 진행할 수 있다.
 * - 서블릿 컨테이너가 실행될 때 onStartup() 메서드가 초기화 메서드이다.
 * - 한 가지 추가로 작업할 것이 있는데, 서블릿한테 어떤 클래스가 초기화 메서드를 가지고 있는지 알려줘야한다.
 * - 아래 경로에 어떤 클래스가 초기화 메서드를 가지고 있는지 풀 패키지를 포함해서 작성하면 된다.
 * - `resources/META-INF/services/jakarta.servlet.ServletContainerInitializer`
 */
public class MyContainerInitV1 implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("MyContainerInitV1.onStartup");
        System.out.println("MyContainerInitV1 set = " + set);
        System.out.println("MyContainerInitV1 servletContext = " + servletContext);
    }
}
