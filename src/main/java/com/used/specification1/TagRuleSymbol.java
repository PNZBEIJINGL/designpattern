package com.used.specification1;

public class TagRuleSymbol {
	/**
	 * 优先级括号，正则中可能有（），所以用<>替换
	 */
	public static final String PARENTHESES_LEFT = "<";

	public static final String PARENTHESES_RIGHT = ">";
	/**
	 * 条件等 例如：PRODCT_CODE=[A,B,C] 等于ABC
	 */
	public static final String EQ = "=";

	/**
	 * 条件不等 例如：PRODCT_CODE!=[A,B,C] 不等于ABC
	 */
	public static final String NOTEQ = "!=";

	/**
	 * 条件且
	 */
	public static final String AND = " AND ";

	/**
	 * 条件或
	 */
	public static final String OR = " OR ";

	/**
	 * LIKE 例如：123% 以123开始 例如：%123以123结尾 例如：123 包含123
	 */
	public static final String LIKE = " LIKE ";

	/**
	 * 正则，不支持正则中包含"<" 例如：PRODCT_CODE-->[0-9]
	 */
	public static final String RE = "-->";

	//// OTHER
	public static final String COMMA = ",";
	public static final String PERCENT = "%";
}
