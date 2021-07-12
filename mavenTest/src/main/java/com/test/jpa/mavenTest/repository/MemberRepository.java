package com.test.jpa.mavenTest.repository;

import com.test.jpa.mavenTest.entity.Member;
import com.test.jpa.mavenTest.repository.query.MemberRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long>, MemberRepositoryQuery {
    Optional<Member> findByEmail(String email);

}
