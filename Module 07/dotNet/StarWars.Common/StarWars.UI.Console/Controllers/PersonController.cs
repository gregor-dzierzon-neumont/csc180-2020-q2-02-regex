using StarWars.Api;
using StarWars.Common.Dtos;
using StarWars.UI.Console.Views;
using StarWars.UI.Console.Views.People;

namespace StarWars.UI.Console.Controllers
{
    public class PersonController
    {
        private PersonApi personApi;

        public PersonController(PersonApi personApi)
        {
            this.personApi = personApi;
        }

        public Person ListPeople()
        {
            var people = personApi.GetPage(2);
            PersonListView view = new PersonListView(people);
            view.Display();

            return view.SelectedPerson;
        }

        public void Details(Person person)
        {
            PersonDetailView view = new PersonDetailView(person);
            view.Display();
        }
    }
}