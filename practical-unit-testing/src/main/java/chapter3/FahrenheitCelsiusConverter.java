package chapter3;

public class FahrenheitCelsiusConverter {
    public static int toFahrenheit(int temperature) {
        return (int) (temperature * 1.8 + 32);
    }

    public static int toCelsius(int temperature) {
        return (int) Math.round((temperature-32)/1.8);
    }
}
