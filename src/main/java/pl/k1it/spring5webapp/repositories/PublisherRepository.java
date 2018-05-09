package pl.k1it.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.k1it.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
