package com.company;

public class Main {

    public static void main(String[] args) {
        Shop melina = new Shop("MelinaUjanusza" , 2 , 10  );
        Product gorzkaZoladkowa = new Product(17.99,"Alkohol" , "GorzkaZoladkowa");
        Product finlandia = new Product(27.99,"Alkohol" , "Finlandia");
        Product soplica = new Product(22.99,"Alkohol" , "Soplica");

        melina.addProduct(finlandia , 30);
        melina.addProduct(gorzkaZoladkowa , 10);
        melina.addProduct(soplica , 10);

        melina.deleteProduct(1);
        System.out.println(melina);
    }
}
