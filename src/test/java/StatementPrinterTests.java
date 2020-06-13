import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.approvaltests.Approvals.verify;

public class StatementPrinterTests {

    @Test
    public void exampleStatement() {
        Play hamlet = new TragedyPlay("Hamlet", "tragedy");
        Play asYouLikeIt = new ComedyPlay("As You Like It", "comedy");
        Play othelo = new TragedyPlay("Othello", "tragedy");

        Invoice invoice = new Invoice("BigCo", Arrays.asList(
                new Performance(hamlet, 55),
                new Performance(asYouLikeIt, 35),
                new Performance(othelo, 40)
        ));

        StatementPrinter statementPrinter = new StatementPrinter();
        String result = statementPrinter.print(invoice);

        verify(result);
    }

    @Test
    public void statementWithNewPlayTypes() {
        Play henryV = new UnknownPlay("Henry V", "history");
        Play asYouLikeIt = new UnknownPlay("As You Like It", "pastoral");

        Invoice invoice = new Invoice("BigCo", Arrays.asList(
                new Performance(henryV, 53),
                new Performance(asYouLikeIt, 55)));

        StatementPrinter statementPrinter = new StatementPrinter();
        Assert.assertThrows(Error.class, () -> {
            statementPrinter.print(invoice);
        });
    }
}
