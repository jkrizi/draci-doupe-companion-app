package net.homecredit.trainee.drd.configuration;

import jdk.nashorn.internal.ir.annotations.Immutable;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(ItemModuleConfiguration.class)
@Configuration
public @interface EnableItemModule {
}
