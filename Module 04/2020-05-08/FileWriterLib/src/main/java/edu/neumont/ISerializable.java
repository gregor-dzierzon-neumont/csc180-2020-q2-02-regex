package edu.neumont;

public interface ISerializable<T>
{
    String serialize();

    //I changed the definition of deserialize
    // it does not return an object but instead
    // populates the current object
    void deserialize(String content);
}
