/*
 * This file is part of java2c. It is subject to the licence terms in the COPYRIGHT file found in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/java2c/master/COPYRIGHT. No part of compilerUser, including this file, may be copied, modified, propagated, or distributed except according to the terms contained in the COPYRIGHT file.
 * Copyright © 2014-2015 The developers of java2c. See the COPYRIGHT file in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/java2c/master/COPYRIGHT.
 */

package com.java2c.model.types.scalars;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/*
    A Scalar is used to define that a class represents a scalar value, such as c_signed_char

    The value is the C type (eg 'signed char')

    A Scalar has a single constructor which takes a Java long. Thus

    c_signed_char x = new c_signed_char(100L)

        is transformed into

    signed char x = 100

    (with appropriate conversion of 100L)

    Scalars are implicitly @Uncastable
 */

@Target(TYPE)
@Retention(RUNTIME)
public @interface Scalar
{
	@NotNull String value();

	@NotNull String[] includes() default {};

	boolean signed() default false;

	boolean typedef() default false;
}
