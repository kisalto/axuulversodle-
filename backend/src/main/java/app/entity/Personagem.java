package app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Personagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O personagem precisa de um nome")
	private String nome;

	@NotBlank(message = "O Universo deve conter um nome")
	private String verso;

	@NotBlank(message = "atributo 1 necessario")
	private String at1;

	@NotBlank(message = "atributo 2 necessario")
	private String at2;

	@NotBlank(message = "atributo 3 necessario")
	private String at3;

	@NotBlank(message = "atributo 4 necessario")
	private String at4;

	@NotBlank(message = "atributo 5 necessario")
	private String at5;

	@NotBlank(message = "atributo 6 necessario")
	private String at6;

	@NotBlank(message = "atributo 7 necessario")
	private String at7;

}
