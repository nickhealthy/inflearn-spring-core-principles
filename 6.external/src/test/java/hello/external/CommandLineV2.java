package hello.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.DefaultApplicationArguments;

import java.util.List;
import java.util.Set;

/**
 * CommandLine 옵션 인수
 * - 스프링에서는 커맨드 라인 인수를 key=value 형식으로 편리하게 사용할 수 있도록 만들었다.(-- 사용)
 * - ex) --key=value
 * `--username=userA --username=userB` 하나의 키에 여러 값도 지정할 수 있다.
 * - 스프링만의 표준 방식
 */
@Slf4j
public class CommandLineV2 {

    public static void main(String[] args) {
        for (String arg : args) {
            log.info("arg {}", arg);
        }

        // 스프링에서 제공하는 커맨드라인 옵션 인수
        // Program Arguments에 작성
        // --url=devdb --username=dev_user --password=dev_pw mode=on
        DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);
        log.info("SourceArgs = {}", List.of(appArgs.getSourceArgs()));  // 커맨드라인 인수 전부를 출력
        log.info("NonOptionArgs = {}", appArgs.getNonOptionArgs());     // mode=on 출력, 옵션 인수가 아님, key=value 형식으로 파싱되지 않는다.
        log.info("OptionNames = {}", appArgs.getOptionNames());         // key=value 형식으로 사용되는 옵션 인수

        Set<String> optionNames = appArgs.getOptionNames();
        for (String optionName : optionNames) {
            log.info("option args {}={}", optionName, appArgs.getOptionValues(optionName));
        }

        /*
        * url=devdb
            [main] INFO hello.external.CommandLineV2 - username=dev_user
            [main] INFO hello.external.CommandLineV2 - password=dev_pw
            [main] INFO hello.external.CommandLineV2 - mode=null
        * */
        appArgs.getOptionValues("url").forEach(a -> log.info("url={}", a));
        appArgs.getOptionValues("username").forEach(a -> log.info("username={}", a));
        appArgs.getOptionValues("password").forEach(a -> log.info("password={}", a));
        List<String> mode = appArgs.getOptionValues("mode");
        log.info("mode={}", mode);

    }

}
