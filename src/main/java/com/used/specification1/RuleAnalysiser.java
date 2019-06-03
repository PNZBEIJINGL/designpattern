package com.used.specification1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuleAnalysiser {

	public static RuleDTO analysisParentheses(String ruleStr) {
		String rule = ruleStr;

		char[] chars = rule.toCharArray();
		int num1 = 0;
		int num2 = 0;
		StringBuffer sbf = new StringBuffer();
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '<') {
				num1++;
			}
			if (num1 > 0) {
				sbf.append(chars[i]);
			}
			if (chars[i] == '>') {
				num2++;
			}
			if (num1 != 0 && (num1 == num2)) {
				list.add(sbf.toString());
				sbf = new StringBuffer();
				num1 = 0;
				num2 = 0;
			}
		}
		Map<String, String> valueMap = new HashMap<String, String>();
		for (int i = 0; i < list.size(); i++) {
			String key = "[$" + i + "]";
			valueMap.put(key, list.get(i));
			rule = rule.replace(list.get(i), key);
		}
		RuleDTO ruleDTO = new RuleDTO();
		ruleDTO.setRule(rule);
		ruleDTO.setMap(valueMap);
		return ruleDTO;

	}

	public static String format(String rule) {
		if (rule != null && rule.startsWith(TagRuleSymbol.PARENTHESES_LEFT)) {
			int index = rule.indexOf(TagRuleSymbol.PARENTHESES_RIGHT);
			if (index + 1 == rule.length()) {
				return rule.substring(1, rule.length() - 1);
			}
		}

		return rule;

	}
}
