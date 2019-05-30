package com.used.specification;

public class EqualSpecification2 extends CompositeSpecification2 {
    private String rule;
    private String code;

    public EqualSpecification2(String rule, String code) {

        this.code = code;
        this.rule = rule;
    }

    public boolean isSatisfiedBy() {

        return rule.equals(code);
    }
}
