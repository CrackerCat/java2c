/*
 * This file is part of java2c. It is subject to the licence terms in the COPYRIGHT file found in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/java2c/master/COPYRIGHT. No part of compilerUser, including this file, may be copied, modified, propagated, or distributed except according to the terms contained in the COPYRIGHT file.
 * Copyright © 2014-2015 The developers of java2c. See the COPYRIGHT file in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/java2c/master/COPYRIGHT.
 */

package com.java2c.transpiler.fieldAttributesProcessors;

import com.java2c.transpiler.elementConverters.ConversionException;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.lang.model.element.Element;
import javax.lang.model.element.QualifiedNameable;
import javax.lang.model.element.VariableElement;
import java.lang.annotation.Annotation;

import static java.lang.String.format;
import static java.util.Locale.ENGLISH;

public abstract class AbstractFieldAttributesProcessor implements FieldAttributesProcessor
{
	protected AbstractFieldAttributesProcessor()
	{
	}

	protected static <A extends Annotation> boolean hasAnnotation(@NotNull final Element element, @NotNull final Class<A> annotation)
	{
		return element.getAnnotation(annotation) != null;
	}

	@NotNull
	protected final ConversionException newConversionException(@NotNull final VariableElement field, @NonNls @NotNull final String message)
	{
		return new ConversionException(format(ENGLISH, "A field '%1$s' (in '%2$s') %3$s", field.getSimpleName(), inClass(field), message));
	}

	@NotNull
	private static String inClass(@SuppressWarnings("TypeMayBeWeakened") @NotNull final VariableElement field)
	{
		// Only null if field is a PackageElement, which it isn't
		@Nullable final QualifiedNameable enclosingElement = (QualifiedNameable) field.getEnclosingElement();
		assert enclosingElement != null;

		return enclosingElement.getQualifiedName().toString();
	}
}
