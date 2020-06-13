import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.approvaltests.Approvals.verify;

public class StatementPrinterTests {

    @Test
    public void exampleStatement() {
        Map<String, Play> plays = new HashMap<String, Play>() {{
            put("hamlet", new TragedyPlay("Hamlet", "tragedy"));
            put("as-like", new ComedyPlay("As You Like It", "comedy"));
            put("othello", new TragedyPlay("Othello", "tragedy"));
        }};

        Invoice invoice = new Invoice("BigCo", Arrays.asList(
                new Performance("hamlet", 55),
                new Performance("as-like", 35),
                new Performance("othello", 40)
        ));

        StatementPrinter statementPrinter = new StatementPrinter();
        String result = statementPrinter.print(invoice, plays);

        verify(result);
    }

    @Test
    public void statementWithNewPlayTypes() {

        Map<String, Play> plays = new HashMap<String, Play>() {{
            put("henry-v", new HistoryPlay("Henry V", "history"));
            put("as-like", new PastoralPlay("As You Like It", "pastoral"));
        }};

        Invoice invoice = new Invoice("BigCo", Arrays.asList(
                new Performance("henry-v", 53),
                new Performance("as-like", 55)));

        StatementPrinter statementPrinter = new StatementPrinter();
        Assert.assertThrows(Error.class, () -> {
            statementPrinter.print(invoice, plays);
        });
    }
}
