import java.util.Scanner;

/*
David Souza Rodrigues, Nº USP 4461180
Edilson Bunicenha Junior, Nº USP 9762935
Otávio Luis de Aguiar, Nº USP 9293518
Oton Papa, Nº USP 9292883
 */

public class Main {

	public static void main(String[] args) throws Exception {
		Board board = new Board();
		board.print();
        System.out.println("Aperte enter para a próxima geração.");
        System.out.println("Digite \"sair\" para encerrar o programa.");
		Scanner keyboard = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            String input = keyboard.nextLine();
            if ("sair".equals(input))
            	exit = true;
            else
            	board.nextBoardState().print();
        }
        keyboard.close();
	}
}
