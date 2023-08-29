package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository; // final로 되어 있으면 기본으로 할당을 하든 생성자를 통해서 할당되어야 한다.
    private final DiscountPolicy discountPolicy; // 인터페이스에만 의존
    /*
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    추상(인터페이스) DiscountPolicy에 의존하고, 구체(구현)클래스 FixDiscountPolicy에도 의존한다. > DIP 위반!
    구체에 의존하지 말고 추상(인터페이스)에만 의존하라.

    FixDiscountPolicy > RateDiscountPolicy 변경하는 것은 OCP 위반!
     */

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
