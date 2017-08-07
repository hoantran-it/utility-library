/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
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
     * @return
     */
    public static String buildCriteriaClause(List<QueryCriteria> criteriaList) {
        StringBuilder criteriaClause = new StringBuilder();
        for (QueryCriteria criteria : criteriaList) {
            appendCriteria(criteriaClause, buildCriteria(criteria));
        }
        return criteriaClause.toString();
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
        List<?> valueList = criteria.getValues();
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

    /**
     * This method will be overridden to specify the way to write filter query.
     * 
     * @param field
     * @param operator
     * @param value
     * @return
     */
    public static String buildSpecificCriteria(String field, String operator, Object value) {
        StringBuilder criteria = new StringBuilder();
        switch (field) {
        default:
            criteria.append(field + operator + buildLikeValue(value.toString()));
            break;
        }
        return criteria.toString();
    }

    /**
     * Build value for searching.
     * Example: "%keyword%"
     * 
     * @param value
     * @return
     */
    private static String buildLikeValue(String value) {
        return "'%" + value + "%'";
    }
}
