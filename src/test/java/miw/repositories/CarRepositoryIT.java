package miw.repositories;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import miw.entities.Car;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class CarRepositoryIT {

	@Autowired
	private CarRepository carRepository;

	@Before
	public void seedDb() {
		String[] listModels = { "Megane", "Clio", "Kangoo", "Scenic", "Talisman", "Express", "Laguna", "Megane",
				"Megane" };
		String[] listRegistration = { "1184CPL", "2345BDC", "1145ACC", "2565XCC", "2311RTC", "0045PPC", "0450WRC",
				"1185CPL", "1186CPL" };
		List<Car> listCars = new LinkedList<Car>();
		for (int i = 0; i < listModels.length; i++) {
			Car car = new Car();
			car.setModel(listModels[i]);
			car.setRegistration(listRegistration[i]);
			listCars.add(car);
		}
		this.carRepository.save(listCars);
	}

	@Test
	public void testCount() {
		assertEquals(9, carRepository.count());
	}

	@Test
	public void testFindOne() {
		Car car = new Car();
		car.setModel("Golf R32");
		car.setRegistration("1701JYH");
		this.carRepository.save(car);
		assertEquals("Golf R32", carRepository.findOne(car.getId()).getModel());
	}

	@Test
	public void testDelete() {
		Car car = new Car();
		car.setModel("Polo");
		car.setRegistration("1991JWH");
		this.carRepository.save(car);
		this.carRepository.delete(car);
		assertNull(this.carRepository.findOne(car.getId()));
	}

	@Test
	public void testFindByModel() {
		assertEquals(3, this.carRepository.findByModel("Megane").size());
	}

	@Test
	public void deleteByModel() {
		this.carRepository.deleteByModel("Megane");
		assertEquals(0, this.carRepository.deleteByModel("Megane"));

	}

	@After
	public void deleteDb() {
		this.carRepository.deleteAll();
	}

}
