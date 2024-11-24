package hello.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * `spring-boot-starter-web`를 사용하면 내부에서 내장 톰캣을 사용한다.
 * 라이브러리 의존관계를 따라가보면 내장 톰캣(`tomcat-embed-core`)이 포함된 것을 확인할 수 있다.
 */
@RestController
public class HelloController {

    @GetMapping("/hello-spring")
    public String hello() {
        System.out.println("HelloController.hello");
        return "hello spring!";
    }
}
