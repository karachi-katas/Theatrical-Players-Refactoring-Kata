public class Performance implements Invoiceable {

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
}
