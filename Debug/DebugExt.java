package Debug;

import Model.Casilla;
import Model.Estructura;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;

public class DebugExt extends javax.swing.JDialog {

    private ArrayList<Estructura> estructuraFilas;
    private ArrayList<Estructura> estructuraColumnas;
    private HashSet<Estructura> ultimasEstructurasModificadas;
    private Casilla ultimaJugada;
    private String direccion;
    
    public DebugExt(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void updateDebug (ArrayList<Estructura> estructuraFilas, ArrayList<Estructura> estructuraColumnas,
                             HashSet<Estructura> ultimasEstructurasModificadas, Casilla ultimaJugada, String direccion)
    {
        this.estructuraFilas = estructuraFilas;
        this.estructuraColumnas = estructuraColumnas;
        this.ultimasEstructurasModificadas = ultimasEstructurasModificadas;
        this.ultimaJugada = ultimaJugada;
        this.direccion = direccion;

        updateTable();
    }

    private void updateTable ()
    {
        AdminTable administrador1 = new AdminTable();
        administrador1.establecer_LIMITADOR_DE_DATOS(1);
        AdminTable administrador2 = new AdminTable();
        administrador2.establecer_LIMITADOR_DE_DATOS(1);
        AdminTable administrador3 = new AdminTable();
        administrador3.establecer_LIMITADOR_DE_DATOS(1);
        ArrayList <Object> data1 = new ArrayList<Object>();
        ArrayList <Object> data2 = new ArrayList<Object>();
        ArrayList <Object> data3 = new ArrayList<Object>();

        for (int i = 0; i < this.estructuraFilas.size(); i ++)
        {
            data1.add(String.valueOf(i + 1));
        }

        for (int i = 0; i < this.estructuraColumnas.size(); i ++)
        {
            data2.add(String.valueOf(i + 1));
        }

        for (int i = 0; i < this.ultimasEstructurasModificadas.size(); i ++)
        {
            data3.add(String.valueOf(i + 1));
        }

        administrador1.establecer_CONTENEDOR_DATOS_1(data1);
        administrador2.establecer_CONTENEDOR_DATOS_1(data2);
        administrador3.establecer_CONTENEDOR_DATOS_1(data3);

        administrador1.actualizacion_TablaDatos_MANUAL(Tabla1, new Object [] {"LinkedList"}, new boolean [] {false});
        administrador2.actualizacion_TablaDatos_MANUAL(Tabla3, new Object [] {"LinkedList"}, new boolean [] {false});
        administrador3.actualizacion_TablaDatos_MANUAL(Tabla5, new Object [] {"LinkedList"}, new boolean [] {false});


        AdminTable administrador5 = new AdminTable();
        administrador5.establecer_LIMITADOR_DE_DATOS(this.estructuraColumnas.size());
        AdminTable administrador6 = new AdminTable();
        administrador6.establecer_LIMITADOR_DE_DATOS(this.ultimasEstructurasModificadas.size());

        try {
            this.ultimaJ.setText(this.ultimaJugada.getFicha().getId() + " " + this.ultimaJugada.getX() + " " + this.ultimaJugada.getY()
                    + " " + this.ultimaJugada.getCasillaSuperior() + " " + ultimaJugada.getCasillaInferior() + " " + ultimaJugada.getCasillaIzquierda()
                    + " " + this.ultimaJugada.getCasillaDerecha());
        }

        catch (Exception err)
        {
            System.out.println("Ultima jugada no disponibles");
        }

        this.address.setText("Dirección: " + this.direccion);
    }

    private void changeData1 (int posicion)
    {
        this.res1.setText("Restricción: " + this.estructuraFilas.get(posicion).getRestriccion());
        this.id1.setText("id: " + this.estructuraFilas.get(posicion).getId());
        this.id11.setText("ID: " + this.estructuraFilas.get(posicion).getID());

        AdminTable administrador1 = new AdminTable();
        administrador1.establecer_LIMITADOR_DE_DATOS(7);

        ArrayList<Object> data1 = new ArrayList<Object>();
        ArrayList<Object> data2 = new ArrayList<Object>();
        ArrayList<Object> data3 = new ArrayList<Object>();
        ArrayList<Object> data4 = new ArrayList<Object>();
        ArrayList<Object> data5 = new ArrayList<Object>();
        ArrayList<Object> data6 = new ArrayList<Object>();
        ArrayList<Object> data7 = new ArrayList<Object>();

        for (int i = 0; i < this.estructuraFilas.get(posicion).getCola().size(); i ++)
        {
            data1.add(this.estructuraFilas.get(posicion).getCola().get(i).getX());
            data2.add(this.estructuraFilas.get(posicion).getCola().get(i).getY());
            data3.add("th");
            if (this.estructuraFilas.get(posicion).getCola().get(i).getCasillaSuperior().getFicha() == null)
            {
                data4.add("None");
            }

            else
            {
                data4.add(this.estructuraFilas.get(posicion).getCola().get(i).getCasillaSuperior().getFicha().getId());
            }

            if (this.estructuraFilas.get(posicion).getCola().get(i).getCasillaInferior().getFicha() == null)
            {
                data5.add("None");
            }

            else
            {
                data5.add(this.estructuraFilas.get(posicion).getCola().get(i).getCasillaInferior().getFicha().getId());
            }

            if (this.estructuraFilas.get(posicion).getCola().get(i).getCasillaIzquierda().getFicha() == null)
            {
                data6.add("None");
            }

            else
            {
                data6.add(this.estructuraFilas.get(posicion).getCola().get(i).getCasillaIzquierda().getFicha().getId());
            }

            if (this.estructuraFilas.get(posicion).getCola().get(i).getCasillaDerecha().getFicha() == null)
            {
                data7.add("None");
            }

            else
            {
                data7.add(this.estructuraFilas.get(posicion).getCola().get(i).getCasillaDerecha().getFicha().getId());
            }
        }

        administrador1.establecer_CONTENEDOR_DATOS_1(data1);
        administrador1.establecer_CONTENEDOR_DATOS_2(data2);
        administrador1.establecer_CONTENEDOR_DATOS_3(data3);
        administrador1.establecer_CONTENEDOR_DATOS_4(data4);
        administrador1.establecer_CONTENEDOR_DATOS_5(data5);
        administrador1.establecer_CONTENEDOR_DATOS_6(data6);
        administrador1.establecer_CONTENEDOR_DATOS_7(data7);

        String [] titulos = new String [] {
                "X", "Y", "Ficha", "Casilla Superior", "Casilla Inferior", "Casilla Izquierda", "Casilla Derecha"
        };

        administrador1.actualizacion_TablaDatos_MANUAL(Tabla2, titulos, new boolean [] {false, false, false, false,
                                                                                        false, false, false});
    }

    private void changeData2 (int posicion)
    {
        this.res2.setText("Restricción: " + this.estructuraColumnas.get(posicion).getRestriccion());
        this.id2.setText("id: " + this.estructuraColumnas.get(posicion).getId());
        this.id22.setText("ID: " + this.estructuraColumnas.get(posicion).getID());

        AdminTable administrador1 = new AdminTable();
        administrador1.establecer_LIMITADOR_DE_DATOS(7);

        ArrayList<Object> data1 = new ArrayList<Object>();
        ArrayList<Object> data2 = new ArrayList<Object>();
        ArrayList<Object> data3 = new ArrayList<Object>();
        ArrayList<Object> data4 = new ArrayList<Object>();
        ArrayList<Object> data5 = new ArrayList<Object>();
        ArrayList<Object> data6 = new ArrayList<Object>();
        ArrayList<Object> data7 = new ArrayList<Object>();

        for (int i = 0; i < this.estructuraColumnas.get(posicion).getCola().size(); i ++)
        {
            data1.add(this.estructuraColumnas.get(posicion).getCola().get(i).getX());
            data2.add(this.estructuraColumnas.get(posicion).getCola().get(i).getY());
            data3.add("th");
            if (this.estructuraColumnas.get(posicion).getCola().get(i).getCasillaSuperior().getFicha() == null)
            {
                data4.add("None");
            }

            else
            {
                data4.add(this.estructuraColumnas.get(posicion).getCola().get(i).getCasillaSuperior().getFicha().getId());
            }

            if (this.estructuraColumnas.get(posicion).getCola().get(i).getCasillaInferior().getFicha() == null)
            {
                data5.add("None");
            }

            else
            {
                data5.add(this.estructuraColumnas.get(posicion).getCola().get(i).getCasillaInferior().getFicha().getId());
            }

            if (this.estructuraColumnas.get(posicion).getCola().get(i).getCasillaIzquierda().getFicha() == null)
            {
                data6.add("None");
            }

            else
            {
                data6.add(this.estructuraColumnas.get(posicion).getCola().get(i).getCasillaIzquierda().getFicha().getId());
            }

            if (this.estructuraColumnas.get(posicion).getCola().get(i).getCasillaDerecha().getFicha() == null)
            {
                data7.add("None");
            }

            else
            {
                data7.add(this.estructuraColumnas.get(posicion).getCola().get(i).getCasillaDerecha().getFicha().getId());
            }
        }

        administrador1.establecer_CONTENEDOR_DATOS_1(data1);
        administrador1.establecer_CONTENEDOR_DATOS_2(data2);
        administrador1.establecer_CONTENEDOR_DATOS_3(data3);
        administrador1.establecer_CONTENEDOR_DATOS_4(data4);
        administrador1.establecer_CONTENEDOR_DATOS_5(data5);
        administrador1.establecer_CONTENEDOR_DATOS_6(data6);
        administrador1.establecer_CONTENEDOR_DATOS_7(data7);

        String [] titulos = new String [] {
                "X", "Y", "Ficha", "Casilla Superior", "Casilla Inferior", "Casilla Izquierda", "Casilla Derecha"
        };

        administrador1.actualizacion_TablaDatos_MANUAL(Tabla4, titulos, new boolean [] {false, false, false, false,
                false, false, false});
    }

    private void changeData3 (int posicion)
    {
        int contador = 0;

        for(Estructura datos: this.ultimasEstructurasModificadas){
            if (posicion == contador)
            {

                this.res3.setText("Restricción: " + datos.getRestriccion());
                this.id3.setText("id: " + datos.getId());
                this.id33.setText("ID: " + datos.getID());

                AdminTable administrador1 = new AdminTable();
                administrador1.establecer_LIMITADOR_DE_DATOS(7);

                ArrayList<Object> data1 = new ArrayList<Object>();
                ArrayList<Object> data2 = new ArrayList<Object>();
                ArrayList<Object> data3 = new ArrayList<Object>();
                ArrayList<Object> data4 = new ArrayList<Object>();
                ArrayList<Object> data5 = new ArrayList<Object>();
                ArrayList<Object> data6 = new ArrayList<Object>();
                ArrayList<Object> data7 = new ArrayList<Object>();

                for (int i = 0; i < datos.getCola().size(); i ++)
                {
                    data1.add(datos.getCola().get(i).getX());
                    data2.add(datos.getCola().get(i).getY());
                    data3.add("th");
                    if (datos.getCola().get(i).getCasillaSuperior().getFicha() == null)
                    {
                        data4.add("None");
                    }

                    else
                    {
                        data4.add(datos.getCola().get(i).getCasillaSuperior().getFicha().getId());
                    }

                    if (datos.getCola().get(i).getCasillaInferior().getFicha() == null)
                    {
                        data5.add("None");
                    }

                    else
                    {
                        data5.add(datos.getCola().get(i).getCasillaInferior().getFicha().getId());
                    }

                    if (datos.getCola().get(i).getCasillaIzquierda().getFicha() == null)
                    {
                        data6.add("None");
                    }

                    else
                    {
                        data6.add(datos.getCola().get(i).getCasillaIzquierda().getFicha().getId());
                    }

                    if (datos.getCola().get(i).getCasillaDerecha().getFicha() == null)
                    {
                        data7.add("None");
                    }

                    else
                    {
                        data7.add(datos.getCola().get(i).getCasillaDerecha().getFicha().getId());
                    }
                }

                administrador1.establecer_CONTENEDOR_DATOS_1(data1);
                administrador1.establecer_CONTENEDOR_DATOS_2(data2);
                administrador1.establecer_CONTENEDOR_DATOS_3(data3);
                administrador1.establecer_CONTENEDOR_DATOS_4(data4);
                administrador1.establecer_CONTENEDOR_DATOS_5(data5);
                administrador1.establecer_CONTENEDOR_DATOS_6(data6);
                administrador1.establecer_CONTENEDOR_DATOS_7(data7);

                String [] titulos = new String [] {
                        "X", "Y", "Ficha", "Casilla Superior", "Casilla Inferior", "Casilla Izquierda", "Casilla Derecha"
                };

                administrador1.actualizacion_TablaDatos_MANUAL(Tabla6, titulos, new boolean [] {false, false, false, false,
                        false, false, false});

                return;
            }

            contador ++;
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla1 = new javax.swing.JTable() {
            //Implement table cell tool tips.
            public String getToolTipText(MouseEvent e) {
                String tip = null;
                java.awt.Point p = e.getPoint();
                int rowIndex = rowAtPoint(p);
                int colIndex = columnAtPoint(p);

                try {
                    tip = getValueAt(rowIndex, colIndex).toString();
                } catch (RuntimeException e1) {
                    //catch null pointer exception if mouse is over an empty line
                }

                return tip;
            }
        }
        ;
        jButton1 = new javax.swing.JButton();
        res1 = new javax.swing.JLabel();
        id1 = new javax.swing.JLabel();
        id11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabla2 = new javax.swing.JTable(){
            //Implement table cell tool tips.
            public String getToolTipText(MouseEvent e) {
                String tip = null;
                java.awt.Point p = e.getPoint();
                int rowIndex = rowAtPoint(p);
                int colIndex = columnAtPoint(p);

                try {
                    tip = getValueAt(rowIndex, colIndex).toString();
                } catch (RuntimeException e1) {
                    //catch null pointer exception if mouse is over an empty line
                }

                return tip;
            }
        };
        jPanel5 = new javax.swing.JPanel();
        jSplitPane3 = new javax.swing.JSplitPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tabla3 = new javax.swing.JTable(){
            //Implement table cell tool tips.
            public String getToolTipText(MouseEvent e) {
                String tip = null;
                java.awt.Point p = e.getPoint();
                int rowIndex = rowAtPoint(p);
                int colIndex = columnAtPoint(p);

                try {
                    tip = getValueAt(rowIndex, colIndex).toString();
                } catch (RuntimeException e1) {
                    //catch null pointer exception if mouse is over an empty line
                }

                return tip;
            }
        }
        ;
        jButton2 = new javax.swing.JButton();
        res2 = new javax.swing.JLabel();
        id2 = new javax.swing.JLabel();
        id22 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        Tabla4 = new javax.swing.JTable(){
            //Implement table cell tool tips.
            public String getToolTipText(MouseEvent e) {
                String tip = null;
                java.awt.Point p = e.getPoint();
                int rowIndex = rowAtPoint(p);
                int colIndex = columnAtPoint(p);

                try {
                    tip = getValueAt(rowIndex, colIndex).toString();
                } catch (RuntimeException e1) {
                    //catch null pointer exception if mouse is over an empty line
                }

                return tip;
            }
        }
        ;
        jPanel8 = new javax.swing.JPanel();
        jSplitPane4 = new javax.swing.JSplitPane();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        Tabla5 = new javax.swing.JTable() {
            //Implement table cell tool tips.
            public String getToolTipText(MouseEvent e) {
                String tip = null;
                java.awt.Point p = e.getPoint();
                int rowIndex = rowAtPoint(p);
                int colIndex = columnAtPoint(p);

                try {
                    tip = getValueAt(rowIndex, colIndex).toString();
                } catch (RuntimeException e1) {
                    //catch null pointer exception if mouse is over an empty line
                }

                return tip;
            }
        }
        ;
        jButton3 = new javax.swing.JButton();
        res3 = new javax.swing.JLabel();
        id3 = new javax.swing.JLabel();
        id33 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        Tabla6 = new javax.swing.JTable(){
            //Implement table cell tool tips.
            public String getToolTipText(MouseEvent e) {
                String tip = null;
                java.awt.Point p = e.getPoint();
                int rowIndex = rowAtPoint(p);
                int colIndex = columnAtPoint(p);

                try {
                    tip = getValueAt(rowIndex, colIndex).toString();
                } catch (RuntimeException e1) {
                    //catch null pointer exception if mouse is over an empty line
                }

                return tip;
            }
        };
        jButton4 = new javax.swing.JButton();
        ultimaJ = new javax.swing.JLabel();
        address = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Debug - Estructura de datos");
        // setAlwaysOnTop(true);

        jLabel1.setText("Analizador de estructura de datos");

        jSplitPane2.setDividerLocation(180);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel4.setText("Estructura de filas:");

        Tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "LinkedList"
            }
        ));
        jScrollPane2.setViewportView(Tabla1);

        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        res1.setText("Restricción: ");

