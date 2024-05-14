package cool.exec.samples.validator.user.controller;

import cool.exec.samples.validator.common.Result;
import cool.exec.samples.validator.dto.*;
import cool.exec.samples.validator.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import java.util.Set;


/**
 * @Description 用户模块restful接口
 * @Author justin
 * @Date 2024/5/14
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private javax.validation.Validator globalValidator;

    @PostMapping("/create")
    public Result create(@RequestBody UserDTO dto) {

        if (dto.getId() == null || dto.getName() == null) {
            return Result.error(false, HttpStatus.BAD_REQUEST.value(), "请求参数错误");
        }

        UserVO vo = new UserVO();
        BeanUtils.copyProperties(dto, vo);

        Result result = Result.ok().data(vo);
        return result;
    }

    @PostMapping("/create2")
    public Result createValid(@Validated @RequestBody UserValidDTO dto) {
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(dto, vo);
        Result result = Result.ok().data(vo);
        return result;
    }

    @PostMapping("/createGrp")
    public Result createGrpValid(@Validated(UserGroupValidDTO.Create.class) @RequestBody UserGroupValidDTO dto) {
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(dto, vo);
        Result result = Result.ok().data(vo);
        return result;
    }

    @PostMapping("/updateGrp")
    public Result updateGrpValid(@RequestBody @Validated(UserGroupValidDTO.Update.class) UserGroupValidDTO dto) {
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(dto, vo);
        Result result = Result.ok().data(vo);
        return result;
    }

    @PostMapping("/createNest")
    public Result createNestValid(@RequestBody @Validated UserNestValidDTO dto) {
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(dto, vo);
        Result result = Result.ok().data(vo);
        return result;
    }

    @PostMapping("/createCustomize")
    public Result createCustomizeValid(@Validated @RequestBody UserCustomizeValidDTO dto) {
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(dto, vo);
        Result result = Result.ok().data(vo);
        return result;
    }

    @PostMapping("/validByCoding")
    public Result validByCoding(@RequestBody UserValidDTO dto) {
        Set<ConstraintViolation<UserValidDTO>> validate = globalValidator.validate(dto);
        // 如果校验通过，validate为空；否则，validate包含未校验通过项
        if (validate.isEmpty()) {
            // 校验通过，才会执行业务逻辑处理

        } else {
            for (ConstraintViolation<UserValidDTO> userDTOConstraintViolation : validate) {
                // 校验失败，做其它逻辑
                log.info(userDTOConstraintViolation.getMessage());
            }
        }
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(dto, vo);
        Result result = Result.ok().data(vo);
        return result;
    }

}