/*
 * This file is part of java2c. It is subject to the licence terms in the COPYRIGHT file found in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/java2c/master/COPYRIGHT. No part of compilerUser, including this file, may be copied, modified, propagated, or distributed except according to the terms contained in the COPYRIGHT file.
 * Copyright © 2014-2015 The developers of java2c. See the COPYRIGHT file in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/java2c/master/COPYRIGHT.
 */

package com.java2c.libraries.c.stdint;

import com.java2c.model.other.NotAnObject;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings({"ClassNamePrefixedWithPackageName", "ClassNamingConvention", "UtilityClass"})
@NotAnObject
public final class stdint
{
	@NonNls @SuppressWarnings("ConstantNamingConvention") @NotNull public static final String stdint = "<stdint.h>";
	// ptrdiff, intptr, uintptr INTPTR_MIN etc WINT_MIN WCHAR_MAX INT8_C etc

	private stdint()
	{
	}
}
