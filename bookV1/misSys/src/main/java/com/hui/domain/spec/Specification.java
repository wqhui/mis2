package com.hui.domain.spec;

import com.hui.domain.Member;

public interface Specification {
	boolean isSatisfiedBy(Member member);
	
}
