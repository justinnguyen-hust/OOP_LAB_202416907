import javax.swing.JOptionPane;
public class FirstDegreeWithTwoX {
    public static void main(String[] args) {
        String numA11 = JOptionPane.showInputDialog(null, "Nhap a11:");
        String numA12 = JOptionPane.showInputDialog(null, "Nhap a12:");
        String numB1 = JOptionPane.showInputDialog(null, "Nhap b1");
        String numA21 = JOptionPane.showInputDialog(null, "Nhap a21:");
        String numA22 = JOptionPane.showInputDialog(null, "Nhap a22:");
        String numB2 = JOptionPane.showInputDialog(null, "Nhap b2");

        double a11 = Double.parseDouble(numA11);
        double a12 = Double.parseDouble(numA12);
        double b1 = Double.parseDouble(numB1);
        double a21 = Double.parseDouble(numA21);
        double a22 = Double.parseDouble(numA22);
        double b2 = Double.parseDouble(numB2);

        double D = a11*a22 - a12*a21;
        double D1 = b1*a22 - b2*a12;
        double D2 = a11*b2 - b1*a21;

        if(D == 0 && D1 == 0 && D2 == 0){
            JOptionPane.showMessageDialog(null, "Phuong trinh vo so nghiem");
        }
        else if(D == 0 && (D1 != 0 || D2 != 0)){
            JOptionPane.showMessageDialog(null, "Phuong trinh vo nghiem");
        }
        else{
            JOptionPane.showMessageDialog(null, "Phuong trinh co nghiem duy nhat:\n" + "x1 = " + D1/D + "\n" + "x2 = " + D2/D);
        }
        System.exit(0);
    }
}
