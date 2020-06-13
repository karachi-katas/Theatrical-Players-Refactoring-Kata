import Play.Play;
import invoice.Invoice;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import performance.Performance;
import performance.Performances;

import static org.approvaltests.Approvals.verify;

public class StatementPrinterTests {

    @Test
    public void exampleStatement() {
        Map<String, Play> plays = new HashMap<String, Play>() {{
            put("hamlet", Play.create("Hamlet", "tragedy"));
            put("as-like", Play.create("As You Like It", "comedy"));
            put("othello", Play.create("Othello", "tragedy"));
        }};

        List<Performance> performances = Arrays.asList(
                new Performance(plays.get("hamlet"), 55),
                new Performance(plays.get("as-like"), 35),
                new Performance(plays.get("othello"), 40)
        );

        Invoice invoice = new Invoice("BigCo", new Performances(performances));

        String result = invoice.print();

        verify(result);
    }

    @Test
    public void statementWithNewPlayTypes() {

        Map<String, Play> plays = new HashMap<String, Play>() {{
            put("henry-v", Play.create("Henry V", "history"));
            put("as-like", Play.create("As You Like It", "pastoral"));
        }};

        List<Performance> performances = Arrays.asList(
                new Performance(plays.get("henry-v"), 53),
                new Performance(plays.get("as-like"), 55));

        Invoice invoice = new Invoice("BigCo", new Performances(performances)
        );

        Assert.assertThrows(Error.class, () -> {
            invoice.print();
        });
    }
}
