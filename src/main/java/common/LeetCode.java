package common;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

/**
 * @author RakhmedovRS
 * @created 10-Mar-20
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {TYPE})
public @interface LeetCode
{
	int id();

	String name() default "";

	String url() default "https://leetcode.com/problemset/all/";

	Difficulty difficulty() default Difficulty.UNDEFINED;

	boolean premium() default false;
}
