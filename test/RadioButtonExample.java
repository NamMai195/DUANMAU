import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonExample {

    public static void main(String[] args) {
        // Tạo khung cửa sổ JFrame
        JFrame frame = new JFrame("RadioButton Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Tạo panel để chứa các thành phần
        JPanel panel = new JPanel();

        // Tạo đối tượng JRadioButton
        JRadioButton radioButton1 = new JRadioButton("Option 1");
        JRadioButton radioButton2 = new JRadioButton("Option 2");

        // Thêm JRadioButton vào panel
        panel.add(radioButton1);
        panel.add(radioButton2);

        // Thêm panel vào frame
        frame.add(panel);

        // Tạo nút bấm để bỏ tích radio button
        JButton deselectButton = new JButton("Deselect RadioButton");
        panel.add(deselectButton);

        // Thêm hành động cho nút bấm để bỏ tích radio button
        deselectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Bỏ tích radioButton1 và radioButton2
                radioButton1.setSelected(false);
                radioButton2.setSelected(false);
            }
        });

        // Hiển thị frame
        frame.setVisible(true);
    }
}

