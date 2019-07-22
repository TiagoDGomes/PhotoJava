
package janela;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;


public class FiltrosArtisticos extends javax.swing.JDialog {
private BufferedImageOp op;
    public FiltrosArtisticos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoBlur = new javax.swing.JButton();
        botaoSharpen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mais efeitos");
        setType(java.awt.Window.Type.UTILITY);

        botaoBlur.setText("Blur");
        botaoBlur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBlurActionPerformed(evt);
            }
        });

        botaoSharpen.setText("Sharpen");
        botaoSharpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSharpenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botaoBlur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoSharpen, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoBlur)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoSharpen)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void sharpen() {
        float[] SHARPEN3x3 = { // sharpening filter kernel
            0.f, -1.f, 0.f,
            -1.f, 5.f, -1.f,
            0.f, -1.f, 0.f
        };
        convolveOp(SHARPEN3x3);
    }

    /**
     * Efeito de embaçamento
     */
    public void blur() {
        float[] BLUR3x3 = {
            0.1f, 0.1f, 0.1f, // low-pass filter kernel
            0.1f, 0.2f, 0.1f,
            0.1f, 0.1f, 0.1f
        };
        convolveOp(BLUR3x3);

    }

    private void convolveOp(float[] data) {
        BufferedImage bi = JanelaQueTemODesenho.getJanelaComFoco().getBI();
        op = new ConvolveOp(new Kernel(3, 3, data),
                ConvolveOp.EDGE_NO_OP,
                null);
        bi = op.filter(bi, null);
        JanelaQueTemODesenho.getJanelaComFoco().atualizaOp(op);
        JanelaQueTemODesenho.getJanelaComFoco().aplicar();

    }

    private void botaoBlurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBlurActionPerformed
        blur();
    }//GEN-LAST:event_botaoBlurActionPerformed

    private void botaoSharpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSharpenActionPerformed
        sharpen();
    }//GEN-LAST:event_botaoSharpenActionPerformed

    /**
     * @param args the command line arguments
     */
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoBlur;
    private javax.swing.JButton botaoSharpen;
    // End of variables declaration//GEN-END:variables
}