        id1.setText("id:");

        id11.setText("ID:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(id11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(id1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(res1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(res1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(id1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(id11, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jSplitPane2.setTopComponent(jPanel4);

        jLabel3.setText("Estructura casilla:");

        Tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "X", "Y", "Casilla Superior", "Casilla Inferior", "Casilla Izquierda", "Casilla Derecha"
            }
        ));
        jScrollPane3.setViewportView(Tabla2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
        );

        jSplitPane2.setRightComponent(jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Filas", jPanel1);

        jSplitPane3.setDividerLocation(180);
        jSplitPane3.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel8.setText("Estructura de columnas:");

        Tabla3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "LinkedList"
            }
        ));
        jScrollPane4.setViewportView(Tabla3);

        jButton2.setText("Seleccionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        res2.setText("Restricción: ");

        id2.setText("id:");

        id22.setText("ID:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(id22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(id2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(res2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(res2, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(id2, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(id22, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jSplitPane3.setTopComponent(jPanel6);

        jLabel12.setText("Estructura casilla:");

        Tabla4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "X", "Y", "Casilla Superior", "Casilla Inferior", "Casilla Izquierda", "Casilla Derecha"
            }
        ));
        jScrollPane5.setViewportView(Tabla4);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
        );

        jSplitPane3.setRightComponent(jPanel7);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane3)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Columnas", jPanel5);

        jSplitPane4.setDividerLocation(180);
        jSplitPane4.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel5.setText("Estructura de ultimas modificadas:");

        Tabla5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "LinkedList"
            }
        ));
        jScrollPane6.setViewportView(Tabla5);

        jButton3.setText("Seleccionar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        res3.setText("Restricción: ");

        id3.setText("id:");

        id33.setText("ID:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(id33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(id3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(res3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(res3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(id3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(id33, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jSplitPane4.setTopComponent(jPanel9);

        jLabel6.setText("Estructura casilla:");

        Tabla6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "X", "Y", "Casilla Superior", "Casilla Inferior", "Casilla Izquierda", "Casilla Derecha"
            }
        ));
        jScrollPane7.setViewportView(Tabla6);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
        );

        jSplitPane4.setRightComponent(jPanel10);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane4)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ultimas modificadas", jPanel8);

        jButton4.setText("Actualizar");

        ultimaJ.setText("Ultima jugada:");

        address.setText("Dirección:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(ultimaJ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(ultimaJ)
                    .addComponent(address))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int index = Tabla1.getSelectedRow();
        
        if (index == -1)
        {
            return;
        }

        changeData1(index);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int index = Tabla3.getSelectedRow();
        
        if (index == -1)
        {
            return;
        }

        changeData2(index);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int index = Tabla5.getSelectedRow();
        
        if (index == -1)
        {
            return;
        }

        changeData3(index);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(DebugExt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DebugExt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DebugExt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DebugExt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DebugExt dialog = new DebugExt(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable Tabla1;
    private javax.swing.JTable Tabla2;
    private javax.swing.JTable Tabla3;
    private javax.swing.JTable Tabla4;
    private javax.swing.JTable Tabla5;
    private javax.swing.JTable Tabla6;
    private javax.swing.JLabel address;
    private javax.swing.JLabel id1;
    private javax.swing.JLabel id11;
    private javax.swing.JLabel id2;
    private javax.swing.JLabel id22;
    private javax.swing.JLabel id3;
    private javax.swing.JLabel id33;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    public javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel res1;
    private javax.swing.JLabel res2;
    private javax.swing.JLabel res3;
    private javax.swing.JLabel ultimaJ;
    // End of variables declaration//GEN-END:variables
}
