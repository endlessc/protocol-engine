package org.apache.io.protocol.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annocation marked on a property of a JavaBean which can
 * convert a number to <code>byte[]</code>
 * or <code>byte[]</code> to a number.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Number {
    /**
     * The formation of number convertion.
     * @return The formation of convertion, default is normal.
     * true: use Binary-Coded Decimal‎ to convert.
     * false: user normal way to convert.
     */
    boolean isBCDCode() default false;

    /**
     * The type of number in java is both signed, while we expect an
     * unsigned value, we must user a <code>Long</code> type to represent
     * a 32 bit unsigned value.
     * @return The number sign value.
     */
    Sign sign() default Sign.Unsigned;

    /**
     * The bit width of the number.
     * Fox example:
     * <code>Byte</code>: 8 bit
     * <code>Short</code>: 16 bit
     * <code>Integer</code>: 32 bit
     * <code>Long</code>: 64 bit
     * @return The bit width of number value.
     */
    int width() default 32;

    /**
     * The offset of a number.
     * when we want to send a number with value -50,we can plus 100
     * to avoid negative number transmission.
     * @return The offset of a number value.
     */
    int offset() default 0;

    /**
     * The Network byte order.
     * @return The Network byte order.
     */
    ByteOrder order() default ByteOrder.SmallEndian;

    /**
     * The user defined special encode convertion function in the JavaBean.
     * @return The encode convertion function name.
     */
    String encoder() default "";

    /**
     * The user defined special decode convertion function in the JavaBean.
     * @return The decode convertion function name.
     */
    String decoder() default "";

    /**
     * The number array length. user define themself.
     * @return The number array length. default value is 1.
     */
    String length() default "1";
}
