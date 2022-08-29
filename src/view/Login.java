package view;

import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.dao.AdminDAO;
import model.entity.Admin;

public class Login extends javax.swing.JFrame {

    public Login() {

        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin = new javax.swing.JPanel();
        LabelAdmin = new javax.swing.JLabel();
        LabelPass = new javax.swing.JLabel();
        txtAdminId = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome to SIT Library");

        panelLogin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(235, 149, 50), 1, true));

        LabelAdmin.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        LabelAdmin.setText("ID Admin:");

        LabelPass.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        LabelPass.setText("Contrasinal:");

        txtAdminId.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        txtAdminId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdminIdActionPerformed(evt);
            }
        });

        btnLogin.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        btnLogin.setText("Iniciar Sesión");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        txtPassword.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/biblioteca-digital.png"))); // NOI18N

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LabelAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LabelPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(21, 21, 21)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAdminId, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(txtPassword)))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(btnLogin)))
                .addContainerGap(152, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(186, 186, 186))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LabelAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAdminId, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelPass, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        panelLogin.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAdminIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdminIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdminIdActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String id = txtAdminId.getText().trim();
        String password = String.valueOf(txtPassword.getPassword()).trim();
        if (id.length() == 0 || password.length() == 0) {
            JOptionPane.showMessageDialog(panelLogin, "Please enter Email and password", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        AdminDAO dao = new AdminDAO();
        if (dao.isValidAdmin(new Admin(id, password))) {
            loggedIn = true;
            System.out.println("Logged in successfully");
            new Dashboard().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(panelLogin, "Invalid Login!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(new FlatArcOrangeIJTheme());
            UIManager.put("Button.arc", 999);
            UIManager.put("Component.arc", 999);
            UIManager.put("ProgressBar.arc", 999);
            UIManager.put("TextComponent.arc", 999);
            UIManager.put("ToolTip.background", new java.awt.Color(245, 245, 245));
            UIManager.put("ToolTip.border", new javax.swing.border.LineBorder(new java.awt.Color(245, 121, 0), 1, true));
            UIManager.put("Table.font", new java.awt.Font("Raleway", 0, 14));
            UIManager.put("TableHeader.font", new java.awt.Font("Raleway", 0, 14));
            UIManager.put("ToolTip.font", new java.awt.Font("Raleway", 1, 14));
            UIManager.put("Button.font", new java.awt.Font("Raleway", 0, 14));
            UIManager.put("Label.font", new java.awt.Font("Raleway", 0, 14));
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login LF = new Login();
                LF.setVisible(true);

            }
        });
    }

    public static boolean loggedIn = false;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelAdmin;
    private javax.swing.JLabel LabelPass;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JTextField txtAdminId;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
