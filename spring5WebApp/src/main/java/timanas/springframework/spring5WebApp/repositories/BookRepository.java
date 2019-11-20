package timanas.springframework.spring5WebApp.repositories;

import org.springframework.data.repository.CrudRepository;
import timanas.springframework.spring5WebApp.model.Book;

/**
 * Created by timmanas on 2019-11-19.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
