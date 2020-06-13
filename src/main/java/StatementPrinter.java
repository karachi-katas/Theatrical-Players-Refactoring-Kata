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
                    thisAmount = getTragedyAmount(perf);
                    break;
                case "comedy":
                    thisAmount = getComedyAmount(perf);
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

    private int getComedyAmount(Performance perf) {
        return getAmount(perf, COMEDY_BASE_AMOUNT, COMEDY_AUDIENCE_THRESHOLD, COMEDY_FIXED_SURCHARGE_FOR_ADDITIONAL_AUDIENCE, COMEDY_PRICE_PER_ADDITIONAL_PERSON, COMEDY_PRICE_PER_PERSON);
    }

    private int getAmount(Performance perf, int comedyBaseAmount, int comedyAudienceThreshold, int comedyFixedSurchargeForAdditionalAudience, int comedyPricePerAdditionalPerson, int comedyPricePerPerson) {
        int thisAmount;
        thisAmount = comedyBaseAmount;
        if (perf.audience > comedyAudienceThreshold) {
            thisAmount += comedyFixedSurchargeForAdditionalAudience
                    + comedyPricePerAdditionalPerson
                    * (perf.audience - comedyAudienceThreshold);
        }
        thisAmount += comedyPricePerPerson * perf.audience;
        return thisAmount;
    }

    private int getTragedyAmount(Performance perf) {
        return getAmount(perf, TRAGEDY_BASE_AMOUNT, TRAGEDY_AUDIENCE_THRESHOLD, TRAGEDY_FIXED_SURCHARGE_FOR_ADDITIONAL_AUDIENCE, TRAGEDY_PRICE_PER_ADDITIONAL_PERSON, TRAGEDY_PRICE_PER_PERSON);
    }

}
