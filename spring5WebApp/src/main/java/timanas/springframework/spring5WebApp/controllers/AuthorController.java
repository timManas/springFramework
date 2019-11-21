package timanas.springframework.spring5WebApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import timanas.springframework.spring5WebApp.repositories.AuthorRepository;
import timanas.springframework.spring5WebApp.repositories.BookRepository;

/**
 * Created by timmanas on 2019-11-21.
 */
@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){

        model.addAttribute("authors", authorRepository.findAll());

        return "authors";
    }
}


/**

 Note

 1. the line:
 model.addAttribute("authors", authorRepository.findAll());
  with "authors" must match the template to be displayed
 - Which in this case must be authors.html
 - Thats how Spring maps it

 */