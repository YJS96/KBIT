package org.scoula.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.scoula.dto.member.MemberDto;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<MemberDto> findAll();
}
