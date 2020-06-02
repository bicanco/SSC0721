import java.util.Scanner;

/*
David Souza Rodrigues, N� USP 4461180
Edilson Bunicenha Junior, N� USP 9762935
Ot�vio Luis de Aguiar, N� USP 9293518
Oton Papa, N� USP 9292883
 */

public class Main {

	public static void main(String[] args) throws Exception {
		Board board = new Board();
		board.print();
        System.out.println("Aperte enter para a pr�xima gera��o.");
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
