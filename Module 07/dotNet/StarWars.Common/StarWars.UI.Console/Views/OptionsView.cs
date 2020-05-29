using System;
using System.Collections.Generic;

namespace StarWars.UI.Console.Views
{
    public class OptionsView: ViewBase
    {
        private List<string> options;
        private int? selection = null;

        public string SelectedOption
        {
            get
            {
                return options[selection.Value - 1];
            }
        }

        public OptionsView(List<string> options)
        {
            this.options = options;
        }

        public override void Display()
        {
            System.Console.WriteLine("Please select from the following: ");
            for (var i = 0; i < options.Count; i++)
            {
                System.Console.WriteLine($"   {i+1}) {options[i]}");
            }

            System.Console.Write("> ");
            selection = int.Parse(System.Console.ReadLine());
        }
    }
}