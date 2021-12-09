/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTCG.view;

import CTCG.dao.HorasCompGrafDAO;
import CTCG.dao.ObsCompGrafDAO;
import CTCG.dao.OperadorDAO;
import CTCG.model.HorasCompGraf;
import CTCG.model.ObsCompGraf;
import CTCG.model.Operador;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author usuario
 */
public class FrmPrincipal extends javax.swing.JFrame {

    // Metodo Pegar Data
    public String DataCompleta() {
        Date data = new Date();
        SimpleDateFormat formatar = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataFormatada = formatar.format(data);

        return dataFormatada;
    }

    // Metodo Pegar Data
    public String DataDia() {
        Date data = new Date();
        SimpleDateFormat formatar = new SimpleDateFormat("dd");
        String dataFormatada = formatar.format(data);

        return dataFormatada;
    }

    // Metodo Pegar Data
    public String DataMes() {
        Date data = new Date();
        SimpleDateFormat formatar = new SimpleDateFormat("MM");
        String dataFormatada = formatar.format(data);

        return dataFormatada;
    }

    // Metodo Pegar Data
    public String DataAno() {
        Date data = new Date();
        SimpleDateFormat formatar = new SimpleDateFormat("yyyy");
        String dataFormatada = formatar.format(data);

        return dataFormatada;
    }

    //Metodo mostrar cardLayout 1
    public void MostraCard1(String card) {
        CardLayout cl = (CardLayout) jPanelCard1.getLayout();
        cl.show(jPanelCard1, card);
    }

    //Metodo mostrar cardLayout 2
    public void MostraCard2(String card) {
        CardLayout cl = (CardLayout) jPanelCard2.getLayout();
        cl.show(jPanelCard2, card);
    }

