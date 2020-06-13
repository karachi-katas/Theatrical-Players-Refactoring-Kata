import java.text.NumberFormat;
import java.util.Locale;

public class Performance implements Invoiceable, Printable {

    public Play play;
    public int audience;

    public Performance(Play play, int audience) {
        this.play = play;
        this.audience = audience;
    }

    @Override
    public int getPerformanceRevenue() {
        return play.totalAmountBasedOnAudience(audience);
    }

    @Override
    public int getVolumeCredits() {
        return play.volumeCreditBasedOnAudience(audience);
    }

    @Override
    public String print() {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        return String.format("  %s: %s (%s seats)\n", play.print(), numberFormat.format(getPerformanceRevenue() / 100), audience);
    }
}
