package br.com.edusync.Spring.Repository;
import br.com.edusync.Spring.Models.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClinicaRepository extends JpaRepository <Clinica, Integer>{

}
