package com.example.apis.service;

import com.example.apis.model.Libro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    private final List<Libro> libros = new ArrayList<>();
    private Long contadorId = 1L;

    // Registrar libro
    public Libro guardar(Libro libro) {
        libro.setId(contadorId++);
        libros.add(libro);
        return libro;
    }

    // Consultar todos
    public List<Libro> obtenerTodos() {
        return libros;
    }

    // Consultar por título
    public List<Libro> buscarPorTitulo(String titulo) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro l : libros) {
            if (l.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultado.add(l);
            }
        }
        return resultado;
    }

    // Consultar por ID
    public Optional<Libro> buscarPorId(Long id) {
        return libros.stream().filter(l -> l.getId().equals(id)).findFirst();
    }

    // Actualizar
    public Optional<Libro> actualizar(Long id, Libro libroActualizado) {
        Optional<Libro> opcional = buscarPorId(id);
        if (opcional.isPresent()) {
            Libro libro = opcional.get();
            libro.setTitulo(libroActualizado.getTitulo());
            libro.setAutor(libroActualizado.getAutor());
            libro.setIsbn(libroActualizado.getIsbn());
            libro.setAñopub(libroActualizado.getAñopub());
            libro.setEstado(libroActualizado.getEstado());
            return Optional.of(libro);
        }
        return Optional.empty();
    }

    // Eliminar
    public boolean eliminar(Long id) {
        return libros.removeIf(l -> l.getId().equals(id));
    }
}