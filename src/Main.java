import javax.swing.JOptionPane;
import java.io.*;

public class Main {

	 public static void main(String[] args) throws IOException {
		
		 int opc = 0, i , num = 0;
		
		 ClasseVota�ao [] vota��o = new ClasseVota�ao [50];
		 Metodos metodos = new Metodos();
		 
		 for (i = 0; i < 50; i++) {
				vota��o[i] = new ClasseVota�ao();
			}
		 
		 
		 
		 
		 while(opc != 9) {
			 opc = Integer.parseInt(JOptionPane.showInputDialog("1 � Carregar Se��o/N�mero Eleitor  \n2 � Classificar por Se��o"
			 		+ "\n3 � Gravar Registros \n4 � Mostrar Indicadores \n9 - sair"));
			 
			 switch(opc) {
			 
			 case 1:
				 vota��o = metodos.fCadastroVota�ao(vota��o);
				 break;
				 
			 case 2:
				 vota��o = metodos.fClassificaVota�ao(vota��o);
				 break;
				 
			 case 3:
				 vota��o = metodos.gravarVotos(vota��o);
				 break;
				 
			 case 9:
				 JOptionPane.showMessageDialog(null,"vc saiu do sistema");
				 break;
				 
			 case 4:
				 while (num != 9) {
					 num = Integer.parseInt(JOptionPane.showInputDialog("1- Quantidade Eleitores por Se��o \n2- Se��o com Maior e Menor n�mero de Eleitores "
					 		+ "\n3 - Quantidade de votos por candidato \n4- Os 10 primeiros colocados \n9 - sair"));
					 
					 switch (num) {
					 
					 case 1:
						 metodos.procQuantidadeEleitoresSessao(vota��o);
						 break;
						 
					 case 2:
						 metodos.procMaiorMenor(vota��o);
						 break;
						 
					 case 3:
						 metodos.procNumeroVotos(vota��o);
						 break;
						 
					 case 4:
						metodos.procDezPrimeiros(vota��o);
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
