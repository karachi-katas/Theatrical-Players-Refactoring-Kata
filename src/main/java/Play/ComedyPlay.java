package Play;

public class ComedyPlay extends Play {

    protected ComedyPlay(String name, String type) {
        super(name, type);
    }

    @Override
    public int getAmount(int audience) {
        return super.getAmount(
                audience,
                30000,
                20,
                10000,
                500,
                300);
    }
}
