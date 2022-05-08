package hello.core.member;

public class MemberServicelmpl implements MemberService{

   // private final MemberRepository memberRepository = new MemoryMemberRepository(); -> AppConfig 를 통해 들어갈수 있도록 수정

    //MemoryMemberRepository 라는 구현체를 의존하지 않는다
    private final MemberRepository memberRepository;        //생성자 주입

    public MemberServicelmpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
