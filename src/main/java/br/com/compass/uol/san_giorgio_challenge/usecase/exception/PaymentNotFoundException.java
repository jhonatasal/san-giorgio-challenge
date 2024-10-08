package br.com.compass.uol.san_giorgio_challenge.usecase.exception;

public class PaymentNotFoundException extends RuntimeException {
    public PaymentNotFoundException(final String message) {
        super(message);
    }

}
