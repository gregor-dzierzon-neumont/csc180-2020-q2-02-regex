using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Net.Http.Headers;
using Newtonsoft.Json;
using StarWars.Api.Models;
using StarWars.Common.Dtos;
using StarWars.Common.interfaces;

namespace StarWars.Api
{
    public abstract class ApiBase<T>: IApi<T> where T: DtoBase
    {
        protected const string BaseUrl = "https://swapi.dev/api/";

        public abstract List<T> GetAll();
        public abstract List<T> GetPage(int pageNumber);
        public abstract List<T> GetPage(string url);
        public abstract T Get(string url);
        public abstract T Get(int id);

        protected SwapiPageResponse<T> GetPageResponse(String url)
        {
            var responseString = CallApi(url);

            if (responseString != null)
            {
                var settings = new JsonSerializerSettings
                               {
                                   ContractResolver = new CustomContractResolver()
                               };

                return JsonConvert.DeserializeObject<SwapiPageResponse<T>>(responseString, settings);
            }

            var response = (SwapiPageResponse<T>) Activator.CreateInstance(typeof(SwapiPageResponse<T>));
            return response;
        }

        protected T GetItemResponse(String url)
        {
            var responseString = CallApi(url);

            var settings = new JsonSerializerSettings
                           {
                               ContractResolver = new CustomContractResolver()
                           };

            if (responseString != null)
            {
                return JsonConvert.DeserializeObject<T>(responseString, settings);
            }

            return null;
        }


        protected string CallApi(string url)
        {
            var client = new HttpClient();
            client.BaseAddress = new Uri(url);

            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

            var response = client.GetAsync(url).Result;

            return response.IsSuccessStatusCode ? response.Content.ReadAsStringAsync().Result : null;
        }
    }
}