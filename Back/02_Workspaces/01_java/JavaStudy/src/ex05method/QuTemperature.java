package ex05method;

public class QuTemperature {
    public static void main(String[] args) {
        celsiusToFahrenheit(28.4);
        fahrenheitToCelsius(34.8);
    }

    static void celsiusToFahrenheit(double celsius) {
        System.out.println("화씨 =" + (1.8 * celsius + 32));
    }

    static void fahrenheitToCelsius(double fahrenheit) {
        System.out.println("섭씨 =" + ((fahrenheit - 32) / 1.8));
    }
}
