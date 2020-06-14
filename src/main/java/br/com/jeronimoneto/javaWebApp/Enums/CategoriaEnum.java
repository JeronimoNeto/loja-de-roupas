package br.com.jeronimoneto.javaWebApp.Enums;

public enum CategoriaEnum {
	
	//Criamos objetos do enum seguindo construtor privado
	ROUPA_MASCULINA("Roupa Masculina", 0), ROUPA_FEMININA("Roupa Feminina", 1),
	ROUPA_INFANTIL("Roupa Infantil", 2), FANTASIA("Fantasia", 3);
	
	private String nome;
	private Integer codigo;
	
	private CategoriaEnum(String nome, Integer codigo) {
		this.nome = nome;
		this.codigo = codigo;
		
	}
	public String getNome() {
		return nome;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	


}
