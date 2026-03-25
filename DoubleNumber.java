import javax.swing.JOptionPane;
public class DoubleNumber {
    public static void main(String[] args) {
        String strNum1, strNum2;

        strNum1 = JOptionPane.showInputDialog(null,"Nhap so thu nhat: ");
        strNum2 = JOptionPane.showInputDialog(null,"Nhap so thu hai: ");

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        JOptionPane.showMessageDialog(null,"Tong 2 so: " +(num1 + num2) + "\n"+ "Hieu 2 so: " +(num1 - num2) +"\n" + "Tich 2 so: " +(num1 * num2) + "\n" + "Thuong 2 so: " +(num1 / num2));
        System.exit(0);
    }
}
