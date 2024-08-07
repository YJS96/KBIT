package org.scoula.controller;


import lombok.extern.slf4j.Slf4j;
import org.scoula.dto.TodoDtoListV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("/todo/v3")
public class TodoControllerV3 {
    private final TodoDtoListV2 todoList;

    @Autowired
    public TodoControllerV3(TodoDtoListV2 todoList) {
        this.todoList = todoList;
    }

    @GetMapping("/show")
    public String process(Model model) {
        log.info("========> 투두 리스트 조회 페이지 호출, /todo/show");

        model.addAttribute("todoList", todoList.getList());
        return "todo-show3";
    }

    @GetMapping("/form")
    public String todoForm() {
        log.info("========> 할일 추가 페이지 호출, /todo/form");

        return "todo-form3";
    }

    @GetMapping("/form/save")
    public String todoFormSave(@RequestParam("todo") String todo, Model model) {
        log.info("========> 할일 추가 Request 호출, /todo/form/save");

        todoList.addList(todo);

        model.addAttribute("todoList", todoList.getList());
        return "todo-show3";
    }
}
