package com.hui.domain.spec;

import com.hui.domain.Member;

public class HasReachMaxSpecification implements Specification {
    @Override
    public boolean isSatisfiedBy(Member member) {
        return member.getLoans().stream().filter(loan -> loan.hasNotBeenReturned()).count()<2;
    }
}
