package com.dummiesmind.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
 * This annotation is used for objects to be declared as XML
 * Object. It has a retention policy of Runtime.
 * {@link Retention} determines the scope of the annotation
 * so {@link RetentionPolicy# RUNTIME} says that
 * annotation will retain till Runtime. {@link Target}
 * determines the types on which this will be applicable.
 * {@link ElementType#Type}is an <b>enum</b> which has about
 * 8 types where annotations can be applied.Type is Class.
 * {@link Documented} that annotations with a type are to
 * be documented by javadoc and similar tools by default.
 * At run time the value field will be used as a header tag
 * name for {@link XMLTag}. This is a sample annotation
 * which can be extended to create a Object to XML converter
 * using annotations.
 *
 * @author Pawan Chopra
 *
 */
 @Documented@Retention(RetentionPolicy.RUNTIME)
 @Target(ElementType.TYPE)
 public @interface XMLObject {
 /*
  * This is a field but acts as a function
  * default value is header. It returns an array of
  * String values. You can have multiple field or you can say
  * methods like this.
  * @return {@link String[]}
  */
   public String[] value() default "header";
}