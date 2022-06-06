package br.com.etechoracio.boa_viagem.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import br.com.etechoracio.boa_viagem.enums.TipoViagemEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="TBL_VIAGEM")

public class Viagem {
	 
	 @NotNull
	 @Id
	 @Column(name="ID_VIAGEM")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @NotNull
	 @Column(name="TX_DESTINO")
	 private String destino;
	 
	 @NotNull
	 @Enumerated(EnumType.STRING)
	 @Column(name="TP_VIAGEM")
	 private TipoViagemEnum tipo;
	 
	 @NotNull
	 @FutureOrPresent
	 @Column(name = "DT_CHEGADA")
	 private LocalDate chegada;
	 
	 @NotNull
	 @FutureOrPresent
	 @Column(name = "DT_SAIDA")
	 private LocalDate saida;
	 
	 @NotNull
	 @DecimalMin(value = "0.01")
	 @Column(name="VLR_ORCAMENTO")
	 private Double orcamento;
	 
	 @NotNull
	 @Min(value = 1)
	 @Column(name="QTD_PESSOAS")
	 private Integer pessoas;
	}
