import Play.Play;

public class Performance {

    public Play play;
    public String playID;
    public int audience;

    public Performance(Play play, int audience) {
        playID = play.name;
        this.play = play;
        this.audience = audience;
    }

    public int getAmount() {
        return play.getAmount(audience);
    }

    public int getVolumeCredits() {
        return play.getVolumeCredits(audience);
    }
}
