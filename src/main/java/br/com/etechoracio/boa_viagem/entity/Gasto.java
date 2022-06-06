package br.com.etechoracio.boa_viagem.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.*;

import br.com.etechoracio.boa_viagem.enums.CategoriaEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="TBL_GASTO")
public class Gasto {

 @NotNull
 @Id
 @Column(name="ID_GASTO")
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 
 @Column(name="TX_DESCRICAO")
 private String descricao;
 
 @javax.validation.constraints.NotBlank(message="Campo local é obrigatório.")
 @Length(max=30)
 @Column(name="TX_LOCAL")
 private String local;
 
 @Enumerated(EnumType.STRING)
 @Column(name="TP_CATEGORIA")
 private CategoriaEnum categoria;
 
 @NotNull
 @FutureOrPresent
 @Column(name="DT_GASTO")
 private LocalDate data;

 @DecimalMin(value="0.01")
 @Column(name="VLR_GASTO")
 private Double valor;
 
 @NotNull
 @ManyToOne
 @JoinColumn(name="ID_VIAGEM")
 private Viagem viagem;
 
 
}