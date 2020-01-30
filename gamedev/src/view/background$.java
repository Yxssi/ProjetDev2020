package view;
import javax.swing.*;

class Demo extends JFrame {
    Demo() {

        setSize(1920, 1080);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon img = new ImageIcon("../../images/com/background/decor.jpg");

        setVisible(true);

        System.out.println("ca marche !");
    }


    public static void main(String args[]) {
        new Demo();
    }
}
