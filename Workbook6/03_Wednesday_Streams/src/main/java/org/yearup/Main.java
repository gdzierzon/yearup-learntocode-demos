package org.yearup;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args)
    {
//        demoFilter();
        demoMaxMinPrice();
    }

    public static void demoFilter()
    {
        List<Product> products = loadProducts();

        var searchResults = products.stream()
                .filter(product -> product.getPrice() >= 10 && product.getPrice() <= 18)
                .filter(product -> product.getCategory().equalsIgnoreCase("Beverages"))
                .collect(Collectors.toList());

        for(var product: searchResults)
        {
            System.out.println("(" + product.getCategory() + ") " +  product.getName() + " $" + product.getPrice());
        }
    }

    public static void demoMaxMinPrice()
    {
        var products = loadProducts();

//        var prices = products.stream()
//                .map(product -> product.getPrice())
//                .toList();

        var max = products.stream()
                .map(product -> product.getPrice())
                .reduce(0.0, (price, collector) -> price > collector ? price : collector);

        var min = products.stream()
                .map(product -> product.getPrice())
                .reduce(9999.99, (price, collector) -> price < collector ? price : collector);

//        double collector = 0.0;
//        for(var price : prices)
//        {
//            collector = price > collector ? price : collector;
//        }

        System.out.println("Max price is: " + max);
        System.out.println("Min price is: " + min);



//
//        prices.forEach(price -> {
//            System.out.println(price);
//        });

    }

    public static boolean isCheap(Product product)
    {
        return product.getPrice() < 10;
    }

    public static boolean isInPriceRange(Product p, double min, double max)
    {
        return p.getPrice() >= min && p.getPrice() <= max;
    }

