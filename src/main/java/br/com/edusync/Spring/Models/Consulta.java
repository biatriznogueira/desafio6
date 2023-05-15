package br.com.edusync.Spring.Models;
import jakarta.persistence.*;
import lombok.Data;
import java.sql.Date;


@Data
@Entity (name = "tb_consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdPaciente;

    private Date data;
    @ManyToOne
    @JoinColumn
    private Paciente paciente;
    @ManyToOne
    @JoinColumn
    private Veterinario veterinario;

}

