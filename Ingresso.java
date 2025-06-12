public class Ingresso {
    private int posicaoPoltrona;
    private int combo;
    private Filme filme;
    private Sessao sessao;
    private Aluno aluno;

    public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Ingresso(Aluno aluno,Filme filme,Sessao sessao,int posicaoAluno, int combo) {
        this.combo = combo;
        this.posicaoPoltrona = posicaoAluno;
        this.aluno = aluno;
        this.filme = filme;
        this.sessao = sessao;
    }

    public int isCombo() {
        return combo;
    }

    public void setCombo(int combo) {
        this.combo = combo;
    }

    public int getPosicaoPoltrona() {
        return posicaoPoltrona;
    }

    public void setPosicaoPoltrona(int posicaoPoltrona) {
        this.posicaoPoltrona = posicaoPoltrona;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }
}