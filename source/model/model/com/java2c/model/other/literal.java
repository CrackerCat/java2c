/*
 * This file is part of java2c. It is subject to the licence terms in the COPYRIGHT file found in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/java2c/master/COPYRIGHT. No part of compilerUser, including this file, may be copied, modified, propagated, or distributed except according to the terms contained in the COPYRIGHT file.
 * Copyright © 2014-2015 The developers of java2c. See the COPYRIGHT file in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/java2c/master/COPYRIGHT.
 */

package com.java2c.model.other;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/*
    Currently being used for a static constructor method on some classes (eg int16_t) but NOT ALL - only where there is a #define constructor we can wrap

    Also being used in the broken va_list logic


    Documents that a value MUST be a literal

 */
@SuppressWarnings("AnnotationNamingConvention")
@Target(PARAMETER)
@Retention(RUNTIME)
public @interface literal
{
}
