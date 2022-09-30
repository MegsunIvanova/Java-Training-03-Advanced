package theme_08_Generics.Lab.P03_GenericScale;

public class Main {
    public static void main(String[] args) {

        Scale<String> scale = new Scale<>("A", "B");

        System.out.println(scale.getHeavier());
    }
}
