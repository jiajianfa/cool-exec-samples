package cool.exec.samples.validator.common;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Description 用户身份证号码校验
 * @Author justin
 * @Date 2024/5/14
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {IdCardNoValidator.class})
public @interface IdCardNo {

    /**
     * 默认错误消息
     **/
    String message() default "id格式错误";

    /**
     * 分组
     **/
    Class<?>[] groups() default {};

    /**
     * 负载
     **/
    Class<? extends Payload>[] payload() default {};
}