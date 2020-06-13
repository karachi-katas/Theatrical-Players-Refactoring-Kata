package invoice;

import Play.Play;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import performance.Performance;

public class InvoicePrinter {

    public static final String INVOICE_LINE = "  %s: %s (%s seats)\n";
    public static final String INVOICE_FOOTER =
            "Amount owed is %s\n"
                    + "You earned %s credits\n";
    public static final NumberFormat NUMBER_FORMAT = NumberFormat.getCurrencyInstance(Locale.US);

    public String printFor(Play play, int audience, int amount) {
        return String.format(INVOICE_LINE,
                play.print(this),
                NUMBER_FORMAT.format(amount / 100),
                audience);
    }

    public String printFor(List<Performance> performances, int totalAmount, int totalVolumeCredits) {
        StringBuilder result = new StringBuilder();

        for (Performance perf : performances) {
            result.append(perf.print(this));
        }

        result.append(String.format(INVOICE_FOOTER,
                NUMBER_FORMAT.format(totalAmount / 100),
                totalVolumeCredits));

        return result.toString();
    }

    public String printFor(String playName) {
        return playName;
    }
}
