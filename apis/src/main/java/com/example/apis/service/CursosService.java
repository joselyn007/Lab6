package com.example.apis.service;

import com.example.apis.model.Cursos;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CursosService {

    private final List<Cursos> listaCursos = new ArrayList<>();
    private Long contadorId = 1L;

    public Cursos guardar(Cursos curso) {
        curso.setId(contadorId++);
        listaCursos.add(curso);
        return curso;
    }

    public List<Cursos> obtenerTodos() {
        return listaCursos;
    }

    public Optional<Cursos> buscarPorCodigo(String codigo) {
        return listaCursos.stream()
                .filter(c -> c.getCodigo().equalsIgnoreCase(codigo))
                .findFirst();
    }

    public Optional<Cursos> buscarPorId(Long id) {
        return listaCursos.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    public Optional<Cursos> actualizar(Long id, Cursos cursoActualizado) {
        Optional<Cursos> opcional = buscarPorId(id);
        if (opcional.isPresent()) {
            Cursos curso = opcional.get();
            curso.setNombre(cursoActualizado.getNombre());
            curso.setCodigo(cursoActualizado.getCodigo());
            curso.setCreditos(cursoActualizado.getCreditos());
            curso.setEstado(cursoActualizado.getEstado());
            return Optional.of(curso);
        }
        return Optional.empty();
    }

    public boolean eliminar(Long id) {
        return listaCursos.removeIf(c -> c.getId().equals(id));
    }
}