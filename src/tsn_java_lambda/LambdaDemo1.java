package tsn_java_lambda;

@FunctionalInterface
interface IQuadraticEquation {

    DataQuadraticEquation solve(double a, double b, double c);
}

class DataQuadraticEquation {

    private double a, b, c, x1, x2;

    public DataQuadraticEquation(double a, double b, double c, double x1, double x2) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public String toString() {
        return "a=" + a + ", b=" + b + ", c=" + c + ", x1=" + x1 + ", x2=" + x2;
    }

}

public class LambdaDemo1 {

    public static void main(String[] args) {
        IQuadraticEquation quadraticEquation1 = new IQuadraticEquation() {
            @Override
            public DataQuadraticEquation solve(double aa, double b, double c) {
                double d, x1, x2;
                d = (b * b) - 4 * aa * c;
                x1 = (-b + Math.sqrt(d)) / (2 * aa);
                x2 = (b + Math.sqrt(d)) / (2 * aa);
                return new DataQuadraticEquation(aa, b, c, x1, x2);
            }
        };

        IQuadraticEquation quadraticEquation2 = (a1, b, c) -> {
            double d, x1, x2;
            d = (b * b) - 4 * a1 * c;
            x1 = (-b + Math.sqrt(d)) / (2 * a1);
            x2 = (b + Math.sqrt(d)) / (2 * a1);
            return new DataQuadraticEquation(a1, b, c, x1, x2);
        };

        System.out.println(quadraticEquation1.solve(-20, 2, 4));
        System.out.println(quadraticEquation2.solve(-20, 2, 4));
    }

}
