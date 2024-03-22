package hello.example.core.order;

import hello.example.core.discount.DiscountPolicy;
import hello.example.core.discount.FixDiscountPolicy;
import hello.example.core.member.Member;
import hello.example.core.member.MemberRepository;
import hello.example.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository; //철저히 interface에만 의존하고 있음 DIP준수

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
