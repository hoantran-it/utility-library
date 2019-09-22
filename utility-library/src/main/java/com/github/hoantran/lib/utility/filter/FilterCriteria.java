/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.filter;

/**
 * @author hoan.tran
 */
public class FilterCriteria {

    private String key;

    private String operator;

    private String[] value;

    /**
     * @param key
     * @param operator
     * @param value
     */
    public FilterCriteria(String key, String operator, String[] value) {
        super();
        this.key = key;
        this.operator = operator;
        this.value = value;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
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
     * @return the value
     */
    public String[] getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String[] value) {
        this.value = value;
    }

}
