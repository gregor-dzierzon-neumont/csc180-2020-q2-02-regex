package dzierzon.gregor;

public class Program {
    public static void main(String[] args)
    {
        Program program = new Program();
        System.out.println(program.getMessage("Gregor"));
    }

    public String getMessage(String name){
        return "Hello " + name + "!";
    }

}
