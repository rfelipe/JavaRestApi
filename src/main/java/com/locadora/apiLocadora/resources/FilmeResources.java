package com.locadora.apiLocadora.resources;


import com.locadora.apiLocadora.models.Filme;
import com.locadora.apiLocadora.repository.FilmeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api")
@Api(value="Api REST Filmes")
@CrossOrigin(origins = "*")
public class FilmeResources {

    @Autowired
    FilmeRepository filmeRepository;

    @GetMapping("/filmes")
    @ApiOperation(value = "retorna uma lista de filmes")
    public List<Filme> listaFilmes(){
    return filmeRepository.findAll();
    }

    @GetMapping("/filmes/{titulo}")
    @ApiOperation(value = "retorna um filme pelo titulo")
    public Optional<Filme> listaFilmeId(@PathVariable(value="titulo")String titulo){
        return filmeRepository.findByTitulo(titulo);
    }


    @PutMapping("/filme")
    @ApiOperation(value = "atualiza dados do filme")
    public Filme atalizaFilme(@RequestBody Filme filme){
        return filmeRepository.save(filme);
    }
}
