using System.Collections.Generic;
using StarWars.Common.Dtos;

namespace StarWars.Api.Models
{
    public class SwapiPageResponse<T> where T: DtoBase
    {
        public string Count { get; set; }
        public string Next { get; set; }
        public string Previous { get; set; }
        public List<T> Results { get; set; }

        public SwapiPageResponse()
        {
            Results = new List<T>();
        }
    }
}