import java.text.NumberFormat;
import java.util.Locale;

public class Invoice {

    public static final String INVOICE_HEADER = "Statement for %s\n";
    public static final String INVOICE_LINE = "  %s: %s (%s seats)\n";
    public static final String INVOICE_FOOTER =
            "Amount owed is %s\n"
            + "You earned %s credits\n";

    public static final NumberFormat NUMBER_FORMAT = NumberFormat.getCurrencyInstance(Locale.US);

    public String customer;
    Performances performances;

    public Invoice(String customer, Performances performances) {
        this.customer = customer;
        this.performances = performances;
    }

    public String print() {
        StringBuilder result = new StringBuilder(String.format(INVOICE_HEADER, customer));

        result.append(getInvoiceLines());

        result.append(String.format(INVOICE_FOOTER,
                NUMBER_FORMAT.format(performances.getTotalAmount() / 100),
                performances.getTotalVolumeCredits()));

        return result.toString();
    }

    private StringBuilder getInvoiceLines() {
        StringBuilder result = new StringBuilder();
        for (Performance perf : performances.getPerformances()) {
            result.append(perf.print(new InvoicePrinter()));
        }
        return result;
    }
}
