package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Vinod Kris on 28/09/21
 */

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
