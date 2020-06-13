import play.Play;

public class Performance {

    public Play play;
    public int audience;

    public Performance(Play play, int audience) {
        this.play = play;
        this.audience = audience;
    }

    public int calculatePerformanceAmount() {
        return play.getAmount(audience);

    }

    public int getVolumeCredits(){
        return play.getVolumeCredits(audience);
    }

    public String getPlayName() {
        return play.name;
    }

}
