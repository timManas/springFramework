package timanas.springframework.spring5WebApp.repositories;

import org.springframework.data.repository.CrudRepository;
import timanas.springframework.spring5WebApp.model.Publisher;

/**
 * Created by timmanas on 2019-11-21.
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}