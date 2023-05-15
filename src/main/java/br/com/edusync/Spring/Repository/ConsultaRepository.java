package br.com.edusync.Spring.Repository;
import br.com.edusync.Spring.Models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ConsultaRepository extends JpaRepository <Consulta, Integer>{

}

