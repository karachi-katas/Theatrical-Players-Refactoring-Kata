import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class Invoice {

    public static final String INVOICE_HEADER = "Statement for %s\n";
    public static final String INVOICE_LINE = "  %s: %s (%s seats)\n";
    public static final String INVOICE_FOOTER =
            "Amount owed is %s\n"
            + "You earned %s credits\n";

    public static final NumberFormat NUMBER_FORMAT = NumberFormat.getCurrencyInstance(Locale.US);

    public String customer;
    public List<Performance> performances;

    public Invoice(String customer, List<Performance> performances) {
        this.customer = customer;
        this.performances = performances;
    }

    public String print() {
        int totalAmount = 0;
        int volumeCredits = 0;
        StringBuilder result = new StringBuilder(String.format(INVOICE_HEADER, customer));

        for (Performance perf : performances) {
            int thisAmount = perf.getAmount();
            volumeCredits += perf.getVolumeCredits();

            result.append(String.format(
                    INVOICE_LINE, perf.play.name, NUMBER_FORMAT.format(thisAmount / 100), perf.audience));
            totalAmount += thisAmount;
        }
        result.append(String.format(INVOICE_FOOTER, NUMBER_FORMAT.format(totalAmount / 100), volumeCredits));
        return result.toString();
    }
}
