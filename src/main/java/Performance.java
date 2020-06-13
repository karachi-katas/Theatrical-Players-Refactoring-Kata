import Play.Play;

public class Performance {

    public Play play;
    public String playID;
    public int audience;

    public Performance(String playID, int audience) {
        this.playID = playID;
        this.audience = audience;
    }

    public Performance(Play play, int audience) {
        this.play = play;
        this.audience = audience;
    }
}
