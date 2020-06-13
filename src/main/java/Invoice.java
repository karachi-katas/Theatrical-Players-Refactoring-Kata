import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class Invoice {

    public static final String INVOICE_HEADER = "Statement for %s\n";
    public static final String INVOICE_LINE = "  %s: %s (%s seats)\n";
    public static final String INVOICE_FOOTER_1 = "Amount owed is %s\n";
    public static final String INVOICE_FOOTER_2 = "You earned %s credits\n";

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

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);

        for (Performance perf : performances) {
            int thisAmount = perf.getAmount();
            volumeCredits += perf.getVolumeCredits();

            // print line for this order
            result.append(String.format(
                    INVOICE_LINE, perf.play.name, numberFormat.format(thisAmount / 100), perf.audience));
            totalAmount += thisAmount;
        }
        result.append(String.format(INVOICE_FOOTER_1, numberFormat.format(totalAmount / 100)));
        result.append(String.format(INVOICE_FOOTER_2, volumeCredits));
        return result.toString();
    }
}
