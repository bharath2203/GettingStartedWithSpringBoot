package com.learning.GettingStartedWithSpringBoot.books;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookJPARepository extends JpaRepository<Book, Long> {

    List<Book> findByReader(String reader);

}


// stories
