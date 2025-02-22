package com.carenet.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    CONTENT_NOT_FOUND(HttpStatus.ACCEPTED, "CONTENT_NOT_FOUND"),
    CONFLICT(HttpStatus.OK, "CONFLICT"),

    USER_EXISTED(HttpStatus.OK, "USER_EXISTED"),

    // queue
    UNAUTHORIZED(HttpStatus.OK, "UNAUTHORIZED"),

    // point
    NOT_ENOUGH_POINT(HttpStatus.OK, "NOT_ENOUGH_POINT"),
    INVALID_POINT(HttpStatus.OK, "INVALID_POINT"),

    // seat
    SEAT_ALREADY_OCCUPIED(HttpStatus.OK, "SEAT_ALREADY_OCCUPIED"),

    ;

    public final HttpStatus httpStatus;
    public final String message;

}
