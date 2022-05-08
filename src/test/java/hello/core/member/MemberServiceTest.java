package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    //MemberService memberService = new MemberServicelmpl();  -> 의존관계 주입에 의해 필요없어짐
    MemberService memberService;

    //@BeforeEach -> 코드를 실행하기전 무조건적인 실행
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }


    @Test
    void run(){
        //given
        Member member = new Member(1L, "memberA",Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);

    }

}
