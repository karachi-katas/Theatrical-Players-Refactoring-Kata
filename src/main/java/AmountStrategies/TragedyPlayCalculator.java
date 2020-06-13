package AmountStrategies;

public class TragedyPlayCalculator implements InvoiceCalculator {

    @Override
    public int calculateAmount(int audience) {
        int thisAmount = 40000;
        if (audience > 30) {
            thisAmount += 1000 * (audience - 30);
        }

        return thisAmount;
    }

    @Override
    public int calculateCredits(int audience) {
        return Math.max(audience - 30, 0);
    }
}
