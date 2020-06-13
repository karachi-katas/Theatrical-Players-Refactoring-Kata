import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class Invoice {

    public String customer;
    public List<Performance> performances;

//    private int totalAmount;
//    private int volumeCredits;

    public Invoice(String customer, List<Performance> performances) {
        this.customer = customer;
        this.performances = performances;

//        totalAmount = calculateTotalAmount();
//        volumeCredits = calculateVolumeCredits();
    }

    private int calculateTotalAmount() {
        return this.performances
                .stream()
                .mapToInt(Performance::getAmount)
                .sum();
    }

    private int calculateVolumeCredits() {
        return this.performances
                .stream()
                .mapToInt(Performance::getCredits)
                .sum();
    }

    public String print() {
        StringBuilder result = new StringBuilder(String.format("Statement for %s\n", this.customer));
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);

        int totalAmount = 0;
        int volumeCredits = 0;

        for (Performance perf : this.performances) {
            Play play = PlaysRepository.getInstance().findPlayById(perf.getPlayID());

            int thisAmount = perf.getAmount();

            volumeCredits += perf.getCredits();
            totalAmount += thisAmount;

            result.append(String.format("  %s: %s (%s seats)\n", play.name, numberFormat.format(thisAmount / 100), perf.getAudience()));
        }

        result.append(String.format("Amount owed is %s\n", numberFormat.format(totalAmount / 100)));
        result.append(String.format("You earned %s credits\n", volumeCredits));

        return result.toString();
    }
}
