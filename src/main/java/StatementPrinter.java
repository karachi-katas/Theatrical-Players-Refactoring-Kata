import plays.Play;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class StatementPrinter {

    private Map<String, Play> plays;
    StringBuilder result;
    int totalAmount;
    int volumeCredits;

    NumberFormat numberFormat;

    public String print(Invoice invoice, Map<String, Play> plays) {
        this.plays = plays;
        this.totalAmount = 0;
        this.volumeCredits = 0;
        this.result = new StringBuilder(String.format("Statement for %s\n", invoice.customer));
        this.numberFormat = NumberFormat.getCurrencyInstance(Locale.US);

        this.calculate(invoice);

        result.append(String.format("Amount owed is %s\n", numberFormat.format(totalAmount / 100)));
        result.append(String.format("You earned %s credits\n", volumeCredits));
        return result.toString();
    }

    private void calculate(Invoice invoice) {
        for (Performance performance : invoice.performances) {
            Play play = plays.get(performance.playID);

            int thisAmount = play.calculateAmount(performance.audience);
            // add volume credits
            this.volumeCredits += play.calculateVolumeCredit(performance.audience);
            result.append(String.format("  %s: %s (%s seats)\n", play.name, numberFormat.format(thisAmount / 100), performance.audience));
            this.totalAmount += thisAmount;
        }
    }

}
