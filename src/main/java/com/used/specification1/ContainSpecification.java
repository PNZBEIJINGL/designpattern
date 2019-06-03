package com.used.specification1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContainSpecification implements ISpecification {
	private String rule;

	protected ContainSpecification(String rule) {
		this.rule = rule;
	}

	public boolean isSatisfied(Map<String, Object> map) {
		String column = getKeyName();
		List<String> values = getValue();
		Object data=map.get(column);
		if(data!=null){
			return values.contains(data.toString());			
		}
		return false;
	}

	private List<String> getValue() {
		String[] args = rule.split(TagRuleSymbol.EQ);
		String valuse = args[1].substring(1, args[1].length() - 1);

		List<String> list = new ArrayList<String>();
		for (String string : valuse.split(TagRuleSymbol.COMMA)) {
			list.add(string);
		}
		return list;
	}

	private String getKeyName() {
		String[] arg = rule.split(TagRuleSymbol.EQ);
		return new String(arg[0]).toUpperCase();
	}

	public Set<String> getSpecificationKey() {
		Set<String> sets = new HashSet<String>();
		sets.add(getKeyName());
		return sets;
	}
}
