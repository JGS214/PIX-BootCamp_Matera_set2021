package matera.bootcamp.pix.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity

public class Usuario {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

   @OneToOne(optional = false)
    private ContaCorrente contaCorrente;


}

