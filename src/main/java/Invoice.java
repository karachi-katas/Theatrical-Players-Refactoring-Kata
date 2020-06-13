import java.text.NumberFormat;
import java.util.Locale;

public class Invoice {

    public static final String INVOICE_HEADER = "Statement for %s\n";

    public String customer;
    Performances performances;

    public Invoice(String customer, Performances performances) {
        this.customer = customer;
        this.performances = performances;
    }

    public String print() {
        StringBuilder result = new StringBuilder(String.format(INVOICE_HEADER, customer));

        result.append(performances.print(new InvoicePrinter()));

        return result.toString();
    }
}
