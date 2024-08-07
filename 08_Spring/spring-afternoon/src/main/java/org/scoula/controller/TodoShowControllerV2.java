package org.scoula.controller;


import lombok.extern.slf4j.Slf4j;
import org.scoula.dto.TodoDtoListV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Slf4j
public class TodoShowControllerV2 {
    private final TodoDtoListV2 todoList;

    @Autowired
    public TodoShowControllerV2(TodoDtoListV2 todoList) {
        this.todoList = todoList;
    }

    @GetMapping("/todo/v2/show")
    public String process(Model model) {
        log.info("========> 투두 리스트 조회 페이지 호출, /todo/show");

        model.addAttribute("todoList", todoList.getList());
        return "todo-show2";
    }
}
