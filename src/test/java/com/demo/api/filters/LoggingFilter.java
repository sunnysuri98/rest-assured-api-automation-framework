package com.demo.api.filters;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

import java.util.regex.Pattern;

public class LoggingFilter implements Filter {

    private static final Logger logger = LogManager.getLogger(LoggingFilter.class);

    private static final Pattern SENSITIVE_PATTERN = Pattern.compile(
            "(?i)(token|access_token|username|password|authorization)\"?\\s*[:=]\\s*\"?(Bearer\\s+)?([^\",\\s}]+)\"?");

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
            FilterableResponseSpecification responseSpec,
            FilterContext ctx) {

        logRequest(requestSpec);

        Response response = ctx.next(requestSpec, responseSpec);

        logResponse(response);

        return response;
    }

    private void logRequest(FilterableRequestSpecification requestSpec) {
        logger.info("Base URI: {}", requestSpec.getBaseUri());
        logger.info("Request Headers: {}", maskSensitiveData(requestSpec.getHeaders().toString()));
        if (requestSpec.getBody() != null) {
            logger.info("Request Payload: {}", maskSensitiveData(requestSpec.getBody().toString()));
        }
    }

    private void logResponse(Response response) {
        logger.info("Status Code: {}", response.getStatusCode());
        logger.info("Response Headers: {}", maskSensitiveData(response.getHeaders().toString()));
        if (response.getBody() != null) {
            logger.info("Response Payload: {}", maskSensitiveData(response.getBody().asPrettyString()));
        }
    }

    private String maskSensitiveData(String text) {
        if (text == null)
            return null;
        return SENSITIVE_PATTERN.matcher(text).replaceAll("$1=****");
    }
}
