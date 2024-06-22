package InterfaceHomework;

public abstract class Parallelogram implements Figure {
    double a;
    double b;
    public Parallelogram(double a, double b) {
        this.a = a;
        this.b = b;
    }
    public double getArea() {
        return a * b;
    }
}
