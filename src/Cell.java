
public class Cell {

private boolean state; //true is alive; false is dead;

public Cell(boolean initialState){
	state = initialState;
}

public Cell(){
	this(false);
}

public void setAlive(){
	state = true;
}

public void setDead(){
	state = false;
}

public void setState(boolean newState){
	state = newState;
}
public boolean getState(){
	return state;
}
}
