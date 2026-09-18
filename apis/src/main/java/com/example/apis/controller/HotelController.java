package com.example.apis.controller;

import com.example.apis.model.Hotel;
import com.example.apis.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotel")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    // Registro en hotel (201 CREATED)
    @PostMapping
    public ResponseEntity<Hotel> crearHotel(@RequestBody Hotel hotel) {
        Hotel nuevo = hotelService.guardar(hotel);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    // Consulta de todo el hotel (200 OK)
    @GetMapping
    public ResponseEntity<List<Hotel>> consultarHotel() {
        return ResponseEntity.ok(hotelService.obtenerTodos());
    }

    // Consultar reserva por id (200 OK o 404 NOT FOUND)
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> consultarPorId(@PathVariable Long id) {
        return hotelService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar reserva (200 OK o 404 NOT FOUND)
    @PutMapping("/{id}")
    public ResponseEntity<Hotel> actualizarHotel(@PathVariable Long id, @RequestBody Hotel hotel) {
        return hotelService.actualizar(id, hotel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar / Cancelar reserva (204 NO CONTENT o 404 NOT FOUND)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHotel(@PathVariable Long id) {
        if (hotelService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}