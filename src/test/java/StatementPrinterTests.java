import Play.Play;
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
            put("hamlet", Play.create("Hamlet", "tragedy"));
            put("as-like", Play.create("As You Like It", "comedy"));
            put("othello", Play.create("Othello", "tragedy"));
        }};

        Invoice invoice = new Invoice("BigCo", Arrays.asList(
                new Performance(plays.get("hamlet"), 55),
                new Performance(plays.get("as-like"), 35),
                new Performance(plays.get("othello"), 40)
        ));

        String result = invoice.print();

        verify(result);
    }

    @Test
    public void statementWithNewPlayTypes() {

        Map<String, Play> plays = new HashMap<String, Play>() {{
            put("henry-v", Play.create("Henry V", "history"));
            put("as-like", Play.create("As You Like It", "pastoral"));
        }};

        Invoice invoice = new Invoice("BigCo", Arrays.asList(
                new Performance(plays.get("henry-v"), 53),
                new Performance(plays.get("as-like"), 55))
        );

        Assert.assertThrows(Error.class, () -> {
            invoice.print();
        });
    }
}
