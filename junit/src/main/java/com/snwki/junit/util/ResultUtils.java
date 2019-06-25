package com.snwki.junit.util;


import com.snwki.junit.model.Result;

public class ResultUtils {

    private ResultUtils() {

    }

    public static Result successResult() {
        return successResult("");
    }

    public static Result successResult(Object data) {
        return result(0, "", data);
    }

    public static Result successResult(String message, Object data) {
        return result(0, message, data);
    }

    public static Result failResult(int code, String message) {
        return result(code, message, "");
    }

    public static Result result(int code, String message, Object data) {
        Result result = new Result();
        result.setMessage(message);
        result.setData(data);
        result.setCode(code);
        return result;
    }

}
