package AmountStrategies;

public class UnknownPlayCalculator implements InvoiceCalculator {

    @Override
    public int calculateAmount(int audience) {
        throw new Error("unknown type: ${play.type}");
    }

    @Override
    public int calculateCredits(int audience) {
        throw new Error("unknown type: ${play.type}");
    }
}
