package hello.springmvc.basic;

import lombok.Data;

@Data //Getter, Setter, ToString, EqualsAndHasgCode, RequiredArgsConstructor를 자동으로 적용
public class HelloData {
    private String username;
    private int age;

}
