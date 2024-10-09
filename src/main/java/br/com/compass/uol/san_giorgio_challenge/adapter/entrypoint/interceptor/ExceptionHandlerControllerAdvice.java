package br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.interceptor;


import br.com.compass.uol.san_giorgio_challenge.usecase.exception.PaymentNotFoundException;
import br.com.compass.uol.san_giorgio_challenge.usecase.exception.SellerNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    private final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerControllerAdvice.class);

    public static final String NOT_FOUND_EXCEPTION = "Not Found exception: ";

    public static final String GENERIC_EXCEPTION = "Generic exception: ";


    @ExceptionHandler({ SellerNotFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ResponseEntity<ErrorDTO> handleNotFoundException(
            final SellerNotFoundException sellerNotFoundException) {
        LOGGER.error(NOT_FOUND_EXCEPTION, sellerNotFoundException);

        return new ResponseEntity<>(ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .message(sellerNotFoundException.getMessage()).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ PaymentNotFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ResponseEntity<ErrorDTO> handleNotFoundException(
            final PaymentNotFoundException paymentNotFoundException) {
        LOGGER.error(NOT_FOUND_EXCEPTION, paymentNotFoundException);

        return new ResponseEntity<>(ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .message(paymentNotFoundException.getMessage()).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ Exception.class })
    @ResponseStatus (HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ResponseEntity<ErrorDTO> handleException(final Exception exception) {
        LOGGER.error(GENERIC_EXCEPTION, exception);

        return new ResponseEntity<>(ErrorDTO.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(exception.getMessage()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

