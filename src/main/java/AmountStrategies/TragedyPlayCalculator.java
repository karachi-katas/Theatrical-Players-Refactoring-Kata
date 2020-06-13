package AmountStrategies;

public class TragedyPlayCalculator implements AmountCalculator {

    @Override
    public int calculate(int audience) {
        int thisAmount = 40000;
        if (audience > 30) {
            thisAmount += 1000 * (audience - 30);
        }

        return thisAmount;
    }
}
