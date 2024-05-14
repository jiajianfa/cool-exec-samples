package cool.exec.samples.validator.dto;

import cool.exec.samples.validator.common.CommonDTO;
import lombok.Data;
import lombok.ToString;

/**
 * @Description 用户DTO
 * @Author justin
 * @Date 2024/5/14
 */
@ToString
@Data
public class UserDTO extends CommonDTO {

    private Long id;

    private String name;
}
