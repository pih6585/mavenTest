package com.test.jpa.mavenTest.repository.query;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.jpa.mavenTest.dto.MemberDto;
import com.test.jpa.mavenTest.dto.QMemberDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import java.util.List;

import static com.test.jpa.mavenTest.entity.QMember.member;

public class MemberRepositoryImpl implements MemberRepositoryQuery {

    private final EntityManager em;

    private final JPAQueryFactory queryFactory;

    public MemberRepositoryImpl(EntityManager em) {
        this.em = em;
        queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public MemberDto findByOneByDto(Long id) {
        MemberDto memberDto = queryFactory
                .select(new QMemberDto(member.id,member.username, member.email, member.password,
                                       member.address.city, member.address.street, member.address.zipcode))
                .from(member)
                .where(member.id.eq(id))
                .fetchOne();
        return memberDto;
    }

    @Override
    public List<MemberDto> findByAllByDto() {
        List<MemberDto> memberDtoList = queryFactory
                .select(new QMemberDto(member.id,member.username, member.email, member.password,
                                       member.address.city, member.address.street, member.address.zipcode))
                .from(member)
                .fetch();
        return memberDtoList;
    }

    @Override
    public Page<MemberDto> findByAllByDtoPaging(Pageable pageable) {
        QueryResults<MemberDto> queryList = queryFactory
                .select(new QMemberDto(member.id, member.username, member.email, member.password,
                                       member.address.city, member.address.street, member.address.zipcode))
                .from(member)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        List<MemberDto> memberDtoList = queryList.getResults();
        long total = queryList.getTotal();
        return new PageImpl<>(memberDtoList,pageable,total);
    }
}
