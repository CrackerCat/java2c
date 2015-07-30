/*
 * This file is part of java2c. It is subject to the licence terms in the COPYRIGHT file found in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/java2c/master/COPYRIGHT. No part of compilerUser, including this file, may be copied, modified, propagated, or distributed except according to the terms contained in the COPYRIGHT file.
 * Copyright © 2014-2015 The developers of java2c. See the COPYRIGHT file in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/java2c/master/COPYRIGHT.
 */

package com.java2c.libraries.c.stdarg;

import com.java2c.model.other.CCodeTemplate;
import com.java2c.model.types.CType;
import com.java2c.model.other.literal;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("ClassNamingConvention")
public final class va_list
{
	/*@
		// nothing stops the call to formatArguments happening before the call. but we could try to detect that
		hello(5, varargs(5, 6, 7));

		...

		// Check 1: At least one argument before varargs
		// Check 2: CVarArgs only used once
		// Check 3: Is at end
		public void hello(final int count, @NotNull final va_list formatArguments)
		{
			for (int index = 0; index++; index < count)
			{
				final c_int value = formatArguments.next(Class<c_int> type)
			}
			formatArguments.end();
		}


		hello(5, 5, 6, 7);

		void namespace_hello(const jint count, ...)
		{
			// Automatically inserted at top of method
			va_list formatArguments;
			va_start(formatArguments, count);

			for(jint index = 0; index++; index < count)
			{
				const c_int value = va_arg(formatArguments, c_int);
			}

			// Could be automatically inserted at bottom
			va_end(formatArguments);
		}

	 */

	@CCodeTemplate("(@values@)")
	@NotNull
	public static va_list varargs(@NotNull final CType... values)
	{
		return new va_list(values);
	}

	@NotNull private final CType[] values;
	private int index;

	@CCodeTemplate(value = "va_start(@this@, @ap.value@)", includes = stdarg.stdarg)
	private va_list(@NotNull final CType... values)
	{
		this.values = values;
		index = 0;
	}

	@SuppressWarnings("InstanceMethodNamingConvention")
	@CCodeTemplate(value = "va_arg(@this@, @type@)", includes = stdarg.stdarg)
	@NotNull
	public <T extends CType> T next(@SuppressWarnings("UnusedParameters") @NotNull @literal final Class<T> type)
	{
		@SuppressWarnings("unchecked") final T result = (T) values[index];
		index++;
		return result;
	}

//	// TODO: Not obvious how this translates
//	// Needs an auto-incrementing count, in case called more than once
//	@SuppressWarnings("InstanceMethodNamingConvention")
//	@CCodeTemplate(value = "va_copy(@XXXXXXXXXXXXXXXXXXXXXXXXXXXXX@, @this@)", includes = stdarg.stdarg)
//	@NotNull
//	public va_list va_copy()
//	{
//
//	}

	@SuppressWarnings("InstanceMethodNamingConvention")
	@CCodeTemplate(value = "va_end(@this@)", includes = stdarg.stdarg)
	public void va_end()
	{

	}
}
