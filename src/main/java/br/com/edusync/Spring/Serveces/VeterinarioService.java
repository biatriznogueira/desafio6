package br.com.edusync.Spring.Serveces;

import br.com.edusync.Spring.Models.Paciente;
import br.com.edusync.Spring.Models.Veterinario;
import br.com.edusync.Spring.Repository.PacienteRepository;
import br.com.edusync.Spring.Repository.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VeterinarioService {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    //criar
    public void adicionar(Veterinario veterinarioSalvo){
        veterinarioRepository.save(veterinarioSalvo);
    }

    //buscar
    private Veterinario buscarCodigo(Integer codigo){
        Optional<Veterinario> optionalVeterinario = veterinarioRepository.findById(codigo);
        if (optionalVeterinario.isPresent()){
            return optionalVeterinario.get();

        }
        return null;

        }

    //deletar
    public void deletar(Integer codigo){
       veterinarioRepository.deleteById(codigo);

    }
    public void atualizar(Integer codigo){
        if (veterinarioRepository.existsById(codigo)){
            veterinarioRepository.deleteById(codigo);
        }
    }

    public List<Veterinario> listarTodos(){
        return veterinarioRepository.findAll();
    }


    }

