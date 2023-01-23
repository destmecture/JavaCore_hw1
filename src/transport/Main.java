package transport;

public class Main {
    public static void main(String[] args) {

        Transport lada = new Car("Lada", "Granta", 1.7,
                "желтый", 2015, "Россия",
                "Седан", 5, "Механика",
                "Т991УЕ71", "Зима", 160, new Car.Key(true, false));

        System.out.println(lada);
        ((Car) lada).changeTypeOfTires();


/*
проверки корректности ввода данных
*/
        Car car = new Car("", " ", -2,
            "", 250, " ",
            "", -1, " ",
            "Т991уЭдд", "winter", -20, new Car.Key(false,false));
        System.out.println(car);

        Transport iveco = new Bus("Iveco", "Daily", 2006, "Россия", "красный", 120);
        Transport mercedes = new Bus("mercedes", "sprinter", 2010, "Германия", "Белый", 140);
        Transport ford = new Bus(null, "     ", 10000, "испания", "", 520);

        System.out.println(iveco);
        System.out.println(mercedes);
        System.out.println(ford);

    }

}
