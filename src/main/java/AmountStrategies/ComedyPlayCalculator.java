package AmountStrategies;

public class ComedyPlayCalculator implements InvoiceCalculator {

    @Override
    public int calculateAmount(int audience) {
        int thisAmount = 30000;
        if (audience > 20) {
            thisAmount += 10000 + 500 * (audience - 20);
        }
        thisAmount += 300 * audience;

        return thisAmount;
    }

    @Override
    public int calculateCredits(int audience) {
        return Math.max(audience - 30, 0) + (int)Math.floor(audience / 5);
    }
}
