package com.learning.GettingStartedWithSpringBoot.books;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/books")
public class ReadingBooksController {

    private final BookJPARepository bookJPARepository;


    public ReadingBooksController(BookJPARepository bookJPARepository) {
        this.bookJPARepository = bookJPARepository;
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public List<Book> readerBooks(
            @PathVariable String reader
    ) {
        return bookJPARepository.findByReader(reader);
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addBook(
            @PathVariable String reader,
            @RequestBody Book book
    ) {
        book.setReader(reader);
        bookJPARepository.save(book);
        return "success";
    }
}
