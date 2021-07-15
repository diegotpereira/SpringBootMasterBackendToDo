package br.com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.java.model.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository <ToDo, String>{

}
