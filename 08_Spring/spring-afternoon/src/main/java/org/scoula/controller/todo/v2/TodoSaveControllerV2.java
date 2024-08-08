package org.scoula.controller.todo.v2;

import lombok.extern.slf4j.Slf4j;
import org.scoula.dto.todo.TodoDtoListV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class TodoSaveControllerV2 {
    private final TodoDtoListV2 todoList;

    @Autowired
    public TodoSaveControllerV2(TodoDtoListV2 todoList) {
        this.todoList = todoList;
    }

    @RequestMapping(value = "/todo/v2/form/save", method = RequestMethod.GET)
    public String process(HttpServletRequest request, Model model) {
        log.info("========> 할 일 추가, Request 호출, /todo/form/save");

        String todo = request.getParameter("todo");

        todoList.addList(todo);

        model.addAttribute("todoList", todoList.getList());
        return "todo-show2";
    }
}
