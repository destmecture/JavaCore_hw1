public class Main {
    public static void main(String[] args) {

        Auto lada = new Auto("Lada", "Granta", 1.7, "желтый", 2015, "Россия");
        Auto audi = new Auto("Audi", "A8 50 L TDI quattro", 3.0, "Черный", 2020, "Германия");
        Auto bmw = new Auto("bmw", "z8", 3.0, "черный", 2021, "Германия");
        Auto kia = new Auto("Kia", "Sportage 4-го поколения", 2.4, "красный", 2018, "Южная Корея");
        Auto hyundai = new Auto("Hyundai", "Avante", 1.6, "оранджевый", 2016, "Южная Корея");

        System.out.println(lada.toString());
        System.out.println(audi.toString());
        System.out.println(bmw.toString());
        System.out.println(kia.toString());
        System.out.println(hyundai.toString());

        /*
        проверки корректности ввода данных
         */

        Auto car = new Auto("", "  ", -2, "", 250, "         ");
        System.out.println(car.toString());
    }
}
