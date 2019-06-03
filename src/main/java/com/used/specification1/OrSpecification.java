package com.used.specification1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrSpecification implements ISpecification {

	private List<ISpecification> specifications;

	public OrSpecification(List<ISpecification> specifications) {
		this.specifications = specifications;
	}

	public OrSpecification(String rule) {
		specifications = new ArrayList<ISpecification>();
		String[] args = rule.split(TagRuleSymbol.AND);
		for (String str : args) {
			specifications.add(SpecificationFactory.getInstance(str));
		}
	}

	public boolean isSatisfied(Map<String, Object> map) {
		for (ISpecification specification : specifications) {
			if (specification.isSatisfied(map)) {
				return true;
			}
		}
		return false;
	}

	public Set<String> getSpecificationKey() {
		Set<String> keys = new HashSet<String>();
		for (ISpecification specification : specifications) {
			keys.addAll(specification.getSpecificationKey());
		}
		return keys;
	}

}
