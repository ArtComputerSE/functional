package se.artcomputer.fn.test;

import se.artcomputer.fn.Function;
import se.artcomputer.fn.Result;

public class ResultExample extends Result<Integer, String> {

    private ResultExample(Integer okValue, String errValue) {
        super(okValue, errValue);
    }

    public static ResultExample ok(Integer okValue) {
        return new ResultExample(okValue, null);
    }

    public static ResultExample err(String errValue) {
        return new ResultExample(null, errValue);
    }

    public String caseExecute(Function<Integer, String> fOk2S, Function<String, String> fErr2S) {
        if (isOk()) {
            return fOk2S.apply(getOkValue());
        }
        return fErr2S.apply(getErrValue());

    }
}