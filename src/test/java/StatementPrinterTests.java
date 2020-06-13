import org.junit.Assert;
import org.junit.Test;
import play.Comedy;
import play.Play;
import play.Tragedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.approvaltests.Approvals.verify;

public class StatementPrinterTests {

    @Test
    public void exampleStatement() {

        Invoice invoice = new Invoice("BigCo", Arrays.asList(
                new Performance(new Tragedy("Hamlet", "tragedy"), 55),
                new Performance(new Comedy("As You Like It", "comedy"), 35),
                new Performance(new Tragedy("Othello", "tragedy"), 40)
        ));

        StatementPrinter statementPrinter = new StatementPrinter();
        String result = statementPrinter.print(invoice);

        verify(result);
    }

    @Test
    public void statementWithNewPlayTypes() {

        Invoice invoice = new Invoice("BigCo", Arrays.asList(
                new Performance(new Play("Henry V", "history"), 53),
                new Performance(new Play("As You Like It", "pastoral"), 55)));

        StatementPrinter statementPrinter = new StatementPrinter();
        Assert.assertThrows(Error.class, () -> statementPrinter.print(invoice));
    }
}
