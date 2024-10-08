package br.com.compass.uol.san_giorgio_challenge.usecase.exception;

public class SellerNotFoundException extends RuntimeException {
    public SellerNotFoundException(final String message) {
        super(message);
    }

}
