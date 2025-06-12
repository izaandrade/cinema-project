
public class Filme {
	private String titulo;
	private String genero;
	private int duracao;
	private int classificacao;
	
	
	public Filme (String titulo, String genero, int duracao, int classificacao) {
		this.titulo = titulo;
		this.genero = genero;
		this.duracao = duracao;
		this.classificacao = classificacao;
	}
	
	

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public int getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}

	
}
