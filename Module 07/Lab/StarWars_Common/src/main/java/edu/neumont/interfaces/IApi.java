package edu.neumont.interfaces;

import edu.neumont.dtos.DtoBase;

import java.util.List;

public interface IApi<T extends DtoBase>
{
    List<T> getAll(String url);
    List<T> getPage(String url);
    List<T> get(String url);
}
