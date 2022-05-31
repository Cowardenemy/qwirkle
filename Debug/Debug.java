package Debug;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Debug extends javax.swing.JDialog {

    public Debug(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        Object titulos [] = new Object [] {"ID", "Nombre"};
        ArrayList<ArrayList<Object>> datos = new ArrayList<ArrayList<Object>>();
        ArrayList<Object> ID = new ArrayList<Object>();
        ArrayList<Object> Nombre = new ArrayList<Object>();
        ID.add("1");
        Nombre.add("Manuel");
        ID.add("1");
        Nombre.add("Manuel");
        ID.add("1");
        Nombre.add("Manuel");
        ID.add("1");
        Nombre.add("Manuel");ID.add("1");
        Nombre.add("Manuel");
        datos.add(ID);
        datos.add(Nombre);
        
        addDebugData("Prueba", titulos, datos);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Qwirkle - Debug");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane1.addTab("Estr. Filas", jScrollPane1);

        jLabel1.setText("Analizador de estructura de datos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void addDebugData (String pestaña, Object [] titulo, ArrayList<ArrayList<Object>> datos)    
    {
        boolean noEditar [] = new boolean [titulo.length];
        for (int i = 0; i < noEditar.length; i++) 
        {
            noEditar [i] = false;
        }
        
        javax.swing.JScrollPane scrool = new javax.swing.JScrollPane();;
        javax.swing.JTable tabla = new javax.swing.JTable()
        {
            public String getToolTipText(MouseEvent e) 
            {
                String tip = null;
                java.awt.Point p = e.getPoint();
                int rowIndex = rowAtPoint(p);
                int colIndex = columnAtPoint(p);

                try 
                {
                    tip = getValueAt(rowIndex, colIndex).toString();
                }
                
                catch (RuntimeException e1) 
                {
                }

                return tip;
            }
        };
        
        AdminTable administrador  = new AdminTable();
        administrador.establecer_LIMITADOR_DE_DATOS(titulo.length);
        System.err.println(titulo.length);
        
        for (int i = 1; i <= titulo.length; i++) 
        {
            switch (i) 
            {
                case 1:
                {
                    administrador.establecer_CONTENEDOR_DATOS_1(datos.get(0));
                    break;
                }

                case 2:
                {
                    administrador.establecer_CONTENEDOR_DATOS_2(datos.get(1));
                    break;
                }

                case 3:
                {
                    administrador.establecer_CONTENEDOR_DATOS_3(datos.get(2));
                    break;
                }

                case 4:
                {
                    administrador.establecer_CONTENEDOR_DATOS_4(datos.get(3));
                    break;
                }

                case 5:
                {
                    administrador.establecer_CONTENEDOR_DATOS_5(datos.get(4));
                    break;
                }

                case 6:
                {
                    administrador.establecer_CONTENEDOR_DATOS_6(datos.get(5));
                    break;
                }

                case 7:
                {
                    administrador.establecer_CONTENEDOR_DATOS_7(datos.get(6));
                    break;
                }

                case 8:
                {
                    administrador.establecer_CONTENEDOR_DATOS_8(datos.get(7));
                    break;
                }

                case 9:
                {
                    administrador.establecer_CONTENEDOR_DATOS_9(datos.get(8));
                    break;
                }

                case 10:
                {
                    administrador.establecer_CONTENEDOR_DATOS_10(datos.get(9));
                    break;
                }
            }
        }
        
        administrador.actualizacion_TablaDatos_MANUAL(tabla, titulo, noEditar);
        scrool.setViewportView(tabla);
        this.jTabbedPane1.addTab(pestaña, scrool);
        
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Debug.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Debug.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Debug.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Debug.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Debug dialog = new Debug(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
