package tsn_java_lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JButton;

public class LambdaDemo3 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(7, 3, 5, 2);

        System.out.println(list);

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        list.forEach(new Consumer<Object>() {
            @Override
            public void accept(Object t) {
                System.out.print(t);
            }
        });

        System.out.println();

        list.sort((o1, o2) -> {
            return o2 - o1;
        });

        list.forEach(n -> {
            System.out.print(n);
        });

        System.out.println();

        JButton button = new JButton();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Привет, Java!");
            }
        });

        button.addActionListener(e -> {
            System.out.println("Привет, Swing!");
        });

        button.doClick();
    }

}
