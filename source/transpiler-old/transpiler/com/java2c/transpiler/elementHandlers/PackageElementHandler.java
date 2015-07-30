/*
 * This file is part of java2c. It is subject to the licence terms in the COPYRIGHT file found in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/java2c/master/COPYRIGHT. No part of compilerUser, including this file, may be copied, modified, propagated, or distributed except according to the terms contained in the COPYRIGHT file.
 * Copyright © 2014-2015 The developers of java2c. See the COPYRIGHT file in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/java2c/master/COPYRIGHT.
 */

package com.java2c.transpiler.elementHandlers;

import com.compilerUser.elementHandlers.ElementHandler;
import com.java2c.model.attributes.packages.PackageGccCompilationOptions;
import com.java2c.transpiler.OurAbstractSyntaxTreeInterpreter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.lang.model.element.PackageElement;
import javax.lang.model.element.QualifiedNameable;

public final class PackageElementHandler implements ElementHandler<PackageElement, OurAbstractSyntaxTreeInterpreter>
{
	@Override
	public void handle(@NotNull final OurAbstractSyntaxTreeInterpreter abstractSyntaxTreeInterpreter, @NotNull final PackageElement element)
	{
		// 1 PackageElements do not contain sub packages
		// 2 They really aren't of much use except for 'package-info.java'

		@Nullable final PackageGccCompilationOptions packageGccCompilationOptions = element.getAnnotation(PackageGccCompilationOptions.class);
		if (packageGccCompilationOptions == null)
		{
			return;
		}
		@NotNull final String[] optimisations = packageGccCompilationOptions.value();
		for (final String optimisation : optimisations)
		{
			// TODO: Do something with the optimisation - write to a file somewhere, perhaps!

			elementNameToUnderscoreName(element);
		}
	}





	@NotNull
	public static String elementNameToUnderscoreName(@NotNull final QualifiedNameable element)
	{
		return element.getQualifiedName().toString().replace('.', '_');
	}
}
