import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class Invoice {

    public String customer;
    public List<Performance> performances;

    public int volumeCredits = 0;
    public int totalAmount = 0;

    private NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
    public Invoice(String customer, List<Performance> performances) {
        this.customer = customer;
        this.performances = performances;
    }


    public void initializeInvoice(StringBuilder result) {

        for (Performance perf : performances) {
            int thisAmount = perf.calculatePerformanceAmount();
            // add volume credits
            volumeCredits += perf.getVolumeCredits();
            result.append(String.format("  %s: %s (%s seats)\n", perf.getPlayName(), numberFormat.format(thisAmount / 100), perf.audience));
            totalAmount += thisAmount;
        }

    }

}
