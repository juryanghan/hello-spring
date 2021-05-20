package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.apache.catalina.Store;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class MemberMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){

        repository.clearStore();

    }  //테스트를 하나씩 실행하고 끝날때마다  지우는 역할 , 테스트는 서로 순서 ,관계 의존 없이 설계되어야 함 공용 데이터들을 깔끔하게 지워줘야 함

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);


    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("sp1");
        repository.save(member1);

        Member member2 = new Member();
        member1.setName("sp2");
        repository.save(member2);

        Member result = repository.findByName("sp2").get();

        assertThat(result).isEqualTo(result);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("sp1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("sp1");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }


}
