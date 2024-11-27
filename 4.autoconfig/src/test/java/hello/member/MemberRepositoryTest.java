package hello.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    /**
     * `@Transactional`을 사용해서 트랜잭션 기능을 적용
     * - 참고로 `@Transactional`을 사용하려면 `TransactionManager`가 스프링 빈으로 등록되어 있어야 한다.
     */
    @Transactional
    @Test
    void memberTest() {
        Member member = new Member("idA", "memberA");
        memberRepository.initTable();
        memberRepository.save(member);
        Member findMember = memberRepository.find(member.getMemberId());
        assertThat(findMember.getMemberId()).isEqualTo(member.getMemberId());
        assertThat(findMember.getName()).isEqualTo(member.getName());

        List<Member> memberList = memberRepository.findAll();
        assertThat(memberList).hasSize(1);
    }

}