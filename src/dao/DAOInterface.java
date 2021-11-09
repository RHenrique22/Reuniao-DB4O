package dao;

import java.util.List;

public interface DAOInterface<T> {
    public void create(T object);
    public T read(Object chave);
    public T update(T object);
    public void delete(T object);
    public List<T> readAll();
    public void deleteAll();
}
