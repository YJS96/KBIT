package org.scoula.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostDto {
    private int id;
    private String title;
    private String content;
}
