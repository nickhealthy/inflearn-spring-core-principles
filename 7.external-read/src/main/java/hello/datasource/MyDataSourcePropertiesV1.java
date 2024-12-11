package hello.datasource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * 강의: 외부설정 사용 - @ConfigurationProperties 시작
 * - 스프링은 외부 설정의 묶음 정보를 객체로 변환하는 기능을 제공한다. 이것을 '타입 안전한 설정 속성'이라 한다.
 * - 외부 설정을 자바 코드로 관리할 수 있다. 그리고 설정 정보 그 자체도 타입을 가지게 된다.
 */
@Data
/*
    @ConfigurationProperties 애노테이션이 있으면 외부 설정을 주입 받는 객체라는 뜻이다.
    여기에 외부 설정 KEY의 묶음 시작점인 `my.datasource`를 적어준다.
    기본 주입 방식은 자바빈 프로퍼티 방식이다. 따라서 Getter, Setter가 필요하다.
 */
@ConfigurationProperties("my.datasource")
public class MyDataSourcePropertiesV1 {

    private String url;
    private String username;
    private String password;
    private Etc etc = new Etc();

    @Data
    public static class Etc {
        private int maxConnection;
        private Duration timeout;
        private List<String> options = new ArrayList<>();
    }
}
