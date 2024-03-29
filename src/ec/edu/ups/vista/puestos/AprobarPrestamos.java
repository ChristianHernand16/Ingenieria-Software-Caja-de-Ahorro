/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista.puestos;

import ec.edu.ups.controlador.ControladorPersona;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ec.edu.ups.modelo.Secretaria;
import ec.edu.ups.modelo.Persona;

/**
 *
 * @author christian Hernandez
 * Vinicio Barzallo
 * Mario Torres
 * Edison Huinaizaca
 */
public class AprobarPrestamos extends javax.swing.JInternalFrame {

    /**
     * Creates new form Crear
     */
    private ControladorPersona controlador;
    private DefaultTableModel modelotabla;

    public AprobarPrestamos() {
        initComponents();
        controlador = new ControladorPersona();
        modelotabla = new DefaultTableModel();
        llenarUsuariosTabla();
        llenarUsuariosSecre();
    }

    public void llenarUsuariosTabla() {
        controlador = new ControladorPersona();
        List<Persona> clientes = controlador.findAproNO();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        int index = 0;
        for (Persona u : clientes) {
            model.insertRow(index, new Object[]{u.getIdUsuario(), u.getCedula(), u.getNombre() + " " + u.getApellido(), u.getDireccion(), u.getTelefono()});
            index++;
        }

    }

    public void llenarUsuariosSecre() {
        ControladorPersona cont = new ControladorPersona();
        List<Persona> clientes = cont.findAproSI();
        DefaultTableModel model = (DefaultTableModel) tabla1.getModel();
        int index = 0;
        for (Persona u : clientes) {
            model.insertRow(index, new Object[]{u.getIdUsuario(), u.getCedula(), u.getNombre() + " " + u.getApellido(), u.getDireccion(), u.getTelefono()});
            index++;
        }

    }

    public void limpiarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        modelo = (DefaultTableModel) tabla1.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        listadeClientes = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        listadeClientes1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        tabla.setBackground(new java.awt.Color(204, 255, 255));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idUsuario", "Cedula", "NombreyApellido", "Direccion", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        listadeClientes.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        listadeClientes.setText("LISTA DE USUARIOS QUE NO ESTAN APROBADOS");

        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        tabla1.setBackground(new java.awt.Color(204, 255, 255));
        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idUsuario", "Cedula", "NombreyApellido", "Direccion", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla1);

        listadeClientes1.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        listadeClientes1.setText("LISTA DE USUARIOS APROBADOS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnActualizar)
                .addGap(68, 68, 68))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listadeClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(listadeClientes1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listadeClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(listadeClientes1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 583, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        limpiarTabla();
        llenarUsuariosTabla();
        llenarUsuariosSecre();

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        if (evt.getClickCount() == 2) {
            int row = tabla.getSelectedRow();
            ControladorPersona con = new ControladorPersona();
            Persona u = con.findByID((int) tabla.getValueAt(row, 0));
            try {
                String conf = JOptionPane.showInputDialog(this, "DESEA PERMITIR QUE EL USUARIO: \n" + u.getNombre() + " " + u.getApellido() + " \n CON CEDULA: "
                        + u.getCedula() + "\n PUEDA REALIZAR PRESTAMOS");
                if (conf.length() > 1) {
                    ControladorPersona cont = new ControladorPersona();
                    Date now = new Date(System.currentTimeMillis());
                    Date d = new java.util.Date();
                    Date date2 = new java.sql.Date(d.getTime());
                    u.setPrestamo("SI");
                    u.setMotivo(conf);
                    cont.edit(u);
                }
                limpiarTabla();
                llenarUsuariosTabla();
                llenarUsuariosSecre();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No Escribio nada", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_tablaMouseClicked

    private void tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla1MouseClicked
        if (evt.getClickCount() == 2) {
            int row = tabla1.getSelectedRow();
            ControladorPersona con = new ControladorPersona();
            Persona u = con.findByID((int) tabla1.getValueAt(row, 0));

            int conf = JOptionPane.showConfirmDialog(this, "DESEA BLOQUEAR AL USUARIO: \n" + u.getNombre() + " " + u.getApellido() + " \n CON CEDULA: "
                    + u.getCedula() + "\n QUE NO PUEDA REALIZAR PRESTAMOS");

            if (conf == JOptionPane.OK_OPTION) {
                ControladorPersona cont = new ControladorPersona();
                Date now = new Date(System.currentTimeMillis());
                Date d = new java.util.Date();
                Date date2 = new java.sql.Date(d.getTime());
                u.setPrestamo("NO");
                cont.edit(u);
            }
            limpiarTabla();
            llenarUsuariosTabla();
            llenarUsuariosSecre();
        }
    }//GEN-LAST:event_tabla1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel listadeClientes;
    private javax.swing.JLabel listadeClientes1;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tabla1;
    // End of variables declaration//GEN-END:variables
}
