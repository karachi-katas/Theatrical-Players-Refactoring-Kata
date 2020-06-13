import java.util.List;

public class Performances {
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
}
