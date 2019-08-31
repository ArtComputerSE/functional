package se.artcomputer.fn.test;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ResultTest {

    private static final String SOME_ERROR_MESSAGE = "some error message";
    private static final Integer SOME_OK_VALUE = 42;
    private static final String FINE_RESULT = "Fine result: ";
    private static final String WENT_SOUTH = "Went south: ";

    @Test
    public void ok_is_ok() {
        ResultExample okResult = ResultExample.ok(SOME_OK_VALUE);

        assertTrue(okResult.isOk());
    }

    @Test
    public void ok_has_value() {
        ResultExample okResult = ResultExample.ok(SOME_OK_VALUE);

        assertEquals(SOME_OK_VALUE, okResult.getOkValue());
    }

    @Test
    public void err_is_err() {
        ResultExample errResult = ResultExample.err(SOME_ERROR_MESSAGE);

        assertTrue(errResult.isErr());
    }

    @Test
    public void err_has_value() {
        ResultExample errResult = ResultExample.err(SOME_ERROR_MESSAGE);

        assertEquals(SOME_ERROR_MESSAGE, errResult.getErrValue());
    }

    @Test
    public void execute_ok_result() {
        ResultExample okResult = ResultExample.ok(SOME_OK_VALUE);

        String actual = okResult.caseExecute(i -> FINE_RESULT + i, s -> WENT_SOUTH + s);

        assertEquals(FINE_RESULT + SOME_OK_VALUE, actual);
    }

    @Test
    public void execute_err_result() {
        ResultExample errResult = ResultExample.err(SOME_ERROR_MESSAGE);

        String actual = errResult.caseExecute(i -> FINE_RESULT + i, s -> WENT_SOUTH + s);

        assertEquals(WENT_SOUTH + SOME_ERROR_MESSAGE, actual);
    }
}