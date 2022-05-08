package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServicelmpl;

public class MemberApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

       // MemberService memberService = new MemberServicelmpl();  -> 의존관계 주입으로인해 필요 없어짐

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member =" + member.getName());
        System.out.println("findMember =" + findMember.getName());

    }

}
