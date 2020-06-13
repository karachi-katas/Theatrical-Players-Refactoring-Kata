import java.text.NumberFormat;
import java.util.Locale;

public class StatementPrinter {

    public String print(Invoice invoice) {

        StringBuilder result = new StringBuilder(String.format("Statement for %s\n", invoice.customer));

        invoice.initializeInvoice(result);

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);

        result.append(String.format("Amount owed is %s\n", numberFormat.format(invoice.totalAmount / 100)));
        result.append(String.format("You earned %s credits\n", invoice.volumeCredits));
        return result.toString();
    }



}
