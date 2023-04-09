import java.util.Scanner;

public class Cajero {
    private int saldoActual = 3000;
    private final Scanner SCANNER = new Scanner(System.in);

    private void setSaldoActual(int saldoActual){
        this.saldoActual = saldoActual;
    }

    private int getSaldoActual() {
        return saldoActual;
    }

    public void retirar(){
        System.out.println("Ingrese el monto a retirar:");
        int montoARetirar = SCANNER.nextInt();
        if (montoARetirar <= 0){
            System.out.println("Usted no puede retirar un monto menor que cero");
        } else if(montoARetirar > getSaldoActual()){
            System.out.println("No puede retirar un monto superior a su saldo. No sea bruto, usted tiene de saldo " + getSaldoActual());
        } else{
            setSaldoActual(getSaldoActual() - montoARetirar);
            System.out.println("Retiro exitoso, en su cuenta tiene: " + getSaldoActual());
        }
    }

    public void imprimirSaldo(){
        System.out.println("Su saldo es de: " + getSaldoActual());
    }

    public void depositar(){
        System.out.println("Ingrese el monto a depositar:");
        int montoADepositar = SCANNER.nextInt();
        if (montoADepositar <= 0){
            System.out.println("Usted no puede depositar un monto menor que cero");
        } else{
            setSaldoActual(saldoActual += montoADepositar);
            System.out.println("Deposito exitoso, tiene un saldo de: " + getSaldoActual());
        }
    }

    public static void main(String []args){
        int opc = 0;
        Cajero cajero = new Cajero();
        while (opc != 3){
            System.out.println("-------- BIENVENIDO --------");
            System.out.println('\t' + "1. Transacciones");
            System.out.println('\t' + "2. Consultar saldo");
            System.out.println('\t' + "3. Salir");
            System.out.print("Ingrese su opcion: ");
            opc = cajero.SCANNER.nextInt();
            switch (opc){
                case 1 -> {
                    while (opc != 3){
                        System.out.println("----- TRANSACCIONES -----");
                        System.out.println('\t' + "1. Depositar");
                        System.out.println('\t' + "2. Retirar");
                        System.out.println('\t' + "3. Salir al menu principal");
                        System.out.print("Ingrese su opcion: ");
                        opc = cajero.SCANNER.nextInt();
                        switch (opc){
                            case 1 -> cajero.depositar();
                            case 2 -> cajero.retirar();
                            case 3 -> System.out.println("Volviendo al menu principal");
                            default -> System.out.println("Opcion equivocada");
                        }
                    }
                    opc = 0;
                }
                case 2 -> cajero.imprimirSaldo();
                case 3 -> System.out.println("Fue un gusto, vuelva pronto");
                default -> System.out.println("Opcion equivocada");
            }
        }
    }
}
