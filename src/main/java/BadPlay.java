public class BadPlay extends Play {

    protected BadPlay(String name, String type) {
        super(name, type);
    }

    @Override
    public int getAmount(int audience) {
        throw new Error("unknown type: ${play.type}");
    }
}
