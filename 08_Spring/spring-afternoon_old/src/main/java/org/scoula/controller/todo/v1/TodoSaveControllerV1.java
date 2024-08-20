package org.scoula.controller.todo.v1;

import lombok.extern.slf4j.Slf4j;
import org.scoula.dto.todo.TodoDtoListV1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Slf4j
public class TodoSaveControllerV1 {
    private TodoDtoListV1 todoList = TodoDtoListV1.getInstance();

    @RequestMapping(value = "/todo/form/save", method = RequestMethod.GET)
    public String process(HttpServletRequest request, HttpServletResponse response) {
        log.info("========> 할 일 추가, Request 호출, /todo/form/save");

        String todo = request.getParameter("todo");

        todoList.addList(todo);

        request.setAttribute("todoList", todoList.getList());
        return "todo-show";
    }
}
