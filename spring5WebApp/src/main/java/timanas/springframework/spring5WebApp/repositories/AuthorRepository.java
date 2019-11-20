package timanas.springframework.spring5WebApp.repositories;

import org.springframework.data.repository.CrudRepository;
import timanas.springframework.spring5WebApp.model.Author;

/**
 * Created by timmanas on 2019-11-19.
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
