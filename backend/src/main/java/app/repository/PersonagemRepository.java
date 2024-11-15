package app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Personagem;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {

	public Optional<Personagem> findByNome(String nome);

}
