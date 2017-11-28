/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.kodikas.sistema.gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import mx.com.kodikas.sistema.datos.BaseDatos;
import mx.com.kodikas.sistema.pojos.Producto;

/**
 *
 * @author Javier Arturo
 */
public class InventariosFrame extends javax.swing.JInternalFrame {

    DefaultTableModel modeloTabla = new DefaultTableModel();
    BaseDatos base = new BaseDatos();
    Producto productoSeleccionado = null;
    String informacion = "";
    
    /**
     * Creates new form Inventarios
     */
    public InventariosFrame() {
        initComponents();
        cargarColumnasTabla();
        cargarModeloTabla();
    }

    private void cargarColumnasTabla(){
        modeloTabla.addColumn("clave");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Unidad");
        modeloTabla.addColumn("Precio Compra");
        modeloTabla.addColumn("Precio Venta");
        modeloTabla.addColumn("Existencias");
    }
    
    /**
     * Este método carga el modelo de la tabla de inventarios.
     */
    private void cargarModeloTabla(){
        limpiarTabla();
        ArrayList<Producto> listaProductos = base.obtenerProductos();
        int numeroProductos = listaProductos.size();
        modeloTabla.setNumRows(numeroProductos);
        
        for(int i = 0; i < numeroProductos; i++){
            Producto producto = listaProductos.get(i);
            String clave = producto.getIdProducto();
            String nombre = producto.getNomProducto();
            String unidad = producto.getUnidadProducto();
            Double precioCompra = producto.getPrecioCompraProducto();
            Double precioVenta = producto.getPrecioVentaProducto();
            Double existencias = producto.getExistenciasProducto();
            
            modeloTabla.setValueAt(clave, i, 0);
            modeloTabla.setValueAt(producto, i, 1);
            modeloTabla.setValueAt(unidad, i, 2);
            modeloTabla.setValueAt(precioCompra, i, 3);
            modeloTabla.setValueAt(precioVenta, i, 4);
            modeloTabla.setValueAt(existencias, i, 5);
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

        btnNuevoArticulo = new javax.swing.JButton();
        btnCategoria = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        tablaProductos.getSelectionModel().addListSelectionListener(
            new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent event) {
                    if (!event.getValueIsAdjusting() && (tablaProductos.getSelectedRow()>= 0)) {//This line prevents double events
                        int filaSeleccionada = tablaProductos.getSelectedRow();
                        Producto producto = (Producto)modeloTabla.getValueAt(filaSeleccionada, 1);
                        campoNombreProducto.setText(producto.getNomProducto());
                        campoClaveProducto.setText(producto.getIdProducto());
                        String existencias = String.valueOf(producto.getExistenciasProducto());
                        campoExistenciaProducto.setText(existencias);
                        productoSeleccionado = producto;
                        //despliegue la foto del producto
                        desplegarFoto(producto);
                    }            
                }
            }
        );
        jLabel2 = new javax.swing.JLabel();
        campoClaveProducto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoNombreProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoExistenciaProducto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoAgregarExistencia = new javax.swing.JTextField();
        btnAgregarExistencia = new javax.swing.JButton();
        btnModificarProd = new javax.swing.JButton();
        btnBorrarProd = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();

        setTitle("Inventarios");
        setToolTipText("");

        btnNuevoArticulo.setToolTipText("Nuevo Producto...");
        btnNuevoArticulo.setPreferredSize(new java.awt.Dimension(134, 134));
        ImageIcon iconBtnNuevoArticulo = new ImageIcon("images/Nuevo-articulo.png");
        Image imgBtnNuevoArticulo = iconBtnNuevoArticulo.getImage();

        Dimension prefSizeBtnNuevoArticulo = btnNuevoArticulo.getPreferredSize();

        int anchoBtnNuevoArticulo = (int)(prefSizeBtnNuevoArticulo.getWidth()* 0.6);
        int altoBtnNuevoArticulo = (int)(prefSizeBtnNuevoArticulo.getHeight()* 0.6);

        Image imgRedimBtnNuevoArticulo = imgBtnNuevoArticulo.getScaledInstance(anchoBtnNuevoArticulo, altoBtnNuevoArticulo, Image.SCALE_DEFAULT);
        ImageIcon iconRedimBtnNuevoArticulo = new ImageIcon(imgRedimBtnNuevoArticulo);

