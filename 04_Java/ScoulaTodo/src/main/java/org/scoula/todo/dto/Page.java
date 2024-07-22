package org.scoula.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.todo.domain.TodoVO;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page {
    private int totalCount;
    private int totalPage;
    private int page;
    private int pageSize;
    private List<TodoVO> list;

    public static Page of(PageRequest request, int totalCount, List<TodoVO> list) {
        int totalPage = (int)Math.ceil((double)totalCount / request.getSize());
        int page = request.getPage();
        int pageSize = request.getSize();

        return new Page(totalCount, totalPage, page, pageSize, list);
    }
}
