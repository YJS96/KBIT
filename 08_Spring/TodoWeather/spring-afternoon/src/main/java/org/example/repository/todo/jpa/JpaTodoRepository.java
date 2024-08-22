package org.example.repository.todo.jpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.Todo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Repository
public class JpaTodoRepository {
    private final EntityManager em;

    public List<Todo> findAll() {
        String jpql = "SELECT t FROM Todo t";
        List<Todo> todoList = em.createQuery(jpql, Todo.class).getResultList();
        return todoList;
    }

    public Todo findById(Long id) {
        return em.find(Todo.class, id);
    }

    public Todo save(Todo newTodo) {
        em.persist(newTodo);
        return newTodo;
    }

    public Todo toggleDone(Long id) {
        Todo todo = em.find(Todo.class, id);
        if (todo != null) {
            todo.setDone(!todo.isDone());
            em.merge(todo);
        }
        return todo;
    }

    public Todo update(Long id, String newContext) {
        Todo todo = em.find(Todo.class, id);
        if (todo != null) {
            todo.setTodo(newContext);
            em.merge(todo);
        }
        return todo;
    }

    public void delete(Long id) {
        Todo todo = em.find(Todo.class, id);
        if (todo != null) em.remove(todo);
    }
}
