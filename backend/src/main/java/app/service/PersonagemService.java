package app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Personagem;
import app.repository.PersonagemRepository;

@Service
public class PersonagemService {

	@Autowired
	private PersonagemRepository personagemRepository;

	public String save(Personagem personagem) {
		this.personagemRepository.save(personagem);
		return "Personagem salvo com sucesso";
	}

	public String update(Personagem personagem, Long id) {
		personagem.setId(id);
		this.personagemRepository.save(personagem);
		return "Personagem atualizado com sucesso";
	}

	public Personagem findByNome(String nome) {
		Optional<Personagem> optional = this.personagemRepository.findByNome(nome);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}

	}

	public Personagem findById(Long id) {
		Optional<Personagem> optional = this.personagemRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public String delete(Long id) {
		Personagem personagem = findById(id);
		this.personagemRepository.delete(personagem);
		return "Personagem deletado com sucesso!";
	}

}
