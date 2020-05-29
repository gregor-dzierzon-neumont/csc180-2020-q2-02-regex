using System.Collections.Generic;
using System.Net.Http;
using Newtonsoft.Json;
using StarWars.Api.Models;
using StarWars.Common.Dtos;

namespace StarWars.Api
{
    public class PersonApi: ApiBase<Person>
    {
        private const string  Url = BaseUrl + "people/";


        public override List<Person> GetAll()
        {
            var people = new List<Person>();
            var url = Url;

            do
            {
                var response = GetPageResponse(url);
                people.AddRange(response.Results);
                url = response.Next;

            } while (url != null);


            return people;
        }

        public override List<Person> GetPage(string url)
        {
            var people = new List<Person>();

            var response = GetPageResponse(url);
            people.AddRange(response.Results);

            return people;
        }

        public override List<Person> GetPage(int pageNumber)
        {
            var url = $"{Url}?page={pageNumber}";
            return GetPage(url);
        }

        public override Person Get(string url)
        {
            return GetItemResponse(url);
        }

        public override Person Get(int id)
        {
            var url = $"{Url}{id}/";
            return Get(url);
        }
    }
}