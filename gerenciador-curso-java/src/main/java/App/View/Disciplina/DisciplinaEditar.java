package App.View.Disciplina;

import App.View.Aluno.*;
import App.Controller.Disciplina.DisciplinaController;
import App.Model.Disciplina.IDisciplina;
import App.View.Aula.AulaView;
import App.View.Professor.ProfessorView;
import App.View.Relatorio.RelatorioView;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernanda
 */
public class DisciplinaEditar extends javax.swing.JFrame {

    /**
     * Creates new form ContactEditorUI
     */
    public DisciplinaEditar() {
        initComponents();
    }

    private int id;

    public void setInput(IDisciplina disciplina) {
        id = disciplina.getId();
        textConteudo.setText(disciplina.getConteudo());
        cargaHoraria.setText(Double.toString(disciplina.getCargaHoraria()));
        tipo.setText(disciplina.getTipo());
        codigo.setText(disciplina.getCodigo());
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cargaHoraria = new javax.swing.JTextField();
        btnSalvar = new java.awt.Button();
        mensagem = new javax.swing.JLabel();
        conteudo = new javax.swing.JScrollPane();
        textConteudo = new javax.swing.JTextArea();
        codigo = new javax.swing.JLabel();
        tipo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        alunoMenu = new javax.swing.JMenu();
        professorMenu = new javax.swing.JMenu();
        disciplinaMenu = new javax.swing.JMenu();
        aulaMenu = new javax.swing.JMenu();
        relatorioMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gerenciar Disciplina", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel1.setText("Código:");

        jLabel2.setText("Tipo:");

        jLabel3.setText("Carga Horária:");

        jLabel5.setText("Conteúdo:");

        btnSalvar.setLabel("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        textConteudo.setColumns(20);
        textConteudo.setRows(5);
        conteudo.setViewportView(textConteudo);

        codigo.setText("jLabel4");

        tipo.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(cargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(mensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(140, 140, 140)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(conteudo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(conteudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(codigo)
                            .addComponent(tipo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(289, Short.MAX_VALUE))
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

        relatorioMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        relatorioMenu.setText("Relatórios");
        relatorioMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                relatorioMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(relatorioMenu);

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

        jPanel1.getAccessibleContext().setAccessibleName("Disciplinas");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        DisciplinaController controller = new DisciplinaController();
        try {
            controller.update(id, textConteudo.getText(), Double.parseDouble(cargaHoraria.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaEditar.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Crio uma nova tela Aluno 
        DisciplinaView view = new DisciplinaView();
        // Exibo essa nova tela aluno.
        view.setVisible(true);
        // Fecha a antiga tela
        this.dispose();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void alunoMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alunoMenuMouseClicked
        new AlunoView().setVisible(true);
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

    private void relatorioMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_relatorioMenuMouseClicked
        new RelatorioView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_relatorioMenuMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisciplinaEditar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu alunoMenu;
    private javax.swing.JMenu aulaMenu;
    private java.awt.Button btnSalvar;
    private javax.swing.JTextField cargaHoraria;
    private javax.swing.JLabel codigo;
    private javax.swing.JScrollPane conteudo;
    private javax.swing.JMenu disciplinaMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel mensagem;
    private javax.swing.JMenu professorMenu;
    private javax.swing.JMenu relatorioMenu;
    private javax.swing.JTextArea textConteudo;
    private javax.swing.JLabel tipo;
    // End of variables declaration//GEN-END:variables
}
