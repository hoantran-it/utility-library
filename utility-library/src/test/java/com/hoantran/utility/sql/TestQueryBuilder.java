/**
 * This file Copyright (c) 2016 Magnolia International
 * Ltd.  (http://www.magnolia-cms.com). All rights reserved.
 *
 *
 * This program and the accompanying materials are made
 * available under the terms of the Magnolia Network Agreement
 * which accompanies this distribution, and is available at
 * http://www.magnolia-cms.com/mna.html
 *
 * Any modifications to this file must keep this entire header
 * intact.
 *
 */
package com.hoantran.utility.sql;

import java.util.List;

import org.junit.Test;

import com.hoantran.utility.sampledata.SampleDataCreation;

/**
 * @author hoan.tran
 */
public class TestQueryBuilder {

    @Test
    public void buildCriteriaClause() {
        List<QueryCriteria> criteriaList = SampleDataCreation.createQueryCriteriaList();
        System.out.println(QueryBuilder.buildCriteriaClause(criteriaList));
    }

}
