package application;

    
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class Game {

	static class Pair{
		int first, second;
		int pick=0;
		public String toString(){
			return "(" + first + "," + second + ")";
		}
	}
	public Pair[][] findMoves(int pots[]){

		Pair[][] moves = new Pair[pots.length][pots.length];

		for(int i=0; i < moves.length; i++){
			for(int j=0; j < moves[i].length; j++){
				moves[i][j] = new Pair();
			}
		}

		for(int i=0; i < pots.length; i++){
			moves[i][i].first = pots[i];
			//to track the sequence of moves
			moves[i][i].pick = i;
		}

		for(int l = 2; l <= pots.length; l++){
			for(int i=0; i <= pots.length - l; i++){
				int j = i + l -1;
				if(pots[i] + moves[i+1][j].second > moves[i][j-1].second + pots[j]){
					moves[i][j].first = pots[i] + moves[i+1][j].second;
					moves[i][j].second = moves[i+1][j].first;
					moves[i][j].pick = i;
				}else{
					moves[i][j].first = pots[j] + moves[i][j-1].second;
					moves[i][j].second = moves[i][j-1].first;
					moves[i][j].pick =j;
				}
			}
		}

		for (int k = 0; k < moves.length; k++) {
			for (int k2 = 0; k2 < moves[k].length; k2++) {
				Label l = new Label(moves[k][k2] + "");
				l.setPadding(new Insets(10));
				l.setTextFill(Color.web("#BFC45A"));
				l.setStyle("-fx-font-size: 18;\n");
				Main.grid.add(l, k2, k);
			}
		}

		return moves;
	}

	//prints the sequence of values and indexes
	public int [] printSequence(int pots[], Pair moves[][]){
		int a [] = new int [pots.length];
		int i = 0;
		int j = pots.length - 1;
		int step;
		for (int k = 0; k < pots.length; k++) {
			step = moves[i][j].pick;
			a[k] = pots[step];
			if (step <= i) {
				i = i + 1;
			} else {
				j = j - 1;
			}
		}
		return a;
	}
/*	public static void main(String args[]){
		Game npg = new Game();
		int pots[] = {20,30,2,1,3,10};
		Pair[][] moves = npg.findMoves(pots);
		for(int i=0; i < moves.length; i++){
			for(int j=0; j < moves[i].length; j++){
				System.out.print("(" + moves[i][j] + ")" + "     ");
			}
			System.out.print("\n");
		}
		System.out.println("The moves by first player and second player:");
		npg.printSequence(pots, moves);
	}*/
}


    