        btnNuevoArticulo.setIcon(iconRedimBtnNuevoArticulo);
        btnNuevoArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoArticuloActionPerformed(evt);
            }
        });

        btnCategoria.setToolTipText("Nueva Categoria...");
        btnCategoria.setPreferredSize(new java.awt.Dimension(134, 134));
        btnCategoria.setIcon(new ImageIcon(new ImageIcon("images/Nueva-categoria.png").getImage().getScaledInstance((int)(btnCategoria.getPreferredSize().getWidth()*0.7), (int)(btnCategoria.getPreferredSize().getHeight()*0.7), java.awt.Image.SCALE_DEFAULT)));
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });

        btnProveedor.setToolTipText("Nuevo Proveedor...");
        btnProveedor.setPreferredSize(new java.awt.Dimension(134, 134));
        btnProveedor.setIcon(new ImageIcon(new ImageIcon("images/proveedores.png").getImage().getScaledInstance((int)(btnProveedor.getPreferredSize().getWidth()*0.7), (int)(btnProveedor.getPreferredSize().getHeight()*0.7), java.awt.Image.SCALE_DEFAULT)));
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Inventarios:");

        tablaProductos.setModel(modeloTabla);
        jScrollPane1.setViewportView(tablaProductos);

        jLabel2.setText("Clave:");

        jLabel4.setText("Nombre:");

        jLabel3.setText("Existencia:");

        jLabel5.setText("Ingresar al inventario:");

        btnAgregarExistencia.setText("Agregar");
        btnAgregarExistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarExistenciaActionPerformed(evt);
            }
        });

        btnModificarProd.setPreferredSize(new java.awt.Dimension(88, 88));
        btnModificarProd.setIcon(new ImageIcon(new ImageIcon("images/editar.png").getImage().getScaledInstance((int)(btnModificarProd.getPreferredSize().getWidth()*0.6), (int)(btnModificarProd.getPreferredSize().getHeight()*0.6), java.awt.Image.SCALE_DEFAULT)));
        btnModificarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProdActionPerformed(evt);
            }
        });

        btnBorrarProd.setPreferredSize(new java.awt.Dimension(88, 88));
        btnBorrarProd.setIcon(new ImageIcon(new ImageIcon("images/eliminar.png").getImage().getScaledInstance((int)(btnBorrarProd.getPreferredSize().getWidth()*0.6), (int)(btnBorrarProd.getPreferredSize().getHeight()*0.6), java.awt.Image.SCALE_DEFAULT)));
        btnBorrarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarProdActionPerformed(evt);
            }
        });

        jLabel6.setText("Buscar:");

        campoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoBuscarKeyReleased(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(campoClaveProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(campoNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(campoAgregarExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAgregarExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnNuevoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1)
                                    .addComponent(campoExistenciaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBorrarProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnModificarProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(382, 382, 382))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(136, 136, 136)
                        .addComponent(jLabel4)
                        .addGap(387, 387, 387))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevoArticulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoClaveProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoExistenciaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoAgregarExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnModificarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBorrarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarProdActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de borrar el producto?");
        
        if(opcion == 0){
            modeloTabla.removeRow(tablaProductos.getSelectedRow());
            base.borrarProducto(productoSeleccionado);
        }
    }//GEN-LAST:event_btnBorrarProdActionPerformed

    private void btnNuevoArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoArticuloActionPerformed
        ProductoFrame articulo = new ProductoFrame(null, true, null, null, "Nuevo Producto", false);
        articulo.setVisible(true);
        articulo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        articulo.setLocation(600, 150);
        articulo.setAlwaysOnTop(true);
    }//GEN-LAST:event_btnNuevoArticuloActionPerformed

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        CategoriaFrame categoria = new CategoriaFrame(null, true);
        categoria.setVisible(true);
        categoria.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        categoria.setLocation(600, 150);
        categoria.setAlwaysOnTop(true);
    }//GEN-LAST:event_btnCategoriaActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        ProveedorFrame proveedor = new ProveedorFrame(null, true);
        proveedor.setVisible(true);
        proveedor.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        proveedor.setLocation(600, 150);
        proveedor.setAlwaysOnTop(true);
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnAgregarExistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarExistenciaActionPerformed
        
        double existencia = Double.parseDouble(campoAgregarExistencia.getText());
        double cantidadActual = productoSeleccionado.getExistenciasProducto();
        double nuevaCantidad = cantidadActual + existencia;
        base.actualizarInventario(productoSeleccionado, nuevaCantidad);
        limpiarTabla();
        cargarModeloTabla();
        
        
    }//GEN-LAST:event_btnAgregarExistenciaActionPerformed

    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased
        
        limpiarTabla();
        String cadenaBusqueda = campoBuscar.getText();
        ArrayList<Producto> listaProductos = base.obtenerProductosPorCriterio(cadenaBusqueda);
        
        int numeroProductos = listaProductos.size();
        
        modeloTabla.setNumRows(numeroProductos);
        
        for(int i = 0; i < numeroProductos; i++){
            Producto producto = listaProductos.get(i);
            String clave = producto.getIdProducto();
            String nombre = producto.getNomProducto();
            String unidad = producto.getUnidadProducto();
            Double precioCompra = producto.getPrecioCompraProducto();
            Double precioVenta = producto.getPrecioVentaProducto();
            Double existencias = producto.getExistenciasProducto();
            
            modeloTabla.setValueAt(clave, i, 0);
            modeloTabla.setValueAt(producto, i, 1);
            modeloTabla.setValueAt(unidad, i, 2);
            modeloTabla.setValueAt(precioCompra, i, 3);
            modeloTabla.setValueAt(precioVenta, i, 4);
            modeloTabla.setValueAt(existencias, i, 5);
        }
        
        
    }//GEN-LAST:event_campoBuscarKeyReleased

    private void desplegarFoto(Producto prod){
        ImageIcon imagenProducto = null;
        try {
                /*obtener imagen*/
                InputStream is = base.buscarFoto(prod);
                BufferedImage bi = ImageIO.read(is);
                imagenProducto = new ImageIcon(bi);
                
                //Redimensión de imagen para ajustarla al tamaño del JLabel.
                Image imgProd = imagenProducto.getImage();
                int anchoEtiqueta = lblImagen.getWidth(); //Obtiene ancho de la imagen
                int altoEtiqueta = lblImagen.getHeight(); //Obtiene alto de la imagen
                
                //Se crea un nuevo objeto Image con la imagen redimensionada.
                Image imgRedimensionada = imgProd.getScaledInstance(anchoEtiqueta, altoEtiqueta, Image.SCALE_DEFAULT);
               
                //Se crea un nuevo objeto ImageIcon a partir de la imagen redimensionada.
                ImageIcon iconRedimensionado = new ImageIcon(imgRedimensionada);
                
                //Establecemos la imagen redimensionada, como icono de la etiqueta de imagen.
                lblImagen.setIcon(iconRedimensionado);
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        
    }
    
    private void btnModificarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProdActionPerformed
        String nombreProducto = productoSeleccionado.getNomProducto();
        ImageIcon imagenProducto = null;
        ProductoFrame frameProd = null;
        int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro de modificar el artículo "+nombreProducto+"?");
        
        if(opcion == 0){
            try {
                /*obtener imagen*/
                InputStream is = base.buscarFoto(productoSeleccionado);
                BufferedImage bi = ImageIO.read(is);
                imagenProducto = new ImageIcon(bi);
                
                /*crear ventana de actualización*/
                frameProd = new ProductoFrame(null, true, productoSeleccionado, imagenProducto, "Actualizar producto", true);
                frameProd.setVisible(true);
                if(frameProd != null){
                    if(frameProd.getInformacion()!=""){
                        cargarModeloTabla();
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
            
        }
    }//GEN-LAST:event_btnModificarProdActionPerformed

    private void limpiarTabla(){
        int numFilas = modeloTabla.getRowCount();
        if(numFilas > 0){
            for(int i = numFilas - 1; i >= 0; i--){
                modeloTabla.removeRow(i);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarExistencia;
    private javax.swing.JButton btnBorrarProd;
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnModificarProd;
    private javax.swing.JButton btnNuevoArticulo;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JTextField campoAgregarExistencia;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JTextField campoClaveProducto;
    private javax.swing.JTextField campoExistenciaProducto;
    private javax.swing.JTextField campoNombreProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}
