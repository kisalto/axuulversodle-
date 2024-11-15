package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Personagem;
import app.service.PersonagemService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/personagem")
// @CrossOrigin(origins = "")
@Validated
public class PersonagemController {

	@Autowired
	private PersonagemService personagemService;

	@PostMapping("/save")
	public ResponseEntity<String> save(@Valid @RequestBody Personagem personagem) {
		try {
			this.personagemService.save(personagem);
			return new ResponseEntity<String>("Personagem cadastrado com sucesso", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro ao cadastrar o personagem: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@Valid @RequestBody Personagem personagem, @PathVariable Long id) {
		try {
			this.personagemService.update(personagem, id);
			return new ResponseEntity<String>("Personagem atualizado com sucesso", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro ao atualizar o personagem: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Personagem> findById(@Valid @PathVariable Long id) {
		try {
			Personagem personagem = this.personagemService.findById(id);
			return new ResponseEntity<Personagem>(personagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findById/{nome}")
	public ResponseEntity<Personagem> findByNome(@Valid @PathVariable String nome) {
		try {
			Personagem personagem = this.personagemService.findByNome(nome);
			return new ResponseEntity<Personagem>(personagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@Valid @PathVariable Long id) {
		try {
			this.personagemService.delete(id);
			return new ResponseEntity<String>("Personagem deletado com sucesso", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro ao deletar o personagem: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
