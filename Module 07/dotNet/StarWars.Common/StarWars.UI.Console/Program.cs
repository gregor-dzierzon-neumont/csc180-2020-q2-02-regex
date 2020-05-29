using System;
using System.Collections.Generic;
using System.Net;
using StarWars.Api;
using StarWars.UI.Console.Controllers;

namespace StarWars.UI.Console
{
    class Program
    {
        private PersonApi personApi;

        public Program()
        {
            personApi = new PersonApi();
        }

        static void Main(string[] args)
        {
            var program = new Program();
            program.Run();

        }

        public void Run()
        {
            var personController = new PersonController(personApi);
            var person = personController.ListPeople();

            personController.Details(person);

        }
    }
}
