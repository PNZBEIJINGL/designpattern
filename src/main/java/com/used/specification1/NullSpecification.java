package com.used.specification1;

import java.util.Map;
import java.util.Set;

public class NullSpecification implements ISpecification {

	public boolean isSatisfied(Map<String, Object> data) {
		return true;
	}

	public Set<String> getSpecificationKey() {
		return null;
	}

}
