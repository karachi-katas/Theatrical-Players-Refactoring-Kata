public class TragedyPlay extends Play {
    public TragedyPlay(String name, String type) {
        super(name, type);
    }

    @Override
    int getBaseAmount() {
        return 40000;
    }
}

