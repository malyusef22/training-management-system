package com.maram.training.validation;
import jakarta.validation.Constraint; import jakarta.validation.Payload; import java.lang.annotation.*;
@Target({ElementType.FIELD,ElementType.PARAMETER}) @Retention(RetentionPolicy.RUNTIME) @Constraint(validatedBy=EmployeeNumberValidator.class) @Documented
public @interface ValidEmployeeNumber { String message() default "Employee number must look like TR-1001"; Class<?>[] groups() default {}; Class<? extends Payload>[] payload() default {}; }
