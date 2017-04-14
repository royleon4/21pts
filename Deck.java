package lab4;
import java.util.Random;
import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> cards;Random random_num;
	public Deck(long seed, String lang){
		cards = new ArrayList<Card>();random_num = new Random(seed);
		if(lang.equals("ch")){
		String[] suits = new String[] {"方塊", "梅花", "紅心", "黑桃"};
		for(String suit : suits){
			for (int i=1;i<14;i++){Card c = new Card(suit, i);cards.add(c);}}}
	else{String[] suits = new String[] {"Diamond", "Club", "Heart", "Spades"};
	for(String suit : suits){
		for (int i=1;i<14;i++){Card c = new Card(suit, i);cards.add(c);}}}}

	public Card draw(){		
		if(cards.size()==0){return null;}else{
			int random = random_num.nextInt(cards.size());
			Card card = cards.get(random);
			cards.remove(random);return card;}}
	public int cardCount(){
		int number = 0;
		for(Card card : cards){number++;}
		return number;}
}
