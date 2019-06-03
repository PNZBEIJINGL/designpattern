package com.used.specification1;

public class SpecificationFactory {

	public static ISpecification getInstance(String string) {

		if (string == null) {
			return new NullSpecification();
		}

		String rule = RuleAnalysiser.format(string);
		if (rule.contains(TagRuleSymbol.PARENTHESES_LEFT)) {
			return new ParenthesesSpecification(rule);
		}
		if (rule.contains(TagRuleSymbol.NOTEQ)) {
			return new ContainNotSpecification(rule);
		}
		if (rule.contains(TagRuleSymbol.AND)) {
			return new AndSpecification(rule);
		}
		if (rule.contains(TagRuleSymbol.EQ)) {
			return new ContainSpecification(rule);
		}
		if (rule.contains(TagRuleSymbol.LIKE)) {
			return new LikeSpecification(rule);
		}
		if (rule.contains(TagRuleSymbol.RE)) {
			return new RegexSepcification(rule);
		}

		throw new RuntimeException("no such Specification:" + string);
	}
}
