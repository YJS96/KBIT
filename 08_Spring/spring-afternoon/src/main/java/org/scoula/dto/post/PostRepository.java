package org.scoula.dto.post;

import lombok.RequiredArgsConstructor;
import org.scoula.mapper.PostMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepository {
    private final PostMapper postMapper;

    public List<PostDto> findAll() {
        return postMapper.findAll();
    }

    public int delete(Long id) {
        return postMapper.delete(id);
    }
}
