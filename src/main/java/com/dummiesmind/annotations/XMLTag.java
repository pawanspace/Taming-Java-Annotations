package com.dummiesmind.annotations;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 *
 * This annotation is used for fields to be declared
 * as XML tags under {@link XMLObject}.
 * It has a retention policy of Runtime.
 *
 *
 * @author Pawan Chopra
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface XMLTag {
 /*
  *
  * @return {@link String[]}
  */
  public String[] value() default "";
}