//
//    public static List<Product> filterByPrice(List<Product> products, double min, double max)
//    {
//        List<Product> filteredProducts = new ArrayList<>();
//
//        for (var product: products)
//        {
//            if(product.getPrice() >= min && product.getPrice() <= max)
//            {
//                filteredProducts.add(product);
//            }
//        }
//
//        return filteredProducts;
//    }

    public static List<Product> loadProducts()
    {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"Chai","Beverages",18.00,"10 boxes x 20 bags"));
        products.add(new Product(2,"Chang","Beverages",19.00,"24 - 12 oz bottles"));
        products.add(new Product(3,"Aniseed Syrup","Condiments",10.00,"12 - 550 ml bottles"));
        products.add(new Product(4,"Chef Anton's Cajun Seasoning","Condiments",22.00,"48 - 6 oz jars"));
        products.add(new Product(5,"Chef Anton's Gumbo Mix","Condiments",21.35,"36 boxes"));
        products.add(new Product(6,"Grandma's Boysenberry Spread","Condiments",25.00,"12 - 8 oz jars"));
        products.add(new Product(7,"Uncle Bob's Organic Dried Pears","Produce",30.00,"12 - 1 lb pkgs."));
        products.add(new Product(8,"Northwoods Cranberry Sauce","Condiments",40.00,"12 - 12 oz jars"));
        products.add(new Product(9,"Mishi Kobe Niku","Meat/Poultry",97.00,"18 - 500 g pkgs."));
        products.add(new Product(10,"Ikura","Seafood",31.00,"12 - 200 ml jars"));
        products.add(new Product(11,"Queso Cabrales","Dairy Products",21.00,"1 kg pkg."));
        products.add(new Product(12,"Queso Manchego La Pastora","Dairy Products",38.00,"10 - 500 g pkgs."));
        products.add(new Product(13,"Konbu","Seafood",6.00,"2 kg box"));
        products.add(new Product(14,"Tofu","Produce",23.25,"40 - 100 g pkgs."));
        products.add(new Product(15,"Genen Shouyu","Condiments",15.50,"24 - 250 ml bottles"));
        products.add(new Product(16,"Pavlova","Confections",17.45,"32 - 500 g boxes"));
        products.add(new Product(17,"Alice Mutton","Meat/Poultry",39.00,"20 - 1 kg tins"));
        products.add(new Product(18,"Carnarvon Tigers","Seafood",62.50,"16 kg pkg."));
        products.add(new Product(19,"Teatime Chocolate Biscuits","Confections",9.20,"10 boxes x 12 pieces"));
        products.add(new Product(20,"Sir Rodney's Marmalade","Confections",81.00,"30 gift boxes"));
        products.add(new Product(21,"Sir Rodney's Scones","Confections",10.00,"24 pkgs. x 4 pieces"));
        products.add(new Product(22,"Gustaf's Knäckebröd","Grains/Cereals",21.00,"24 - 500 g pkgs."));
        products.add(new Product(23,"Tunnbröd","Grains/Cereals",9.00,"12 - 250 g pkgs."));
        products.add(new Product(24,"Guaraná Fantástica","Beverages",4.50,"12 - 355 ml cans"));
        products.add(new Product(25,"NuNuCa Nuß-Nougat-Creme","Confections",14.00,"20 - 450 g glasses"));
        products.add(new Product(26,"Gumbär Gummibärchen","Confections",31.23,"100 - 250 g bags"));
        products.add(new Product(27,"Schoggi Schokolade","Confections",43.90,"100 - 100 g pieces"));
        products.add(new Product(28,"Rössle Sauerkraut","Produce",45.60,"25 - 825 g cans"));
        products.add(new Product(29,"Thüringer Rostbratwurst","Meat/Poultry",123.79,"50 bags x 30 sausgs."));
        products.add(new Product(30,"Nord-Ost Matjeshering","Seafood",25.89,"10 - 200 g glasses"));
        products.add(new Product(31,"Gorgonzola Telino","Dairy Products",12.50,"12 - 100 g pkgs"));
        products.add(new Product(32,"Mascarpone Fabioli","Dairy Products",32.00,"24 - 200 g pkgs."));
        products.add(new Product(33,"Geitost","Dairy Products",2.50,"500 g"));
        products.add(new Product(34,"Sasquatch Ale","Beverages",14.00,"24 - 12 oz bottles"));
        products.add(new Product(35,"Steeleye Stout","Beverages",18.00,"24 - 12 oz bottles"));
        products.add(new Product(36,"Inlagd Sill","Seafood",19.00,"24 - 250 g  jars"));
        products.add(new Product(37,"Gravad lax","Seafood",26.00,"12 - 500 g pkgs."));
        products.add(new Product(38,"Côte de Blaye","Beverages",263.50,"12 - 75 cl bottles"));
        products.add(new Product(39,"Chartreuse verte","Beverages",18.00,"750 cc per bottle"));
        products.add(new Product(40,"Boston Crab Meat","Seafood",18.40,"24 - 4 oz tins"));
        products.add(new Product(41,"Jack's New England Clam Chowder","Seafood",9.65,"12 - 12 oz cans"));
        products.add(new Product(42,"Singaporean Hokkien Fried Mee","Grains/Cereals",14.00,"32 - 1 kg pkgs."));
        products.add(new Product(43,"Ipoh Coffee","Beverages",46.00,"16 - 500 g tins"));
        products.add(new Product(44,"Gula Malacca","Condiments",19.45,"20 - 2 kg bags"));
        products.add(new Product(45,"Rogede sild","Seafood",9.50,"1k pkg."));
        products.add(new Product(46,"Spegesild","Seafood",12.00,"4 - 450 g glasses"));
        products.add(new Product(47,"Zaanse koeken","Confections",9.50,"10 - 4 oz boxes"));
        products.add(new Product(48,"Chocolade","Confections",12.75,"10 pkgs."));
        products.add(new Product(49,"Maxilaku","Confections",20.00,"24 - 50 g pkgs."));
        products.add(new Product(50,"Valkoinen suklaa","Confections",16.25,"12 - 100 g bars"));
        products.add(new Product(51,"Manjimup Dried Apples","Produce",53.00,"50 - 300 g pkgs."));
        products.add(new Product(52,"Filo Mix","Grains/Cereals",7.00,"16 - 2 kg boxes"));
        products.add(new Product(53,"Perth Pasties","Meat/Poultry",32.80,"48 pieces"));
        products.add(new Product(54,"Tourtière","Meat/Poultry",7.45,"16 pies"));
        products.add(new Product(55,"Pâté chinois","Meat/Poultry",24.00,"24 boxes x 2 pies"));
        products.add(new Product(56,"Gnocchi di nonna Alice","Grains/Cereals",38.00,"24 - 250 g pkgs."));
        products.add(new Product(57,"Ravioli Angelo","Grains/Cereals",19.50,"24 - 250 g pkgs."));
        products.add(new Product(58,"Escargots de Bourgogne","Seafood",13.25,"24 pieces"));
        products.add(new Product(59,"Raclette Courdavault","Dairy Products",55.00,"5 kg pkg."));
        products.add(new Product(60,"Camembert Pierrot","Dairy Products",34.00,"15 - 300 g rounds"));
        products.add(new Product(61,"Sirop d'érable","Condiments",28.50,"24 - 500 ml bottles"));
        products.add(new Product(62,"Tarte au sucre","Confections",49.30,"48 pies"));
        products.add(new Product(63,"Vegie-spread","Condiments",43.90,"15 - 625 g jars"));
        products.add(new Product(64,"Wimmers gute Semmelknödel","Grains/Cereals",33.25,"20 bags x 4 pieces"));
        products.add(new Product(65,"Louisiana Fiery Hot Pepper Sauce","Condiments",21.05,"32 - 8 oz bottles"));
        products.add(new Product(66,"Louisiana Hot Spiced Okra","Condiments",17.00,"24 - 8 oz jars"));
        products.add(new Product(67,"Laughing Lumberjack Lager","Beverages",14.00,"24 - 12 oz bottles"));
        products.add(new Product(68,"Scottish Longbreads","Confections",12.50,"10 boxes x 8 pieces"));
        products.add(new Product(69,"Gudbrandsdalsost","Dairy Products",36.00,"10 kg pkg."));
        products.add(new Product(70,"Outback Lager","Beverages",15.00,"24 - 355 ml bottles"));
        products.add(new Product(71,"Flotemysost","Dairy Products",21.50,"10 - 500 g pkgs."));
        products.add(new Product(72,"Mozzarella di Giovanni","Dairy Products",34.80,"24 - 200 g pkgs."));
        products.add(new Product(73,"Röd Kaviar","Seafood",15.00,"24 - 150 g jars"));
        products.add(new Product(74,"Longlife Tofu","Produce",10.00,"5 kg pkg."));
        products.add(new Product(75,"Rhönbräu Klosterbier","Beverages",7.75,"24 - 0.5 l bottles"));
        products.add(new Product(76,"Lakkalikööri","Beverages",18.00,"500 ml"));
        products.add(new Product(77,"Original Frankfurter grüne Soße","Condiments",13.00,"12 boxes"));

        return products;
    }

}