package hello.example.core;

import hello.example.core.discount.DiscountPolicy;
import hello.example.core.discount.FixDiscountPolicy;
import hello.example.core.member.MemberRepository;
import hello.example.core.member.MemberService;
import hello.example.core.member.MemberServiceImpl;
import hello.example.core.member.MemoryMemberRepository;
import hello.example.core.order.Order;
import hello.example.core.order.OrderService;
import hello.example.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {

        return new MemberServiceImpl(memberRepository()); //여기서 MemberServiceImpl에게 의존성 주입을 해준다.
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {

        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {

        return new FixDiscountPolicy();
    }

}
