import java.util.Scanner;

public class Lab1ex1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter the real part of the first complex number:");
			double real1 = scanner.nextDouble();
			System.out.println("Enter the imaginary part of the first complex number:");
			double imaginary1 = scanner.nextDouble();
			ComplexNumber num1 = new ComplexNumber(real1, imaginary1);

			System.out.println("Enter the real part of the second complex number:");
			double real2 = scanner.nextDouble();
			System.out.println("Enter the imaginary part of the second complex number:");
			double imaginary2 = scanner.nextDouble();
			ComplexNumber num2 = new ComplexNumber(real2, imaginary2);

			System.out.println("1. Addition");
			System.out.println("2. Subtraction");
			System.out.println("3. Multiplication");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();

			switch(choice) {
			    case 1:
			        ComplexNumber resultAddition = num1.add(num2);
			        System.out.println("Result of addition: " + resultAddition);
			        break;
			    case 2:
			        ComplexNumber resultSubtraction = num1.subtract(num2);
			        System.out.println("Result of subtraction: " + resultSubtraction);
			        break;
			    case 3:
			        ComplexNumber resultMultiplication = num1.multiply(num2);
			        System.out.println("Result of multiplication: " + resultMultiplication);
			        break;
			    default:
			        System.out.println("Invalid choice");
			}
		}
    }

    static class ComplexNumber {
        double real;
        double imaginary;

        public ComplexNumber(double real, double imaginary) {
            this.real = real;
            this.imaginary = imaginary;
        }

        public ComplexNumber add(ComplexNumber other) {
            return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
        }

        public ComplexNumber subtract(ComplexNumber other) {
            return new ComplexNumber(this.real - other.real, this.imaginary - other.imaginary);
        }

        public ComplexNumber multiply(ComplexNumber other) {
            double realPart = this.real * other.real - this.imaginary * other.imaginary;
            double imaginaryPart = this.real * other.imaginary + this.imaginary * other.real;
            return new ComplexNumber(realPart, imaginaryPart);
        }

        @Override
        public String toString() {
            return real + (imaginary >= 0 ? "+" : "") + imaginary + "i";
        }
    }
}
