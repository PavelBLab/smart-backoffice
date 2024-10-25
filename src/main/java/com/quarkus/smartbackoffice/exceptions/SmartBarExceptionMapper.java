package com.quarkus.smartbackoffice.exceptions;

import io.quarkus.security.UnauthorizedException;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.hibernate.exception.ConstraintViolationException;

import java.util.HashMap;
import java.util.Map;

@Provider
public class SmartBarExceptionMapper implements ExceptionMapper<Exception> {

    private static final Map<Class<? extends Exception>, Response.Status> EXCEPTION_STATUS_MAP = new HashMap<>();

    static {
        // Map specific exception types to HTTP response statuses
        EXCEPTION_STATUS_MAP.put(ResourceNotFoundException.class, Response.Status.NOT_FOUND);
        EXCEPTION_STATUS_MAP.put(BadRequestException.class, Response.Status.BAD_REQUEST);
        EXCEPTION_STATUS_MAP.put(UnauthorizedException.class, Response.Status.UNAUTHORIZED);
        EXCEPTION_STATUS_MAP.put(ConstraintViolationException.class, Response.Status.CONFLICT);
        // Add more mappings as needed
    }

    @Override
    public Response toResponse(Exception exception) {
        // Determine the response status based on the exception type
        Response.Status status = EXCEPTION_STATUS_MAP.getOrDefault(exception.getClass(), Response.Status.INTERNAL_SERVER_ERROR);

        // Set the error code based on the determined status
        String errorCode = status == Response.Status.INTERNAL_SERVER_ERROR ? "INTERNAL_SERVER_ERROR" : status.name();

        // Return the response with the appropriate error details
        return Response.status(status)
                .entity(new ErrorResponse(errorCode, exception.getMessage()))
                .build();
    }

    // Simple class to represent the error response body
    public static class ErrorResponse {
        private String code;
        private String message;

        public ErrorResponse(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }
}
