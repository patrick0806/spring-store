package tech.patricknicezi.Spring.Store.bootstrap.exceptions;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExecptionHandler extends ResponseEntityExceptionHandler {
    private final String GENERIC_ERROR_MESSAGE = "An error occurred, please try again later.";
    private final MessageSource messageSource;

    public ApiExecptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ExceptionData> handleAlreadyExistsException(AlreadyExistsException ex) {
        HttpStatus status = HttpStatus.CONFLICT;
        ExceptionData exceptionData = ExceptionData.builder()
                .status(status.value())
                .title("Entity already exists")
                .detail(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(status).body(exceptionData);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ExceptionData> handleUsernameNotFoundException(UsernameNotFoundException ex) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        ExceptionData exceptionData = ExceptionData.builder()
                .status(status.value())
                .title("Unauthorized access")
                .detail(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(status).body(exceptionData);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionData> handleGenericException(Exception ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ExceptionData exceptionData = ExceptionData.builder()
                .status(status.value())
                .title("Internal server error")
                .detail(GENERIC_ERROR_MESSAGE)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(status).body(exceptionData);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ExceptionData> handleBadCredentialsException(BadCredentialsException ex) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        ExceptionData exceptionData = ExceptionData.builder()
                .status(status.value())
                .title("Unauthorized access")
                .detail(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(status).body(exceptionData);
    }

    @ExceptionHandler(GenerateTokenException.class)
    public ResponseEntity<ExceptionData> handleGenerateTokenException(GenerateTokenException ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ExceptionData exceptionData = ExceptionData.builder()
                .status(status.value())
                .title("Internal server error")
                .detail(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(status).body(exceptionData);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        HttpStatus httpStatus = (HttpStatus) status;
        String userMessage = "Um ou mais parametros estão invalidos, faça o preenchimento correto e tente novamente";
        BindingResult bindingResult = ex.getBindingResult();
        List<ExceptionData.Field> problemFields = bindingResult.getFieldErrors()
                .stream()
                .map(fieldError ->{
                            String message = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
                            return ExceptionData.Field.builder()
                                    .name(fieldError.getField())
                                    .userMessage(message)
                                    .build();
                        }
                )
                .collect(Collectors.toList());


        ExceptionData exceptionData = ExceptionData.builder()
                .status(httpStatus.value())
                .title("Invalid Params")
                .detail("One or more fields are invalid. Fill in correctly and try again")
                .userMessage(userMessage)
                .timestamp(LocalDateTime.now())
                .fields(problemFields)
                .build();
        return handleExceptionInternal(ex,exceptionData,headers,httpStatus,request);
    }
}
