package org.dojo.ezspring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.NoSuchElementException;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(org.thymeleaf.exceptions.TemplateInputException.class)
    public ResponseEntity<String> handler() {
        return ResponseEntity.status(400).body("특정 에러시 발동");
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<String> noResourceHandler() {
        return ResponseEntity.status(404).body("주소 똑바로 입력해라");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handler2() {
        return ResponseEntity.status(500).body("모든 에러시 발동");
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> noSuchElementHandler() {
        return ResponseEntity.status(404).body("해당 자원이 존재하지 않습니다.");
    }
}
