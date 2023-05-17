package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // 반환 값으로 뷰를 찾는 것이 아니라 HTTP바디에 바로 입력
public class LogTestController {

    //private final Logger log = LoggerFactory.getLogger(getClass()); @Slf4j가 이 코드를 넣어준다.

    @RequestMapping("/log-test")
    public String logTest(){

        String name = "Spring";

        System.out.println("name = " + name);

        log.trace("trace log={}",name);
        log.debug("debug log={}",name); // 개발서버
        log.info(" info log={}", name); // 운영서버
        log.warn("warn log={}",name);
        log.error("error log={}",name);

        return "ok";
    }
}
