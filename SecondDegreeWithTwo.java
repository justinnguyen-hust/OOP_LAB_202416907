import javax.swing.JOptionPane;
public class SecondDegreeWithTwo {
    public static void main(String[] args) {
        String numA = JOptionPane.showInputDialog(null,"Nhap a trong ax^2 + bx + c");
        String numB = JOptionPane.showInputDialog(null,"Nhap b trong ax^2 + bx + c");
        String numC = JOptionPane.showInputDialog(null,"Nhap c trong ax^2 + bx + c");

        double a = Double.parseDouble(numA);
        double b = Double.parseDouble(numB);
        double c = Double.parseDouble(numC);

        if(a == 0){
            if(b == 0){
                if(c == 0){
                    JOptionPane.showMessageDialog(null, "Phuong trinh vo so nghiem");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Phuong trinh vo nghiem");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Phuong trinh bac nhat co nghiem x = " + ((-c)/b));
            }
        }
        else{
            double delta = b*b - 4*a*c;
            if(delta < 0){
                JOptionPane.showMessageDialog(null,"Phuong trinh vo nghiem");
            }
            else if(delta == 0){
                JOptionPane.showMessageDialog(null,"Phuong trinh co nghiem kep x = " + (-b)/(2*a));
            }
            else {
                double x1 = (-b + java.lang.Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - java.lang.Math.sqrt(delta)) / (2 * a);
                JOptionPane.showMessageDialog(null, "Phuong trinh co 2 nghiem:\n" + "x1 = " + x1 + "\n" + "x2 = " + x2);
            }
        }
        System.exit(0);
    }
}
