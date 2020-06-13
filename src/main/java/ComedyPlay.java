public class ComedyPlay extends Play {

    public ComedyPlay(String name, String type) {
        super(name, type);
    }

    @Override
    int getBaseAmount() {
        return 30000;
    }
}
