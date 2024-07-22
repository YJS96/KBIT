package org.scoula.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequest {
    private int page;
    private int size;

    public static PageRequest of(int page, int size) {
        return new PageRequest(page, size);
    }

    public int getOffset() {
        return (page - 1) * size;
    }
}
