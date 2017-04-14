package lab4;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
	private int number_of_players=1;
	private ArrayList<Player> players= new ArrayList<Player>();
	private House house=new House(100);
	private Scanner in = new Scanner(System.in);
	private String lang="en";
	
	public void chooseLanguage(){
		System.out.println("\nWhat's your preferred language?(en/ch)\n請選擇你的語言(en/ch)");
		lang=in.next();
		if(lang.equals("en")||lang.equals("ch")){}else{lang="en";}
	}
	public void Players(){
		if(lang.equals("ch")){System.out.println("一共有幾位玩家?");}else{
		   System.out.println("How many players?");}number_of_players = in.nextInt();
		   for(int i=0; i<number_of_players; i++){
			   Player player = new Player(100.0);
			   players.add(player);}}
	public void processGame(){
		if(lang.equals("ch")){System.out.println("目前資金:");for(int i=0; i<number_of_players; ++i){			
			   System.out.println(String.format("第%d個玩家有$%,.1f元", i+1, players.get(i).cash()));		   
		   }}else{System.out.println("Current assets:");
		for(int i=0; i<number_of_players; ++i){			
			   System.out.println(String.format("Player %d has cash $%,.1f", i+1, players.get(i).cash()));		   
		   }}System.out.println("");Random random = new Random();long seed = random.nextLong(); 
		   Deck deck = new Deck(seed, lang);house.firstDraw(deck.draw());house.firstDraw(deck.draw());
		   if(lang.equals("ch")){for(int i=0; i<number_of_players; ++i){
			   System.out.println(String.format("玩家%d，您要下注多少?(不可高於您的資金)", i+1));
			   double amount = in.nextDouble();
			   if(amount>players.get(i).cash()){System.out.println("不可高於您的資金！請再下注一次!\n");i--;}else{players.get(i).bet(amount);
			   players.get(i).hit(deck.draw());
			   players.get(i).hit(deck.draw());
			   }}}else{for(int i=0; i<number_of_players; ++i){
			   System.out.println(String.format("Player %d bets how much?", i+1));
			   double amount = in.nextDouble();
			   if(amount>players.get(i).cash()){System.out.println("Please enter a bet you can afford!\n");i--;}else{players.get(i).bet(amount);
			   players.get(i).hit(deck.draw());
			   players.get(i).hit(deck.draw());
			   }}}
		  boolean notes=true;
		  if(lang.equals("ch")){
			  while(notes==true){int i=0;int count=0;
		   for(i=0; i<number_of_players; i++){
			   if(players.get(i).isStanding()){
				   System.out.println(String.format("玩家 %d停止叫牌。目前分數: %d", i+1, players.get(i).score()));
			   }
			   if(players.get(i).isStanding()==false){
				   System.out.println(String.format("玩家 %d的回合。 目前分數: %d", i+1, players.get(i).score()));
				   System.out.println("請問您要叫牌(hit), 加倍賭注(double)還是停牌(stand)?");
				   String action = in.next();
				   switch(action){					   
					case "hit":
						Card suit_colour = deck.draw();
					   players.get(i).hit(suit_colour);
					   if(players.get(i).score()>21){players.get(i).stand();}
					   System.out.println(String.format("抽了一張%s%s. 目前點數: %d", suit_colour.getSuit(),suit_colour.getNumber(lang),players.get(i).score() ));break;
					case "double":
						Card suit_colour2 = deck.draw();
					   players.get(i).doubleDown(suit_colour2);
					   System.out.println(String.format("抽了一張%s%s. 目前點數: %d", suit_colour2.getSuit(),suit_colour2.getNumber(lang),players.get(i).score() ));
					   players.get(i).stand();
					   break;
					case "stand": players.get(i).stand();break;
						default:i--;System.out.println("喂喂喂， 看清楚，你指令打錯了!\n");
					}}}
		   for(int j=0; j<number_of_players; j++){if(players.get(j).isStanding()){count ++;}}if(count==number_of_players){notes = false;}}
	   System.out.println(String.format("莊家的回合， 莊家目前的點數:%d",house.score()));		   
	   while(house.score()<17){
		   Card card = deck.draw();house.hit(card);
		   System.out.println(String.format("抽了一張%s%s. 目前點數: %d", card.getSuit(), card.getNumber(lang), house.score()));
	   }
	   System.out.println("莊家停止叫牌");
	   if(house.score()>21){
		   for(int i=0; i<number_of_players; i++){
			   double bet = players.get(i).bet();
			   if(players.get(i).score()<=21){
				   players.get(i).win();
				   System.out.println(String.format("玩家 %d贏了$%,.1f! 目前資金: $%,.1f", i+1, bet,players.get(i).cash()));
			   }else{	   
				   players.get(i).fair();
				   System.out.println(String.format("玩家%d取回了賭注$%,.1f元， 目前資金: $%,.1f",i+1,bet,players.get(i).cash()));
			   }}
	   }else{			   
		   for(int i=0; i<number_of_players; i++){double bet = players.get(i).bet();
			   if(players.get(i).score()>house.score() & players.get(i).score()<=21){
				   players.get(i).win();
				   System.out.println(String.format("玩家 %d贏了$%,.1f! 目前資金: $%,.1f", i+1, bet,players.get(i).cash()));
			}else{players.get(i).lose();
				System.out.println(String.format("玩家%d輸了$%,.1f元! 目前資金: $%,.1f",i+1,bet,players.get(i).cash() ));
				}}}}else{
		   while(notes==true){int i=0;int count=0;
			   for(i=0; i<number_of_players; i++){
				   if(players.get(i).isStanding()){
					   System.out.println(String.format("Player %d standing. Current score: %d", i+1, players.get(i).score()));
				   }
				   if(players.get(i).isStanding()==false){
					   System.out.println(String.format("Player %d turn. Current score: %d", i+1, players.get(i).score()));
					   System.out.println("What action shall you take (hit, double, stand)?");
					   String action = in.next();
					   switch(action){					   
						case "hit":
							Card suit_colour = deck.draw();
						   players.get(i).hit(suit_colour);
						   if(players.get(i).score()>21){players.get(i).stand();}
						   System.out.println(String.format("Drew a %s of %s. New score: %d", suit_colour.getNumber(lang),suit_colour.getSuit(),players.get(i).score() ));break;
						case "double":
							Card suit_colour2 = deck.draw();
						   players.get(i).doubleDown(suit_colour2);
						   System.out.println(String.format("Drew a %s of %ss. New score: %d", suit_colour2.getNumber(lang),suit_colour2.getSuit(),players.get(i).score() ));
						   players.get(i).stand();
						   break;
						case "stand": players.get(i).stand();break;
							default:i--;System.out.println("Error!!! You need to enter a valid command!!!\n");
						}}}
			   for(int j=0; j<number_of_players; j++){if(players.get(j).isStanding()){count ++;}}if(count==number_of_players){notes = false;}}
		   System.out.println(String.format("House's turn. Current score: %d",house.score()));		   
		   while(house.score()<17){
			   Card card = deck.draw();house.hit(card);
			   System.out.println(String.format("Drew a %s of %ss. New score: %d", card.getNumber(lang), card.getSuit(), house.score()));
		   }
		   System.out.println("House stands.");
		   if(house.score()>21){
			   for(int i=0; i<number_of_players; i++){
				   double bet = players.get(i).bet();
				   if(players.get(i).score()<=21){
					   players.get(i).win();
					   System.out.println(String.format("Player %d won $%,.1f! Current Cash: $%,.1f", i+1, bet,players.get(i).cash()));
				   }else{	   
					   players.get(i).fair();
					   System.out.println(String.format("Player %d receives bet of $%,.1f back. Current Cash: $%,.1f",i+1,bet,players.get(i).cash()));
				   }}
		   }else{			   
			   for(int i=0; i<number_of_players; i++){double bet = players.get(i).bet();
				   if(players.get(i).score()>house.score() & players.get(i).score()<=21){
					   players.get(i).win();
					   System.out.println(String.format("Player %d won $%,.1f! Current Cash: $%,.1f", i+1, bet,players.get(i).cash()));
				}else{players.get(i).lose();
					System.out.println(String.format("Player %d lost $%,.1f! Current Cash: $%,.1f",i+1,bet,players.get(i).cash() ));
					}}}}house.fair();}
	public void reset(){players.clear();}
	
	   public static void main(String[] args) {
		   String defaultEncodingName = System.getProperty( "file.encoding" );
		   System.setProperty("file.encoding", "UTF-8");
		   Scanner in= new Scanner(System.in);int action=1;int count=0;
		   Game game=new Game();
		   while(action==1||action==2){
			   game.chooseLanguage();
			   if(action==1){if(count==0){game.Players();count++;}game.processGame();}
			   if(action==2){game.reset();game.Players();game.processGame();}
			   System.out.println("\nAnother run with current players:1, New game:2, Exit:3\n用目前的成員再開一局:1, 新遊戲:2, 離開:3");
			   action = in.nextInt();}}
	   }
