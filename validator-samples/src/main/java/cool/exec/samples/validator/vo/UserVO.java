package cool.exec.samples.validator.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Description 用户信息视图类
 * @Author justin
 * @Date 2024/5/14
 */
@ToString
@Data
public class UserVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;
}
