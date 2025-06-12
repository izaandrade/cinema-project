
public class Local {
	private int capacidade;
	private int sala;
	private String bloco;
	
	public Local (int capacidade, int sala, String bloco) {
		this.capacidade = capacidade;
		this.sala = sala;
		this.bloco = bloco;
	}
	
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public int getSala() {
		return sala;
	}
	public void setSala(int sala) {
		this.sala = sala;
	}
	public String getBloco() {
		return bloco;
	}
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}
	
	
}
