/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.hoantran.utility.sql;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hoantran.utility.sampledata.SampleDataCreation;

/**
 * @author hoan.tran
 */
public class TestQueryBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestQueryBuilder.class);

    @Test
    public void buildCriteriaClause() {
        List<QueryCriteria> criteriaList = SampleDataCreation.createQueryCriteriaList();
        LOGGER.debug(QueryBuilder.buildCriteriaClause(criteriaList));
    }

}
