import javax.swing.plaf.nimbus.State;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class StatementPrinter {

    private StringBuilder result;
    private int totalAmount;
    private int totalVolumeCredits;
    private NumberFormat numberFormat;

    public StatementPrinter()
    {
        StringBuilder result;
        int totalAmount = 0;
        int totalVolumeCredits = 0;
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);;
    }

    public String print(Invoice invoice, Map<String, Play> plays) {
        setStringBuilder(invoice.customer);
        calculateTotal(invoice, plays, numberFormat);
        result.append(String.format("Amount owed is %s\n", numberFormat.format(totalAmount / 100)));
        result.append(String.format("You earned %s credits\n", totalVolumeCredits));
        return result.toString();
    }

    private void calculateTotal(Invoice invoice, Map<String, Play> plays, NumberFormat numberFormat) {
        for (Performance perf : invoice.performances) {
            Play play = plays.get(perf.playID);
            int thisAmount = play.getPlayAmount(perf.audience);
            totalVolumeCredits += play.getVolumeCredits(perf.audience);
            appendResult(result, numberFormat, perf, play, thisAmount);
            totalAmount += thisAmount;
        }
    }

    private void appendResult(StringBuilder result, NumberFormat numberFormat, Performance perf, Play play, int thisAmount) {
        result.append(String.format("  %s: %s (%s seats)\n", play.name,
                numberFormat.format(thisAmount / 100), perf.audience));
    }

    public void setStringBuilder(String customer)
    {
        result = new StringBuilder(String.format("Statement for %s\n", customer));
    }
}