package org.dibek.munro.validator;

public enum ErrorCodes {

    MINHEIGHTHIGHERMAXHEIGHT("1000"),MAXHEIGHTLOWERMINHEIGHT("1001");

    public final String code;

    private ErrorCodes(String code) {
        this.code = code;
    }
}
