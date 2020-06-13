public abstract class Play {

    public String name;
    public String type;
    private int baseAmount;

    public Play(String name, String type) {
        this.name = name;
        this.type = type;
    }

    abstract int getBaseAmount();
}
