package timanas.springframework.spring5WebApp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import timanas.springframework.spring5WebApp.model.Author;
import timanas.springframework.spring5WebApp.model.Book;
import timanas.springframework.spring5WebApp.repositories.AuthorRepository;
import timanas.springframework.spring5WebApp.repositories.BookRepository;

/**
 * Created by timmanas on 2019-11-20.
 */
@Component          // This annotation marks this as a Spring Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    // This is dependency injection when starting this object up
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", "Wrox" );
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}


/**

 Notes

 - The @Compoenent annotations marks it as Spring component ... which makes it a Spring bean
 - This now gets wired up with Spring content

 What is a Spring bean ?
 - Spring bean is an object that has been instantiated and managed by Spring Ioc container

 */