import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
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
