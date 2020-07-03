package model.janken3;

public class Janken {
	private String playerHand;
	private String computerHand;
	private String result;
	private int wincount;
	private int losecount;
	private int drawcount;

	public String getPlayerHand() {
		return playerHand;
	}
	public void setPlayerHand(String playerHand) {
		this.playerHand = playerHand;
	}
	public String getComputerHand() {
		return computerHand;
	}
	public void setComputerHand(String computerHand) {
		this.computerHand = computerHand;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getWincount() {
		return wincount;
	}
	public void setWincount(int wincount) {
		this.wincount = wincount;
	}
	public int getLosecount() {
		return losecount;
	}
	public void setLosecount(int losecount) {
		this.losecount = losecount;
	}
	public int getDrawcount() {
		return drawcount;
	}
	public void setDrawcount(int drawcount) {
		this.drawcount = drawcount;
	}



}
