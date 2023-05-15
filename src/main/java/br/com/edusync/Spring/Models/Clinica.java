package br.com.edusync.Spring.Models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity (name = "tb_clinica")
public class Clinica {

    private String veterinario;
    @Id
    private Integer CNPJ;
    private String nomeDaClinica;



}
