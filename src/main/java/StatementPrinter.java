import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class StatementPrinter {

    public static final int TRAGEDY_BASE_AMOUNT = 40000;
    public static final int TRAGEDY_AUDIENCE_THRESHOLD = 30;
    public static final int TRAGEDY_PRICE_PER_ADDITIONAL_PERSON = 1000;
    public static final int COMEDY_BASE_AMOUNT = 30000;
    public static final int COMEDY_AUDIENCE_THRESHOLD = 20;
    public static final int COMEDY_FIXED_SURCHARGE_FOR_ADDITIONAL_AUDIENCE = 10000;
    public static final int COMEDY_PRICE_PER_ADDITIONAL_PERSON = 500;
    public static final int COMEDY_PRICE_PER_PERSON = 300;
    public static final int TRAGEDY_FIXED_SURCHARGE_FOR_ADDITIONAL_AUDIENCE = 0;
    public static final int TRAGEDY_PRICE_PER_PERSON = 0;

    public String print(Invoice invoice, Map<String, Play> plays) {
        int totalAmount = 0;
        int volumeCredits = 0;
        StringBuilder result = new StringBuilder(String.format("Statement for %s\n", invoice.customer));

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);

        for (Performance perf : invoice.performances) {
            Play play = plays.get(perf.playID);
            int thisAmount = 0;

            switch (play.type) {
                case "tragedy":
                    thisAmount = TRAGEDY_BASE_AMOUNT;
                    if (perf.audience > TRAGEDY_AUDIENCE_THRESHOLD) {
                        thisAmount += TRAGEDY_FIXED_SURCHARGE_FOR_ADDITIONAL_AUDIENCE
                                + TRAGEDY_PRICE_PER_ADDITIONAL_PERSON
                                * (perf.audience - TRAGEDY_AUDIENCE_THRESHOLD);
                    }
                    thisAmount += TRAGEDY_PRICE_PER_PERSON * perf.audience;
                    break;
                case "comedy":
                    thisAmount = COMEDY_BASE_AMOUNT;
                    if (perf.audience > COMEDY_AUDIENCE_THRESHOLD) {
                        thisAmount += COMEDY_FIXED_SURCHARGE_FOR_ADDITIONAL_AUDIENCE
                                + COMEDY_PRICE_PER_ADDITIONAL_PERSON
                                * (perf.audience - COMEDY_AUDIENCE_THRESHOLD);
                    }
                    thisAmount += COMEDY_PRICE_PER_PERSON * perf.audience;
                    break;
                default:
                    throw new Error("unknown type: ${play.type}");
            }

            // add volume credits
            volumeCredits += Math.max(perf.audience - 30, 0);
            // add extra credit for every ten comedy attendees
            if ("comedy".equals(play.type)) volumeCredits += Math.floor(perf.audience / 5);

            // print line for this order
            result.append(String.format("  %s: %s (%s seats)\n", play.name, numberFormat.format(thisAmount / 100), perf.audience));
            totalAmount += thisAmount;
        }
        result.append(String.format("Amount owed is %s\n", numberFormat.format(totalAmount / 100)));
        result.append(String.format("You earned %s credits\n", volumeCredits));
        return result.toString();
    }

}
