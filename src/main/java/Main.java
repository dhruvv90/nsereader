//import com.jnsetools.NseTools;


import com.nsereader.NseReader;

public class Main {

    public static void main(String[] args) throws Exception {

        NseReader nseReaderDefault = NseReader.createDefault();

        var stocks = nseReaderDefault.getAllStocks();
        System.out.println(stocks);

        var indices = nseReaderDefault.getAllIndices();
        System.out.println(indices);

        System.out.println(nseReaderDefault.getAllStocks());

    }
}
