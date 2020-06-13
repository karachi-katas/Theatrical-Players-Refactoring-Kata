public class Play {

    protected String name;
    protected Integer amount;
    protected Integer volumeCredits;

    public Play(String name) {
        this.name = name;
        this.amount = 0;
    }

    public Integer getPlayAmount(Integer audience){
        throw new Error("unknown type: ${play.type}");
    }

    public Integer getVolumeCredits(Integer audience){
        return Math.max(audience - 30, 0);
    }

}
