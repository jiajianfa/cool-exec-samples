package cool.exec.samples.validator.config;

import cool.exec.samples.validator.common.GlobalException;
import cool.exec.samples.validator.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * 全局异常处理类。
 * 使用 slf4j 保存日志信息。
 * 此处使用了 统一结果处理 类 Result 用于包装异常信息。
 *
 * @Author justin
 * @Date 2024/5/14
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception e) {
        // logger.error(e.getMessage(), e);
        return Result.error().message("系统异常");
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ExceptionHandler(HttpMessageConversionException.class)
    public Result handlerParamException(HttpMessageConversionException e) {
        // logger.error(e.getMessage(), e);
        return Result.error(false, HttpStatus.BAD_REQUEST.value(), "请求参数格式错误");
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder sb = new StringBuilder("校验失败:");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getField()).append("：").append(fieldError.getDefaultMessage()).append(", ");
        }
        String msg = sb.substring(0, sb.length() - 2);
        return Result.error(false, HttpStatus.BAD_REQUEST.value(), msg);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result handleConstraintViolationException(ConstraintViolationException ex) {
        return Result.error(false, HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ExceptionHandler(GlobalException.class)
    public Result handlerGlobalException(GlobalException e) {
        // logger.error(e.getMessage(), e);
        return Result.error().message(e.getMessage()).code(e.getCode());
    }
}
