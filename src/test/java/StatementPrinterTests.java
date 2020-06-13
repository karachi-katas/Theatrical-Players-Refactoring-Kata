import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.approvaltests.Approvals.verify;

public class StatementPrinterTests {

    @Test
    public void exampleStatement() {
        Invoice invoice = new Invoice("BigCo", Arrays.asList(
                new Performance(new Play("Hamlet", "tragedy"), new Audience(55)),
                new Performance(new Play("As You Like It", "comedy"), new Audience(35)),
                new Performance(new Play("Othello", "tragedy"), new Audience(40))
        ));

        StatementPrinter statementPrinter = new StatementPrinter();
        String result = statementPrinter.print(invoice);

        verify(result);
    }

    @Test
    public void statementWithNewPlayTypes() {

        Invoice invoice = new Invoice("BigCo", Arrays.asList(
                new Performance(new Play("Henry V", "history"), new Audience(53)),
                new Performance(new Play("As You Like It", "pastoral"), new Audience(55))));

        StatementPrinter statementPrinter = new StatementPrinter();
        Assert.assertThrows(Error.class, () -> {
            statementPrinter.print(invoice);
        });
    }
}
