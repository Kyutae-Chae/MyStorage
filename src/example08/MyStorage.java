package example08;

import java.util.Scanner;

public class MyStorage {
    private static String name;
    private static Scanner scan;
    private static Storage storage;

    public void close() {
        System.out.println("[Item_Storage] end!");
    }

    public static void start() {
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
        return scan.nextInt();
    }

    private static void productInput() {}

    private static void productRemove() {}

    private static void productAmountAdd() {}

    private static void productAmountDecrease() {}

    private static void productSearch() {}

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
                    System.out.println(("[System] 기능 선택을 다시하세요."));
            }
            if (isExit) break;
        }

        scan.close();
        System.out.println("[System] 프로그램을 종료합니다.");
    }
}
