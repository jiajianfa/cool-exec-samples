package cool.exec.samples.validator.dto;

import cool.exec.samples.validator.common.CommonDTO;
import lombok.Data;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Description 用户DTO
 * @Author justin
 * @Date 2024/5/14
 */
@ToString
@Data
public class UserNestValidDTO extends CommonDTO {

    @NotNull(message = "不能为空")
    private Long id;

    @NotNull(message = "不能为空")
    private String name;

    @Valid
    private Address address;

    @ToString
    @Data
    public static class Address {
        @NotBlank(message = "不能为空")
        @Size(message = "长度范围为3~20", min = 3, max = 20)
        private String province;

        @NotNull(message = "不能为空")
        @Size(message = "长度范围为3~20", min = 3, max = 20)
        private String city;

        @NotBlank(message = "不能为空")
        @Size(message = "长度范围为3~20", min = 3, max = 20)
        private String area;

        @NotBlank(message = "不能为空")
        @Size(message = "长度范围为3~20", min = 3, max = 50)
        private String detail;
    }
}
