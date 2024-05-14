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
public class UserGroupValidDTO extends CommonDTO {

    @NotNull(message = "不能为空",groups = {Update.class})
    private Long id;

    @NotNull(message = "不能为空",groups = {Create.class,Update.class})
    private String name;

    public interface Update{}

    public interface  Create{}
}
