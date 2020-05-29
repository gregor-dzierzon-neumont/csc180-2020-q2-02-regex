using System;
using System.Collections.Generic;

namespace StarWars.Common.Dtos
{
    public class Planet
    {
        public string RotationPeriod { get; set; }
        public string OrbitalPeriod { get; set; }
        public string Diameter { get; set; }
        public string Climate { get; set; }
        public string Gravity { get; set; }
        public string Terrain { get; set; }
        public string SurfaceWater { get; set; }
        public string Population { get; set; }
        public List<string> Residents { get; set; }
        public List<string> Films { get; set; }
    }
}