package cool.exec.samples.validator.dto;

import cool.exec.samples.validator.common.CommonDTO;
import cool.exec.samples.validator.common.IdCardNo;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @Description 用户DTO
 * @Author justin
 * @Date 2024/5/14
 */
@ToString
@Data
public class UserCustomizeValidDTO extends CommonDTO {

    @NotNull(message = "不能为空")
    private Long id;

    @NotNull(message = "不能为空")
    private String name;

    @IdCardNo(message = "身份证号码格式不正确")
    private String idCardNo;
}
