package janela;

import classes.ExtensionFileFilter;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorConvertOp;
import java.awt.image.RescaleOp;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileFilter;



public class JMain extends javax.swing.JFrame {

    private static JMain instance;
    public static JMain getInstance(){
        return instance;
    }
    public JMain() {
        initComponents();
        
        setLocationRelativeTo(null);  
        setTitle("PhotoJava (desenvolvido por Paulo e Tiago)");

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator4 = new javax.swing.JSeparator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        jMenuArquivo = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenuEditar = new javax.swing.JMenu();
        mDesfazer = new javax.swing.JMenuItem();
        mRefazer = new javax.swing.JMenuItem();
        jMenuFiltro = new javax.swing.JMenu();
        mRotate = new javax.swing.JMenuItem();
        mZoom = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        mBrilho = new javax.swing.JMenuItem();
        mContraste = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        jMenuCor = new javax.swing.JMenu();
        mEscalaDeCinza = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuPlus = new javax.swing.JMenuItem();
        jMenuAjuda = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jMenuArquivo.setMnemonic('f');
        jMenuArquivo.setText("Arquivo");

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Abrir");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        jMenuArquivo.add(openMenuItem);
        jMenuArquivo.add(jSeparator1);

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Salvar");
        saveMenuItem.setEnabled(false);
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        jMenuArquivo.add(saveMenuItem);

        saveAsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Salvar como...");
        saveAsMenuItem.setEnabled(false);
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });
        jMenuArquivo.add(saveAsMenuItem);
        jMenuArquivo.add(jSeparator3);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Sair");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        jMenuArquivo.add(exitMenuItem);

        menuBar.add(jMenuArquivo);

        jMenuEditar.setText("Editar");

        mDesfazer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        mDesfazer.setText("Desfazer");
        mDesfazer.setEnabled(false);
        mDesfazer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mDesfazerActionPerformed(evt);
            }
        });
        jMenuEditar.add(mDesfazer);

        mRefazer.setText("Refazer");
        mRefazer.setEnabled(false);
        mRefazer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mRefazerActionPerformed(evt);
            }
        });
        jMenuEditar.add(mRefazer);

        menuBar.add(jMenuEditar);

        jMenuFiltro.setMnemonic('e');
        jMenuFiltro.setText("Filtros");
        jMenuFiltro.setEnabled(false);
        jMenuFiltro.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jMenuFiltroMenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
                jMenuFiltroMenuKeyReleased(evt);
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });

        mRotate.setMnemonic('d');
        mRotate.setText("Girar");
        mRotate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mRotateActionPerformed(evt);
            }
        });
        jMenuFiltro.add(mRotate);

        mZoom.setText("Zoom");
        mZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mZoomActionPerformed(evt);
            }
        });
        jMenuFiltro.add(mZoom);
        jMenuFiltro.add(jSeparator6);

        mBrilho.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        mBrilho.setMnemonic('t');
        mBrilho.setText("Brilho");
        mBrilho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mBrilhoActionPerformed(evt);
            }
        });
        jMenuFiltro.add(mBrilho);

        mContraste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        mContraste.setText("Contraste");
        mContraste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mContrasteActionPerformed(evt);
            }
        });
        jMenuFiltro.add(mContraste);
        jMenuFiltro.add(jSeparator5);

        jMenu2.setText("Efeitos artísticos");

        jMenuCor.setText("Cor");

        mEscalaDeCinza.setText("Escala de Cinza");
        mEscalaDeCinza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mEscalaDeCinzaActionPerformed(evt);
            }
        });
        jMenuCor.add(mEscalaDeCinza);

        jMenuItem2.setText("Negativo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuCor.add(jMenuItem2);

        jMenu2.add(jMenuCor);

        menuPlus.setText("Mais...");
        menuPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPlusActionPerformed(evt);
            }
        });
        jMenu2.add(menuPlus);

        jMenuFiltro.add(jMenu2);

        menuBar.add(jMenuFiltro);

        jMenuAjuda.setMnemonic('h');
        jMenuAjuda.setText("Ajuda");

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("Sobre");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        jMenuAjuda.add(aboutMenuItem);

        menuBar.add(jMenuAjuda);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        formWindowClosing(null);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        
        JFileChooser chooser = new JFileChooser();
        FileFilter filter1 = new ExtensionFileFilter("Imagens (JPG, JPEG, BMP, PNG)", new String[] { "JPG", "JPEG", "BMP", "PNG" });
        chooser.addChoosableFileFilter(filter1);
        chooser.setFileFilter(filter1);
        filter1 = new ExtensionFileFilter("Imagens BMP", new String[] {  "BMP" });
        chooser.addChoosableFileFilter(filter1);
        filter1 = new ExtensionFileFilter("Imagens JPEG", new String[] {  "JPEG","JPG" });
        chooser.addChoosableFileFilter(filter1);
        filter1 = new ExtensionFileFilter("Imagens PNG", new String[] {  "PNG" });
        chooser.addChoosableFileFilter(filter1);
        chooser.setCurrentDirectory(null);
        
         int rval = chooser.showOpenDialog(this);
         if (rval == JFileChooser.APPROVE_OPTION) {
                 File openFile = chooser.getSelectedFile();
                 System.out.println(openFile);
                 JanelaQueTemODesenho j = new JanelaQueTemODesenho();
                 
                 j.setVisible(true);
                 j.abrirImagem(openFile);
                 desktopPane.add(j);
                 JanelaQueTemODesenho.setJanelaComFoco(j);
                 j.moveToFront();
             }
             
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void mBrilhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mBrilhoActionPerformed
        Brilho e = new Brilho();
        e.setVisible(true);
        System.out.println("menu");
    }//GEN-LAST:event_mBrilhoActionPerformed

    private void mEscalaDeCinzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mEscalaDeCinzaActionPerformed
        BufferedImageOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY),null);
        JanelaQueTemODesenho.getJanelaComFoco().atualizaOp(op);
        JanelaQueTemODesenho.getJanelaComFoco().aplicar();
    }//GEN-LAST:event_mEscalaDeCinzaActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        RescaleOp rop = new RescaleOp(-1f, 255f, null); 
        JanelaQueTemODesenho.getJanelaComFoco().atualizaOp(rop);
        JanelaQueTemODesenho.getJanelaComFoco().aplicar();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void mContrasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mContrasteActionPerformed
        Contraste c = new Contraste();
        c.setVisible(true);
        System.out.println("contraste");
    }//GEN-LAST:event_mContrasteActionPerformed

    private void mRotateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mRotateActionPerformed
        Rotate r = new Rotate();
        r.setVisible(true);
        System.out.println("rotate");
    }//GEN-LAST:event_mRotateActionPerformed

    private void mDesfazerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mDesfazerActionPerformed
        JanelaQueTemODesenho.getJanelaComFoco().desfazer();
    }//GEN-LAST:event_mDesfazerActionPerformed

    private void mRefazerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mRefazerActionPerformed
        JanelaQueTemODesenho.getJanelaComFoco().refazer();
    }//GEN-LAST:event_mRefazerActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        Sobre sobre = new Sobre(this, true);
        sobre.setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        JanelaQueTemODesenho.getJanelaComFoco().salvarImagem();
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItemActionPerformed
        JFileChooser chooser = new JFileChooser();
        // chooser.setSelectedFile(saveFile);
        FileFilter filter1 = new ExtensionFileFilter("Imagem JPG", new String[] {  "JPG" });
        chooser.addChoosableFileFilter(filter1);
        chooser.setFileFilter(filter1);
        filter1 = new ExtensionFileFilter("Imagem BMP", new String[] {  "BMP" });
        chooser.addChoosableFileFilter(filter1);
        chooser.addChoosableFileFilter(filter1);
        filter1 = new ExtensionFileFilter("Imagem PNG", new String[] {  "PNG" });
        chooser.addChoosableFileFilter(filter1);
        chooser.setCurrentDirectory(null);
        chooser.setAcceptAllFileFilterUsed(false);
        int retornoArquivoSelecionado = chooser.showSaveDialog(null);  
        if(retornoArquivoSelecionado == JFileChooser.APPROVE_OPTION){  
                JanelaQueTemODesenho jf = JanelaQueTemODesenho.getJanelaComFoco();
                String d = chooser.getFileFilter().getDescription();
                jf.salvarImagem(chooser.getSelectedFile() , d.substring(d.length()-3));
        }  
       
    }//GEN-LAST:event_saveAsMenuItemActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (JanelaQueTemODesenho.fecharTudo()) {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void mZoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mZoomActionPerformed
        Zoom z  = new Zoom();
        z.setVisible(true);
    }//GEN-LAST:event_mZoomActionPerformed

    private void jMenuFiltroMenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenuFiltroMenuKeyPressed

    }//GEN-LAST:event_jMenuFiltroMenuKeyPressed

    private void jMenuFiltroMenuKeyReleased(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenuFiltroMenuKeyReleased

    }//GEN-LAST:event_jMenuFiltroMenuKeyReleased

    private void menuPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPlusActionPerformed
        FiltrosArtisticos f = new FiltrosArtisticos(this, false);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }//GEN-LAST:event_menuPlusActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                instance = new JMain();
                instance.setVisible(true);
            }
        });
    }
    public javax.swing.JMenuItem getJMenuDesfazer(){
        return mDesfazer;
    }
    public javax.swing.JMenuItem getJMenuRefazer(){
        return mRefazer;
    }

    public JMenu getjMenuFiltro() {
        return jMenuFiltro;
    }

    public JMenuItem getSaveAsMenuItem() {
        return saveAsMenuItem;
    }

    public JMenuItem getSaveMenuItem() {
        return saveMenuItem;
    }


    public JMenuBar getMMenuBar() {
        return menuBar;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenuAjuda;
    private javax.swing.JMenu jMenuArquivo;
    private javax.swing.JMenu jMenuCor;
    private javax.swing.JMenu jMenuEditar;
    private javax.swing.JMenu jMenuFiltro;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JMenuItem mBrilho;
    private javax.swing.JMenuItem mContraste;
    private javax.swing.JMenuItem mDesfazer;
    private javax.swing.JMenuItem mEscalaDeCinza;
    private javax.swing.JMenuItem mRefazer;
    private javax.swing.JMenuItem mRotate;
    private javax.swing.JMenuItem mZoom;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuPlus;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables
}
