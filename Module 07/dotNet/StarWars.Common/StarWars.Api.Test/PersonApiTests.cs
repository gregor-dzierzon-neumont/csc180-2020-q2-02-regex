using Microsoft.VisualStudio.TestTools.UnitTesting;

using FluentAssertions;

namespace StarWars.Api.Test
{
    [TestClass]
    public class PersonApiTests
    {
        [TestMethod]
        public void should_get_all_people()
        {
            //arrange
            var api = new PersonApi();

            //act
            var people = api.GetAll();

            //assert
            people.Should().HaveCount(82, "because the api states that there are 82 people.");
        }

        [TestMethod]
        public void should_get_page_by_url()
        {
            //arrange
            var api = new PersonApi();

            //act
            var people = api.GetPage("https://swapi.dev/api/people/?page=2");

            //assert
            people.Should().HaveCount(10, "because each page should have 10 people.");
        }

        [TestMethod]
        public void should_get_last_page_by_url()
        {
            //arrange
            var api = new PersonApi();

            //act
            var people = api.GetPage("https://swapi.dev/api/people/?page=9");

            //assert
            people.Should().HaveCount(2, "because the last page should only have 2 people.");
        }

        [TestMethod]
        public void should_get_empty_page()
        {
            //arrange
            var api = new PersonApi();

            //act
            var people = api.GetPage("https://swapi.dev/api/people/?page=10");

            //assert
            people.Should().HaveCount(0, "because there should not be a page 10.");
        }

        [TestMethod]
        public void should_get_page_by_page_number()
        {
            //arrange
            var api = new PersonApi();

            //act
            var people = api.GetPage(2);

            //assert
            people.Should().HaveCount(10, "because page 2 should have 10 people.");
            people[0].Name.Should().Be("Anakin Skywalker", "because that is the first person of page 2.");
        }

        [TestMethod]
        public void should_get_person_by_url()
        {
            //arrange
            var api = new PersonApi();

            //act
            var person = api.Get("https://swapi.dev/api/people/1/");

            //assert
            person.Should().NotBeNull();
            person.Name.Should().Be("Luke Skywalker");

        }

        [TestMethod]
        public void should_get_person_by_id()
        {
            //arrange
            var api = new PersonApi();

            //act
            var person = api.Get(1);

            //assert
            person.Should().NotBeNull();
            person.Name.Should().Be("Luke Skywalker");

        }
    }
}