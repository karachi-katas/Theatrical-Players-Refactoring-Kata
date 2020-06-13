import java.util.List;

public class Performances {
    List<Performance> performances;

    public Performances(List<Performance> performances) {
        this.performances = performances;
    }

    public int getTotalAmount() {
        return performances.stream().mapToInt(Performance::getAmount).sum();
    }
}
