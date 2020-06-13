import org.junit.Assert;
import org.junit.Test;
import plays.Comedy;
import plays.Invalid;
import plays.Play;
import plays.Tragedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.approvaltests.Approvals.verify;

public class StatementPrinterTests {

    @Test
    public void exampleStatement() {
        Map<String, Play> plays = new HashMap<String, Play>() {{
            put("hamlet", new Tragedy("Hamlet"));
            put("as-like", new Comedy("As You Like It"));
            put("othello", new Tragedy("Othello"));
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
            put("henry-v", new Invalid("Henry V"));
            put("as-like", new Invalid("As You Like It"));
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
