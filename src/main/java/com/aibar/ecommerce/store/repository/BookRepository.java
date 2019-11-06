package com.aibar.ecommerce.store.repository;

import com.aibar.ecommerce.store.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitleContaining(String keyword);
    public List<Book> findAllByOrderByIdDesc();
}
