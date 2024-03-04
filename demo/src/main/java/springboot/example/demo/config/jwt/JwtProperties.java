package springboot.example.demo.config.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("jwt") //application.yml 설정 파일에서 특정 접두사를 가진 속성들을 자바 클래스에 매핑
public class JwtProperties {

    private String issuer;
    private String secretKey;
}
