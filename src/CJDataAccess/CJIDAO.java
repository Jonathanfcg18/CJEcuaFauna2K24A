package CJDataAccess;

import java.util.List;

public interface CJIDAO<T> {
    public boolean cjCreate(T entity)     throws Exception;
    public List<T> cjReadAll()            throws Exception;
    public boolean cjUpdate(T entity)     throws Exception;
    public boolean cjDelete(int id)       throws Exception;
    public T cjReadBy(Integer id)         throws Exception;
}
