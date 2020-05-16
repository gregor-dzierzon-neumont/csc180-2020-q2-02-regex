package edu.neumont;

public interface ISerializable
{
    String serialize();
    void deserialize(String content);
}
