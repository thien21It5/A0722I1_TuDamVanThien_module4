package demo.config;

import demo.formatter.DateFomatter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class config implements WebMvcConfigurer, ApplicationContextAware {
    ApplicationContext context;
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFomatter());
//        registry.addConverter(new DateConverter());
        registry.addFormatter(new EmployeeFormatter(context.getBean(EmployeeService.class)));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
