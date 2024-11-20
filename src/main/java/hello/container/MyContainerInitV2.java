package hello.container;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HandlesTypes;

import java.util.Set;

/**
 * 애플리케이션 초기화
 * 애플리케이션을 초기화 하는 이유는 서블릿 컨테이너 초기화로 모든 초기화 작업 시
 * - ServletContainerInitializer 인터페이스 구현
 * - META-INF/services/ jakarta.servlet.ServletContainerInitializer` 초기화 정보 등록 과정이 필요하다.
 *
 * 하지만 애플리케이션 초기화를 진행하게 되면 위에 과정을 한번만 거쳐 서블릿을 등록한 후,
 * AppInit.class 인터페이스만 구현한 클래스는 모두 서블릿으로 등록할 수 있게 된다.
 * (물론 인터페이스를 구현한 클래스 중에서 서블릿으로 등록하는 과정 말고도 필요에 따라 여러 작업을 할 수 있다.)
 *
 */
// @HandlesTypes(value = {AppInit.class}) - 애플리케이션 초기화 인터페이스를 지정한다.
@HandlesTypes(value = {AppInit.class})
public class MyContainerInitV2 implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("MyContainerInitV2.onStartup");
        System.out.println("MyContainerInitV2 set = " + set);   // MyContainerInitV2 set = [class hello.container.AppInitV1Servlet]
        System.out.println("MyContainerInitV2 servletContext = " + servletContext);

        // Set<Class<?>> set - 애플리케이션 초기화 인터페이스(AppInit.class)의 구현체들을 모두 찾아서 클래스 정보로 전달한다.
        for (Class<?> appInitClass : set) {
            try {
                // new AppInitV1Servlet()과 같은 코드
                AppInit appInit =
                        (AppInit) appInitClass.getDeclaredConstructor().newInstance();
                // 이 메서드를 통해 AppInit으로 구현한 클래스들을 모두 불러와 프로그래밍 방식으로 서블릿에 등록한다.
                appInit.onStartup(servletContext);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
