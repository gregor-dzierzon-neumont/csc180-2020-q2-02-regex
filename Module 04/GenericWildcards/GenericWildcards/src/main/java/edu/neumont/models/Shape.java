package edu.neumont.models;

public abstract class Shape
{
    public abstract String getName();

    @Override
    public String toString()
    {
        return "I am a Shape.";
    }
}
