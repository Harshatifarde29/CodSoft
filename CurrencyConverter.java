import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        // Define exchange rates (base currency is USD)
        Map<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.74);
        exchangeRates.put("JPY", 110.41);

        // Get user input for base and target currencies
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Currency Converter!");
        System.out.print("Enter the base currency (e.g., USD, EUR): ");
        String baseCurrency = scanner.nextLine().toUpperCase();
        System.out.print("Enter the target currency (e.g., USD, EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        // Validate input currencies
        if (!exchangeRates.containsKey(baseCurrency) || !exchangeRates.containsKey(targetCurrency)) {
            System.out.println("Invalid currency codes. Please enter valid currency codes.");
            scanner.close();
            return;
        }

        // Get user input for the amount to convert
        System.out.print("Enter the amount to convert: ");
        double amountToConvert = scanner.nextDouble();

        // Perform currency conversion
        double baseToTargetRate = exchangeRates.get(targetCurrency) / exchangeRates.get(baseCurrency);
        double convertedAmount = amountToConvert * baseToTargetRate;

        // Display the result
        System.out.printf("%.2f %s is equivalent to %.2f %s%n", amountToConvert, baseCurrency, convertedAmount, targetCurrency);

        scanner.close();
    }
}
