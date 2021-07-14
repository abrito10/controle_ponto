package br.com.abrito.ponto.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity

public class Ocorrencia {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String descricao;
}
