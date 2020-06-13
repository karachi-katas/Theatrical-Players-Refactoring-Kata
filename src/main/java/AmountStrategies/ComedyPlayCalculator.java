package AmountStrategies;

public class ComedyPlayCalculator implements AmountCalculator {

    @Override
    public int calculate(int audience) {
        int thisAmount = 30000;
        if (audience > 20) {
            thisAmount += 10000 + 500 * (audience - 20);
        }
        thisAmount += 300 * audience;

        return thisAmount;
    }
}
