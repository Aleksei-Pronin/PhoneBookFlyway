package ru.academits.phonebookflyway.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.academits.phonebookflyway.dto.BaseResponse;
import ru.academits.phonebookflyway.exception.ContactException;

import java.util.Locale;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class ContactExceptionHandler {
    private final MessageSource messageSource;

    @ExceptionHandler(ContactException.class)
    public BaseResponse handleContactException(ContactException e) {
        String message = messageSource.getMessage(e.getMessage(), null, Locale.getDefault());
        log.warn("Contact operation failed: {}", message);
        return BaseResponse.error(message);
    }
}