package Actividad_2_DSWII_T6CL_Soto_Nolazco_Alfredo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_auto")
public class Auto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_auto;
    private String des_auto;
    private Integer stock_auto;
    private Double precio;
    
    @ManyToOne
    @JoinColumn(name = "cod_marca")
    private Marca marca;
}
