public class UnknownPlay extends Play {

    public UnknownPlay(String name, String type) {
        super(name, type);
    }

    @Override
    int getBaseAmount() {
        return 0;
    }

    @Override
    int totalAmountBasedOnAudience(int audience) {
        throw new Error("unknown type: ${play.type}");
    }
}
