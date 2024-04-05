/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Clases.BinaryTree;
import Clases.BinaryTreePanel;
import Conexion.ConexionBD;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Esaú
 */
public class Arbolesbinarios extends javax.swing.JFrame {
private BinaryTree tree;
    /**
     * Creates new form Arbolesbinarios
     */
    public Arbolesbinarios() {
        initComponents();
        this.setLocationRelativeTo(null);
        cerrar();
        setVisible(true);
        mostrarDatosEnTabla();
        tree = new BinaryTree();
        txDato.setVisible(false);
        
    }
    public void cerrar(){
        
        try {
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter(){
            
            public void windowClosing(WindowEvent e){
                
             confirmarsalida();
            }
        });
        } catch(Exception e){
            
        } 
    }
    
    public void confirmarsalida(){
        int valor=JOptionPane.showConfirmDialog(this,"¿Desea cerrar la aplicación?","Advertencia",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE );
        if (valor==JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null,"Hasta pronto","",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }      
    }
    
    public void mostrarDatosEnTabla() {
        ConexionBD cn = new ConexionBD(); 
        Connection con = cn.conexion(); 

        try {
            String sql = "SELECT * FROM arbolesbin";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("DATO");
            modelo.addColumn("ESTADO");

            while (rs.next()) {
                Object[] fila = new Object[3];
                fila[0] = rs.getString("ID");
                fila[1] = rs.getString("DATO");
                fila[2] = rs.getString("ESTADO");
                modelo.addRow(fila);
            }
            tblBD.setModel(modelo);
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.err.println("Error al obtener los datos: " + e.getMessage());
        }
    }
    private void imprimirArbol() {
    String input = txDato.getText();
    String[] values = input.split(",");
    for (String value : values) {
        try {
            int num = Integer.parseInt(value.trim());
            tree.insert(num);
        } catch (NumberFormatException ex) {
            // Handle non-numeric input
            ex.printStackTrace();
        }
    }

    int internalFrameWidth = jInternalFrame1.getWidth(); 
    int internalFrameHeight = jInternalFrame1.getHeight();

    BinaryTreePanel panel = new BinaryTreePanel(tree);
    panel.setPreferredSize(new Dimension(internalFrameWidth, internalFrameHeight)); 
    jInternalFrame1.setContentPane(panel);
    jInternalFrame1.pack();
    jInternalFrame1.setVisible(true);
}




    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBD = new javax.swing.JTable();
        btnCargaArchivoBD = new javax.swing.JButton();
        btnGenerarArbol = new javax.swing.JButton();
        btnImprimirArbol = new javax.swing.JButton();
        btnLimpiarBD = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        txDato = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblBD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblBD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBD);

        btnCargaArchivoBD.setText("Cargar archivo a BD");

        btnGenerarArbol.setText("Generar Árbol");

        btnImprimirArbol.setText("Imprimir Árbol");
        btnImprimirArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirArbolActionPerformed(evt);
            }
        });

        btnLimpiarBD.setText("Limpiar Base de Datos");

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 581, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
        );

        jDesktopPane1.setLayer(jInternalFrame1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1208, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 54, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jDesktopPane1);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("Árboles Binarios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiarBD)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnGenerarArbol, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCargaArchivoBD)
                        .addComponent(btnImprimirArbol)))
                .addGap(303, 303, 303)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txDato, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(536, 536, 536)
                        .addComponent(jLabel1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txDato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiarBD)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnCargaArchivoBD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGenerarArbol)
                        .addGap(18, 18, 18)
                        .addComponent(btnImprimirArbol)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblBDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBDMouseClicked
        txDato.setEditable(false);
        int fila=this.tblBD.getSelectedRow();
        this.txDato.setText(this.tblBD.getValueAt(fila, 1).toString());
    }//GEN-LAST:event_tblBDMouseClicked

    private void btnImprimirArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirArbolActionPerformed
        // TODO add your handling code here:
        imprimirArbol();
    }//GEN-LAST:event_btnImprimirArbolActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargaArchivoBD;
    private javax.swing.JButton btnGenerarArbol;
    private javax.swing.JButton btnImprimirArbol;
    private javax.swing.JButton btnLimpiarBD;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable tblBD;
    private javax.swing.JTextField txDato;
    // End of variables declaration//GEN-END:variables
ConexionBD cn = new ConexionBD();
Connection con = cn.conexion();
}
