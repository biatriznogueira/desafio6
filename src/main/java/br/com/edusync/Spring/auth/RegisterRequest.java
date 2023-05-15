package br.com.edusync.Spring.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String senha;
    private String email;
    private String nomeCompleto;
    private String userName;
}
