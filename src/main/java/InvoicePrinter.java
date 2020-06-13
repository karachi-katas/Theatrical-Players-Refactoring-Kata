import Play.Play;
import java.text.NumberFormat;
import java.util.Locale;

public class InvoicePrinter {

    public static final String INVOICE_LINE = "  %s: %s (%s seats)\n";
    public static final NumberFormat NUMBER_FORMAT = NumberFormat.getCurrencyInstance(Locale.US);

    public String printFor(Play play, int audience, int amount) {
        return String.format(INVOICE_LINE,
                play.name,
                NUMBER_FORMAT.format(amount / 100),
                audience);
    }
}
