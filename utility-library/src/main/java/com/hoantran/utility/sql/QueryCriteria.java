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
 * Query criteria. One field can have many value.
 * 
 * @author hoan.tran
 */
public class QueryCriteria {

    private String field;

    private String operator;

    private List<Object> values;

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
    public List<Object> getValues() {
        return values;
    }

    /**
     * @param values the values to set
     */
    public void setValues(List<Object> values) {
        this.values = values;
    }

}
