import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class Invoice implements Printable{

    public String customer;
    public List<Performance> performances;

    public Invoice(String customer, List<Performance> performances) {
        this.customer = customer;
        this.performances = performances;
    }

    public int generateInvoice(Performance perf) {
        return perf.getPerformanceRevenue();
    }

    public int getVolumeCredits(Performance perf) {
        return perf.getVolumeCredits();
    }

    @Override
    public String print() {
        int totalAmount = 0;
        int volumeCredits = 0;
        StringBuilder result = new StringBuilder(String.format("Statement for %s\n", customer));

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        for (Performance perf : performances) {
            int thisAmount = generateInvoice(perf);

            volumeCredits += getVolumeCredits(perf);
            result.append(perf.print());
            totalAmount += thisAmount;
        }

        result.append(String.format("Amount owed is %s\n", numberFormat.format(totalAmount / 100)));
        result.append(String.format("You earned %s credits\n", volumeCredits));
        return result.toString();
    }
}
