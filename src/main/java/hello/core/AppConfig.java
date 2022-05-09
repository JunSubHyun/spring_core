package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServicelmpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServicelmpl;

public class AppConfig {

    //Service 에서는 실행에만 집중
    //외부에서 의존관계를 주입
    //Dependency Injection : 의존관계 주입 또는 의존성 주입

    public MemberService memberService(){
        return new MemberServicelmpl(memberRepository());
        //자동 리팩토링 : command + option + m
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
        //회원 저장에 대한 부분을 수정할 때 이 부분만 교체
    }

    public OrderService orderService(){

        //FixDiscountPolicy 주입 시 (생성자 주입)
        return new OrderServicelmpl(memberRepository(),discountPolicy());

        //RateDiscountPolicy 주입 시 (생성자 주입)
        //return new OrderServicelmpl(new MemoryMemberRepository(),new RateDiscountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        //할인정책에 대한 교체시 이부분 교체

        //고정 할인금액
        //return new FixDiscountPolicy();
        //퍼센트 할인금액
        return  new RateDiscountPolicy();

        //구현체 교체만으로 쉽게 사용법을 바꿀수 있다.
    }



}
