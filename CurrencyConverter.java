public class CurrencyConverter {
    private static final double coefficient = 4.29;

    public static double euroToZloty(double euro) {
        return euro * coefficient;
    }

    public static double zlotyToEuro(double zloty) {
        return zloty / coefficient;
    }
}
