package model.janken3;

public class Judgment {

	public void jadg(int player, int computer, Janken janken) {
		String result = null;

//		あいこ
		if(player == computer) {
			result = "あいこ！";
			janken.setDrawcount(janken.getDrawcount() + 1);
		} else {

	//		グーを選んだ時
			if(player == 0) {
				if(computer == 1) {
					result = "WIN!";
					janken.setWincount(janken.getWincount() + 1);
				} else if(computer == 2) {
					result = "Lose…";
					janken.setLosecount(janken.getLosecount() + 1);
				}
			}

	//		チョキを選んだ時
			if(player == 1) {
				if(computer == 2) {
					result = "WIN!";
					janken.setWincount(janken.getWincount() + 1);
				} else if(computer == 0)  {
					result = "Lose…";
					janken.setLosecount(janken.getLosecount() + 1);
				}
			}

	//		パーを選んだ時
			if(player == 2) {
				if(computer == 0) {
					result = "WIN!";
					janken.setWincount(janken.getWincount() + 1);
				} else if(computer == 1) {
					result = "Lose…";
					janken.setLosecount(janken.getLosecount() + 1);
				}
			}
		}

		janken.setResult(result);

	}
}
