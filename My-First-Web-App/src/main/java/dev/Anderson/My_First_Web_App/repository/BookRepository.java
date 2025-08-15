package dev.Anderson.My_First_Web_App.repository;

import dev.Anderson.My_First_Web_App.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
