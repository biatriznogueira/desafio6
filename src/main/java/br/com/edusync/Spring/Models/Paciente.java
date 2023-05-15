package br.com.edusync.Spring.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "tb_paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String responsavel;


}
