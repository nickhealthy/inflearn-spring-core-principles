package hello.external;

import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

/**
 * 자바 시스템 속성을 통한 환경변수 설정(JVM)
 * - 아래와 같이 System.getProperties() 메서드를 통해 JVM 안에서 접근 가능한 외부 설정을 확인할 수 있다.
 * - 자바가 내부에서 미리 설정해두고 사용하는 속성들도 있다.
 */
@Slf4j
public class JavaSystemProperties {

    public static void main(String[] args) {
        Properties properties = System.getProperties();
        for (Object key : properties.keySet()) {
            log.info("prop {}={}", key, properties.get(key));
        }

        // 사용자가 직접 정의하는 자바 시스템 속성(-Durl=url -Dusername=username -Dpassword=password, 이런 식으로 VM 옵션에 설정해야 한다.)
        String url = System.getProperty("url");
        String username = System.getProperty("username");
        String password = System.getProperty("password");

        log.info("url={}", url);
        log.info("username={}", username);
        log.info("password={}", password);

        // 자바 시스템 속성을 자바 코드로 설정하기
        // - 자바 시스템 속성은 앞서 살펴본 것처럼 -D 옵션을 통해 실행 시점에 전달하는 것도 가능하고,
        // - 다음과 같이 자바 코드 내부에서 추가하는 것도 가능하다.
        System.setProperty("nick", "nickhealthy");
        String value = System.getProperty("nick");
        log.info("nick={}", value);
    }
}
