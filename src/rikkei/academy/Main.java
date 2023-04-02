package rikkei.academy;

import rikkei.academy.config.ColorConfig;
import rikkei.academy.config.Config;
import rikkei.academy.validate.ValidateInput;
import rikkei.academy.validate.ValidatePhoneNumber;

public class Main {
    public Main() {
        while (true) {
            System.out.println("******************** Menu ********************");
            System.out.println("1. Để nhập tên lớp \n" +
                    "0. Để thoát chường trình"
            );
            int chooseMenu = ValidateInput.validateInt();
            switch (chooseMenu) {
                case 1:
                    checkClassName();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Nhập menu từ 0 or 1 mời chọn lại: ");
            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }

    public void checkClassName() {
        ValidatePhoneNumber validateCheck = new ValidatePhoneNumber();
        while (true) {
            System.out.println("Nhập số điện thoại: ");
            String phoneNumber = Config.scanner().nextLine();
            boolean checkPhone = validateCheck.validate(phoneNumber);
            if (checkPhone) {
                System.out.println("___ SĐT: " + phoneNumber + " là " + checkPhone);

                System.out.println("|     Nhập 'M' để quay lại Menu,                              |");
                System.out.println("|     hoặc nhập phím khác để tiếp tục thêm số điện thoại      |");
                String backMenu = Config.scanner().nextLine();
                if (backMenu.equalsIgnoreCase("m")) {
                    new Main();
                }
            } else {
                System.out.println("___SĐT: " + "\'" + phoneNumber + "\'" + " là " + checkPhone);
                System.out.println(ColorConfig.RED + "Nhập số điện thoại phải :\n" +
                        "Số điện thoại hợp lệ cần đạt theo mẫu sau: xx-0xxxxxxxxx\n" +
                        "x là ký tự số \n" +
                        "Không chứa các ký tự đặc biệt\n" +
                        "Ví dụ số điện thoại hợp lệ: 84-0978489648\n" + ColorConfig.RESET);
                System.out.println("Mời nhập lại ! ");
            }

        }

    }
}
