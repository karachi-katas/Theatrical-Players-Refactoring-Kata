import sun.misc.Perf;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class Invoice {

    private String customer;
    private List<Performance> performances;

    private final NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);

    private int totalAmount;
    private int volumeCredits;

    private String printableResult;

    public Invoice(String customer, List<Performance> performances) {
        this.customer = customer;
        this.performances = performances;

        totalAmount = calculateTotalAmount();
        volumeCredits = calculateVolumeCredits();

        printableResult = generatePrintableString();
    }

    private int calculateTotalAmount() {
        return this.performances
                .stream()
                .mapToInt(Performance::getAmount)
                .sum();
    }

    private int calculateVolumeCredits() {
        return this.performances
                .stream()
                .mapToInt(Performance::getCredits)
                .sum();
    }

    private void processPerformance(Performance performance, StringBuilder result) {
        Play play = PlaysRepository.getInstance().findPlayById(performance.getPlayID());
        result.append(String.format("  %s: %s (%s seats)\n", play.name, numberFormat.format(performance.getAmount() / 100), performance.getAudience()));
    }

    private String generatePrintableString() {
        StringBuilder result = new StringBuilder(String.format("Statement for %s\n", this.customer));
        performances.forEach(performance -> processPerformance(performance, result));
        result.append(String.format("Amount owed is %s\n", numberFormat.format(totalAmount / 100)));
        result.append(String.format("You earned %s credits\n", volumeCredits));
        return result.toString();
    }

    public String print() {
        return printableResult;
    }
}
