using System.Collections.Generic;
using System.Linq;
using StarWars.Common.Dtos;

namespace StarWars.UI.Console.Views.People
{
    public class PersonListView: ViewBase
    {
        private List<Person> people;
        public Person SelectedPerson { get; private set; }

        public PersonListView(List<Person> people)
        {
            this.people = people;
        }

        public override void Display()
        {
            foreach (var person in people)
            {
                System.Console.WriteLine($"{person.Id,-5} {person.Name}");
            }

            System.Console.WriteLine();
            System.Console.Write("Select a character: ");
            int id = int.Parse(System.Console.ReadLine());

            SelectedPerson = people.FirstOrDefault(p => p.Id == id);
        }
    }
}