import java.io.*;

import javax.swing.JOptionPane;

public class Metodos {

	public ClasseVotaçao[] fCadastroVotaçao(ClasseVotaçao[] vetor) {
		int i;
		for (i = 0; i < 50; i++) {
			vetor[i].numeroCandidato = (int) (Math.random() * 300);
			vetor[i].numeroSessao = (int) (Math.random() * 10);
		}

		return vetor;
	}

	public ClasseVotaçao[] fClassificaVotaçao(ClasseVotaçao[] vetor) {
		int i, j, aux = 0;

		for (i = 0; i < 49; i++) {
			for (j = i + 1; j < 50; j++) {
				if (vetor[i].numeroSessao > vetor[j].numeroSessao) {
					aux = vetor[i].numeroSessao;
					vetor[i].numeroSessao = vetor[j].numeroSessao;
					vetor[j].numeroSessao = aux;
				}
			}
		}

		JOptionPane.showMessageDialog(null, "dados classificados");
		return vetor;
	}

	public ClasseVotaçao[] gravarVotos(ClasseVotaçao[] vetor) throws IOException {
		int i;

		String fileName = "D:\\Download\\Votos.txt";
		BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName));

		for (i = 0; i < 50; i++) {
			gravar.write("o canditado votado e a sessão foram : ");
			gravar.newLine();
			gravar.write("N° canditato :" + vetor[i].numeroCandidato);
			gravar.newLine();
			gravar.write("N° da sessão :" + vetor[i].numeroSessao);
			gravar.newLine();
			gravar.write(" ");
			gravar.newLine();
		}
		JOptionPane.showMessageDialog(null, "arquivo gerado");
		gravar.close();
		return vetor;
	}

	public void procQuantidadeEleitoresSessao(ClasseVotaçao[] vetor) {
		int i;
		int V[] = new int[11];
		String msg = " ";

		for (i = 0; i < 50; i++) {
			V[vetor[i].numeroSessao]++;
		}

		for (i = 0; i <= 10; i++) {
			msg += "o numero de eleitores na sessão " + i + " é de :" + V[i] + "\n";
		}
		JOptionPane.showMessageDialog(null, msg);
	}

	public void procMaiorMenor(ClasseVotaçao[] vetor) {
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

		JOptionPane.showMessageDialog(null, "a sessão com maior quantidade de votos foi : " + maior);
		JOptionPane.showMessageDialog(null, "a sessão com menor quantidade de votos foi : " + menor);
	}

	public void procNumeroVotos(ClasseVotaçao[] vetor) {
		int i;
		int V[] = new int[300];
		String msg = " ";

		for (i = 0; i < 50; i++) {
			V[vetor[i].numeroCandidato]++;
		}

		for (i = 0; i < 50; i++) {
			msg += "o candidato N° " + i + " recebeu : " + V[i] + " votos! " + "\n";
		}

		JOptionPane.showMessageDialog(null, msg);
	}

	public void procDezPrimeiros(ClasseVotaçao[] vetor) {
		int i, j, aux = 0, aux2;
		int V[] = new int[300];
		int M[][] = new int [2][300];
		String msg = " ";

		for (i = 0; i < 50; i++) {
			V[vetor[i].numeroCandidato]++;
		}
		
		for(i = 0; i < 300; i++) {
			M[0][i]= i;
			M[1][i] = V[i];
		}

		for (i = 0; i < 299; i++) {
			for (j = i + 1; j < 300; j++) {
				if (M[1][i] < M[1][j]) {
					aux2 = M[1][i];
					M[1][i] = M[1][j];
					M[1][j] = aux2;
					aux = M[0][i];
					M[0][i] = M[0][j];
					M[0][j] = aux;
				}
			}
		}

		for (i = 0; i < 10; i++) {
			msg += "os 10 primeiros canditados são : " + " o canditado " + M[0][i] +  " com " + M[1][i] + " votos " + "\n";
		}

		JOptionPane.showMessageDialog(null, msg);
	}
}
