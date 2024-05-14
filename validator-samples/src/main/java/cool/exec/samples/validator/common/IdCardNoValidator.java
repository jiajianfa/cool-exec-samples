package cool.exec.samples.validator.common;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @Description
 * @Author justin
 * @Date 2024/5/14
 */
public class IdCardNoValidator implements ConstraintValidator<IdCardNo, String> {

    /**
     * 中国大陆的身份证号码通常由18位数字组成，其中最后一位可能是数字或字母X。
     * 前17位是数字，最后一位是校验码。
     * 身份证号码的第7到第14位表示出生年月日，第17位表示性别（奇数为男性，偶数为女性）
     *
     * 这个正则表达式的组成部分说明如下:
     * ^[1-9]：第一位数字不能为0。
     * \\d{5}：接下来的5位是地址码。
     * (18|19|20)：年份的前两位数必须是18, 19或20。
     * \\d{2}：年份的后两位数。
     * (0[1-9]|1[0-2])：月份，范围是01到12。
     * (0[1-9]|[12]\\d|3[01])：日期，范围是01到31。
     * \\d{3}：身份证号码中的顺序码，表示在同一地址码和出生日期下分配的序号。
     * [0-9Xx]：最后一位是校验码，可以是数字或大写或小写的X。
     * $：正则表达式的结束。
     */
    private static final String regex = "^[1-9]\\d{5}(18|19|20)\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])\\d{3}[0-9Xx]$";

    private static final Pattern PATTERN = Pattern.compile(regex);


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null) {
            Matcher matcher = PATTERN.matcher(value);
            return matcher.find();
        }
        return true;
    }
}
