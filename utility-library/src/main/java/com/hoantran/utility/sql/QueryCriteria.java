/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.hoantran.utility.sql;

import java.util.List;

/**
 * Query criteria. One field can have many value.
 * 
 * @author hoan.tran
 */
public class QueryCriteria {

    private String field;

    private String operator;

    private List<?> values;

    /**
     * @return the field
     */
    public String getField() {
        return field;
    }

    /**
     * @param field the field to set
     */
    public void setField(String field) {
        this.field = field;
    }

    /**
     * @return the operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @param operator the operator to set
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * @return the values
     */
    public List<?> getValues() {
        return values;
    }

    /**
     * @param values the values to set
     */
    public void setValues(List<?> values) {
        this.values = values;
    }

}
