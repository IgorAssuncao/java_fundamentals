public class Calculator {
    private double x;
    private double y;

    public Calculator() {
    }

    public Calculator(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double addition() {
        return this.x + this.y;
    }

    public double addition(double x, double y) {
        return x + y;
    }

    public double subtraction() {
        return this.x - this.y;
    }

    public double subtraction(double x, double y) {
        return x - y;
    }

    public double multiplication() {
        return this.x * this.y;
    }

    public double multiplication(double x, double y) {
        return x * y;
    }

    public double division() {
        return this.x / this.y;
    }

    public double division(double x, double y) {
        return x / y;
    }

    @Override
    public String toString() {
        return "Calculator";
    }
}