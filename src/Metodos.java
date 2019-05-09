import java.io.*;

import javax.swing.JOptionPane;

public class Metodos {

	public ClasseVota�ao[] fCadastroVota�ao(ClasseVota�ao[] vetor) {
		int i;
		for (i = 0; i < 50; i++) {
			vetor[i].numeroCandidato = (int) (Math.random() * 300);
			vetor[i].numeroSessao = (int) (Math.random() * 10);
		}

		return vetor;
	}

	public ClasseVota�ao[] fClassificaVota�ao(ClasseVota�ao[] vetor) {
		int i, j, aux = 0;

		for (i = 0; i < 49; i++) {
			for (j = i + 1; j < 50; j++) {
				if (vetor[i].numeroSessao > vetor[j].numeroSessao) {
					aux = vetor[i].numeroSessao;
					vetor[i].numeroSessao = vetor[j].numeroSessao;
					vetor[j].numeroSessao = vetor[i].numeroSessao;
				}
			}
		}

		JOptionPane.showMessageDialog(null, "dados classificados");
		return vetor;
	}

	public ClasseVota�ao[] gravarVotos(ClasseVota�ao[] vetor) throws IOException {
		int i;

		String fileName = "D:\\Download\\Votos.txt";
		BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName));

		for (i = 0; i < 50; i++) {
			gravar.write("o canditado votado e a sess�o foram : ");
			gravar.newLine();
			gravar.write("N� canditato :" + vetor[i].numeroCandidato);
			gravar.newLine();
			gravar.write("N� da sess�o :" + vetor[i].numeroSessao);
			gravar.newLine();
			gravar.write(" ");
			gravar.newLine();
		}
		JOptionPane.showMessageDialog(null, "arquivo gerado");
		gravar.close();
		return vetor;
	}

	public void procQuantidadeEleitoresSessao(ClasseVota�ao[] vetor) {
		int i;
		int V[] = new int[11];
		String msg = " ";

		for (i = 0; i < 50; i++) {
			V[vetor[i].numeroSessao]++;
		}

		for (i = 0; i <= 10; i++) {
			msg += "o numero de eleitores na sess�o " + i + " � de :" + V[i] + "\n";
		}
		JOptionPane.showMessageDialog(null, msg);
	}

	public void procMaiorMenor(ClasseVota�ao[] vetor) {
		int i, maior = 0, menor = 0;

		int V[] = new int[11];

		for (i = 0; i < 50; i++) {
			V[vetor[i].numeroSessao]++;
		}

		for (i = 0; i <= 10; i++) {

			if (i == 0) {
				maior = V[i];
				menor = V[i];
			}

			else if (V[i] >= maior) {
				maior = V[i];
			}

			else if (V[i] <= menor) {
				menor = V[i];
			}
		}

		JOptionPane.showMessageDialog(null, "a sess�o com maior quantidade de votos foi : " + maior);
		JOptionPane.showMessageDialog(null, "a sess�o com menor quantidade de votos foi : " + menor);
	}

	public void procNumeroVotos(ClasseVota�ao[] vetor) {
		int i;
		int V[] = new int[300];
		String msg = " ";

		for (i = 0; i < 50; i++) {
			V[vetor[i].numeroCandidato]++;
		}

		for (i = 0; i < 50; i++) {
			msg += "o candidato N� " + i + " recebeu : " + V[i] + " votos! " + "\n";
		}

		JOptionPane.showMessageDialog(null, msg);
	}

	public void procDezPrimeiros(ClasseVota�ao[] vetor) {
		int i, j, aux = 0;
		int V[] = new int[300];
		String msg = " ";

		for (i = 0; i < 50; i++) {
			V[vetor[i].numeroCandidato]++;
		}

		for (i = 0; i < 49; i++) {
			for (j = i + 1; j < 50; j++) {
				if (V[i] < V[j]) {
					aux = V[i];
					V[i] = V[j];
					V[j] = aux;
				}
			}
		}

		for (i = 0; i < 10; i++) {
			if(V[i] == vetor[i].numeroCandidato) {
				msg += "os 10 primeiros canditados s�o : " + " o canditado " + vetor[i].numeroCandidato +  " com " + V[i] + " votos " + "\n";	
			}
			
		}

		JOptionPane.showMessageDialog(null, msg);
	}
}
