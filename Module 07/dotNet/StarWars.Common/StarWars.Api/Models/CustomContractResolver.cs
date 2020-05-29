using System.Collections.Generic;
using Newtonsoft.Json.Serialization;

namespace StarWars.Api.Models
{
    public class CustomContractResolver: DefaultContractResolver
    {
        private Dictionary<string, string> PropertyMappings { get; set; }
        public CustomContractResolver()
        {
            this.PropertyMappings = new Dictionary<string, string>
                                    {
                                        {"HairColor", "hair_color"},
                                        {"EyeColor", "eye_color"},
                                        {"SkinColor", "skin_color"},
                                        {"BirthYear", "birth_year"},
                                    };
        }

        protected override string ResolvePropertyName(string propertyName)
        {
            var resolved = this.PropertyMappings.TryGetValue(propertyName, out var resolvedName);
            return (resolved) ? resolvedName : base.ResolvePropertyName(propertyName);
        }
    }
}