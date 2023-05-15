package br.com.edusync.Spring.Repository;
import br.com.edusync.Spring.Models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PacienteRepository extends JpaRepository <Paciente, Integer> {



}
