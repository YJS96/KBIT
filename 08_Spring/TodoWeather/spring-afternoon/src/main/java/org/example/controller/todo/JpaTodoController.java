package org.example.controller.todo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.Todo;
import org.example.repository.todo.jpa.JpaTodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@Transactional
@RequestMapping("/todo")
@CrossOrigin(origins = "*")
public class JpaTodoController {
    private final JpaTodoRepository jpaTodoRepository;

    @GetMapping
    public ResponseEntity<List<Todo>> findAll() {
        List<Todo> todoList = jpaTodoRepository.findAll();
        return ResponseEntity.ok(todoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> findById(@PathVariable("id") Long id) {
        Todo findTodo = jpaTodoRepository.findById(id);

        if (findTodo == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(findTodo);
    }

    @PostMapping("/{newTodo}")
    public ResponseEntity<Todo> save(@PathVariable("newTodo") String todoString) {
        Todo newTodo = new Todo(null, todoString, false);
        Todo addedTodo = jpaTodoRepository.save(newTodo);

        if (addedTodo == null) return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Todo> toggleDone(@PathVariable("id") Long id) {
        Todo updatedTodo = jpaTodoRepository.toggleDone(id);

        if (updatedTodo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedTodo);
    }

    @PutMapping("/update/{id}/{newTodo}")
    public ResponseEntity<Todo> updateContext(@PathVariable("id") Long id, @PathVariable("newTodo") String newTodo) {
        Todo updatedTodo = jpaTodoRepository.update(id, newTodo);

        if (updatedTodo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        Todo findTodo = jpaTodoRepository.findById(id);
        if (findTodo == null) return ResponseEntity.notFound().build();

        jpaTodoRepository.delete(id);
        return ResponseEntity.ok("삭제 성공");
    }


}
