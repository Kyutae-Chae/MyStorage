package example08;

import java.util.Scanner;

public class MyStorage {
    private static String name;
    private static Scanner scan;
    private static Storage storage;

    private void close() {
        System.out.println("[Item_Storage] end!");
    }

    private static void start() {
        System.out.printf("[System] %s 점장님 어서오세요.\n", name);
        storage = new Storage();
    }

    private static void showMenu() {
        System.out.println("[System] 해당 프로그램의 기능입니다.\n" +
                "1. 물건 정보(제품명) 등록하기\n" +
                "2. 물건 정보(제품명) 등록 취소하기\n" +
                "3. 물건 넣기 (제품 입고)\n" +
                "4. 물건 빼기 (제품 출고)\n" +
                "5. 재고 조회\n" +
                "6. 프로그램 종료\n" +
                "------------------------------");
        System.out.print("[System] 원하는 기능의 번호를 입력하세요 : ");
    }

    private static int selectMenu() {
        int ret = 0;
        try {
            ret = scan.nextInt();
        } catch (Exception e) {
            ret = 0;
            scan = new Scanner(System.in); //무한 반복을 위한 scanner 초기화(?)
        }
        return ret;
    }

    private static void productInput() {
        System.out.print("[System] 제품 등록을 원하는 제품명을 입력하세요 : ");
        String inputName = scan.next();
        if (storage.productInput(inputName)) {
            System.out.println("[System] 등록이 완료됐습니다.");
        } else {
            System.out.println("[System] 등록 실패했습니다.");
        }
    }

    private static void productRemove() {
        System.out.print("[System] 제품 등록 취소를 원하는 제품명을 입력하세요 : ");
        String inputName = scan.next();
        if (storage.productRemove(inputName)) {
            System.out.println("[System] 제품 취소가 완료됬습니다.");
        } else {
            System.out.println("[System] 등록 취소가 가능한 제품이 없습니다.");
        }
    }

    private static void productAmountAdd() {
        System.out.println("[System] 물건의 수량을 추가합니다.(입고)");
        productSearch();

        System.out.print("[System] 수량을 추가할 제품명을 입력하세요 : ");
        String inputName = scan.next();
        System.out.println("[System] 추가할 수량을 입력해주세요 : ");
        int inputCnt = scan.nextInt();
        if (storage.productAmountAdd(inputName, inputCnt)) {
            System.out.println("[Clear] 정상적으로 제품의 수량 추가가 완료되었습니다.");
            productSearch();
        } else {
            System.out.println("[Error] 제품 수량 추가 실패했습니다.");
        }

    }

    private static void productAmountDecrease() {
        System.out.println("[System] 제품의 출고를 진행합니다.");
        productSearch();

        System.out.print("[System] 출고를 진행할 제품명을 입력하세요 : ");
        String inputName = scan.next();
        System.out.println("[System] 원하는 출고량을 입력해주세요 : ");
        int inputCnt = scan.nextInt();
        if (storage.productAmountDecrease(inputName, inputCnt)) {
            System.out.println("[Clear] 출고가 완료되었습니다.");
            productSearch();
        } else {
            System.out.println("[Error] 제품 출고 실패했습니다.");
        }
    }

    private static void productSearch() {
        System.out.println("\n[System] 현재 등록된 제품 목록 ▼");
        storage.showProductListWithCount();
    }

    public static void main(String[] args) {
        boolean isExit = false;
        scan = new Scanner(System.in);
        if (args.length >= 1)
            name = args[0];
        else
            name = "DEFAULT NAME";
        System.out.println("[Item_Storage] start!");
        start();

        while(true) {
            showMenu();

            switch(selectMenu()) {
                case 1:
                    productInput();
                    break;
                case 2:
                    productRemove();
                    break;
                case 3:
                    productAmountAdd();
                    break;
                case 4:
                    productAmountDecrease();
                    break;
                case 5:
                    productSearch();
                    break;
                case 6:
                    isExit = true;
                    break;
                default:
                    System.out.println(("[System] 지원되는 기능(1~6번)을 확인후 다시 선택해주세요."));
            }
            if (isExit) break;
        }

        scan.close();
        System.out.println("[System] 프로그램을 종료합니다.");
    }
}
