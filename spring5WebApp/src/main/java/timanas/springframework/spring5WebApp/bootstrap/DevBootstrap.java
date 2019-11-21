package timanas.springframework.spring5WebApp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import timanas.springframework.spring5WebApp.model.Author;
import timanas.springframework.spring5WebApp.model.Book;
import timanas.springframework.spring5WebApp.model.Publisher;
import timanas.springframework.spring5WebApp.repositories.AuthorRepository;
import timanas.springframework.spring5WebApp.repositories.BookRepository;
import timanas.springframework.spring5WebApp.repositories.PublisherRepository;

/**
 * Created by timmanas on 2019-11-20.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher publisher = new Publisher();
        publisher.setName("foo");
        publisher.setAddress("12th Street, LA");
        publisherRepository.save(publisher);

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book  ddd = new Book("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisher );
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