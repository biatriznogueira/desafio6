package br.com.edusync.Spring.Serveces;
import br.com.edusync.Spring.Models.Clinica;
import br.com.edusync.Spring.Repository.ClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClinicaService {

    @Autowired
    private ClinicaRepository clinicaRepository;


    //criar
   public void adicionar (Clinica clinicaSalvo) {
      clinicaRepository.save(clinicaSalvo);
    }


    //buscar
    public Clinica buscarRegistro(Integer CNPJ){
        Optional<Clinica> optionalClinica = clinicaRepository.findById(CNPJ);
        if (optionalClinica.isPresent()) {
            return optionalClinica.get();
        }
        return null;

        }

    //delete
    public void deletar(Integer CNPJ){
       clinicaRepository.deleteById(CNPJ);
    }

    //atualizar
    public void atualizar(Integer codigo){
        if (clinicaRepository.existsById(codigo)){
            clinicaRepository.deleteById(codigo);
        }
    }


    //listar
    public List<Clinica> listarTodos(){
        return clinicaRepository.findAll();
    }
}

