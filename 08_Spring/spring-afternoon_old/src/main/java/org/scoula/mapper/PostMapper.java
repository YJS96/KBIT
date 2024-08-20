package org.scoula.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.scoula.dto.post.PostDto;

import java.util.List;

@Mapper
public interface PostMapper {
    List<PostDto> findAll();
    int delete(@Param("id") Long id);
    int save(@Param("title") String title, @Param("content") String content);
    List<PostDto> findByCond(@Param("title") String title, @Param("content") String content);
}
