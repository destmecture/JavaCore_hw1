package transport;

public class Main {
    public static void main(String[] args) {

        Car lada = new Car("Lada", "Granta", 1.7,
                "желтый", 2015, "Россия",
                "Седан", 5, "Механика",
                "Т991УЕ71", "Зима", new Car.Key(true, false));

        System.out.println(lada);
        lada.changeTypeOfTires();


/*
проверки корректности ввода данных
*/
        Car car = new Car("", " ", -2,
            "", 250, " ",
            "", -1, " ",
            "Т991уЭдд", "winter",new Car.Key(false,false));
        System.out.println(car);
    }

}
