package cool.exec.samples.validator.dto;

import cool.exec.samples.validator.common.CommonDTO;
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
public class UserValidDTO extends CommonDTO {

    @NotNull(message = "不能为空")
    private Long id;

    @NotNull(message = "不能为空")
    private String name;
}
