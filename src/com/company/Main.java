package com.company;

public class Main {

    public static void main(String[] args) {
        Shop melina = new Shop("MelinaUjanusza" , 2 , 10  );
        Product gorzkaZoladkowa = new Product(17.99, ProductType.ALCOHOL , "GorzkaZoladkowa");
        Product finlandia = new Product(27.99, ProductType.ALCOHOL, "Finlandia");
        Product soplica = new Product(22.99, ProductType.ALCOHOL , "Soplica");

        melina.addProduct(finlandia , 30);
        melina.addProduct(gorzkaZoladkowa , 10);
        melina.addProduct(soplica , 10);

        melina.deleteProduct(1);
        System.out.println(melina);
    }
}
