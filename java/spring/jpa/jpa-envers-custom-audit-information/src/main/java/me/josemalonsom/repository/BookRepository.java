package me.josemalonsom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import me.josemalonsom.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
