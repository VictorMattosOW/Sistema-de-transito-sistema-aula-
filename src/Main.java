import javax.swing.JOptionPane;
import java.io.*;

public class Main {

	 public static void main(String[] args) throws IOException {
		
		 int opc = 0, i , num = 0;
		
		 ClasseVotaçao [] votação = new ClasseVotaçao [50];
		 Metodos metodos = new Metodos();
		 
		 for (i = 0; i < 50; i++) {
				votação[i] = new ClasseVotaçao();
			}
		 
		 
		 
		 
		 while(opc != 9) {
			 opc = Integer.parseInt(JOptionPane.showInputDialog("1 – Carregar Seção/Número Eleitor  \n2 – Classificar por Seção"
			 		+ "\n3 – Gravar Registros \n4 – Mostrar Indicadores \n9 - sair"));
			 
			 switch(opc) {
			 
			 case 1:
				 votação = metodos.fCadastroVotaçao(votação);
				 break;
				 
			 case 2:
				 votação = metodos.fClassificaVotaçao(votação);
				 break;
				 
			 case 3:
				 votação = metodos.gravarVotos(votação);
				 break;
				 
			 case 9:
				 JOptionPane.showMessageDialog(null,"vc saiu do sistema");
				 break;
				 
			 case 4:
				 while (num != 9) {
					 num = Integer.parseInt(JOptionPane.showInputDialog("1- Quantidade Eleitores por Seção \n2- Seção com Maior e Menor número de Eleitores "
					 		+ "\n3 - Quantidade de votos por candidato \n4- Os 10 primeiros colocados \n9 - sair"));
					 
					 switch (num) {
					 
					 case 1:
						 metodos.procQuantidadeEleitoresSessao(votação);
						 break;
						 
					 case 2:
						 metodos.procMaiorMenor(votação);
						 break;
						 
					 case 3:
						 metodos.procNumeroVotos(votação);
						 break;
						 
					 case 4:
						metodos.procDezPrimeiros(votação);
						break;
						
					 case 9:
						 JOptionPane.showMessageDialog(null,"vc saiu do sistema");
						 break;
					 }
				 }
			 }
		 }
	}
}
