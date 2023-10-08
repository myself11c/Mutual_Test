package com.genesis1.mutual.model.payload;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Builder
public class MensajeResponse  implements Serializable {

    private String message;
    private Object object;
    private String code;

}
