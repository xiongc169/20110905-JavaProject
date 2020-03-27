import org.practice.spring.domain.Car
import org.practice.spring.domain.Customer

beans {
    car(Car) {
        carId = "001"
    }

    customer(Customer, "customerId-001", "customerName-001") {
        car = car;
    }
}