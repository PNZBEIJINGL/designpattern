package com.used.specification1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author liuyong
 *
 *
 */
public class ParenthesesSpecification implements ISpecification {

	private String rule;

	protected ParenthesesSpecification(String rule) {
		this.rule = rule;
	}

	public boolean isSatisfied(Map<String, Object> data) {
		RuleDTO ruleDTO = RuleAnalysiser.analysisParentheses(rule);
		if (ruleDTO.getRule().contains(TagRuleSymbol.AND)) {
			List<ISpecification> list = new ArrayList<ISpecification>();
			for (String key : ruleDTO.getMap().keySet()) {
				String rule = ruleDTO.getMap().get(key);
				list.add(SpecificationFactory.getInstance(rule));
			}

			AndSpecification as = new AndSpecification(list);
			return as.isSatisfied(data);
		}
		if (ruleDTO.getRule().contains(TagRuleSymbol.OR)) {
			List<ISpecification> list = new ArrayList<ISpecification>();
			for (String key : ruleDTO.getMap().keySet()) {
				String rule = ruleDTO.getMap().get(key);
				list.add(SpecificationFactory.getInstance(rule));
			}
			OrSpecification os = new OrSpecification(list);
			return os.isSatisfied(data);
		}

		throw new RuntimeException("Parentheses error:" + rule);
	}

	public Set<String> getSpecificationKey() {
		RuleDTO ruleDTO = RuleAnalysiser.analysisParentheses(rule);
		if (ruleDTO.getRule().contains(TagRuleSymbol.AND)) {
			List<ISpecification> list = new ArrayList<ISpecification>();
			for (String key : ruleDTO.getMap().keySet()) {
				String rule = ruleDTO.getMap().get(key);
				list.add(SpecificationFactory.getInstance(rule));
			}

			AndSpecification as = new AndSpecification(list);
			return as.getSpecificationKey();
		}
		if (ruleDTO.getRule().contains(TagRuleSymbol.OR)) {
			List<ISpecification> list = new ArrayList<ISpecification>();
			for (String key : ruleDTO.getMap().keySet()) {
				String rule = ruleDTO.getMap().get(key);
				list.add(SpecificationFactory.getInstance(rule));
			}
			OrSpecification os = new OrSpecification(list);
			return os.getSpecificationKey();
		}

		throw new RuntimeException("Parentheses error:" + rule);
	}

}
