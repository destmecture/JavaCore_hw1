package transport;

import static transport.Utilities.checkCountry;
import static transport.Utilities.checkYear;

public class Bus extends Transport {
    public Bus(String brand,
               String model,
               int year,
               String country,
               String color, int
                       maxSpeed) {
        super(brand,
                model,
                checkYear(year),
                checkCountry(country),
                color,
                maxSpeed);
    }

    @Override
    public String toString() {
        return getBrand() + " "
                + getModel() + ", "
                + getYear() + " год выпуска, сборка в "
                + getCountry() + ". "
                + getColor() + " " +
                "цвет кузова. "
                + getMaxSpeed() + "км/ч - максимальная скорость.";
    }
}
