package dev.Anderson.My_First_Web_App.repository;

import dev.Anderson.My_First_Web_App.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
