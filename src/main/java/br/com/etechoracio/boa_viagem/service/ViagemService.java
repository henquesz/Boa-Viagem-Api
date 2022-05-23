package br.com.etechoracio.boa_viagem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etechoracio.boa_viagem.entity.Gasto;
import br.com.etechoracio.boa_viagem.entity.Viagem;
import br.com.etechoracio.boa_viagem.repository.GastoRepository;
import br.com.etechoracio.boa_viagem.repository.ViagemRepository;


@Service
public class ViagemService {

	
	@Autowired
	private ViagemRepository viagemRepo;
	
	@Autowired
	private GastoRepository gastoRepo;
	                                                                                                                                                                                                                               

	public boolean excluir(Long id) {
		
		boolean existe = viagemRepo.existsById(id);
		if(!existe) {
			return existe;
		}
		
		List<Gasto> gastos = gastoRepo.findByViagemId(id);
		
		if(!gastos.isEmpty()) {
			gastoRepo.deleteAll(gastos);
		}
		
		viagemRepo.deleteById(id);
		return existe;
	}
	
	public List<Viagem> listarTodos(){
		
		return viagemRepo.findAll();
	}
	

	public Optional<Viagem> buscarPorId(Long id){
		
		return viagemRepo.findById(id);
	}
	

	public Viagem inserir(Viagem obj) {
		
		return viagemRepo.save(obj);
	}
	

	public Optional<Viagem> atualizar(Long id, Viagem viagem) {
		
		boolean existe = viagemRepo.existsById(id);
		
		if (!existe) {return Optional.empty();}
		
		return Optional.of(viagemRepo.save(viagem));
	}
}
