package com.locadora.apiLocadora.resources;

import com.locadora.apiLocadora.models.Usuario;
import com.locadora.apiLocadora.repository.UsuarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value="/api")
@Api(value="Api REST usuario")
@CrossOrigin(origins = "*")
public class UsuarioResources {
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/usuario/BuscaUsuario")
    @ApiOperation(value = "retorna um Usuario")
    public String BuscaUsuario(String email,String senha){
        Optional<Usuario> emailOptional=usuarioRepository.findByEmail(email);
        Optional<Usuario> senhaOptional=usuarioRepository.findBySenha(senha);
        if(emailOptional.isPresent()){
            if(senhaOptional.isPresent()){
                return usuarioRepository.findByEmail(email).get().getNome().toString();
            }
        }
        return "erro";
    }


    @PutMapping("/usuario")
    @ApiOperation(value = "salva dados do Usuario")
    public Usuario atalizaUsurio(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}
