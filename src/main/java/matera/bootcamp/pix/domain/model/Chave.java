package matera.bootcamp.pix.domain.model;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Chave {

    // id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TipoChave
    @Column
    @Enumerated(EnumType.STRING)
    private TipoChave tipoChave;

    //ContaCorrente
    @Column(nullable = false)
    private String valor;

    @ManyToOne(optional = false)
    private ContaCorrente contaCorrente;
}
