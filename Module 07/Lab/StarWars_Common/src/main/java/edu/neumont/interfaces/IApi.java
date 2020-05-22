package edu.neumont.interfaces;

import edu.neumont.dtos.DtoBase;

import java.util.List;

public interface IApi<T extends DtoBase>
{
    List<T> getAll();
    List<T> getPage(String url);
    T get(String url);
}
