package base;

import dominio.BBDD;

public class Main {

    public static void main(String[] args) {

        System.out.println("Bienvenido a la tienda");
        System.out.println("***************************************************");

        BBDD bdEmpleados = new BBDD();
        bdEmpleados.conectarBBDD();



    }
}
