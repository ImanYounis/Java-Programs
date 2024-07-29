import java.util.Scanner;

class complex {
    float real;
    float imaginary;

    complex() {
        real = 0.0f;
        imaginary = 0.0f;
    }
float getreal(){
return real;
}
void setreal(float d){
real=d;
}
float getimaginary(){
return imaginary;
}
void setimaginary(float n){
imaginary=n;
}
    complex(float real, float imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    complex(String str) {
        String str1 = str.substring(0, str.length() - 1); // Remove the 'i' at the end
        if (str1.contains("-")) {
            String[] parts = str1.split("-");
            this.real = Float.parseFloat(parts[0]);
            this.imaginary = -Float.parseFloat(parts[1]);
        } else if (str1.contains("+")) {
            String[] parts = str1.split("\\+");
            this.real = Float.parseFloat(parts[0]);
            this.imaginary = Float.parseFloat(parts[1]);
        } else {
            System.out.println("Invalid input");
        }
    }

    complex(complex other) {
        this.real = other.real;
        this.imaginary = other.imaginary;
    }

    complex add(complex other) {
        complex result = new complex();
        result.real = this.real + other.real;
        result.imaginary = this.imaginary + other.imaginary;
        result.display();
        return result;
    }

    complex subtract(complex other) {
        complex result = new complex();
        result.real = this.real - other.real;
        result.imaginary = this.imaginary - other.imaginary;
        result.display();
        return result;
    }

    complex multiply(complex other) {
        complex result = new complex();
        result.real = this.real * other.real - this.imaginary * other.imaginary;
        result.imaginary = this.real * other.imaginary + this.imaginary * other.real;
        result.display();
        return result;
    }

   /* complex divide(complex other) {
        complex result = new complex();
        float denominator = other.real * other.real + other.imaginary * other.imaginary;
        result.real = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        result.imaginary = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        result.display();
        return result;
    }*/

    void display() {
        System.out.println(this.real + " + " + this.imaginary + "i");
    }
}

