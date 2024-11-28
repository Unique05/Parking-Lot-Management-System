package Exit;

public class PriceCalculator {
    PriceCalculator() {

        TimeCalculator calculateTime = new TimeCalculator();
        double price = (double) (2000 * calculateTime.timeDifferenceInMinutes) / 60; // 60 minutes = 2000 Naira

        double rounded = Math.ceil(price / 100) * 100; //rounds price to the nearest hundred

        System.out.printf("Total price is %, .2f ", rounded );
        System.out.print("Naira");
        System.out.println();

    }
}
