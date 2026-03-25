import java.util.Scanner;

public class DisplayDayOfMonth{
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int month = -1;
        int year;

        //Nhap thang
        while (true) {
            System.out.print("Nhap thang: ");
            String inputMonth = keyboard.nextLine().trim().toLowerCase();

            switch (inputMonth) {
                case "1": case "jan": case "january": case "jan.":
                    month = 1; break;
                case "2": case "feb": case "february": case "feb.":
                    month = 2; break;
                case "3": case "mar": case "march": case "mar.":
                    month = 3; break;
                case "4": case "apr": case "april": case "apr.":
                    month = 4; break;
                case "5": case "may": case "may.":
                    month = 5; break;
                case "6": case "jun": case "june": case "june.":
                    month = 6; break;
                case "7": case "jul": case "july": case "jul.":
                    month = 7; break;
                case "8": case "aug": case "august": case "aug.":
                    month = 8; break;
                case "9": case "sep": case "september": case "sep.":
                    month = 9; break;
                case "10": case "oct": case "october": case "oct.":
                    month = 10; break;
                case "11": case "nov": case "november": case "nov.":
                    month = 11; break;
                case "12": case "dec": case "december": case "dec.":
                    month = 12; break;
                default:
                    System.out.println("Nhap sai, xin moi nhap lai");
                    continue;
            }
            break;
        }

        //Nhap nam
        while (true) {
            System.out.print("Nhap nam: ");
            String inputYear = keyboard.nextLine();

            try {
                year = Integer.parseInt(inputYear);
                if (year < 0) {
                    System.out.println("Nhap nam la mot so duong");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Nhap so, khong nhap chu");
            }
        }

        //Check leap
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        int days = 0;

        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31; break;
            case 4: case 6: case 9: case 11:
                days = 30; break;
            case 2:
                days = isLeap ? 29 : 28;
                break;
        }

        // ===== Output =====
        System.out.println("Thang " + month + " nam " + year + " co " + days + " ngay.");
    }
}