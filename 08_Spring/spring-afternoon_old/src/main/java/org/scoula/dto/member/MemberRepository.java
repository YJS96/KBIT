package org.scoula.dto.member;

import lombok.RequiredArgsConstructor;
import org.scoula.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {
    private MemberMapper memberMapper;

    @Autowired
    public MemberRepository(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public List<MemberDto> findAll() {
        return memberMapper.findAll();
    }
}
