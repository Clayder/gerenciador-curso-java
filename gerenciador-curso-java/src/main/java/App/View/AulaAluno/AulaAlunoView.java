/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.View.AulaAluno;

import App.View.Aluno.*;
import App.Controller.Aluno.AlunoController;
import App.Model.Aluno.Aluno;
import App.Model.Aluno.IAluno;
import App.View.Aula.AulaView;
import App.View.Disciplina.DisciplinaView;
import App.View.Professor.ProfessorView;
import java.awt.Color;
import java.awt.Point;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fernanda
 */
public class AulaAlunoView extends javax.swing.JFrame {

    /**
     * Creates new form ContactEditorUI
     */
    public AulaAlunoView() {
        initComponents();
    }

    public void setAula(String aula) {
        this.aula.setText(aula);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        button4 = new java.awt.Button();
        btnSalvar = new java.awt.Button();
        mensagem = new javax.swing.JLabel();
        aula = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        alunos = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        alunoMenu = new javax.swing.JMenu();
        professorMenu = new javax.swing.JMenu();
        disciplinaMenu = new javax.swing.JMenu();
        aulaMenu = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gerenciar Aluno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel1.setText("Aula :");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matrícula", "Nome", "Telefone", "E-mail", "Editar", "Excluir"
            }
        ));
        tabela.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tabelaAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        button4.setLabel("Cancelar");

        btnSalvar.setLabel("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        aula.setText("jLabel4");

        jLabel6.setText("Aluno :");

        alunos.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                alunosAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aula, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(13, Short.MAX_VALUE)
                        .addComponent(mensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alunos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(aula)
                    .addComponent(jLabel6)
                    .addComponent(alunos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        alunoMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        alunoMenu.setText("Aluno");
        alunoMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alunoMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(alunoMenu);

        professorMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        professorMenu.setText("Professor");
        professorMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                professorMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(professorMenu);

        disciplinaMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        disciplinaMenu.setText("Disciplina");
        disciplinaMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disciplinaMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(disciplinaMenu);

        aulaMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        aulaMenu.setText("Aula");
        aulaMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aulaMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(aulaMenu);

        jMenu5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu5.setText("Relatórios");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Gerenciar Alunos da aula");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tabelaAncestorAdded

        AlunoController controller = new AlunoController();
        try {
            // Recebe os alunos
            for (IAluno item : controller.getAll()) {
                
                /**
                 * Cria a nova linha na tabela
                 */
                DefaultTableModel model = (DefaultTableModel) tabela.getModel();
                
                /**
                 * Popula a nova linha da tabela
                 */
                model.addRow(
                        new Object[]{
                            item.getMatricula(),
                            item.getNome(),
                            item.getTelefone(),
                            item.getEmail(),
                            "Editar",
                            "Excluir"
                        }
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_tabelaAncestorAdded

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
//        try {
//                
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(AulaAlunoView.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void alunoMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alunoMenuMouseClicked
        new AulaAlunoView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_alunoMenuMouseClicked

    private void professorMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_professorMenuMouseClicked
        new ProfessorView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_professorMenuMouseClicked

    private void disciplinaMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disciplinaMenuMouseClicked
        new DisciplinaView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_disciplinaMenuMouseClicked

    private void aulaMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aulaMenuMouseClicked
        new AulaView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_aulaMenuMouseClicked

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        Point point = evt.getPoint();
        // Captura o numero da coluna
        int coluna = tabela.columnAtPoint(point);
        // Captura o número da linha
        int linha = tabela.rowAtPoint(point);

        AlunoController controller = new AlunoController();

        // Verifica qual foi o número da coluna e realiza alguma ação 
        switch (coluna) {
            // Se a coluna for excluir 
            case 5:
                // Crio uma nova tela Aluno 
                AulaAlunoView view = new AulaAlunoView();
                // Exibo essa nova tela aluno.
                view.setVisible(true);
                 {
                    try {
                        // Excluir o registro 
                        view.mensagem.setText(controller.excluir(controller.getAll().get(linha).getId()));

                    } catch (SQLException ex) {
                        Logger.getLogger(AulaAlunoView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                 // Fecha a antiga tela
                this.dispose();
                
                /**
                 *  view.setVisible(true);
                 *  this.dispose();
                 * 
                 *  São utilizados para atualizar a tela. 
                 */
                break;
        }

    }//GEN-LAST:event_tabelaMouseClicked

    private void alunosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_alunosAncestorAdded
        DefaultComboBoxModel<String> newItem = new javax.swing.DefaultComboBoxModel<>();

        AlunoController itens = new AlunoController();

        try {
            for (IAluno item : itens.getAll()) {
                newItem.addElement(item.getMatricula());
            }
        } catch (SQLException ex) {
            Logger.getLogger(AulaAlunoView.class.getName()).log(Level.SEVERE, null, ex);
        }

        alunos.setModel(newItem);
    }//GEN-LAST:event_alunosAncestorAdded

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AulaAlunoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AulaAlunoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AulaAlunoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AulaAlunoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AulaAlunoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu alunoMenu;
    private javax.swing.JComboBox<String> alunos;
    private javax.swing.JLabel aula;
    private javax.swing.JMenu aulaMenu;
    private java.awt.Button btnSalvar;
    private java.awt.Button button4;
    private javax.swing.JMenu disciplinaMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mensagem;
    private javax.swing.JMenu professorMenu;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
