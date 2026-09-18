package com.example.apis.controller;

import com.example.apis.model.Libro;
import com.example.apis.service.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    // Registro de libro (201)
    @PostMapping
    public ResponseEntity<Libro> registrarLibro(@RequestBody Libro libro) {
        Libro nuevo = libroService.guardar(libro);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    // Consulta de todos los libros (200)
    @GetMapping
    public ResponseEntity<List<Libro>> consultarLibros() {
        return ResponseEntity.ok(libroService.obtenerTodos());
    }

    // Consultar por título (200 OK)
    @GetMapping("/buscar")
    public ResponseEntity<List<Libro>> consultarPorTitulo(@RequestParam String titulo) {
        return ResponseEntity.ok(libroService.buscarPorTitulo(titulo));
    }

    // Actualizar Libro (200 OK o 404 NOT FOUND)
    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Long id, @RequestBody Libro libro) {
        return libroService.actualizar(id, libro)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar libro (204 NO CONTENT o 404 NOT FOUND)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        if (libroService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}