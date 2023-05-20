package Actividad_2_DSWII_T6CL_Soto_Nolazco_Alfredo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Actividad_2_DSWII_T6CL_Soto_Nolazco_Alfredo.entities.Auto;
import Actividad_2_DSWII_T6CL_Soto_Nolazco_Alfredo.repositories.AutoRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/autos")
@AllArgsConstructor
public class AutoController {
    
    @Autowired
    private AutoRepository autoRepository;

    @GetMapping
    public List<Auto> listarAutos() {
        return autoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Auto registrarAuto(@RequestBody Auto auto) {
        return autoRepository.save(auto);
    }

    @GetMapping("{cod_auto}")
    public ResponseEntity<Auto> findById(@PathVariable Long cod_auto) {
        return ResponseEntity.of(this.autoRepository.findById(cod_auto));
    }

    @PutMapping("/{cod_auto}")
    public Auto actualizarAuto(@PathVariable Long cod_auto, @RequestBody Auto autoActualizado) {
        Auto auto = autoRepository.findById(cod_auto)
                .orElseThrow(() -> new RuntimeException("Auto no encontrado: " + cod_auto));
        auto.setDes_auto(autoActualizado.getDes_auto());
        auto.setStock_auto(autoActualizado.getStock_auto());
        auto.setPrecio(autoActualizado.getPrecio());
        auto.setMarca(autoActualizado.getMarca());
        return autoRepository.save(auto);
    }

    @DeleteMapping("/{cod_auto}")
    public void eliminarAuto(@PathVariable Long cod_auto) {
        autoRepository.deleteById(cod_auto);
    }

    @GetMapping("/filtrarAutoPorPrecio")
    public List<Auto> filteredAutos(double minPrice, double maxPrice) {
        return autoRepository.findByPrecioBetween(minPrice, maxPrice);
    }
}


