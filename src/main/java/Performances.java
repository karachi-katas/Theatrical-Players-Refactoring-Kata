import java.util.List;

public class Performances implements Invoiceable {
    List<Performance> performances;

    public Performances(List<Performance> performances) {
        this.performances = performances;
    }

    public List<Performance> getPerformances() {
        return performances;
    }

    public int getTotalAmount() {
        return performances.stream().mapToInt(Performance::getAmount).sum();
    }

    public int getTotalVolumeCredits() {
        return performances.stream().mapToInt(Performance::getVolumeCredits).sum();
    }

    @Override
    public String print(InvoicePrinter invoicePrinter) {
        return invoicePrinter.printFor(performances);
    }
}
