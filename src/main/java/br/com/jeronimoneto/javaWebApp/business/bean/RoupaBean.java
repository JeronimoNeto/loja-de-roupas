package br.com.jeronimoneto.javaWebApp.business.bean;

public class RoupaBean {
	private Integer codigo;
	private String nome;
	private Integer codigoCategoria;
	private String categoria;
	private Float preco;
	private String nomeImagem;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Float getPreco() {
		return preco;
	}
	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public String getNomeImagem() {
		return nomeImagem;
	}
	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}
	public Integer getCodigoCategoria() {
		return codigoCategoria;
	}
	public void setCodigoCategoria(Integer codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

}
