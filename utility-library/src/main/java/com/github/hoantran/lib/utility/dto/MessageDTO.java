/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.dto;

import java.io.Serializable;

import com.github.hoantran.lib.utility.http.HttpStatus;

/**
 * @author hoan.tran
 */
@SuppressWarnings("serial")
public class MessageDTO implements Serializable {

    private HttpStatus status;

    private String message;

    public MessageDTO() {

    }

    /**
     * @param status
     */
    public MessageDTO(HttpStatus status) {
        super();
        this.status = status;
    }

    /**
     * @param status
     * @param message
     */
    public MessageDTO(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    /**
     * @return the status
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
