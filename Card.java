package lab4;

public class Card {
	private String the_suit;
	private int num;	
	public Card (String suit, int number){the_suit = suit;num = number;}
	public String getSuit(){return the_suit;}
	public int getPts(){
		switch(num){
		case 11 :
		case 12 :
		case 13 :return 10;
		default: return num;}}
	
	public String getNumber(String lang){
		if(lang.equals("ch")){switch(num){
		case 1:return "A";
		case 11:return "J";
		case 12:return "Q";
		case 13:return "K";
		default: return Integer.toString(num);}}else{
		switch(num){
		case 1:return "Ace";
		case 11:return "Jack";
		case 12:return "Queen";
		case 13:return "King";
		default: return Integer.toString(num);}}}
	public String toString(){return String.format("A %s card with value %d.", the_suit, num);}
}
