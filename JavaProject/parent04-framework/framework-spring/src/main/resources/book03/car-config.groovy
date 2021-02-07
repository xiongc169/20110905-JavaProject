import com.yoong.springfx.domain.Car
import com.yoong.springfx.domain.Customer

beans {
    car(Car) {
        carId = "001"
    }

    customer(Customer, "customerId-001", "customerName-001") {
        car = car;
    }
}