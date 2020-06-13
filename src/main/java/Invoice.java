import java.util.List;

public class Invoice {

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
}
