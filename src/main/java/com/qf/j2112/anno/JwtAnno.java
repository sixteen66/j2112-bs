package com.qf.j2112.anno;



import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JwtAnno {
    public String name() default "";
}
