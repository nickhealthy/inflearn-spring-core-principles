package hello;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Slf4j
@Component
public class CommandLineBean {

    private final ApplicationArguments arguments;

    public CommandLineBean(ApplicationArguments arguments) {
        this.arguments = arguments;
    }

    @PostConstruct
    public void init() {
        /**
         * --url=devdb --url=devdb2 --username=dev_user --password=dev_pw mode=on
         *
         * optionNames [password, url, username]
         */
        log.info("source {}", List.of(arguments.getSourceArgs()));  // source [--url=devdb, --url=devdb2, --username=dev_user, --password=dev_pw, mode=on]
        log.info("optionNames {}", arguments.getOptionNames());     // optionNames [password, url, username]
        Set<String> optionNames = arguments.getOptionNames();       // option args password=[dev_pw], option args url=[devdb, devdb2], option args username=[dev_user]
        for (String optionName : optionNames) {
            log.info("option args {}={}", optionName, arguments.getOptionValues(optionName));
        }
    }
}
