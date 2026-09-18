 package com.example.apis.service;

import com.example.apis.model.Hotel;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private final List<Hotel> listaHotel = new ArrayList<>();
    private Long contadorId = 1L; 

    public Hotel guardar(Hotel hotel) {
        hotel.setId(contadorId++);
        listaHotel.add(hotel);
        return hotel;
    }

    public List<Hotel> obtenerTodos() {
        return listaHotel;
    }


    public Optional<Hotel> buscarPorId(Long id) {
        return listaHotel.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    public Optional<Hotel> actualizar(Long id, Hotel habitacionActualizado) {
        Optional<Hotel> opcional = buscarPorId(id);
        if (opcional.isPresent()) {
            Hotel hotel = opcional.get();
            hotel.setNomCliente(habitacionActualizado.getNomCliente());
            hotel.setHabitacion(habitacionActualizado.getHabitacion());
            hotel.setFechEntrada(habitacionActualizado.getFechEntrada());
            hotel.setFechSalida(habitacionActualizado.getFechSalida());
            hotel.setEstado(habitacionActualizado.getEstado());
            return Optional.of(hotel);
        }
        return Optional.empty();
    }

    public boolean eliminar(Long id) {
        return listaHotel.removeIf(c -> c.getId().equals(id));
    }
}