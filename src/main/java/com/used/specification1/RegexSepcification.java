package com.used.specification1;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSepcification implements ISpecification {

	private String rule;

	protected RegexSepcification(String rule) {
		this.rule = rule;
	}

	public boolean isSatisfied(Map<String, Object> datas) {
		String column = getKeyName();
		String value = getValue();
		Object data = datas.get(column);
		if (data == null) {
			return false;
		} else {
			Pattern pattern = Pattern.compile(value);
			Matcher matcher = pattern.matcher(datas.get(column).toString());
			return matcher.matches();
		}
	}

	private String getValue() {
		String[] arg = rule.split(TagRuleSymbol.RE);
		return arg[1];
	}

	private String getKeyName() {
		String[] arg = rule.split(TagRuleSymbol.RE);
		return arg[0].toUpperCase();
	}

	public Set<String> getSpecificationKey() {
		Set<String> sets = new HashSet<String>();
		sets.add(getKeyName());
		return sets;
	}

}
