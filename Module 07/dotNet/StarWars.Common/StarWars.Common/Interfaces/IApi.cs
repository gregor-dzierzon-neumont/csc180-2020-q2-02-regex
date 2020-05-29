using System;
using System.Collections.Generic;
using StarWars.Common.Dtos;

namespace StarWars.Common.interfaces
{
    public interface IApi<T> where T: DtoBase
    {
        List<T> GetAll();
        List<T> GetPage(int pageNumber);
        List<T> GetPage(string url);
        T Get(string url);
        T Get(int id);
    }
}