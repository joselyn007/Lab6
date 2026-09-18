package com.example.apis.controller;

import com.example.apis.model.Cursos;
import com.example.apis.service.CursosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cursos")
public class CursosController {

    private final CursosService cursoService;

    public CursosController(CursosService cursosService) {
        this.cursoService = cursosService;
    }

    // Registro de cursos (201 CREATED)
    @PostMapping
    public ResponseEntity<Cursos> crearCurso(@RequestBody Cursos cursos) {
        Cursos nuevo = cursoService.guardar(cursos);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    // Consulta de todos los cursos (200 OK)
    @GetMapping
    public ResponseEntity<List<Cursos>> consultarCursos() {
        return ResponseEntity.ok(cursoService.obtenerTodos());
    }

    // Consultar curso por código (200 OK o 404 NOT FOUND)
    @GetMapping("/buscar")
    public ResponseEntity<Cursos> consultarPorCodigo(@RequestParam String codigo) {
        return cursoService.buscarPorCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar curso (200 OK o 404 NOT FOUND)
    @PutMapping("/{id}")
    public ResponseEntity<Cursos> actualizarCurso(@PathVariable Long id, @RequestBody Cursos cursos) {
        return cursoService.actualizar(id, cursos)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar curso (204 NO CONTENT o 404 NOT FOUND)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id) {
        if (cursoService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}