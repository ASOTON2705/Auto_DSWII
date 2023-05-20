package Actividad_2_DSWII_T6CL_Soto_Nolazco_Alfredo.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import Actividad_2_DSWII_T6CL_Soto_Nolazco_Alfredo.entities.Auto;

public interface AutoRepository extends JpaRepository<Auto, Long>{
    List<Auto> findByPrecioBetween(double minPrice, double maxPrice);
}