    //Personalizar tabelas
    public void PersonalizarTabelas() {
        JTableHeader Tb1 = tb_operador.getTableHeader();
        Tb1.setBackground(Color.black);
        Tb1.setFont(new Font("Dialog", 1, 12));
        ((DefaultTableCellRenderer) Tb1.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        jScrolloperador.getViewport().setBackground(Color.DARK_GRAY);
        tb_operador.setBackground(Color.DARK_GRAY);

        JTableHeader Tb2 = tb_obs.getTableHeader();
        Tb2.setBackground(Color.black);
        Tb2.setFont(new Font("Dialog", 1, 12));
        ((DefaultTableCellRenderer) Tb2.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        jScrollobs.getViewport().setBackground(Color.DARK_GRAY);
        tb_obs.setBackground(Color.DARK_GRAY);

        JTableHeader Tb3 = tb_registro.getTableHeader();
        Tb3.setBackground(Color.black);
        Tb3.setFont(new Font("Dialog", 1, 12));
        ((DefaultTableCellRenderer) Tb3.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        jScrollregistro.getViewport().setBackground(Color.DARK_GRAY);
        tb_registro.setBackground(Color.DARK_GRAY);

    }

    // Metodo pesquisa na lista FilmeFaca RP e FT
    public void PesquisaRegistro() {
        String rp = txt_rp.getText();
        HorasCompGrafDAO dao = new HorasCompGrafDAO();
        List<HorasCompGraf> lista = dao.Pesquisar(rp);
        DefaultTableModel dados = (DefaultTableModel) tb_registro.getModel();
        dados.setNumRows(0);
        for (HorasCompGraf c : lista) {
            dados.addRow(new Object[]{
                c.getCod_hcg(),
                c.getCadoperador(),
                c.getNomeoperador(),
                c.getOrdemprod(),
                c.getObs(),
                c.getInicio(),
                c.getTermino(),
                c.getCriado(),
                c.getModificado(),
                c.getH(),
                c.getM()
            });

        }
    }

    //Metodo listar Registro
    public void ListarRegistro() {
        HorasCompGrafDAO dao = new HorasCompGrafDAO();
        List<HorasCompGraf> lista = dao.listar();
        DefaultTableModel dados = (DefaultTableModel) tb_registro.getModel();
        dados.setNumRows(0);
        for (HorasCompGraf c : lista) {
            dados.addRow(new Object[]{
                c.getCod_hcg(),
                c.getCadoperador(),
                c.getNomeoperador(),
                c.getOrdemprod(),
                c.getObs(),
                c.getInicio(),
                c.getTermino(),
                c.getCriado(),
                c.getModificado(),
                c.getH(),
                c.getM()
            });

        }
    }

    //Metodo listar
    public void listarOperador() {
        OperadorDAO dao = new OperadorDAO();
        List<Operador> lista = dao.listar();
        DefaultTableModel dados = (DefaultTableModel) tb_operador.getModel();
        dados.setNumRows(0);
        for (Operador c : lista) {
            dados.addRow(new Object[]{
                c.getCod_oper(),
                c.getCadastro(),
                c.getNome()
            });

        }
    }

    //Metodo listar
    public void listarObsCompGraf() {
        ObsCompGrafDAO dao = new ObsCompGrafDAO();
        List<ObsCompGraf> lista = dao.listar();
        DefaultTableModel dados = (DefaultTableModel) tb_obs.getModel();
        dados.setNumRows(0);
        for (ObsCompGraf c : lista) {
            dados.addRow(new Object[]{
                c.getCod_obs(),
                c.getTipo()
            });

        }
    }

    //limpar campos
    public void LimparOperador() {
        txt_codOper_cad.setText("");
        txt_cadastroOper_cad.setText("");
        txt_nomeOper_cad.setText("");

        btn_addOper.setEnabled(false);
        btn_altOper.setEnabled(false);
        btn_exclOper.setEnabled(false);
        btn_limpOper.setEnabled(false);

    }

    //limpar campos
    public void LimparObsCompGraf() {
        txt_codObs_cad.setText("");
        txt_tipoObs_cad.setText("");

        btn_addObs.setEnabled(false);
        btn_altObs.setEnabled(false);
        btn_exclObs.setEnabled(false);
        btn_limpObs.setEnabled(false);

    }

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        PersonalizarTabelas();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelCard1 = new javax.swing.JPanel();
        jPanelCadastro = new javax.swing.JPanel();
        txt_idFaca = new javax.swing.JTextField();
        txt_rp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn_buscaRp = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cb_operador = new javax.swing.JComboBox();
        cb_obs = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_dia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_mes = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_ano = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_inicioHora = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_inicioMinuto = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_terminoHora = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_terminoMinuto = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        btn_limpaRp = new javax.swing.JButton();
        btn_buscaRpFaca2 = new javax.swing.JButton();
        btn_limpaReg = new javax.swing.JButton();
        btn_excluiReg = new javax.swing.JButton();
        btn_alteraReg = new javax.swing.JButton();
        btn_novoReg = new javax.swing.JButton();
        jScrollregistro = new javax.swing.JScrollPane();
        tb_registro = new javax.swing.JTable();
        jPanelAjustes = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanelCard2 = new javax.swing.JPanel();
        jPanelOperador = new javax.swing.JPanel();
        jScrolloperador = new javax.swing.JScrollPane();
        tb_operador = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txt_cadastroOper_cad = new javax.swing.JTextField();
        txt_nomeOper_cad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btn_addOper = new javax.swing.JButton();
        btn_altOper = new javax.swing.JButton();
        btn_exclOper = new javax.swing.JButton();
        btn_limpOper = new javax.swing.JButton();
        txt_codOper_cad = new javax.swing.JTextField();
        jPanelObs = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txt_codObs_cad = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_tipoObs_cad = new javax.swing.JTextField();
        btn_addObs = new javax.swing.JButton();
        btn_altObs = new javax.swing.JButton();
        btn_exclObs = new javax.swing.JButton();
        btn_limpObs = new javax.swing.JButton();
        jScrollobs = new javax.swing.JScrollPane();
        tb_obs = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(65, 65, 65));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel2.setBackground(new java.awt.Color(65, 65, 65));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/CartonDruck 3D.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelCard1.setBackground(new java.awt.Color(65, 65, 65));
        jPanelCard1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelCard1.setLayout(new java.awt.CardLayout());

        jPanelCadastro.setBackground(new java.awt.Color(65, 65, 65));

        txt_idFaca.setBackground(new java.awt.Color(255, 255, 255, 0));
        txt_idFaca.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        txt_idFaca.setForeground(new java.awt.Color(255, 255, 255));
        txt_idFaca.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_idFaca.setBorder(null);
        txt_idFaca.setEnabled(false);
        txt_idFaca.setFocusable(false);
        txt_idFaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idFacaActionPerformed(evt);
            }
        });

        txt_rp.setBackground(new java.awt.Color(63, 63, 63));
        txt_rp.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_rp.setForeground(new java.awt.Color(255, 255, 255));
        txt_rp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_rp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_rpKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("RP:");

        btn_buscaRp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Pesquisar2_16.png"))); // NOI18N
        btn_buscaRp.setToolTipText("Pesquisa RP");
        btn_buscaRp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_buscaRp.setBorderPainted(false);
        btn_buscaRp.setMaximumSize(new java.awt.Dimension(30, 30));
        btn_buscaRp.setMinimumSize(new java.awt.Dimension(30, 30));
        btn_buscaRp.setPreferredSize(new java.awt.Dimension(30, 30));
        btn_buscaRp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscaRpActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Operador");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        cb_operador.setBackground(new java.awt.Color(65, 65, 65));
        cb_operador.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cb_operador.setForeground(new java.awt.Color(255, 255, 255));
        cb_operador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "*" }));

        cb_obs.setBackground(new java.awt.Color(65, 65, 65));
        cb_obs.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cb_obs.setForeground(new java.awt.Color(255, 255, 255));
        cb_obs.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "*" }));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Observação");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Data");

        txt_dia.setBackground(new java.awt.Color(63, 63, 63));
        txt_dia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_dia.setForeground(new java.awt.Color(255, 255, 255));
        txt_dia.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("/");

        txt_mes.setBackground(new java.awt.Color(63, 63, 63));
        txt_mes.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_mes.setForeground(new java.awt.Color(255, 255, 255));
        txt_mes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mesActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("/");

        txt_ano.setBackground(new java.awt.Color(63, 63, 63));
        txt_ano.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_ano.setForeground(new java.awt.Color(255, 255, 255));
        txt_ano.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_anoActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Início");

        txt_inicioHora.setBackground(new java.awt.Color(63, 63, 63));
        txt_inicioHora.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_inicioHora.setForeground(new java.awt.Color(255, 255, 255));
        txt_inicioHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(":");

        txt_inicioMinuto.setBackground(new java.awt.Color(63, 63, 63));
        txt_inicioMinuto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_inicioMinuto.setForeground(new java.awt.Color(255, 255, 255));
        txt_inicioMinuto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_inicioMinuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_inicioMinutoActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Término");

        txt_terminoHora.setBackground(new java.awt.Color(63, 63, 63));
        txt_terminoHora.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_terminoHora.setForeground(new java.awt.Color(255, 255, 255));
        txt_terminoHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText(":");

        txt_terminoMinuto.setBackground(new java.awt.Color(63, 63, 63));
        txt_terminoMinuto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_terminoMinuto.setForeground(new java.awt.Color(255, 255, 255));
        txt_terminoMinuto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_terminoMinuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_terminoMinutoActionPerformed(evt);
            }
        });

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btn_limpaRp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Limpar_16.png"))); // NOI18N
        btn_limpaRp.setToolTipText("Limpa RP");
        btn_limpaRp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_limpaRp.setBorderPainted(false);
        btn_limpaRp.setMaximumSize(new java.awt.Dimension(30, 30));
        btn_limpaRp.setMinimumSize(new java.awt.Dimension(30, 30));
        btn_limpaRp.setPreferredSize(new java.awt.Dimension(30, 30));
        btn_limpaRp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpaRpActionPerformed(evt);
            }
        });

        btn_buscaRpFaca2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Atualiza_16.png"))); // NOI18N
        btn_buscaRpFaca2.setToolTipText("Atualiza data");
        btn_buscaRpFaca2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_buscaRpFaca2.setBorderPainted(false);
        btn_buscaRpFaca2.setMaximumSize(new java.awt.Dimension(30, 30));
        btn_buscaRpFaca2.setMinimumSize(new java.awt.Dimension(30, 30));
        btn_buscaRpFaca2.setPreferredSize(new java.awt.Dimension(30, 30));
        btn_buscaRpFaca2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscaRpFaca2ActionPerformed(evt);
            }
        });

        btn_limpaReg.setBackground(new java.awt.Color(22, 22, 22));
        btn_limpaReg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Limpar_32px.png"))); // NOI18N
        btn_limpaReg.setToolTipText("Limpar!");
        btn_limpaReg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_limpaReg.setBorderPainted(false);
        btn_limpaReg.setEnabled(false);
        btn_limpaReg.setMaximumSize(new java.awt.Dimension(40, 40));
        btn_limpaReg.setMinimumSize(new java.awt.Dimension(40, 40));
        btn_limpaReg.setPreferredSize(new java.awt.Dimension(40, 40));

        btn_excluiReg.setBackground(new java.awt.Color(22, 22, 22));
        btn_excluiReg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Remover_32px.png"))); // NOI18N
        btn_excluiReg.setToolTipText("Excluir!");
        btn_excluiReg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_excluiReg.setBorderPainted(false);
        btn_excluiReg.setEnabled(false);
        btn_excluiReg.setMaximumSize(new java.awt.Dimension(40, 40));
        btn_excluiReg.setMinimumSize(new java.awt.Dimension(40, 40));
        btn_excluiReg.setPreferredSize(new java.awt.Dimension(40, 40));

        btn_alteraReg.setBackground(new java.awt.Color(22, 22, 22));
        btn_alteraReg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Alterar_32px.png"))); // NOI18N
        btn_alteraReg.setToolTipText("Alterar!");
        btn_alteraReg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_alteraReg.setBorderPainted(false);
        btn_alteraReg.setEnabled(false);
        btn_alteraReg.setMaximumSize(new java.awt.Dimension(40, 40));
        btn_alteraReg.setMinimumSize(new java.awt.Dimension(40, 40));
        btn_alteraReg.setPreferredSize(new java.awt.Dimension(40, 40));

        btn_novoReg.setBackground(new java.awt.Color(22, 22, 22));
        btn_novoReg.setForeground(new java.awt.Color(255, 255, 255));
        btn_novoReg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Adicionar_32px.png"))); // NOI18N
        btn_novoReg.setToolTipText("Adicionar novo!");
        btn_novoReg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_novoReg.setBorderPainted(false);
        btn_novoReg.setEnabled(false);
        btn_novoReg.setMaximumSize(new java.awt.Dimension(40, 40));
        btn_novoReg.setMinimumSize(new java.awt.Dimension(40, 40));
        btn_novoReg.setPreferredSize(new java.awt.Dimension(40, 40));

        tb_registro.setBackground(new java.awt.Color(63, 63, 63));
        tb_registro.setForeground(new java.awt.Color(255, 255, 255));
        tb_registro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "cod_hcg", "cadoperador", "Operador", "RP", "Obs", "Inicio", "Termino", "criado", "modificado", "H", "M"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_registro.getTableHeader().setReorderingAllowed(false);
        jScrollregistro.setViewportView(tb_registro);
        if (tb_registro.getColumnModel().getColumnCount() > 0) {
            tb_registro.getColumnModel().getColumn(0).setMinWidth(0);
            tb_registro.getColumnModel().getColumn(0).setPreferredWidth(0);
            tb_registro.getColumnModel().getColumn(0).setMaxWidth(0);
            tb_registro.getColumnModel().getColumn(1).setMinWidth(0);
            tb_registro.getColumnModel().getColumn(1).setPreferredWidth(0);
            tb_registro.getColumnModel().getColumn(1).setMaxWidth(0);
            tb_registro.getColumnModel().getColumn(2).setResizable(false);
            tb_registro.getColumnModel().getColumn(2).setPreferredWidth(50);
            tb_registro.getColumnModel().getColumn(3).setMinWidth(0);
            tb_registro.getColumnModel().getColumn(3).setPreferredWidth(0);
            tb_registro.getColumnModel().getColumn(3).setMaxWidth(0);
            tb_registro.getColumnModel().getColumn(4).setResizable(false);
            tb_registro.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_registro.getColumnModel().getColumn(5).setResizable(false);
            tb_registro.getColumnModel().getColumn(5).setPreferredWidth(110);
            tb_registro.getColumnModel().getColumn(6).setResizable(false);
            tb_registro.getColumnModel().getColumn(6).setPreferredWidth(110);
            tb_registro.getColumnModel().getColumn(7).setMinWidth(0);
            tb_registro.getColumnModel().getColumn(7).setPreferredWidth(0);
            tb_registro.getColumnModel().getColumn(7).setMaxWidth(0);
            tb_registro.getColumnModel().getColumn(8).setMinWidth(0);
            tb_registro.getColumnModel().getColumn(8).setPreferredWidth(0);
            tb_registro.getColumnModel().getColumn(8).setMaxWidth(0);
            tb_registro.getColumnModel().getColumn(9).setResizable(false);
            tb_registro.getColumnModel().getColumn(9).setPreferredWidth(10);
            tb_registro.getColumnModel().getColumn(10).setResizable(false);
            tb_registro.getColumnModel().getColumn(10).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanelCadastroLayout = new javax.swing.GroupLayout(jPanelCadastro);
        jPanelCadastro.setLayout(jPanelCadastroLayout);
        jPanelCadastroLayout.setHorizontalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addComponent(jScrollregistro)
                        .addContainerGap())
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                                        .addComponent(txt_rp, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(btn_buscaRp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, 0)
                                .addComponent(btn_limpaRp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                                        .addComponent(cb_operador, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_idFaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cb_obs, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                                        .addComponent(txt_dia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel2)
                                        .addGap(0, 0, 0)
                                        .addComponent(txt_mes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel3)
                                        .addGap(0, 0, 0)
                                        .addComponent(txt_ano, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(btn_buscaRpFaca2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_inicioHora, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGap(0, 0, 0)
                                .addComponent(jLabel4)
                                .addGap(0, 0, 0)
                                .addComponent(txt_inicioMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                                        .addComponent(txt_terminoHora, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel16)
                                        .addGap(0, 0, 0)
                                        .addComponent(txt_terminoMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_novoReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_alteraReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_excluiReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_limpaReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6))))
        );
        jPanelCadastroLayout.setVerticalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_idFaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txt_rp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscaRp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_operador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_obs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_limpaRp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, 0)
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txt_dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txt_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txt_ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_buscaRpFaca2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(0, 0, 0)
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txt_inicioHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txt_inicioMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_terminoHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(txt_terminoMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btn_excluiReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_limpaReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btn_novoReg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_alteraReg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollregistro, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelCard1.add(jPanelCadastro, "cadastro");
        jPanelCadastro.getAccessibleContext().setAccessibleName("cadastro");

        jPanelAjustes.setBackground(new java.awt.Color(65, 65, 65));

        jPanel5.setBackground(new java.awt.Color(65, 65, 65));

        jButton8.setBackground(new java.awt.Color(25, 25, 25));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/CircleGreen_32.png"))); // NOI18N
        jButton8.setText("   Operador");
        jButton8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8.setBorderPainted(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(25, 25, 25));
        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/CircleBlue_32.png"))); // NOI18N
        jButton10.setText(" Observação");
        jButton10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton10.setBorderPainted(false);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton8)
                .addGap(18, 18, 18)
                .addComponent(jButton10)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelCard2.setBackground(new java.awt.Color(65, 65, 65));
        jPanelCard2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanelCard2.setLayout(new java.awt.CardLayout());

        jPanelOperador.setBackground(new java.awt.Color(65, 65, 65));

        tb_operador.setBackground(new java.awt.Color(63, 63, 63));
        tb_operador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tb_operador.setForeground(new java.awt.Color(255, 255, 255));
        tb_operador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "Código", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_operador.setToolTipText("Duplo clicke para alterar ou excluir cadastro");
        tb_operador.setGridColor(new java.awt.Color(63, 63, 63));
        tb_operador.getTableHeader().setReorderingAllowed(false);
        tb_operador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_operadorMouseClicked(evt);
            }
        });
        jScrolloperador.setViewportView(tb_operador);
        if (tb_operador.getColumnModel().getColumnCount() > 0) {
            tb_operador.getColumnModel().getColumn(0).setMinWidth(0);
            tb_operador.getColumnModel().getColumn(0).setPreferredWidth(0);
            tb_operador.getColumnModel().getColumn(0).setMaxWidth(0);
            tb_operador.getColumnModel().getColumn(1).setMinWidth(60);
            tb_operador.getColumnModel().getColumn(1).setPreferredWidth(60);
            tb_operador.getColumnModel().getColumn(1).setMaxWidth(60);
        }

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Cadastro de Operador");

        txt_cadastroOper_cad.setBackground(new java.awt.Color(63, 63, 63));
        txt_cadastroOper_cad.setForeground(new java.awt.Color(255, 255, 255));
        txt_cadastroOper_cad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cadastroOper_cad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cadastroOper_cadKeyPressed(evt);
            }
        });

        txt_nomeOper_cad.setBackground(new java.awt.Color(63, 63, 63));
        txt_nomeOper_cad.setForeground(new java.awt.Color(255, 255, 255));
        txt_nomeOper_cad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nomeOper_cad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nomeOper_cadKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Nome");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Código");

        btn_addOper.setBackground(new java.awt.Color(22, 22, 22));
        btn_addOper.setForeground(new java.awt.Color(255, 255, 255));
        btn_addOper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Adicionar_32px.png"))); // NOI18N
        btn_addOper.setToolTipText("Adicionar novo!");
        btn_addOper.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_addOper.setBorderPainted(false);
        btn_addOper.setEnabled(false);
        btn_addOper.setMaximumSize(new java.awt.Dimension(40, 40));
        btn_addOper.setMinimumSize(new java.awt.Dimension(40, 40));
        btn_addOper.setPreferredSize(new java.awt.Dimension(40, 40));
        btn_addOper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addOperActionPerformed(evt);
            }
        });

        btn_altOper.setBackground(new java.awt.Color(22, 22, 22));
        btn_altOper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Alterar_32px.png"))); // NOI18N
        btn_altOper.setToolTipText("Alterar!");
        btn_altOper.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_altOper.setBorderPainted(false);
        btn_altOper.setEnabled(false);
        btn_altOper.setMaximumSize(new java.awt.Dimension(40, 40));
        btn_altOper.setMinimumSize(new java.awt.Dimension(40, 40));
        btn_altOper.setPreferredSize(new java.awt.Dimension(40, 40));
        btn_altOper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_altOperActionPerformed(evt);
            }
        });

        btn_exclOper.setBackground(new java.awt.Color(22, 22, 22));
        btn_exclOper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Remover_32px.png"))); // NOI18N
        btn_exclOper.setToolTipText("Excluir!");
        btn_exclOper.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_exclOper.setBorderPainted(false);
        btn_exclOper.setEnabled(false);
        btn_exclOper.setMaximumSize(new java.awt.Dimension(40, 40));
        btn_exclOper.setMinimumSize(new java.awt.Dimension(40, 40));
        btn_exclOper.setPreferredSize(new java.awt.Dimension(40, 40));
        btn_exclOper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exclOperActionPerformed(evt);
            }
        });

        btn_limpOper.setBackground(new java.awt.Color(22, 22, 22));
        btn_limpOper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Limpar_32px.png"))); // NOI18N
        btn_limpOper.setToolTipText("Limpar!");
        btn_limpOper.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_limpOper.setBorderPainted(false);
        btn_limpOper.setEnabled(false);
        btn_limpOper.setMaximumSize(new java.awt.Dimension(40, 40));
        btn_limpOper.setMinimumSize(new java.awt.Dimension(40, 40));
        btn_limpOper.setPreferredSize(new java.awt.Dimension(40, 40));
        btn_limpOper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpOperActionPerformed(evt);
            }
        });

        txt_codOper_cad.setBackground(new java.awt.Color(255, 255, 255, 0));
        txt_codOper_cad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_codOper_cad.setForeground(new java.awt.Color(255, 255, 255));
        txt_codOper_cad.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_codOper_cad.setBorder(null);
        txt_codOper_cad.setEnabled(false);

        javax.swing.GroupLayout jPanelOperadorLayout = new javax.swing.GroupLayout(jPanelOperador);
        jPanelOperador.setLayout(jPanelOperadorLayout);
        jPanelOperadorLayout.setHorizontalGroup(
            jPanelOperadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOperadorLayout.createSequentialGroup()
                .addGroup(jPanelOperadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addGroup(jPanelOperadorLayout.createSequentialGroup()
                        .addGroup(jPanelOperadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txt_cadastroOper_cad, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelOperadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txt_nomeOper_cad)))
                    .addComponent(txt_codOper_cad, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelOperadorLayout.createSequentialGroup()
                        .addComponent(btn_addOper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_altOper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_exclOper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_limpOper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrolloperador, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelOperadorLayout.setVerticalGroup(
            jPanelOperadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOperadorLayout.createSequentialGroup()
                .addGroup(jPanelOperadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelOperadorLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_codOper_cad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelOperadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(0, 0, 0)
                        .addGroup(jPanelOperadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_cadastroOper_cad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nomeOper_cad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelOperadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_altOper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_exclOper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_limpOper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_addOper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrolloperador, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanelCard2.add(jPanelOperador, "operador");
        jPanelOperador.getAccessibleContext().setAccessibleName("operador");

        jPanelObs.setBackground(new java.awt.Color(65, 65, 65));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Cadastro de Observação");

        txt_codObs_cad.setBackground(new java.awt.Color(255, 255, 255, 0));
        txt_codObs_cad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_codObs_cad.setForeground(new java.awt.Color(255, 255, 255));
        txt_codObs_cad.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_codObs_cad.setBorder(null);
        txt_codObs_cad.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Tipo");

        txt_tipoObs_cad.setBackground(new java.awt.Color(63, 63, 63));
        txt_tipoObs_cad.setForeground(new java.awt.Color(255, 255, 255));
        txt_tipoObs_cad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_tipoObs_cad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tipoObs_cadKeyPressed(evt);
            }
        });

        btn_addObs.setBackground(new java.awt.Color(22, 22, 22));
        btn_addObs.setForeground(new java.awt.Color(255, 255, 255));
        btn_addObs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Adicionar_32px.png"))); // NOI18N
        btn_addObs.setToolTipText("Adicionar novo!");
        btn_addObs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_addObs.setBorderPainted(false);
        btn_addObs.setEnabled(false);
        btn_addObs.setMaximumSize(new java.awt.Dimension(40, 40));
        btn_addObs.setMinimumSize(new java.awt.Dimension(40, 40));
        btn_addObs.setPreferredSize(new java.awt.Dimension(40, 40));
        btn_addObs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addObsActionPerformed(evt);
            }
        });

        btn_altObs.setBackground(new java.awt.Color(22, 22, 22));
        btn_altObs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Alterar_32px.png"))); // NOI18N
        btn_altObs.setToolTipText("Alterar!");
        btn_altObs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_altObs.setBorderPainted(false);
        btn_altObs.setEnabled(false);
        btn_altObs.setMaximumSize(new java.awt.Dimension(40, 40));
        btn_altObs.setMinimumSize(new java.awt.Dimension(40, 40));
        btn_altObs.setPreferredSize(new java.awt.Dimension(40, 40));
        btn_altObs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_altObsActionPerformed(evt);
            }
        });

        btn_exclObs.setBackground(new java.awt.Color(22, 22, 22));
        btn_exclObs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Remover_32px.png"))); // NOI18N
        btn_exclObs.setToolTipText("Excluir!");
        btn_exclObs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_exclObs.setBorderPainted(false);
        btn_exclObs.setEnabled(false);
        btn_exclObs.setMaximumSize(new java.awt.Dimension(40, 40));
        btn_exclObs.setMinimumSize(new java.awt.Dimension(40, 40));
        btn_exclObs.setPreferredSize(new java.awt.Dimension(40, 40));
        btn_exclObs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exclObsActionPerformed(evt);
            }
        });

        btn_limpObs.setBackground(new java.awt.Color(22, 22, 22));
        btn_limpObs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Limpar_32px.png"))); // NOI18N
        btn_limpObs.setToolTipText("Limpar!");
        btn_limpObs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_limpObs.setBorderPainted(false);
        btn_limpObs.setEnabled(false);
        btn_limpObs.setMaximumSize(new java.awt.Dimension(40, 40));
        btn_limpObs.setMinimumSize(new java.awt.Dimension(40, 40));
        btn_limpObs.setPreferredSize(new java.awt.Dimension(40, 40));
        btn_limpObs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpObsActionPerformed(evt);
            }
        });

        tb_obs.setBackground(new java.awt.Color(63, 63, 63));
        tb_obs.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tb_obs.setForeground(new java.awt.Color(255, 255, 255));
        tb_obs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Cod_obs", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_obs.setToolTipText("Duplo clicke para alterar ou excluir cadastro");
        tb_obs.setGridColor(new java.awt.Color(63, 63, 63));
        tb_obs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_obsMouseClicked(evt);
            }
        });
        jScrollobs.setViewportView(tb_obs);
        if (tb_obs.getColumnModel().getColumnCount() > 0) {
            tb_obs.getColumnModel().getColumn(0).setMinWidth(0);
            tb_obs.getColumnModel().getColumn(0).setPreferredWidth(0);
            tb_obs.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanelObsLayout = new javax.swing.GroupLayout(jPanelObs);
        jPanelObs.setLayout(jPanelObsLayout);
        jPanelObsLayout.setHorizontalGroup(
            jPanelObsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelObsLayout.createSequentialGroup()
                .addGroup(jPanelObsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10)
                    .addComponent(txt_codObs_cad)
                    .addComponent(jLabel11)
                    .addGroup(jPanelObsLayout.createSequentialGroup()
                        .addComponent(btn_addObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_altObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_exclObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_limpObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_tipoObs_cad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollobs, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelObsLayout.setVerticalGroup(
            jPanelObsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelObsLayout.createSequentialGroup()
                .addGroup(jPanelObsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelObsLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_codObs_cad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addGap(0, 0, 0)
                        .addComponent(txt_tipoObs_cad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelObsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_altObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_exclObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_limpObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_addObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollobs, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 42, Short.MAX_VALUE))
        );

        jPanelCard2.add(jPanelObs, "obs");
        jPanelObs.getAccessibleContext().setAccessibleName("obs");

        javax.swing.GroupLayout jPanelAjustesLayout = new javax.swing.GroupLayout(jPanelAjustes);
        jPanelAjustes.setLayout(jPanelAjustesLayout);
        jPanelAjustesLayout.setHorizontalGroup(
            jPanelAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAjustesLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCard2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelAjustesLayout.setVerticalGroup(
            jPanelAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAjustesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCard2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelCard1.add(jPanelAjustes, "ajustes");
        jPanelAjustes.getAccessibleContext().setAccessibleName("ajustes");

        jButton1.setBackground(new java.awt.Color(25, 25, 25));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Cadastrar_32.png"))); // NOI18N
        jButton1.setToolTipText("Cadastrar");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(25, 25, 25));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/definicoes_32.png"))); // NOI18N
        jButton4.setToolTipText("Definições");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.setBorderPainted(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap())
            .addComponent(jPanelCard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1)
                        .addComponent(jButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        MostraCard1("cadastro");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        MostraCard1("ajustes");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        MostraCard2("operador");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        MostraCard2("obs");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void txt_cadastroOper_cadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cadastroOper_cadKeyPressed

        if ("".equals(txt_codOper_cad.getText()) && !"".equals(txt_nomeOper_cad.getText())) {
            btn_addOper.setEnabled(true);
            btn_altOper.setEnabled(false);
            btn_exclOper.setEnabled(false);
        }
        btn_limpOper.setEnabled(true);
    }//GEN-LAST:event_txt_cadastroOper_cadKeyPressed

    private void txt_nomeOper_cadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nomeOper_cadKeyPressed

        if ("".equals(txt_codOper_cad.getText()) && !"".equals(txt_cadastroOper_cad.getText())) {
            btn_addOper.setEnabled(true);
            btn_altOper.setEnabled(false);
            btn_exclOper.setEnabled(false);
        }
        btn_limpOper.setEnabled(true);
    }//GEN-LAST:event_txt_nomeOper_cadKeyPressed

    private void btn_limpOperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpOperActionPerformed

        LimparOperador();
    }//GEN-LAST:event_btn_limpOperActionPerformed

    private void btn_addOperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addOperActionPerformed

        if ("".equals(txt_cadastroOper_cad.getText())) {
            JOptionPane.showMessageDialog(null, "Digite o Código do Operador!", "", 2);
        } else {
            if ("".equals(txt_nomeOper_cad.getText())) {
                JOptionPane.showMessageDialog(null, "Digite o Nome do Operador!", "", 2);
            } else {

                Operador obj = new Operador();

                obj.setCadastro(Integer.parseInt(txt_cadastroOper_cad.getText()));
                obj.setNome(txt_nomeOper_cad.getText());

                OperadorDAO dao = new OperadorDAO();
                dao.cadastrar(obj);

                LimparOperador();

                //AtualizarcbClientes();
            }
        }
    }//GEN-LAST:event_btn_addOperActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        listarOperador();
        listarObsCompGraf();
    }//GEN-LAST:event_formWindowActivated

    private void tb_operadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_operadorMouseClicked

        tb_operador.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String c0 = tb_operador.getValueAt(tb_operador.getSelectedRow(), 0).toString();
                    String c1 = tb_operador.getValueAt(tb_operador.getSelectedRow(), 1).toString();
                    String c2 = tb_operador.getValueAt(tb_operador.getSelectedRow(), 2).toString();

                    txt_codOper_cad.setText(c0);
                    txt_cadastroOper_cad.setText(c1);
                    txt_nomeOper_cad.setText(c2);

                    btn_addOper.setEnabled(false);
                    btn_exclOper.setEnabled(true);
                    btn_altOper.setEnabled(true);
                    btn_limpOper.setEnabled(true);
                }
            }
        });
    }//GEN-LAST:event_tb_operadorMouseClicked

    private void btn_altOperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_altOperActionPerformed

        Operador obj = new Operador();

        obj.setCadastro(Integer.parseInt(txt_cadastroOper_cad.getText()));
        obj.setNome(txt_nomeOper_cad.getText());
        obj.setCod_oper(Integer.parseInt(txt_codOper_cad.getText()));
        OperadorDAO dao = new OperadorDAO();
        dao.alterar(obj);

        LimparOperador();

        //AtualizarcbClientes();
    }//GEN-LAST:event_btn_altOperActionPerformed

    private void btn_exclOperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exclOperActionPerformed

        String mt = txt_nomeOper_cad.getText();
        int resposta = JOptionPane.showConfirmDialog(null, "Excluir " + mt + "?", "", JOptionPane.YES_NO_OPTION);

        if (resposta == 0) {

            Operador obj = new Operador();

            obj.setCod_oper(Integer.parseInt(txt_codOper_cad.getText()));

            OperadorDAO dao = new OperadorDAO();

            dao.excluir(obj);

            LimparOperador();

            //AtualizarcbClientes();
        }
    }//GEN-LAST:event_btn_exclOperActionPerformed

    private void txt_tipoObs_cadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tipoObs_cadKeyPressed

        if ("".equals(txt_codObs_cad.getText())) {
            btn_addObs.setEnabled(true);
            btn_altObs.setEnabled(false);
            btn_exclObs.setEnabled(false);
            btn_limpObs.setEnabled(true);
        }
    }//GEN-LAST:event_txt_tipoObs_cadKeyPressed

    private void btn_limpObsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpObsActionPerformed

        LimparObsCompGraf();
    }//GEN-LAST:event_btn_limpObsActionPerformed

    private void btn_addObsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addObsActionPerformed

        ObsCompGraf obj = new ObsCompGraf();

        obj.setTipo(txt_tipoObs_cad.getText());

        ObsCompGrafDAO dao = new ObsCompGrafDAO();
        dao.cadastrar(obj);

        LimparObsCompGraf();

        //AtualizarcbClientes();
    }//GEN-LAST:event_btn_addObsActionPerformed

    private void btn_altObsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_altObsActionPerformed

        ObsCompGraf obj = new ObsCompGraf();

        obj.setTipo(txt_tipoObs_cad.getText());
        obj.setCod_obs(Integer.parseInt(txt_codObs_cad.getText()));
        ObsCompGrafDAO dao = new ObsCompGrafDAO();
        dao.alterar(obj);

        LimparObsCompGraf();

        //AtualizarcbClientes();
    }//GEN-LAST:event_btn_altObsActionPerformed

    private void btn_exclObsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exclObsActionPerformed

        String mt = txt_tipoObs_cad.getText();
        int resposta = JOptionPane.showConfirmDialog(null, "Excluir " + mt + "?", "", JOptionPane.YES_NO_OPTION);

        if (resposta == 0) {

            ObsCompGraf obj = new ObsCompGraf();

            obj.setCod_obs(Integer.parseInt(txt_codObs_cad.getText()));

            ObsCompGrafDAO dao = new ObsCompGrafDAO();

            dao.excluir(obj);

            LimparObsCompGraf();

            //AtualizarcbClientes();
        }
    }//GEN-LAST:event_btn_exclObsActionPerformed

    private void tb_obsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_obsMouseClicked

        tb_obs.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String c0 = tb_obs.getValueAt(tb_obs.getSelectedRow(), 0).toString();
                    String c1 = tb_obs.getValueAt(tb_obs.getSelectedRow(), 1).toString();

                    txt_codObs_cad.setText(c0);
                    txt_tipoObs_cad.setText(c1);

                    btn_addObs.setEnabled(false);
                    btn_exclObs.setEnabled(true);
                    btn_altObs.setEnabled(true);
                    btn_limpObs.setEnabled(true);
                }
            }
        });
    }//GEN-LAST:event_tb_obsMouseClicked

    private void txt_idFacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idFacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idFacaActionPerformed

    private void txt_mesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mesActionPerformed

    private void txt_anoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_anoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_anoActionPerformed

    private void txt_inicioMinutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_inicioMinutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_inicioMinutoActionPerformed

    private void txt_terminoMinutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_terminoMinutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_terminoMinutoActionPerformed

    private void btn_buscaRpFaca2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscaRpFaca2ActionPerformed

        txt_dia.setText(DataDia());
        txt_mes.setText(DataMes());
        txt_ano.setText(DataAno());
    }//GEN-LAST:event_btn_buscaRpFaca2ActionPerformed

    private void btn_limpaRpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpaRpActionPerformed

        txt_rp.setText("");
        PesquisaRegistro();
    }//GEN-LAST:event_btn_limpaRpActionPerformed

    private void btn_buscaRpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscaRpActionPerformed

        PesquisaRegistro();
    }//GEN-LAST:event_btn_buscaRpActionPerformed

    private void txt_rpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_rpKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            PesquisaRegistro();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            txt_rp.setText("");
            PesquisaRegistro();
        }
    }//GEN-LAST:event_txt_rpKeyPressed

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addObs;
    private javax.swing.JButton btn_addOper;
    private javax.swing.JButton btn_altObs;
    private javax.swing.JButton btn_altOper;
    private javax.swing.JButton btn_alteraReg;
    private javax.swing.JButton btn_buscaRp;
    private javax.swing.JButton btn_buscaRpFaca2;
    private javax.swing.JButton btn_exclObs;
    private javax.swing.JButton btn_exclOper;
    private javax.swing.JButton btn_excluiReg;
    private javax.swing.JButton btn_limpObs;
    private javax.swing.JButton btn_limpOper;
    private javax.swing.JButton btn_limpaReg;
    private javax.swing.JButton btn_limpaRp;
    private javax.swing.JButton btn_novoReg;
    public javax.swing.JComboBox cb_obs;
    public javax.swing.JComboBox cb_operador;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelAjustes;
    private javax.swing.JPanel jPanelCadastro;
    private javax.swing.JPanel jPanelCard1;
    private javax.swing.JPanel jPanelCard2;
    private javax.swing.JPanel jPanelObs;
    private javax.swing.JPanel jPanelOperador;
    private javax.swing.JScrollPane jScrollobs;
    private javax.swing.JScrollPane jScrolloperador;
    private javax.swing.JScrollPane jScrollregistro;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable tb_obs;
    private javax.swing.JTable tb_operador;
    private javax.swing.JTable tb_registro;
    public javax.swing.JTextField txt_ano;
    private javax.swing.JTextField txt_cadastroOper_cad;
    private javax.swing.JTextField txt_codObs_cad;
    private javax.swing.JTextField txt_codOper_cad;
    public javax.swing.JTextField txt_dia;
    public javax.swing.JTextField txt_idFaca;
    public javax.swing.JTextField txt_inicioHora;
    public javax.swing.JTextField txt_inicioMinuto;
    public javax.swing.JTextField txt_mes;
    private javax.swing.JTextField txt_nomeOper_cad;
    public javax.swing.JTextField txt_rp;
    public javax.swing.JTextField txt_terminoHora;
    public javax.swing.JTextField txt_terminoMinuto;
    private javax.swing.JTextField txt_tipoObs_cad;
    // End of variables declaration//GEN-END:variables
}
