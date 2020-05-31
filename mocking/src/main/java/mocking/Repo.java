package mocking;

public class Repo {

	public Dao getDao() {
		return new Dao("one", 1);
	}
	
}
