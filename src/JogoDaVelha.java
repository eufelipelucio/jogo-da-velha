import java.util.Scanner;

public class JogoDaVelha {
	public static void main(String[] args) {
		startGame();
	}

	static void startGame(){
		String[][] oldGame = new String[3][3];
		setPosition(oldGame);
		showGame(oldGame);	
		String[] positions = new String[9];
		String player = "X";
		
		boolean toPlay = true;
		int attempt = 0;
		int aux = 0;
		
		while(toPlay) {
			System.out.println("O jogador " + player + " , Escolha uma linha: ");
			int linha = new Scanner(System.in).nextInt();
			
			System.out.println("O jogador " + player + " , Escolha uma coluna: ");
			int coluna = new Scanner(System.in).nextInt();
			
			if(!oldGame[linha][coluna].equals("_")) {
				System.out.println("Local já escolhido. Tente novamente!");
				continue;
			};
			
			oldGame[linha][coluna] = player;
			attempt++;
			showGame(oldGame);
			toPlay = checkChances(attempt,oldGame, player);
			player  = player.equals("X") ? "O" : "X";
				
		}
		
	}	
	
	static boolean checkPosition(String[][] arr,String position) {
		for (int line = 0; line < 3; line++) {
			for (int column = 0; column < 3; column++) {
				if (arr[column][line].equalsIgnoreCase(position)) {
					return true;
				}
			}
		}
		return false;
	}
		
	
	static boolean checkChances(int chances,String[][] winner, String player) {
		if(chances == 9) {
			System.out.println("Ninguem Ganhou!");
		}
		if(checkWinner(winner)){
			System.out.println("--> O Player " + player + " ganhou!!!");
			return false;
		}
		return true;
		
	}


	static boolean checkWinner(String[][] slots) {
		
		if((slots[0][0] == slots[0][1]) && (slots[0][1] == slots[0][2]) &&!(slots[0][2].equals("_"))) {
			return true;
		};
		if((slots[0][0] == slots[1][0]) && (slots[1][0] == slots[2][0]) &&!(slots[2][0].equals("_"))) {
			return true;
		};
		if((slots[0][0] == slots[1][1]) && (slots[1][1] == slots[2][2]) &&!(slots[2][2].equals("_"))) {
			return true;
		};
		if((slots[1][0] == slots[1][1]) && (slots[1][1] == slots[1][2]) &&!(slots[1][2].equals("_"))) {
			return true;
		};
		if((slots[2][0] == slots[2][1]) && (slots[2][1] == slots[2][2]) &&!(slots[2][2].equals("_"))) {
			return true;
		};
		if((slots[0][1] == slots[1][1]) && (slots[1][1] == slots[2][1]) &&!(slots[2][1].equals("_"))) {
			return true;
		};
		if((slots[0][2] == slots[1][2]) && (slots[1][2] == slots[2][2]) &&!(slots[2][2].equals("_"))) {
			return true;
		};
		if((slots[0][2] == slots[1][1]) && (slots[1][1] == slots[2][0]) &&!(slots[2][0].equals("_"))) {
			return true;
		};
	
		return false;
		
	}


	static String[][] setPosition(String[][] arr) {
		for (int line = 0; line < 3; line++) {
			for(int column = 0; column < 3; column++) {
				arr[line][column] = "_";
			}
		}
		return arr;
	}
	
	
	static void showGame(String[][] slots) {
		for (int line = 0; line < slots.length; line++) {
			for(int column = 0; column < slots[line].length; column++) { 
				System.out.print(slots[line][column] + " " );
			}
			System.out.println();
		}
	}
	
	
	
	
	
	
	
	
}
