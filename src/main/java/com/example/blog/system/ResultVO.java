package com.example.blog.system;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @param <T>
 */
public class ResultVO<T> implements Serializable {

    private Integer code;

    private String message;

    private T data;

    public static<T> ResultVO<T> success(Integer code, String message, T data) {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setData(data);
        resultVO.setCode(code == null ? HttpStatus.OK.value() : code);
        resultVO.setMessage(message == null ? HttpStatus.OK.getReasonPhrase() : message);
        return resultVO;
    }

    public static <T> ResultVO<T> success(T data) {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setData(data);
        resultVO.setCode(HttpStatus.OK.value());
        resultVO.setMessage(HttpStatus.OK.getReasonPhrase());
        return resultVO;
    }

    public static ResultVO<String> success() {
        ResultVO<String> resultVO = new ResultVO<>();
        resultVO.setCode(HttpStatus.OK.value());
        resultVO.setMessage(HttpStatus.OK.getReasonPhrase());
        return resultVO;
    }

    public static ResultVO<String> error(Integer code, String message) {
        ResultVO<String> resultVO = new ResultVO<>();
        resultVO.setCode(code == null ? HttpStatus.INTERNAL_SERVER_ERROR.value() : code);
        resultVO.setMessage(message == null ? HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase() : message);
        return resultVO;
    }

    public static ResultVO<String> error(HttpStatus httpStatus) {
        ResultVO<String> resultVO = new ResultVO<>();
        resultVO.setCode(httpStatus.value());
        resultVO.setMessage(httpStatus.getReasonPhrase());
        return resultVO;
    }

    public static ResultVO<String> error() {
        ResultVO<String> resultVO = new ResultVO<>();
        resultVO.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        resultVO.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        return resultVO;
    }

    private ResultVO() {
    }

    public Integer getCode() {
        return code;
    }

    private void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    private void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResultVO<?> resultVO = (ResultVO<?>) o;
        return code.equals(resultVO.code) &&
                message.equals(resultVO.message) &&
                data.equals(resultVO.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message, data);
    }

    @Override
    public String toString() {
        return "ResultVO{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
