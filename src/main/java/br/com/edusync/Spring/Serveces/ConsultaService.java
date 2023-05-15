package br.com.edusync.Spring.Serveces;
import br.com.edusync.Spring.Models.Consulta;
import br.com.edusync.Spring.Repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;


    //adicionar
    public void adicionar (Consulta consultaSalvo){
        consultaRepository.save(consultaSalvo);
    }
    //buscar
    private Consulta buscarRegistro(Integer codigo){
        Optional<Consulta> optionalConsulta = consultaRepository.findById(codigo);
        if (optionalConsulta.isPresent()) {
            return optionalConsulta.get();

        }
        return null;
        }
    //delete
    public void deletar(Integer codigo){
        consultaRepository.deleteById(codigo);
    }

    //atualizar
    public void atualizar(Integer codigo){
        if (consultaRepository.existsById(codigo)){
            consultaRepository.deleteById(codigo);
        }
    }
    //listar
    public List<Consulta> listarTodo(){
        return consultaRepository.findAll();
    }


}


