package br.com.edusync.Spring.Serveces;
import br.com.edusync.Spring.Models.Paciente;
import br.com.edusync.Spring.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteServece {

    @Autowired
    private PacienteRepository pacienteRepository;

    //criar
    public void adicionar(Paciente pacienteSalvo ) {
        pacienteRepository.save(pacienteSalvo);

    }

    //buscar
    private Paciente buscarRegistro(Integer codigo){
        Optional<Paciente> optionalPaciente = pacienteRepository.findById(codigo);
        if (optionalPaciente.isPresent()) {
            return optionalPaciente.get();

        }
        return null;

        }


    //delete
    public void deletar(Integer codigo){
        pacienteRepository.deleteById(codigo);
    }

    //atualizar
    public void atualizar(Integer codigo){
        if (pacienteRepository.existsById(codigo)){
            pacienteRepository.deleteById(codigo);
        }
    }

    //listar
    public List<Paciente> listarTodo(){
        return pacienteRepository.findAll();
    }
}




