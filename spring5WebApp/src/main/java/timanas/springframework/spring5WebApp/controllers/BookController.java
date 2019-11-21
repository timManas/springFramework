package timanas.springframework.spring5WebApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import timanas.springframework.spring5WebApp.repositories.BookRepository;

/**
 * Created by timmanas on 2019-11-21.
 */
@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){

        model.addAttribute("books", bookRepository.findAll());

        return "books";
    }
}


/**

 Notes

 1. The @RequestMapping("/books") gets invoked when a request with "/book" occurs
 - This now returns a String "books" when model is added

 2. The annotation @Controller tells Spring that this Spring MVC Controller

 3. The line model.addAttribute("books", bookRepository.findAll()); invokes the books.html
 <tr th:each="book : ${books}">

 4. This works with Thymeleaf to display the contents from the book DB to display on browser

 */