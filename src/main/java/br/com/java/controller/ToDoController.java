package br.com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.java.model.ToDo;
import br.com.java.repository.ToDoRepository;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    private final ToDoRepository repository;

    public ToDoController(ToDoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    List<ToDo> findAll() {
        return this.repository.findAll();
    }

    @GetMapping("/buscar/{id}")
    ToDo findById(@PathVariable String id) {
        return this.repository.findById(id).orElseThrow(() -> new RuntimeException("Not found."));
    }

    @PostMapping("/add")
    ToDo save(@RequestBody ToDo toDo) {
        return this.repository.save(toDo);
    }
    @PutMapping("/update/{id}")
    ToDo replaceById(@RequestBody ToDo newToDo, @PathVariable String id) {
        return this.repository.findById(id)
                .map(toDo -> {
                    toDo.setName(newToDo.getName());
                    toDo.setDone(newToDo.isDone());
                    toDo.setDetails(newToDo.getDetails());
                    return repository.save(toDo);
                })
                .orElseGet(() -> {
                    newToDo.setId(id);
                    return this.repository.save(newToDo);
                });
    }

    @DeleteMapping("/deletar/{id}")
    void deleteById(@PathVariable String id) {
        this.repository.deleteById(id);
    }
    
}
