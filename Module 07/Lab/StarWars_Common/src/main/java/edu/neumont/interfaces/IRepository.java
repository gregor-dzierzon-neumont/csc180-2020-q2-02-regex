package edu.neumont.interfaces;


import edu.neumont.dtos.DtoBase;

import java.util.List;

public interface IRepository<T extends DtoBase>
{
    List<T> get();
    T get(String id);
    void save(T target);
    void update(String id, T target);
    void delete(String id);
}
