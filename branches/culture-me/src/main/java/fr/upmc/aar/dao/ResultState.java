package fr.upmc.aar.dao;

public class ResultState<Concern> {
	private boolean state;
	
	private Concern content;

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Concern getContent() {
		return content;
	}

	public void setContent(Concern content) {
		this.content = content;
	}
	
	

}
