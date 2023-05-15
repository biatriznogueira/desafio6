package br.com.edusync.Spring.Repository;
import br.com.edusync.Spring.Models.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VeterinarioRepository extends JpaRepository <Veterinario, Integer>{

}
