package AmountStrategies;

import java.util.HashMap;

public class AmountStrategyFactory {
    private static UnknownPlayCalculator unknownPlayCalculator = new UnknownPlayCalculator();

    private static HashMap<String, InvoiceCalculator> singletons = new HashMap<String, InvoiceCalculator>() {{
       put("comedy", new ComedyPlayCalculator());
       put("tragedy", new TragedyPlayCalculator());
    }};

    public static InvoiceCalculator getAmountCalculatorStrategy(String playType) {
        return singletons.getOrDefault(playType, unknownPlayCalculator);
    }
}
