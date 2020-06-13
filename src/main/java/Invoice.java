import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class Invoice {

    public String customer;
    public List<Performance> performances;

    public Invoice(String customer, List<Performance> performances) {
        this.customer = customer;
        this.performances = performances;
    }

    public String print() {
        int totalAmount = 0;
        int volumeCredits = 0;
        StringBuilder result = new StringBuilder(String.format("Statement for %s\n", this.customer));

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        PlaysRepository playRepo = PlaysRepository.getInstance();
        for (Performance perf : this.performances) {
            Play play = playRepo.findPlayById(perf.getPlayID());

            int thisAmount = perf.getAmount();

            volumeCredits += Math.max(perf.getAudience() - 30, 0);
            if ("comedy".equals(play.type)) volumeCredits += Math.floor(perf.getAudience() / 5);

            result.append(String.format("  %s: %s (%s seats)\n", play.name, numberFormat.format(thisAmount / 100), perf.getAudience()));
            totalAmount += thisAmount;
        }
        result.append(String.format("Amount owed is %s\n", numberFormat.format(totalAmount / 100)));
        result.append(String.format("You earned %s credits\n", volumeCredits));
        return result.toString();
    }
}
