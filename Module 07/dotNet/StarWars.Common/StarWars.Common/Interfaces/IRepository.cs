using System;
using System.Collections.Generic;
using StarWars.Common.Dtos;

namespace StarWars.Common.interfaces
{
    public interface IRepository<T> where T: DtoBase
    {
        List<T> Get();
        T Get(string id);
        void Save(T target);
        void Update(string id, T target);
        void Delete(string id);
    }
}