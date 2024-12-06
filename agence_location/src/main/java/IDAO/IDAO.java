package IDAO;

public interface IDAO<x> {
	
	boolean insertUser(x o) throws ClassNotFoundException;
	boolean update(x o) throws ClassNotFoundException;
	boolean delete(x o) throws ClassNotFoundException;
	x selectAll(x o) throws ClassNotFoundException;
	x selectById(int o) throws ClassNotFoundException;
	
}
