import javax.swing.*;
import java.awt.*;

public class Main {

    static double firstNumber = 0;
    static String operator = "";
    static double secondNumber = 0;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculator");
        frame.setSize(275,350);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JButton[] numberButtons = new JButton[10];
        for (int i=0; i<=9; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            frame.add(numberButtons[i]);
        }

        JTextField text = new JTextField();
        frame.add(text);
        JButton sum = new JButton("+");
        frame.add(sum);
        JButton sub = new JButton("-");
        frame.add(sub);
        JButton div = new JButton("/");
        frame.add(div);
        JButton mul = new JButton("*");
        frame.add(mul);
        JButton equal = new JButton("=");
        frame.add(equal);
        JButton cls = new JButton("C");
        frame.add(cls);

        text.setBounds(30,25,215,40);
        numberButtons[7].setBounds(30, 70, 50,50);
        numberButtons[8].setBounds(85,70,50,50);
        numberButtons[9].setBounds(140,70,50,50);
        div.setBounds(195,70,50,50);
        numberButtons[4].setBounds(30,125,50,50);
        numberButtons[5].setBounds(85,125,50,50);
        numberButtons[6].setBounds(140,125,50,50);
        mul.setBounds(195,125,50,50);
        numberButtons[1].setBounds(30,180,50,50);
        numberButtons[2].setBounds(85,180,50,50);
        numberButtons[3].setBounds(140,180,50,50);
        sub.setBounds(195,180,50,50);
        cls.setBounds(30,235,50,50);
        numberButtons[0].setBounds(85,235,50,50);
        sum.setBounds(140,235,50,50);
        equal.setBounds(195,235,50,50);


        for(int i=0; i<=9; i++){
            int num = i;
            numberButtons[i].addActionListener(e -> text.setText(text.getText()+num));
        }

        sum.addActionListener(e -> {
            firstNumber = Double.parseDouble(text.getText());
            operator = "+";
            text.setText(String.valueOf(firstNumber)+" + ");
        });

        sub.addActionListener(e -> {
            firstNumber = Double.parseDouble(text.getText());
            operator = "-";
            text.setText(String.valueOf(firstNumber)+" - ");
        });

        mul.addActionListener(e -> {
            firstNumber = Double.parseDouble(text.getText());
            operator = "*";
            text.setText(String.valueOf(firstNumber)+" * ");
        });

        div.addActionListener(e -> {
            firstNumber = Double.parseDouble(text.getText());
            operator = "/";
            text.setText(String.valueOf(firstNumber)+" / ");
        });

        equal.addActionListener(e -> {
            secondNumber = Double.parseDouble(text.getText().split(" ")[2]);
            double result = 0;
            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    if (secondNumber != 0){
                        result = firstNumber / secondNumber;
                    }
                    else {
                        text.setText("Hata 0'a bölünemez.");
                        return;
                    }
                    break;
            }
            text.setText(String.valueOf(result));
        });

        cls.addActionListener(e -> {
            text.setText("");
            operator = "";
            firstNumber = 0;
            secondNumber = 0;
        });

        frame.setVisible(true);
    }
}