public class BadPlay extends Play {

    protected BadPlay(String name, String type) {
        super(name, type);
    }

    @Override
    int getAmount(Performance perf) {
        throw new Error("unknown type: ${play.type}");
    }
}
