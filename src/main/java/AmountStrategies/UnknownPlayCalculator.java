package AmountStrategies;

public class UnknownPlayCalculator implements AmountCalculator {

    @Override
    public int calculate(int audience) {
        throw new Error("unknown type: ${play.type}");
    }
}
