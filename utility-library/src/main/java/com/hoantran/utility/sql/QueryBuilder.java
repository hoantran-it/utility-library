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

/**
 * Support building sql native query.
 * 
 * @author hoan.tran
 */
public class QueryBuilder {

    /**
     * Build criteria clause with given criteria list.
     * 
     * @param criteriaList
     */
    public static void buildCriteriaClause(List<QueryCriteria> criteriaList) {
        StringBuilder criteriaClause = new StringBuilder();
        for (QueryCriteria criteria : criteriaList) {
            appendCriteria(criteriaClause, buildCriteria(criteria));
        }
    }

    /**
     * Append criteria to criteria clause.
     * 
     * @param criteriaClause
     * @param criteria
     */
    private static void appendCriteria(StringBuilder criteriaClause, String criteria) {
        if (!criteria.isEmpty()) {
            // If criteria clause already has criteria before, add keyword AND
            // If this is the first criteria in criteria clause, bypass this step
            if (!criteriaClause.toString().isEmpty()) {
                criteriaClause.append(" AND ");
            }
            criteriaClause.append(" (" + criteria + ") ");
        }
    }

    /**
     * Build criteria with list of value. Use keyword OR to append.
     * 
     * @param criteria
     * @return
     */
    private static String buildCriteria(QueryCriteria criteria) {
        StringBuilder sql = new StringBuilder();
        String field = criteria.getField();
        String operator = criteria.getOperator();
        List<Object> valueList = criteria.getValues();
        for (Object value : valueList) {
            // If query already has criteria before
            if (!sql.toString().isEmpty()) {
                sql.append(" OR ");
            }
            // If this is the first criteria in query.
            sql.append(buildSpecificCriteria(field, operator, value));
        }
        return sql.toString();
    }

    private static String buildSpecificCriteria(String field, String operator, Object value) {
        String criteria = "";
        // criteria.append(field + " = '" + value + "'");
        switch (field) {
        default:
            // String.format("", args)
            break;
        }
        return criteria.toString();
    }
}
