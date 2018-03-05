package miw.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import miw.entities.Driver;
import miw.entities.Level;

@RepositoryRestResource(collectionResourceRel = "drivers", path = "drivers")
public interface DriverRepository extends MongoRepository<Driver, String> {

	List<Driver> findByLevel(Level level);
}
