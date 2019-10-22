package lab03FranciclaudioDantas;

import java.util.Scanner;

public class Menu {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Controlador ctrl = new Controlador();
		String opcao;
	
		do {
			System.out.println("(C)adastrar Contato");
			System.out.println("(L)istar Contatos");
			System.out.println("(E)xibir Contato");
			System.out.println("(S)air\n");
			System.out.print("Opção> ");
			opcao = sc.nextLine();
			System.out.print("\n");
			
			System.out.println(ctrl.leOpcao(opcao));
			
		} while (!opcao.equals("S"));
		
		sc.close();
	}
}
