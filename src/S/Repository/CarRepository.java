package S.Repository;
import S.Models.Car;

public class CarRepository {
    public void save(Car car) {
        String model = car.getModel();
        System.out.println("Salvando carro" + model + " no banco de dados");
    }
}
