import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AplikasiBiodataGUI {
    public static void main(String[] args) {
        Color warnaBackgroundUtama = new Color(240, 244, 248);
        Color warnaHeader = new Color(30, 58, 138);
        Color warnaTombolUtama = new Color(37, 99, 235);
        Color warnaTombolHover = new Color(29, 78, 216);
        Color warnaTombolReset = new Color(220, 38, 38);
        Color warnaTeksGelap = new Color(31, 41, 55);

        Font fontJudul = new Font("Segoe UI", Font.BOLD, 16);
        Font fontLabel = new Font("Segoe UI", Font.BOLD, 13);
        Font fontInput = new Font("Segoe UI", Font.PLAIN, 13);

        JFrame frame = new JFrame("Eksplorasi GUI Java - Form Mahasiswa");
        frame.setSize(450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));
        frame.getContentPane().setBackground(warnaBackgroundUtama);

        JPanel panelHeader = new JPanel();
        panelHeader.setBackground(warnaHeader);
        panelHeader.setBorder(new EmptyBorder(12, 15, 12, 15));

        JPanel panelForm = new JPanel();
        panelForm.setLayout(new GridLayout(3, 2, 10, 12));
        panelForm.setBackground(warnaBackgroundUtama);
        panelForm.setBorder(new EmptyBorder(15, 25, 10, 25));

        JPanel panelTombol = new JPanel();
        panelTombol.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panelTombol.setBackground(warnaBackgroundUtama);

        JPanel panelOutput = new JPanel(new BorderLayout());
        panelOutput.setBackground(warnaBackgroundUtama);
        panelOutput.setBorder(new EmptyBorder(5, 25, 20, 25));

        JLabel lblJudul = new JLabel("FORM DATA MAHASISWA");
        lblJudul.setForeground(Color.WHITE);
        lblJudul.setFont(fontJudul);
        panelHeader.add(lblJudul);

        JLabel lblNama = new JLabel("Nama Lengkap:");
        lblNama.setFont(fontLabel);
        lblNama.setForeground(warnaTeksGelap);
        JTextField txtNama = new JTextField();
        txtNama.setFont(fontInput);

        JLabel lblNim = new JLabel("NIM:");
        lblNim.setFont(fontLabel);
        lblNim.setForeground(warnaTeksGelap);
        JTextField txtNim = new JTextField();
        txtNim.setFont(fontInput);

        JLabel lblJurusan = new JLabel("Program Studi:");
        lblJurusan.setFont(fontLabel);
        lblJurusan.setForeground(warnaTeksGelap);
        JTextField txtJurusan = new JTextField();
        txtJurusan.setFont(fontInput);

        JButton btnTampil = new JButton("Tampilkan Data");
        btnTampil.setFont(fontLabel);
        btnTampil.setBackground(warnaTombolUtama);
        btnTampil.setForeground(Color.WHITE);
        btnTampil.setFocusPainted(false);
        btnTampil.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JButton btnReset = new JButton("Reset");
        btnReset.setFont(fontLabel);
        btnReset.setBackground(warnaTombolReset);
        btnReset.setForeground(Color.WHITE);
        btnReset.setFocusPainted(false);
        btnReset.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JTextArea areaHasil = new JTextArea(4, 30);
        areaHasil.setEditable(false);
        areaHasil.setFont(new Font("Consolas", Font.PLAIN, 13));
        areaHasil.setBackground(Color.WHITE);
        areaHasil.setForeground(warnaTeksGelap);
        areaHasil.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(203, 213, 225), 1),
            new EmptyBorder(8, 10, 8, 10)
        ));

        panelForm.add(lblNama);
        panelForm.add(txtNama);
        panelForm.add(lblNim);
        panelForm.add(txtNim);
        panelForm.add(lblJurusan);
        panelForm.add(txtJurusan);

        panelTombol.add(btnTampil);
        panelTombol.add(btnReset);
        panelOutput.add(areaHasil, BorderLayout.CENTER);

        JPanel panelTengah = new JPanel(new BorderLayout());
        panelTengah.setBackground(warnaBackgroundUtama);
        panelTengah.add(panelForm, BorderLayout.CENTER);
        panelTengah.add(panelTombol, BorderLayout.SOUTH);

        btnTampil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = txtNama.getText();
                String nim = txtNim.getText();
                String jurusan = txtJurusan.getText();

                if (nama.isEmpty() || nim.isEmpty() || jurusan.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Harap isi semua kolom!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                } else {
                    areaHasil.setText("Nama  : " + nama + "\nNIM   : " + nim + "\nProdi : " + jurusan);
                }
            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNama.setText("");
                txtNim.setText("");
                txtJurusan.setText("");
                areaHasil.setText("");
            }
        });

        btnTampil.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnTampil.setBackground(warnaTombolHover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnTampil.setBackground(warnaTombolUtama);
            }
        });

        frame.add(panelHeader, BorderLayout.NORTH);
        frame.add(panelTengah, BorderLayout.CENTER);
        frame.add(panelOutput, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
