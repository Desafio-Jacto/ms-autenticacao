package br.com.jacto.api_autenticacao.infra.exception_handler;

import br.com.jacto.api_autenticacao.infra.exceptions.EmailJaCadastradoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailJaCadastradoException.class)
    public ResponseEntity<RestErrorMessage> handleEmailJaCadastrado(
            EmailJaCadastradoException ex,
            HttpServletRequest request) {

        RestErrorMessage error = new RestErrorMessage(
                HttpStatus.CONFLICT,
                ex.getMessage(),
                LocalDateTime.now(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RestErrorMessage> handleValidationExceptions(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {

        String message = ex.getBindingResult().getFieldError().getDefaultMessage();
        RestErrorMessage error = new RestErrorMessage(
                HttpStatus.BAD_REQUEST,
                "Erro de validação: " + message,
                LocalDateTime.now(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
