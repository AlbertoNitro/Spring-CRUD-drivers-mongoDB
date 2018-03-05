package miw.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import miw.entities.Car;

@RepositoryRestResource(collectionResourceRel = "cars", path = "cars")
public interface CarRepository extends MongoRepository<Car, String> {

	List<Car> findByModel(String model);

	int deleteByModel(String model);

}
