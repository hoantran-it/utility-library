/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.dto;

import java.io.Serializable;

import com.github.hoantran.lib.utility.http.HttpStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class MessageDTO implements Serializable {

    private HttpStatus status;
    private String message;

    public MessageDTO(HttpStatus status) {
        super();
        this.status = status;
    }

    public MessageDTO(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

}
