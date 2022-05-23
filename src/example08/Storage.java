package example08;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    Map<String, Integer> productList;
    final int MAX_PRODUCT_CNT = 5;

    public Storage() {
        productList = new HashMap<>();
    }

    private void showProductList() {
        System.out.println("[System] 현재 등록된 제품 목록 ▼\n");
        for (String key : productList.keySet()) {
            System.out.printf("> %s \n", key);
        }
        for (int i=productList.size(); i<MAX_PRODUCT_CNT; i++) {
            System.out.println("> 등록 가능");
        }
        System.out.println("------------------------------");
    }

    public void showProductListWithCount() {
        for (Map.Entry<String, Integer> entry : productList.entrySet()) {
            System.out.printf("> %s : %d개\n", entry.getKey(), entry.getValue());
        }
        for (int i=productList.size(); i<MAX_PRODUCT_CNT; i++) {
            System.out.println("> 등록 가능 : 0개");
        }
        System.out.println("------------------------------");
    }
    public boolean productInput(String name) {
        if (!productList.containsKey(name)) {
            if (productList.size() >= MAX_PRODUCT_CNT) {
                System.out.printf("[Error] 등록 가능수량(%d)을 초과하여 등록할 수 없습니다.\n", MAX_PRODUCT_CNT);
                showProductList();
                return false;
            } else {
                productList.put(name, 0);
                showProductList();
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean productRemove(String name) {
        if (productList.containsKey(name)) {
            productList.remove(name);
        } else {
            return false;
        }
        return true;
    }

    public boolean productAmountAdd(String name, int count) {
        if (productList.containsKey(name)) {
            productList.put(name, productList.get(name) + count);
        } else {
            System.out.println("[Error] 입고할 제품명이 등록되어있지 않습니다.");
            return false;
        }
        return true;
    }

    public boolean productAmountDecrease(String name, int count) {
        if (productList.containsKey(name)) {
            if (productList.get(name) >= count) {
                productList.put(name, productList.get(name) - count);
            } else {
                System.out.println("[Error] 출고할 제품의 수량을 확인해주세요.");
                return false;
            }
        } else {
            System.out.println("[Error] 출고할 제품명을 확인해주세요.");
            return false;
        }
        return true;
    }
}
