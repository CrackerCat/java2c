package com.java2c.libraries.c.stdint;

import com.java2c.model.types.scalars.*;
import com.java2c.model.other.CCodeTemplate;
import com.java2c.model.other.literal;
import org.jetbrains.annotations.NotNull;

import static com.java2c.model.other.CCodeTemplate.Scalar;
import static com.java2c.libraries.c.stdint.stdint.stdint;

@SuppressWarnings("ClassNamingConvention")
@Scalar(value = "int16_t", includes = stdint)
public final class int16_t extends AbstractScalar<int16_t> implements Equality<int16_t>, Comparison<int16_t>, SignedMathematics<int16_t>, BooleanAlgebra<int16_t>
{
	@CCodeTemplate(value = "INT16_MAX", includes = stdint)
	public static final int16_t INT16_MAX = new int16_t(32767L);

	@CCodeTemplate(value = "INT16_MIN", includes = stdint)
	public static final int16_t INT16_MIN = new int16_t(-32768L);

	@CCodeTemplate(value = "INT16_C(value)", includes = stdint)
	public static int16_t literal(@literal final long value)
	{
		return new int16_t(value);
	}

	@CCodeTemplate(Scalar)
	public int16_t(final long value)
	{
		super(value);
	}

	@NotNull
	@Override
	protected int16_t constructT(@SuppressWarnings("ParameterHidesMemberVariable") final long value)
	{
		return new int16_t(value);
	}

	@SuppressWarnings("CovariantEquals")
	@Override
	public boolean isEqual(@NotNull final int16_t right)
	{
		return super.isEqual(right);
	}

	@Override
	public boolean isNotEqual(@NotNull final int16_t right)
	{
		return super.isNotEqual(right);
	}

	@Override
	public boolean isGreaterThan(@NotNull final int16_t right)
	{
		return super.isGreaterThan(right);
	}

	@Override
	public boolean isLessThan(@NotNull final int16_t right)
	{
		return super.isLessThan(right);
	}

	@Override
	public boolean isGreaterThanOrEqualTo(@NotNull final int16_t right)
	{
		return super.isGreaterThanOrEqualTo(right);
	}

	@Override
	public boolean isLessThanOrEqualTo(@NotNull final int16_t right)
	{
		return super.isLessThanOrEqualTo(right);
	}

	@NotNull
	@Override
	public int16_t add(@NotNull final int16_t right)
	{
		return super.add(right);
	}

	@NotNull
	@Override
	public int16_t subtract(@NotNull final int16_t right)
	{
		return super.subtract(right);
	}

	@NotNull
	@Override
	public int16_t multiply(@NotNull final int16_t right)
	{
		return super.multiply(right);
	}

	@NotNull
	@Override
	public int16_t divide(@NotNull final int16_t right)
	{
		return super.divide(right);
	}

	@NotNull
	@Override
	public int16_t modulus(@NotNull final int16_t right)
	{
		return super.modulus(right);
	}

	@Override
	@NotNull
	public int16_t negate()
	{
		return negateT();
	}

	@Override
	public int16_t and(@NotNull final int16_t right)
	{
		return super.and(right);
	}

	@Override
	public int16_t or(@NotNull final int16_t right)
	{
		return super.or(right);
	}
}
