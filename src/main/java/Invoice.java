import Play.Play;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Invoice {

    public String customer;
    public List<Performance> performances;
    Map<String, Play> plays;

    public Invoice(String customer, List<Performance> performances,
            Map<String, Play> plays) {
        this.customer = customer;
        this.performances = performances;
        this.plays = plays;
    }

    public String print() {
        int totalAmount = 0;
        int volumeCredits = 0;
        StringBuilder result = new StringBuilder(String.format("Statement for %s\n", customer));

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);

        for (Performance perf : performances) {
            Play play = perf.play;
            int thisAmount = play.getAmount(perf.audience);
            volumeCredits += play.getVolumeCredits(perf.audience);

            // print line for this order
            result.append(String.format("  %s: %s (%s seats)\n", play.name, numberFormat.format(thisAmount / 100), perf.audience));
            totalAmount += thisAmount;
        }
        result.append(String.format("Amount owed is %s\n", numberFormat.format(totalAmount / 100)));
        result.append(String.format("You earned %s credits\n", volumeCredits));
        return result.toString();
    }
}
