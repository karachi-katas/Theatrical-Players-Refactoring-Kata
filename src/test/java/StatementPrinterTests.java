import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.approvaltests.Approvals.verify;

public class StatementPrinterTests {

    @Test
    public void exampleStatement() {

        // Setup
        PlaysRepository playRepo = PlaysRepository.getInstance();
        playRepo.addPlay("hamlet", new Play("Hamlet", "tragedy"));
        playRepo.addPlay("as-like", new Play("As You Like It", "comedy"));
        playRepo.addPlay("othello", new Play("Othello", "tragedy"));

        Invoice invoice = new Invoice("BigCo", Arrays.asList(
                new Performance("hamlet", 55),
                new Performance("as-like", 35),
                new Performance("othello", 40)
        ));

        String result = invoice.print();

        verify(result);
    }

    @Test
    public void statementWithNewPlayTypes() {

        // Setup
        PlaysRepository playRepo = PlaysRepository.getInstance();
        playRepo.addPlay("henry-v", new Play("Henry V", "history"));
        playRepo.addPlay("as-like", new Play("As You Like It", "pastoral"));

        Invoice invoice = new Invoice("BigCo", Arrays.asList(
                new Performance("henry-v", 53),
                new Performance("as-like", 55)));

        Assert.assertThrows(Error.class, () -> {
            invoice.print();
        });
    }
}
