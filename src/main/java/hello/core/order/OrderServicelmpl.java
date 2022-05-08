package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServicelmpl implements OrderService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository();-> 생성자 할당의 위해 주석
   // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();    //고정할인금액
    // (추상 인터페이스와 구현체도 의존을 하고있다) -> 추상에만 의존을 해야한다. DIP 위반
    // OrderServicelmpl 을 수정을 해야하는 상황 -> OCP 위반

   //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();      //할인율 할인 금액

    //DIP,OCP 에 위반하지 않은 인터페이스에만 의존하도록 수정
    //private DiscountPolicy discountPolicy;-> 생성자 할당의 위해 주석

    //구현체가 없어 NULL 이 나옴

    //생성자 할당 코드
    // final 이 있으면 무조건 생성자를 할당해야한다
    //오직 인터페이스만 의존함 -> 기능을 실행하는 역할만 한다
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServicelmpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return  new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
