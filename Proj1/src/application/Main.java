package application;

import java.awt.event.ActionEvent;
import javafx.event.Event.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.time.Duration;
import java.util.*;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.css.Size;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application implements EventHandler{
	Game g = new Game();
	HBox vll = new HBox();
	ScrollPane scrollLeft = new ScrollPane();
	Button player1 = new Button ();
	Button player2 = new Button ();
	TextField  txtcoins= new TextField ();
	HBox h = new HBox();
	HBox vrr = new HBox();
	int [] rescoins = null;
	ScrollPane scrollRight = new ScrollPane();
	static GridPane grid = new GridPane();
	@Override
	public void start(Stage primaryStage) {
		try {


			grid.setStyle("-fx-background: transparent; -fx-background-color: transparent;"); 
			grid.setAlignment(Pos.BASELINE_CENTER);
			Image test = new Image ("players2.jpg");
			BackgroundImage bImg = new BackgroundImage (test,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
			Background bground = new Background (bImg);

			Image test2 = new Image ("players1.png");
			BackgroundImage bImg2 = new BackgroundImage (test2,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
			Background bground2 = new Background (bImg2);

			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,1538,788);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			root.setBackground(bground);

			Button startGame = new Button ();
			//	startGame.setStyle("-fx-font-family: tekton;");
			startGame.setFont(Font.font(54));
			startGame.setStyle("-fx-background: transparent; -fx-background-color: transparent;"); 
			//startGame.setBorder(Border.stroke(Color.web("#BFC45A")));
			startGame.setTextFill(Color.web("#BFC45A"));
			/*startGame.setStyle("-fx-background-color: transparent;");
			startGame.setStyle("-fx-text-fill: #828282;");
			startGame.setStyle("-fx-border-color: transparent, black;");
			startGame.setStyle("-fx-text-fill: #828282;");
			startGame.setStyle("-fx-text-fill: #828282;");*/
			startGame.setText("    Start " + "\n" + "The Game");
			startGame.setAlignment(Pos.BASELINE_CENTER);
			root.setCenter(startGame);
			Button bnum = new Button ("Confirm");
			Button bcoins = new Button ("Confirm");
			TextField txtnum = new TextField ();
			VBox vnum = new VBox();
			startGame.setOnAction(e ->{
				root.setBackground(bground2);

				Label lnum = new Label ("Please enter the number of coins:");
				lnum.setTextFill(Color.web("#BFC45A"));
				lnum.setFont(Font.font(25));

				txtnum.setFont(Font.font(22));
				txtnum.setMaxWidth(350);
				txtnum.setPrefHeight(20);
				txtnum.setStyle("-fx-background: transparent; -fx-background-color: transparent;"); 
				txtnum.setBorder(Border.stroke(Color.web("#BFC45A")));
				txtnum.setStyle("-fx-text-fill: #BFC45A;");
				bnum.setFont(Font.font(25));
				bnum.setStyle("-fx-background: transparent; -fx-background-color: transparent;"); 
				bnum.setBorder(Border.stroke(Color.web("#BFC45A")));
				bnum.setTextFill(Color.web("#BFC45A"));
				bnum.setAlignment(Pos.CENTER);
				vnum.getChildren().addAll(lnum,txtnum,bnum);
				vnum.setPadding(new Insets (300,100,100,100));
				vnum.setSpacing(10);
				vnum.setAlignment(Pos.BASELINE_CENTER);
				root.setCenter(vnum);

				txtnum.setOnKeyReleased(l ->{
					if (Integer.parseInt(txtnum.getText()) % 2 != 0) {
						Alert evenodd = new Alert(AlertType.ERROR);
						evenodd.setContentText("The number of coins must be even");
						Optional <ButtonType> result = evenodd.showAndWait();
						if (result.isPresent() && result.get() == ButtonType.OK) {
							root.setCenter(vnum);
							txtnum.clear();
						}
					}

				});

			});	



			VBox vcoins = new VBox();

			bnum.setOnAction(n -> {


				Label lcoins = new Label ("Please enter the coins separated by comas:");
				lcoins.setTextFill(Color.web("#BFC45A"));
				lcoins.setFont(Font.font(25));
				txtcoins.setPromptText("1,2,3,4,5,...");
				txtcoins.setFont(Font.font(22));
				txtcoins.setMaxWidth(350);
				txtcoins.setPrefHeight(20);
				txtcoins.setStyle("-fx-background: transparent; -fx-background-color: transparent;"); 
				txtcoins.setBorder(Border.stroke(Color.web("#BFC45A")));
				txtcoins.setStyle("-fx-text-fill: #BFC45A;");
				bcoins.setFont(Font.font(25));
				bcoins.setStyle("-fx-background: transparent; -fx-background-color: transparent;"); 
				bcoins.setBorder(Border.stroke(Color.web("#BFC45A")));
				bcoins.setTextFill(Color.web("#BFC45A"));

				bcoins.setFont(Font.font(25));
				bcoins.setAlignment(Pos.CENTER);
				vcoins.getChildren().addAll(lcoins,txtcoins,bcoins);
				vcoins.setPadding(new Insets (300,100,100,100));
				vcoins.setSpacing(10);
				vcoins.setAlignment(Pos.BASELINE_CENTER);
				root.setCenter(vcoins);

				txtcoins.setOnKeyReleased(l ->{
					if (txtcoins.getText().contains(".")||txtcoins.getText().contains("^[a-zA-Z]+$")||txtcoins.getText().contains("-")) {
						Alert dot = new Alert(AlertType.ERROR);
						dot.setContentText("Please make sure you entered the coins as 1,2,3,4,..");
						Optional <ButtonType> result = dot.showAndWait();
						if (result.isPresent() && result.get() == ButtonType.OK) {
							root.setCenter(vcoins);
							txtcoins.clear();

						}
					}
				});

			

			});


			HBox playoneh = new HBox ();

			scrollRight.setStyle("-fx-background: transparent; -fx-background-color: transparent; "); 
			//scrollRight.setMaxWidth(200);
			//scrollRight.setMaxHeight(100);
			HBox hbr = new HBox ();
			hbr.getChildren().add(scrollRight);
			//hbr.setPadding(new Insets (500,100,0,0));
			hbr.setMaxHeight(100);
			hbr.setMaxWidth(200);
			hbr.setPrefHeight(100);
			hbr.setPrefWidth(200);


			HBox playtwoh = new HBox ();

			scrollLeft.setStyle("-fx-background: transparent; -fx-background-color: transparent; "); 

			//scrollLeft.setMaxWidth(400);
			//scrollLeft.setMaxHeight(100);
			HBox hbl = new HBox ();
			hbl.setMaxHeight(100);
			hbl.setMaxWidth(200);
			hbl.setPrefHeight(100);
			hbl.setPrefWidth(200);
			hbl.getChildren().add(scrollLeft);
			//hbl.setPadding(new Insets (500,0,0,100));
			hbl.setMaxHeight(300);
			hbl.setMaxWidth(200);



			Button dp = new Button ("DP table");
			dp.setStyle("-fx-background: transparent; -fx-background-color: transparent;"); 
			dp.setBorder(Border.stroke(Color.web("#BFC45A")));
			dp.setTextFill(Color.web("#BFC45A"));
			Button exresult = new Button ("Scores");
			exresult.setStyle("-fx-background: transparent; -fx-background-color: transparent;"); 
			exresult.setBorder(Border.stroke(Color.web("#BFC45A")));
			exresult.setTextFill(Color.web("#BFC45A"));
			Button playersCoins = new Button ("Player's Coins");
			playersCoins.setStyle("-fx-background: transparent; -fx-background-color: transparent;"); 
			playersCoins.setBorder(Border.stroke(Color.web("#BFC45A")));
			playersCoins.setTextFill(Color.web("#BFC45A"));
			ScrollPane scroll = new ScrollPane();
			scroll.setMaxWidth(850);
			scroll.setMaxHeight(100);
			scroll.setPadding(new Insets (0,0,0,0));
			scroll.setStyle("-fx-background: transparent; -fx-background-color: transparent; "); 
			//scroll.isMouseTransparent();
			bcoins.setOnAction(e -> {


				String s = txtcoins.getText();
				String [] res = s.split(",");
				if (res.length > Integer.parseInt(txtnum.getText())) {
					Alert extra = new Alert(AlertType.ERROR);
					extra.setContentText("You have an extra coin/s");
					Optional <ButtonType> result = extra.showAndWait();
					if (result.isPresent() && result.get() == ButtonType.OK) {
						root.setCenter(vcoins);
						txtcoins.clear();
					}

				}
				else if (res.length < Integer.parseInt(txtnum.getText())) {
					Alert min = new Alert(AlertType.ERROR);
					min.setContentText("You have a missed coin/s");
					Optional <ButtonType> result = min.showAndWait();
					if (result.isPresent() && result.get() == ButtonType.OK) {
						root.setCenter(vcoins);
						txtcoins.clear();
					}
				}
				else {
					for (int i = 0; i < Integer.parseInt(txtnum.getText()) ; i++) {
						Image bgcoin = new Image ("coin.png");
						BackgroundImage bImg3 = new BackgroundImage (bgcoin,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
						Background bground3 = new Background (bImg3);
						Button coin = new Button();	
						coin.setStyle("-fx-background: transparent; -fx-background-color: transparent; "); 
						coin.setBorder(Border.stroke(Color.web("#BFC45A")));
						coin.setBackground(bground3);			
						h.getChildren().add(coin);
						scroll.setContent(h);
						h.setAlignment(Pos.CENTER);
						coin.setText(String.valueOf(res[i]));
						coin.setFont(Font.font(28));
						coin.setTextFill(Color.web("#BFC45A"));
						coin.setShape( new Circle (20, Color.ALICEBLUE));


					}

					dp.setPrefHeight(25);
					dp.setPrefWidth(150);
					dp.setFont(Font.font(24));
					dp.setDisable(true);
					exresult.setPrefHeight(25);
					exresult.setPrefWidth(140);
					exresult.setFont(Font.font(24));
					exresult.setDisable(true);
					playersCoins.setPrefHeight(25);
					playersCoins.setPrefWidth(180);
					playersCoins.setDisable(true);
					playersCoins.setFont(Font.font(24));
					player1.setStyle("-fx-background: transparent; -fx-background-color: transparent;"); 
					player1.setBorder(Border.stroke(Color.web("#BFC45A")));
					player1.setTextFill(Color.web("#BFC45A"));
					player2.setStyle("-fx-background: transparent; -fx-background-color: transparent;"); 
					player2.setBorder(Border.stroke(Color.web("#BFC45A")));
					player2.setTextFill(Color.web("#BFC45A"));
					player1.setText("Play 1");
					player1.setPrefHeight(25);
					player1.setPrefWidth(112);
					player1.setFont(Font.font(22));
					player2.setText("Play 2");
					player2.setPrefHeight(25);
					player2.setPrefWidth(112);
					player2.setFont(Font.font(22));
					playoneh.getChildren().addAll(player1,hbr);
					playtwoh.setSpacing(235);
					playoneh.setSpacing(235);
					playtwoh.getChildren().addAll(hbl,player2);
					HBox players = new HBox ();
					HBox ex = new HBox ();
					player2.setDisable(true);

					players.setPadding(new Insets (0,100,55,100));
					players.setSpacing(335);
					players.getChildren().addAll(playtwoh,playoneh);
					ex.getChildren().addAll(dp,exresult,playersCoins);
					ex.setPadding(new Insets (100,500,0,500));
					ex.setSpacing(30);

					h.setPadding(new Insets (3,320,0,280));
					h.setSpacing(10);
					h.setAlignment(Pos.BASELINE_CENTER);


					root.setTop(ex);
					root.setCenter(scroll);
					root.setBottom(players);


				}

			});

			ScrollPane scrollTop = new ScrollPane();

			scrollTop.setMaxWidth(418);
			scrollTop.setMaxHeight(390);
			scrollTop.setPadding(new Insets (0,0,0,0));


			scrollTop.setStyle("-fx-background: transparent; -fx-background-color: transparent; "); 

			dp.setOnAction(e -> {
				String s = txtcoins.getText();
				String [] res = s.split(",");
				int [] a =new int[res.length];
				for (int i = 0; i < res.length; i++) {
					a[i] = Integer.parseInt(res[i]);
				}
				g.findMoves(a);
				grid.setAlignment(Pos.BASELINE_LEFT);
				grid.setPadding(new Insets (10,0,0,20));
				scrollTop.setContent(grid);
				root.setCenter(scrollTop);
			});

			player1.setOnAction(l -> {
				try {

					player1.setDisable(true);
					player2.setDisable(false);
					String s = txtcoins.getText();
					String [] res = s.split(",");
					int [] a =new int[res.length];
					for (int i = 0; i < res.length; i++) {
						a[i] = Integer.parseInt(res[i]);
					}

					if(rescoins==null)
						rescoins = g.printSequence(a, g.findMoves(a));

					ArrayList<Integer> rescoinsList = new ArrayList<Integer>(rescoins.length);


					for (int k : rescoins)
					{
						rescoinsList.add(k);
					}

					for (int j = 0; j < rescoinsList.size(); j=j+2) {
						for (Node coin: h.getChildren()) {
							Button b = (Button)coin;
							if (String.valueOf(rescoinsList.get(j)).equals(b.getText())) {
								String st= b.getText();
								Button g = new Button ();
								g.setStyle("-fx-background: transparent; -fx-background-color: transparent;");
								g.setBorder(Border.stroke(Color.web("#BFC45A")));
								g.setFont(Font.font(28));
								g.setTextFill(Color.web("#BFC45A"));
								g.setShape( new Circle (12));
								g.setText(st);
								vrr.getChildren().add(g);
								vrr.setSpacing(3);
								scrollRight.setContent(vrr);
								//root.setRight(hbr);
								rescoinsList.remove(j);
								b.setVisible(false);
								h.getChildren().remove(b);
								if (h.getChildren().isEmpty()) {
									player1.setDisable(true);
									player2.setDisable(true);
									exresult.setDisable(false);
									playersCoins.setDisable(false);
									dp.setDisable(false);
									Label l1 = new Label("The Game Has Ended !");
									l1.setTextFill(Color.web("#BFC45A"));
									l1.setFont(Font.font(24));
									root.setCenter(l1);

								}

							}
						}

					}


				}catch (ConcurrentModificationException e) {

				}

			});

			player2.setOnAction(l ->{
				try {


					player2.setDisable(true);
					player1.setDisable(false);
					String s = txtcoins.getText();
					String [] res = s.split(",");
					int [] a =new int[res.length];
					for (int i = 0; i < res.length; i++) {
						a[i] = Integer.parseInt(res[i]);
					}

					int [] rescoins = g.printSequence(a, g.findMoves(a));
					ArrayList<Integer> rescoinsList = new ArrayList<Integer>(rescoins.length);
					for (int k : rescoins)
					{
						rescoinsList.add(k);
					}

					for (int j = 1; j < rescoinsList.size(); j=j+2) {
						for (Node coin: h.getChildren()) {
							Button b = (Button)coin;
							if(b.isVisible()){
								if (String.valueOf(rescoinsList.get(j)).equals(b.getText())) {
									String st= b.getText();
									Button g = new Button ();
									g.setText(st);
									g.setStyle("-fx-background: transparent; -fx-background-color: transparent;");
									g.setBorder(Border.stroke(Color.web("#BFC45A")));
									g.setFont(Font.font(28));
									g.setTextFill(Color.web("#BFC45A"));
									g.setShape( new Circle (12));
									g.setText(st);
									vll.getChildren().add(g);
									vll.setSpacing(3);
									scrollLeft.setContent(vll);
									//root.setLeft(hbl);
									rescoinsList.remove(j);
									b.setVisible(false);
									h.getChildren().remove(b);
									if (h.getChildren().isEmpty()) {
										player1.setDisable(true);
										player2.setDisable(true);
										exresult.setDisable(false);
										playersCoins.setDisable(false);
										dp.setDisable(false);
										Label l1 = new Label("The Game Has Ended !");
										l1.setTextFill(Color.web("#BFC45A"));
										l1.setFont(Font.font(24));
										root.setCenter(l1);


									}
								}
							}

						}


					}
				}catch (ConcurrentModificationException e) {

				}
			});
			exresult.setOnAction(e ->{
				String s = txtcoins.getText();
				String [] res = s.split(",");
				int [] a =new int[res.length];
				for (int i = 0; i < res.length; i++) {
					a[i] = Integer.parseInt(res[i]);
				}
				int [] rescoins = g.printSequence(a, g.findMoves(a));
				ArrayList<Integer> rescoinsList = new ArrayList<Integer>(rescoins.length);	
				for (int k : rescoins)
				{
					rescoinsList.add(k);
				}
				int playerOneScore = 0;
				int playerTwoScore = 0;
				for (int i = 0; i < rescoinsList.size(); i=i+2) {
					playerOneScore = playerOneScore + rescoinsList.get(i);

				}
				for (int i = 1; i < rescoinsList.size(); i=i+2) {
					playerTwoScore = playerTwoScore + rescoinsList.get(i);

				}

				VBox v = new VBox();
				Label l1 = new Label("Player One's Score: " + playerOneScore);
				l1.setTextFill(Color.web("#BFC45A"));
				l1.setFont(Font.font(24));
				Label l2 = new Label("Player Two's Score: " + playerTwoScore );
				l2.setTextFill(Color.web("#BFC45A"));
				l2.setFont(Font.font(24));
				Label cong = new Label("Player One Won, CONGRATS !"+ "\n\n");
				cong.setTextFill(Color.web("#BFC45A"));
				cong.setFont(Font.font(24));
				v.setAlignment(Pos.BASELINE_CENTER);
				v.setSpacing(10);
				v.getChildren().addAll(l1,l2,cong);
				v.setPadding(new Insets (150,0,0,0));
				root.setCenter(v);
			});

			playersCoins.setOnAction(e -> {
				String s = txtcoins.getText();
				String [] res = s.split(",");
				int [] a =new int[res.length];
				for (int i = 0; i < res.length; i++) {
					a[i] = Integer.parseInt(res[i]);
				}
				int [] rescoins = g.printSequence(a, g.findMoves(a));
				ArrayList<Integer> rescoinsList = new ArrayList<Integer>(rescoins.length);	
				for (int k : rescoins)
				{
					rescoinsList.add(k);
				}
				int [] playerOneScore = new int [rescoinsList.size() / 2] ;

				int [] playerTwoScore = new int [rescoinsList.size() / 2] ;

				int j = 0;
				for (int i = 0; i < rescoinsList.size(); i=i+2) {

					playerOneScore[j]= rescoinsList.get(i); 
					j++;
				}

				int k = 0;
				for (int i = 1; i < rescoinsList.size(); i=i+2) {
					playerTwoScore[k]= rescoinsList.get(i); 
					k++;
				}

				String s1 = Arrays.toString(playerOneScore);
				String s2 = Arrays.toString(playerTwoScore);

				VBox v = new VBox();
				Label l1 = new Label("Player One's Coins: " + s1);
				l1.setTextFill(Color.web("#BFC45A"));
				l1.setFont(Font.font(24));
				Label l2 = new Label("Player Two's Coins: " + s2 );
				l2.setTextFill(Color.web("#BFC45A"));
				l2.setFont(Font.font(24));
				v.setAlignment(Pos.BASELINE_CENTER);
				v.setSpacing(10);
				v.getChildren().addAll(l1,l2);
				v.setPadding(new Insets (150,0,0,0));
				root.setCenter(v);


			});


		}	


		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void handle(Event event) {
		if(event.getSource().equals(player1)){

		}
		else if(event.getSource().equals(player2)){

		}
	}
}


