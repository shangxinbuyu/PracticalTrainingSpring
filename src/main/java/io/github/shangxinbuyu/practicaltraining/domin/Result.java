package io.github.shangxinbuyu.practicaltraining.domin;

import lombok.Data;

@Data
public class Result<T> {
    private int code;
    private String msg;
    private T data;


    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.code = 200;
        return result;
    }
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<T>();
        result.code = 200;
        result.data = data;
        return result;
    }
    public static <T> Result<T> result(String msg) {
        Result<T> result = new Result<T>();
        result.code = -1;
        result.msg = msg;
        return result;
    }
}
