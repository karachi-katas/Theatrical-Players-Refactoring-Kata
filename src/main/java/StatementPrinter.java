import java.text.NumberFormat;
import java.util.Locale;

public class StatementPrinter {

    public String print(Invoice invoice) {
        int totalAmount = 0;
        int volumeCredits = 0;
        StringBuilder result = new StringBuilder(String.format("Statement for %s\n", invoice.customer));

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);

        for (Performance perf : invoice.performances) {
            Play play = perf.play;
            int thisAmount = perf.getThisAmount();

            // add volume credits
            volumeCredits += perf.getVolumeCredit();

            // print line for this order
            result.append(String.format("  %s: %s (%s seats)\n", play.name, numberFormat.format(thisAmount / 100), perf.audience));
            totalAmount += thisAmount;
        }
        result.append(String.format("Amount owed is %s\n", numberFormat.format(totalAmount / 100)));
        result.append(String.format("You earned %s credits\n", volumeCredits));
        return result.toString();
    }

}
