import javax.swing.JOptionPane;
import java.util.ArrayList;

public class GestaoIngresso {
    private static ArrayList<Ingresso> listaDeIngressos = new ArrayList<Ingresso>();

    public static void adicionarIngresso(Ingresso ingresso) {
        listaDeIngressos.add(ingresso);
    }

    public static ArrayList<Ingresso> getListaDeIngressos() {
        return listaDeIngressos;
    }

    public static void setListaDeIngressos(ArrayList<Ingresso> listaDeIngressos) {
        GestaoIngresso.listaDeIngressos = listaDeIngressos;
    }

    public static void exibirIngressos() {
        if (listaDeIngressos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum ingresso reservado");
        } else {
            for (Ingresso ingresso : listaDeIngressos) {
                JOptionPane.showMessageDialog(null, "Poltrona " + ingresso.getPosicaoPoltrona() +
                        (ingresso.isCombo() == 1 ? " com combo." : " sem combo."));
            }
        }
    }
}