package edu.neumont.dtos;

import java.beans.JavaBean;
import java.util.List;

@JavaBean
public class Planet extends DtoBase
{
    String rotation_period;
    String orbital_period;
    String diameter;
    String climate;
    String gravity;
    String terrain;
    String surface_water;
    String population;
    List<String> residents;

}
