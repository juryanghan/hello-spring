package hello.hellospring.repository;


import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //회원을 찾는 optional은 findById값이 null일 때 사용
    Optional<Member> findByName(String name);
    List<Member> findAll();
}