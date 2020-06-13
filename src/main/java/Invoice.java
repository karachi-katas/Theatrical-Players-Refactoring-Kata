import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import play.Play;

public class Invoice {

    public String customer;
    public List<Performance> performances;

    public int volumeCredits = 0;
    public int totalAmount = 0;

    private NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
    public Invoice(String customer, List<Performance> performances) {
        this.customer = customer;
        this.performances = performances;
    }


    public void func(StringBuilder result) {

        for (Performance perf : performances) {
            Play play = perf.play;
            int thisAmount = perf.calculatePerformanceAmount(play);
            // add volume credits
            volumeCredits += play.getVolumeCredits(perf.audience);
            result.append(String.format("  %s: %s (%s seats)\n", play.name, numberFormat.format(thisAmount / 100), perf.audience));
            totalAmount += thisAmount;
        }

    }

}
