package miw.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import miw.entities.Car;
import miw.repositories.CarRepository;

@RestController
@RequestMapping(CarResources.CARS)
public class CarResources {
	@Autowired CarRepository carRepository;
	
	public static final String CARS = "/cars";
	
    public static final String ID = "/{id}";
    
    @RequestMapping(value = ID, method = RequestMethod.GET) 
    public Car getCar(@PathVariable(value = "id") String id) {
        return carRepository.findOne(id);
    }
    
    @RequestMapping(method = RequestMethod.POST) 
    public Car createCar(@RequestBody Car car) {
        return carRepository.save(car);
    }
    
    @RequestMapping(value = ID, method = RequestMethod.DELETE) 
    public void deleteCar(@PathVariable(value = "id") String id) {
        carRepository.delete(id);
    }
    
    @RequestMapping(value = ID, method = RequestMethod.PUT) 
    public Car updateCar(@RequestBody Car car) {
        return carRepository.save(car);
    }
    
    @RequestMapping(method = RequestMethod.GET) 
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

}
