package cool.exec.samples.validator.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @Description
 * @Author justin
 * @Date 2024/5/14
 */
@Component
public class CommonConf {

    /**
     * Spring Validation默认会校验完所有字段，然后才抛出异常。
     * 可以通过一些简单的配置，开启Fali Fast模式，一旦校验失败就立即返回。
     * @return
     */
    @Bean
    public Validator validator() {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                // 快速失败模式
                .failFast(true)
                .buildValidatorFactory();
        return validatorFactory.getValidator();
    }
}
