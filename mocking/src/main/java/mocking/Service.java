package mocking;

public class Service {

	private Repo repo;

	public boolean test() {
		if(repo.getDao() != null)
			return true;
		else 
			return false;
	}
	
	public void setRepo(Repo repo) {
		this.repo = repo;
	}

}
