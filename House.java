package lab4;

public class House extends Player{

	public House(double money) {
		super(money);
		// TODO Auto-generated constructor stub
	}
	public void firstDraw(Card card){
		score += card.getPts();
	}

}
