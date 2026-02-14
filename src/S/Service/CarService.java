package S.Service;

import S.Models.Car;

public class CarService {
    public void registerCar(String model, String year, double price) {
        System.out.println("Registrando carro: " + model + ", Ano: " + year + ", Preço: " + price);
    }
}
