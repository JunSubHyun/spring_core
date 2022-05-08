package hello.core;

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
        return new MemberServicelmpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){

        //FixDiscountPolicy 주입 시 (생성자 주입)
        return new OrderServicelmpl(new MemoryMemberRepository(),new FixDiscountPolicy());

        //RateDiscountPolicy 주입 시 (생성자 주입)
        //return new OrderServicelmpl(new MemoryMemberRepository(),new RateDiscountPolicy());
    }



}
