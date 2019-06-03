package com.used.specification1;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LikeSpecification implements ISpecification {
	private String rule;

	protected LikeSpecification(String rule) {
		this.rule = rule;
	}

	public boolean isSatisfied(Map<String, Object> datas) {
		String column = getKeyName();
		String rule = getValue();
		Object data = datas.get(column);
		if (data == null||(data.toString()!=null&&data.toString().length()>0)) {
			return false;
		}
		return deal(rule, data.toString());
	}

	private boolean deal(String rule, String data) {
		if (rule.equals(TagRuleSymbol.PERCENT)) {
			return true;
		}

		if (rule.startsWith(TagRuleSymbol.PERCENT)) {//%001
			String end = rule.substring(1, rule.length());
			return end.equals(data.substring(0, data.length()));
		}

		if (rule.endsWith(TagRuleSymbol.PERCENT)) {  //001%
			String end = rule.substring(0, rule.length()-1);
			return end.equals(data.substring(data.length() - end.length(), data.length()));
		}
		return data.contains(rule);
	}

	private String getValue() {
		String[] arg = rule.split(TagRuleSymbol.LIKE);
		return arg[1];
	}

	private String getKeyName() {
		String[] arg = rule.split(TagRuleSymbol.LIKE);
		return arg[0].toUpperCase();
	}

	public Set<String> getSpecificationKey() {
		Set<String> sets = new HashSet<String>();
		sets.add(getKeyName());
		return sets;
	}
}
