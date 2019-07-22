/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package janela;

import classes.ImageEx;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class JanelaQueTemODesenho extends javax.swing.JInternalFrame {

    private BufferedImage bi, biFiltered;
    private BufferedImageOp op = null;
    private File arquivoImagem;
    private String formatoImagem;
    private int w, h;
    private Graphics big;
    //private Graphics2D g2;
    private ArrayList<BufferedImage> pilhaDesfazerBI = new ArrayList();
    private ArrayList<BufferedImage> pilhaRefazerBI = new ArrayList();
    private static JanelaQueTemODesenho janelaComFoco;
    /**
     * Lista de janelas ativas
     */
    public static ArrayList<JanelaQueTemODesenho> listaJanela = new ArrayList();
    private boolean modificacaoFeita;

    /**
     * Construtor
     */
    public JanelaQueTemODesenho() {
        initComponents();
        
    }

    /**
     * Faz a rotina de verificar se há alterações feitas nos documentos ativos
     *
     * @return boolean
     */
    public static boolean fecharTudo() {
        ArrayList<JanelaQueTemODesenho> lj = (ArrayList<JanelaQueTemODesenho>) listaJanela.clone();
        for (JanelaQueTemODesenho j : lj) {
            if (!j.fechar()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Retorna o BufferedImage da janela
     *
     * @return BufferedImage
     */
    public BufferedImage getBI() {
        return bi;
    }

    /**
     *
     * @return
     */
    public static JanelaQueTemODesenho getJanelaComFoco() {
        return janelaComFoco;
    }

    public static void setJanelaComFoco(JanelaQueTemODesenho janelaComFoco) {
        JanelaQueTemODesenho.janelaComFoco = janelaComFoco;
    }

    public void desfazer() {
        BufferedImage biAnterior = pilhaDesfazerBI.get(-2 + pilhaDesfazerBI.size()); // pegar a penúltima ação (a última é o proprio bi)
        labelImagem.setIcon(new ImageIcon(biAnterior));
        pilhaRefazerBI.add(bi);
        pilhaDesfazerBI.remove(pilhaDesfazerBI.size() - 1);
        if (pilhaDesfazerBI.toArray().length == 1) {
            JMain.getInstance().getJMenuDesfazer().setEnabled(false);
            modificacaoFeita = false;
        } else {
            modificacaoFeita = true;
        }
        JMain.getInstance().getJMenuRefazer().setEnabled(true);
        bi = biAnterior;
        redimensionarPorBI(bi);

    }

    public void refazer() {
        BufferedImage biRefazer = pilhaRefazerBI.get(-1 + pilhaRefazerBI.size());
        labelImagem.setIcon(new ImageIcon(biRefazer));
        pilhaDesfazerBI.add(biRefazer);
        pilhaRefazerBI.remove(biRefazer);
        if (pilhaRefazerBI.toArray().length == 0) {
            JMain.getInstance().getJMenuRefazer().setEnabled(false);
        }
        JMain.getInstance().getJMenuDesfazer().setEnabled(true);
        bi = biRefazer;
        redimensionarPorBI(bi);
        modificacaoFeita = true;
    }

    public void atualiza() {
        labelImagem.setIcon(new ImageIcon(bi));
        redimensionarPorBI(bi);
    }

    public void atualizaOp(BufferedImageOp rop) {
        biFiltered = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        rop.filter(bi, biFiltered);
        labelImagem.setIcon(new ImageIcon(biFiltered));
    }

    public void aplicar() {
        JMain.getInstance().getJMenuDesfazer().setEnabled(true);
        JMain.getInstance().getJMenuRefazer().setEnabled(false);
        bi = biFiltered;
        pilhaDesfazerBI.add(bi);
        pilhaRefazerBI.removeAll(pilhaRefazerBI);
        redimensionarPorBI(bi);
        modificacaoFeita = true;

    }

    public void desaplicar() {
        biFiltered = bi;
        labelImagem.setIcon(new ImageIcon(bi));
        redimensionarPorBI(bi);
    }

    public void redimensionarPorBI(BufferedImage bi) {
        w = bi.getWidth();
        h = bi.getHeight();
        setSize(w + 25, h + 45);
    }

    public void abrirImagem(File f) {

        try {
            bi = ImageIO.read(f);
            redimensionarPorBI(bi);
            if (bi.getType() != BufferedImage.TYPE_INT_RGB) {
                BufferedImage bi2 = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
                big = bi2.getGraphics();
                big.drawImage(bi, 0, 0, null);
                biFiltered = bi2;
                bi = bi2;
                labelImagem.setIcon(new ImageIcon(bi));
                setTitle(f.getPath());
                pilhaDesfazerBI.add(bi);
                arquivoImagem = f;
                JMain.getInstance().getSaveMenuItem().setEnabled(true);
                JMain.getInstance().getSaveAsMenuItem().setEnabled(true);
                JMain.getInstance().getjMenuFiltro().setEnabled(true);
                formatoImagem = ImageEx.getFormatName(f);
                listaJanela.add(this);
                modificacaoFeita = false;
                //setLocation(- w / 2 + JMain.getInstance().getWidth() / 2  , - h / 2 + JMain.getInstance().getHeight() / 2 );

            }

        } catch (IOException ex) {
            Logger.getLogger(JanelaQueTemODesenho.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }

    public void salvarImagem() {
        try {
            ImageIO.write(bi, formatoImagem, arquivoImagem);
            modificacaoFeita = false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(JMain.getInstance(),  "Erro ao salvar imagem. \n " + ex, "Erro",  JOptionPane.ERROR_MESSAGE);
        }
    }

    public void salvarImagem(File f, String format) {
        
        if (f.getName().toString().toLowerCase().endsWith(".jpg")) {
            format = "JPG";
        } else if (f.getName().toString().toLowerCase().endsWith(".gif")) {
            format = "GIF";
        } else if (f.getName().toString().toLowerCase().endsWith(".bmp")) {
            format = "BMP";
        } else if (f.getName().toString().toLowerCase().endsWith(".jpeg")) {
            format = "JPEG";
        } else {
            f = new File(f.getPath() + "." + format);
        }
        System.out.println("format: " + format);
        try {
            ImageIO.write(bi, format, f);
            formatoImagem = format;
            setTitle(f.getPath());
            modificacaoFeita = false;

        } catch (IOException ex) {
            Logger.getLogger(JanelaQueTemODesenho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelImagem = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        labelImagem.setAutoscrolls(true);
        labelImagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelImagemMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                labelImagemMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelImagem, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelImagem, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        gotFocus();
    }//GEN-LAST:event_formFocusGained

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        if (w > labelImagem.getWidth()) {
        }
    }//GEN-LAST:event_formComponentResized

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        gotFocus();
    }//GEN-LAST:event_formMouseClicked

    private void labelImagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelImagemMouseClicked
    }//GEN-LAST:event_labelImagemMouseClicked

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed

    }//GEN-LAST:event_formInternalFrameClosed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        fechar();
    }//GEN-LAST:event_formInternalFrameClosing

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        gotFocus();
    }//GEN-LAST:event_formInternalFrameActivated

    private void labelImagemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelImagemMouseReleased
//        if (evt.getButton()== MouseEvent.BUTTON3){
//            if (evt.isPopupTrigger()){
//                JMenu m =  JMain.getInstance().getjMenuFiltro();
//                JMain.getInstance().getMMenuBar().remove(2);
//                m.getPopupMenu().show(evt.getComponent(), evt.getX(), evt.getY());                
//                JMain.getInstance().getMMenuBar().add(m, 2);
//            }
//        }
    }//GEN-LAST:event_labelImagemMouseReleased

    public boolean fechar() {
        this.moveToFront();
        // Se houver modificação feita...
        if (modificacaoFeita) {
            int r = JOptionPane.showConfirmDialog(JMain.getInstance(), "Deseja salvar alterações em " + getTitle() + "?", "Confirmar alterações", JOptionPane.YES_NO_CANCEL_OPTION);
            switch (r) {
                case JOptionPane.YES_OPTION:
                    salvarImagem();
                    break;
                case JOptionPane.NO_OPTION:
                    break;

                case JOptionPane.CANCEL_OPTION:
                    return false;
            }
        }
        listaJanela.remove(this);
        try {
            // Setar uma outra janela para ter o foco
            // Se caso der erro, é porque não há mais janelas ativas...
            JanelaQueTemODesenho jfocus = listaJanela.get(listaJanela.size() - 1);
            jfocus.moveToFront();
            JanelaQueTemODesenho.setJanelaComFoco(jfocus);

        } catch (Exception e) {
            // ... e os menus referente as janelas abertas serão bloqueados
            JMain.getInstance().getjMenuFiltro().setEnabled(false);
            JMain.getInstance().getSaveAsMenuItem().setEnabled(false);
            JMain.getInstance().getSaveMenuItem().setEnabled(false);
            JMain.getInstance().getJMenuDesfazer().setEnabled(false);
            JMain.getInstance().getJMenuRefazer().setEnabled(false);
            JanelaQueTemODesenho.setJanelaComFoco(null);
            
        }
        dispose();
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelImagem;
    // End of variables declaration//GEN-END:variables

    private void filterImage() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void gotFocus() {
        JanelaQueTemODesenho.setJanelaComFoco(this);

        if (pilhaDesfazerBI.toArray().length == 1) {
            JMain.getInstance().getJMenuDesfazer().setEnabled(false);
        } else {
            JMain.getInstance().getJMenuDesfazer().setEnabled(true);
        }
    }
}
