package org.acme.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Address implements Serializable {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

}