package example08;

import java.util.HashMap;

public class Storage {
    HashMap<String, Integer> productList;
    final int MAX_PRODUCT_CNT = 5;

    public Storage() {
        productList = new HashMap<String, Integer>();
    }


}
