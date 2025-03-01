package serieI;
public class Main {
    static class Calculadora {
        public int sumar(int a, int b) {
            return a + b;
        }
        public int sumar(int a, int b, int c) {
            return a + b + c;
        }
    }
    static class Animal {
        public void sonido() {
            System.out.println("El animal hace un sonido.");
        }
    }
    
    static class Perro extends Animal {
        @Override
        public void sonido() {
            System.out.println("El perro ladra.");
        }
    }
    static class Gato extends Animal {
        @Override
        public void sonido() {
            System.out.println("El gato maúlla.");
        }
    }
    static class CuentaBancaria {
        private double saldo;
        public void depositar(double monto) {
            if (monto > 0) {
                saldo += monto;
            }
        }
        public double obtenerSaldo() {
            return saldo;
        }
    }
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        System.out.println("Suma de dos números: " + calc.sumar(2, 3)); 
        System.out.println("Suma de tres números: " + calc.sumar(2, 3, 4)); 
        Animal miAnimal = new Animal();
        miAnimal.sonido(); 
        Animal miPerro = new Perro();
        miPerro.sonido(); 
        Animal miGato = new Gato();
        miGato.sonido(); 
        CuentaBancaria cuenta = new CuentaBancaria();
        cuenta.depositar(1000);
        System.out.println("Saldo: " + cuenta.obtenerSaldo());  
    }
}