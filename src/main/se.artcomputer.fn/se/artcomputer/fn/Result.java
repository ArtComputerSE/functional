package se.artcomputer.fn;

public abstract class Result<OK, ERR> {

    private OK okValue;
    private ERR errValue;

    protected Result(OK okValue, ERR errValue) {
        this.okValue = okValue;
        this.errValue = errValue;
    }

    public boolean isOk() {
        return okValue != null && errValue == null;
    }

    public boolean isErr() {
        return errValue != null && okValue == null;
    }

    public OK getOkValue() {
        return okValue;
    }

    public ERR getErrValue() {
        return errValue;
    }

}
