package br.com.joao.payflux.exception;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ErrorResponse {
    private String error;
    private int codigo;
    private Date timeStamp;
    private String path;
}
