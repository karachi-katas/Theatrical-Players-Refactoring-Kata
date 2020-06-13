package Play;

public class TragedyPlay extends Play {

    protected TragedyPlay(String name, String type) {
        super(name, type);
    }

    @Override
    public int getAmount(int audience) {
        return super.getAmount(
                audience,
                40000,
                30,
                0,
                1000,
                0);
    }
}
