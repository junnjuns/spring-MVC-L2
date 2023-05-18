package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody   // @RestController가 아닐 때 리턴 값 문자로 반환해준다.
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge) {

        log.info("username={}, age={}", memberName, memberAge);

        return "ok";

    }


    @ResponseBody   // @RestController가 아닐 때 리턴 값 문자로 반환해준다.
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,  // 파라미터명 == 변수명 이면 RequestParam 다음 () 생략가능
            @RequestParam int age) {

        log.info("username={}, age={}", username, age);

        return "ok";
    }

    @ResponseBody   // @RestController가 아닐 때 리턴 값 문자로 반환해준다.
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) { // String, int, Integer 등 단순 타입일 때 @RequestParam 생략 가능

        log.info("username={}, age={}", username, age);

        return "ok";
    }


    @ResponseBody   // @RestController가 아닐 때 리턴 값 문자로 반환해준다.
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username, // requried = true 이면 반드시 데이터가 들어와야 함, 기본값 true
            @RequestParam(required = false) Integer age) { // int는 null 이 들어갈 수 없다. Integer는 객체형이기 때문에 null이 들어올 수 있음

        log.info("username={}, age={}", username, age);

        return "ok";
    }

    @ResponseBody   // @RestController가 아닐 때 리턴 값 문자로 반환해준다.
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(defaultValue = "guest") String username, //값이 안 들어올 때 defaultValue로 값을 설정할 수 있음
            @RequestParam(defaultValue = "-1") Integer age){

        log.info("username={}, age={}", username, age);

        return "ok";
    }


    @ResponseBody   // @RestController가 아닐 때 리턴 값 문자로 반환해준다.
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap){

        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    //해당 프로퍼티의 setter를 호출해서 파라미터의 값을 입력한다.
    public String modelAttributeV1(@ModelAttribute HelloData helloData){

        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }


    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    //ModelAttribute 생략 가능
    public String modelAttributeV2(HelloData helloData){

        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }
}
