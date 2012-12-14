package tapestry.liferay.portlets.data.Celebrity;

import java.util.List;



public interface IDataSource {
	public List<Celebrity> getAllCelebrities();
    public Celebrity getCelebrityById(long id);
    public void addCelebrity(Celebrity c);
    public List<Celebrity> getRange(int indexFrom, int indexTo);
}
