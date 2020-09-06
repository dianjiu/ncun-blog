package cn.org.dianjiu.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessException extends RuntimeException {

    private String code;
    private String message;

    public BusinessException() {
    }

    public BusinessException(String code, String message) {
        this.code = code;
        this.message = message;
    }
}

