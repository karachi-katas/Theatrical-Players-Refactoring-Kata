package plays;

public  abstract class Play {

    public String name;
    public int audience;

    public Play(String name) {
        this.name = name;

    }
    public abstract int calculateAmount(int audience);
    public abstract int calculateVolumeCredit(int audience);
}
