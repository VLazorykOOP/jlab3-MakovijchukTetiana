import java.util.*;

abstract class Container {
    protected double[] elements; 

    public Container(double[] elements) {
        this.elements = elements;
    }

    abstract void sort();
    abstract double norma();

 
    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Container c = (Container) obj;
        return Arrays.equals(this.elements, c.elements);
    }
}

class Bubble extends Container {

    public Bubble(double[] elements) {
        super(elements);
    }

    @Override
    void sort() {
        for (int i = 0; i < elements.length - 1; i++) {
            for (int j = 0; j < elements.length - i - 1; j++) {
                if (elements[j] > elements[j + 1]) {
                    double temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }

    @Override
    double norma() {
        double sum = 0;
        for (double el : elements) {
            sum += el;
        }
        return Math.sqrt(sum);
    }

    @Override
    public String toString() {
        return "Bubble: " + super.toString();
    }
}

class Choice extends Container {

    public Choice(double[] elements) {
        super(elements);
    }

    @Override
    void sort() {
        for (int i = 0; i < elements.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < elements.length; j++) {
                if (elements[j] > elements[maxIndex]) {
                    maxIndex = j;
                }
            }
            double temp = elements[i];
            elements[i] = elements[maxIndex];
            elements[maxIndex] = temp;
        }
    }

    @Override
    double norma() {
        double sum = 0;
        for (double el : elements) {
            sum += el;
        }
        return sum / elements.length;
    }

    @Override
    public String toString() {
        return "Choice: " + super.toString();
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); System.out.print("Введіть кількість елементів: ");
         int n = sc.nextInt();

        double[] arr = new double[n];
        System.out.println("Введіть елементи:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }

        Container[] containers = new Container[2];
        containers[0] = new Bubble(Arrays.copyOf(arr, n));
        containers[1] = new Choice(Arrays.copyOf(arr, n));

        for (Container c : containers) {
            System.out.println("\nДо сортування: " + c);
            c.sort();
            System.out.println("Після сортування: " + c);
            System.out.println("Norma = " + c.norma());
        }
   }
}
