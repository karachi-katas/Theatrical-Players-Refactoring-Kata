public abstract class Play {

    public String name;
    public String type;

    public Play(String name, String type) {
        this.name = name;
        this.type = type;
    }

    abstract int totalAmountBasedOnAudience(int audience);

    public int volumeCreditBasedOnAudience(int audience) {
        return Math.max(audience - 30, 0);
    }
}
