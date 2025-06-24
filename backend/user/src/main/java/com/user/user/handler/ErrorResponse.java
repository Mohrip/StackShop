package main.java.com.user.user.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {

}