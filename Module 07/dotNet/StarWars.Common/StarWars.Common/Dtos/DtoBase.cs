using System;

namespace StarWars.Common.Dtos
{
    public class DtoBase
    {
        public string Url { get; set; }
        public string Name { get; set; }
        public string Created { get; set; }
        public string Edited { get; set; }

        public int Id
        {
            get
            {
                var urlParts = Url.Split('/');
                var id = urlParts[urlParts.Length - 2];
                return int.Parse(id);
            }
        }
    }
}