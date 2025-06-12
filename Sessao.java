import java.time.LocalDate;
import java.util.ArrayList;

public class Sessao {
	
	private int status;
	private LocalDate data;
	private String hora;
	private int sala;
	private int filme; 
	
	public Sessao (LocalDate data, String hora, int local, int filme) {
		this.data = data;
		this.hora = hora;
		this.sala = local;
		this.filme = filme;
	}
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public int getSala() {
		return sala;
	}
	
	public int getFilme() {
		return filme;
	}
	
	
}
