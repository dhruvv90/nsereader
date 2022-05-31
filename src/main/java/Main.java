//import com.jnsetools.NseTools;


import com.nsereader.NseReader;

public class Main {

    public static void print(Object o){
        System.out.println(o);
    }

    public static void main(String[] args) throws Exception {

        NseReader def = NseReader.createDefault();

        var stocks = def.getAllStocks();
        print(stocks);

        var indices = def.getAllIndices();
        print(indices);

        var checkStock = def.isValidStockCode("hdfc");
        print(checkStock);

        var checkIndex = def.isValidIndex("Nifty 50");
        print(checkIndex);

        var topGainers = def.getTopGainerStocks();
        print(topGainers);

        var topLosers = def.getTopLoserStocks();
        print(topLosers);
    }
}
