using StarWars.Common.Dtos;

namespace StarWars.UI.Console.Views.People
{
    public class PersonDetailView: ViewBase
    {
        private Person person;

        public PersonDetailView(Person person)
        {
            this.person = person;
        }

        public override void Display()
        {
            System.Console.WriteLine("**********************");
            System.Console.WriteLine("*** Person Details ***");
            System.Console.WriteLine("**********************");
            System.Console.WriteLine();
            System.Console.WriteLine($"Name: {person.Name}");
            System.Console.WriteLine($"Hair: {person.HairColor}");
            System.Console.WriteLine($"Eyes: {person.EyeColor}");
            System.Console.WriteLine($"Skin: {person.SkinColor}");
            System.Console.WriteLine($"Home World: {person.HomeWorld}");
        }
    }
}