import javax.swing.JOptionPane;
public class LinearEquation {
    public static void main(String[] args) {
        String strNum1 = JOptionPane.showInputDialog(null,"Nhap a trong ax + b");
        String strNum2 = JOptionPane.showInputDialog(null,"Nhap b trong ax + b");

        double numA = Double.parseDouble(strNum1);
        double numB = Double.parseDouble(strNum2);

        if(numA == 0){
            if(numB == 0){
                JOptionPane.showMessageDialog(null, "Phuong trinh vo so nghiem");
            }
            else{
                JOptionPane.showMessageDialog(null,"Phuong trinh vo nghiem");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Phuong trinh co nghiem x = " + ((-numB)/numA));
        }
        System.exit(0);
    }
}
