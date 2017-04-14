package lab4;

public class Player {
	private double cash;
	private double bet=0.0;
	protected int score;
	boolean is_stand=false;
	
	public Player(double money){cash = money;}
	public double bet(){return bet;}
	public void bet(double amount){
		
		bet += amount;cash -= amount;
	}
	public void hit(Card card){
		switch(card.getPts()){
		case 1:
			if(score+11>21){score += 1;
			}else{score += 11;}break;
		default: 
				score += card.getPts();}}
	public void doubleDown(Card card){
		cash -= bet;bet += bet;
		switch(card.getPts()){
		case 1:
			if(score+11>21){score += 1;
			}else{score += 11;}break;
		default: 
				score += card.getPts();}}
	public void stand(){is_stand=true;}
	public boolean isStanding(){
		if(is_stand){return true;}
		if(score > 21){is_stand = true;return true;}return false;}
	public void win(){
		cash += (bet)*2;is_stand = false;
		score = 0;bet = 0;}
	public void lose(){
		is_stand=false;
		score = 0;bet = 0;}
	public int score(){
		return score;}
	public double cash(){
		return cash;}
	public void fair(){
		cash += bet;is_stand=false;
		score = 0;bet = 0;}
}
