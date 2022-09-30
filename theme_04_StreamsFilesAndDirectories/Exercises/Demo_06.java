package theme_04_StreamsFilesAndDirectories.Exercises;

public class Demo_06 {
    public static void main(String[] args) {

        byte a = 120;
        byte b = 9;
        //short, byte, char при събиране в java винаги ги превръщата в int,
        //проблемът се решава с cast-ване
        byte c = (byte) (a + b);
    }
}
