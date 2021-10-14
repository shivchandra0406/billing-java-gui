/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiApplication;

import billing.DbConnection;
import static java.lang.Float.valueOf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import medical_gui.HomePage;

/**
 *
 * @author ROCKSTAR
 */
public class AddItem extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    public AddItem() {
        initComponents();
        getTime();
        category();
        brand();
        loadData();
    }
    private String username="";
    public AddItem(String username)
    {
        this.username=username;
        initComponents();
    }
    DefaultTableModel model=null;
    static int id;
    
    
    void getTime(){
    Calendar calender=Calendar.getInstance();
          SimpleDateFormat formetter=new SimpleDateFormat("dd/MM/yyyy");
         String  date=formetter.format(calender.getTime());
           formetter=new SimpleDateFormat("HH:mm:ss");
          String time=formetter.format(calender.getTime());
          jLabel11.setText(date);
          jLabel12.setText(time);
    }
    public class GetCategory
    {
     
        int id;
        String name;
        public GetCategory(int id,String name)
        {
         this.id=id;
         this.name=name;
        }
        @Override
        public String toString()
        {
         return name;
        }
         
    }
     public class GetBrand
    {
     
        int id;
        String name;
        public GetBrand(int id,String name)
        {
         this.id=id;
         this.name=name;
        }
        @Override
        public String toString()
        {
         return name;
        }
         
    }
    
    
     private void category()
    {
    
        Connection con=DbConnection.getConnection();
        try
        {
          PreparedStatement pst=con.prepareStatement("select * from category");
          ResultSet rs=pst.executeQuery();
          while(rs.next())
          {
              jComboBox2.addItem(new GetCategory(rs.getInt("id"),rs.getString("name")));
          }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());  
        }
    }
    
     
      private void brand()
    {
    
        Connection con=DbConnection.getConnection();
        try
        {
          PreparedStatement pst=con.prepareStatement("select * from brand");
          ResultSet rs=pst.executeQuery();
          while(rs.next())
          {
              jComboBox3.addItem(new GetBrand(rs.getInt("id"),rs.getString("name")));
          }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());  
        }
    }
    
      
      public void loadData()
      {
          
           model=(DefaultTableModel)jTable1.getModel();
          try
          {
             Connection con=DbConnection.getConnection();
             PreparedStatement pst=con.prepareStatement("select * from product");
             ResultSet rs=pst.executeQuery();
             // ResultSetMetaData rsm=pst.getMetaData();
              int col=model.getColumnCount();
              model.setRowCount(0);
              
              while(rs.next())
              {
                  Vector v2=new Vector();
                  for(int i=0;i<col;i++)
                  {
                      v2.add(rs.getInt("id"));
                      v2.add(rs.getString("p_name"));
                      v2.add(rs.getFloat("c_price"));
                      v2.add(rs.getFloat("r_price"));
                      v2.add(rs.getInt("quantity"));
                      v2.add(rs.getInt("barcode"));
                      v2.add(rs.getString("status"));
                  }
                  model.addRow(v2);
              }
          }
          catch(SQLException e)
          {
              e.getErrorCode();
          }
      }
      
      void addInTable()
      {
          model=(DefaultTableModel)jTable1.getModel();
          int row=model.getRowCount();
          Vector v2=new Vector();
          int col=model.getColumnCount();
          int id=Integer.parseInt(jTable1.getValueAt((row-1), 0).toString());
          for(int i=0;i<col;i++)
          {
              v2.add(++id);
              v2.add(p_text.getText());
              v2.add(c_text.getText());
              v2.add(r_text.getText());
              v2.add(q_text.getText());
              v2.add(B_text.getText());
              v2.add(jComboBox4.getSelectedItem());
              
          }
          model.addRow(v2);
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        p_text = new javax.swing.JTextField();
        B_text = new javax.swing.JTextField();
        q_text = new javax.swing.JTextField();
        r_text = new javax.swing.JTextField();
        c_text = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Home");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Category");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Brand");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Product");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Pos");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Exit");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cashier");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Sale Return");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Return to Stock");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel1)
                .addGap(56, 56, 56)
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addComponent(jLabel3)
                .addGap(39, 39, 39)
                .addComponent(jLabel4)
                .addGap(37, 37, 37)
                .addComponent(jLabel5)
                .addGap(36, 36, 36)
                .addComponent(jLabel6)
                .addGap(47, 47, 47)
                .addComponent(jLabel7)
                .addGap(34, 34, 34)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 51, 0));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Date");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Time");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Admin");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel11)
                .addGap(58, 58, 58)
                .addComponent(jLabel12)
                .addGap(80, 80, 80)
                .addComponent(jLabel13)
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(21, 21, 21))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Description");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("product");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setText("Bar Code");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("Status");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setText("Quantity");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setText("Cost Price");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel22.setText("Retail Price");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel23.setText("Category");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setText("Brand");

        p_text.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        B_text.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        q_text.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        r_text.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        r_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_textActionPerformed(evt);
            }
        });

        c_text.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Id", "Product name", "Cost Price", "Retail Price", "Quantity", "Barcode", "Status"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setBackground(new java.awt.Color(0, 153, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 153, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 153, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jComboBox3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jComboBox4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Active", "DeActive" }));

        jButton1.setBackground(new java.awt.Color(0, 102, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel16))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(c_text)
                                        .addComponent(q_text)
                                        .addComponent(B_text)
                                        .addComponent(p_text)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(r_text))
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel17)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jButton2)
                        .addGap(70, 70, 70)
                        .addComponent(jButton3)
                        .addGap(74, 74, 74)
                        .addComponent(jButton4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel17)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel16))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(p_text, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel23)
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(c_text, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(r_text, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(q_text, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(B_text, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1)))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(118, 118, 118))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // update data
        try
        {
           Connection con=DbConnection.getConnection();
           PreparedStatement pst=con.prepareStatement("UPDATE PRODUCT SET C_price=?,r_price=?,quantity=?,status=? where id=?");
           pst.setFloat(1,Float.parseFloat(c_text.getText()));
           pst.setFloat(2, Float.parseFloat(r_text.getText()));
           pst.setInt(3, Integer.parseInt(q_text.getText()));
           pst.setString(4,jComboBox4.getSelectedItem().toString());
           pst.setInt(5, id);
         int i=  pst.executeUpdate();
         if(i>0){
           JOptionPane.showMessageDialog(null,"Update Succesfully");
           p_text.setText("");
           jTextArea1.setText("");
           c_text.setText("");
           r_text.setText("");
           q_text.setText("");
           B_text.setText("");
         }   
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        //Delete button 
        try{
            Connection con=DbConnection.getConnection();
            model=(DefaultTableModel)jTable1.getModel();
            
            int index=jTable1.getSelectedRow();
            int id=(int)model.getValueAt(index,0);
            PreparedStatement pst=con.prepareStatement("delete from product where id=?");
            pst.setInt(1, id);
            
            pst.executeUpdate();
           
            model.removeRow(index);
            p_text.setText("");
            jTextArea1.setText("");
            c_text.setText("");
            r_text.setText("");
            q_text.setText("");
            B_text.setText("");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage()); 
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void r_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_textActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
// TODO add your handling code here:
        GetBrand item1=(GetBrand)jComboBox3.getSelectedItem();
        
        GetCategory item=(GetCategory)jComboBox2.getSelectedItem();
        //GetBrand i=(GetBrand)jComboBox4.getSelectedItem();
        System.out.println(item);
        
        try
        {
           Connection con=DbConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("insert into product( `p_name`, `description`, `category`, `brand`, `c_price`, `r_price`, `quantity`, `barcode`, `status`) values(?,?,?,?,?,?,?,?,?)");
            pst.setString(1,p_text.getText());
            pst.setString(2,jTextArea1.getText());
            pst.setInt(3, item.id);
            pst.setInt(4, item1.id);
            pst.setFloat(5, valueOf(c_text.getText()));
            pst.setFloat(6, valueOf(r_text.getText()));
            pst.setInt(7, Integer.parseInt(q_text.getText()));
            pst.setInt(8, Integer.parseInt(B_text.getText()));
            pst.setString(9,jComboBox4.getSelectedItem().toString());
            int rs=pst.executeUpdate();
            if(rs>0)
            {
                JOptionPane.showMessageDialog(null,"Data Save Successfully","Success",JOptionPane.INFORMATION_MESSAGE);
                addInTable();
                p_text.setText("");
                jTextArea1.setText("");
                c_text.setText("");
                r_text.setText("");
                q_text.setText("");
                B_text.setText("");
                
            }
        }
        catch(SQLException e)
        {
            System.out.println("Problem in database"+e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jButton2MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row;
       
        row=jTable1.getSelectedRow();
         id=Integer.parseInt(model.getValueAt(row, 0).toString());
         //System.out.println(id);
         int category=jComboBox2.getItemCount();
         int brand=jComboBox3.getItemCount();
         
         
        
         try
       {
         
        Connection con=DbConnection.getConnection();
        PreparedStatement pst=con.prepareStatement("SELECT * FROM `product` WHERE id=?");
        //pst1=con.prepareStatement("select * from category where ")
        pst.setInt(1, id);
        ResultSet rs=pst.executeQuery();
        while(rs.next())
        {
            p_text.setText(rs.getString("p_name"));
            jTextArea1.setText(rs.getString("description"));
            
            int c1 =rs.getInt("category");
           // System.out.println("cat="+cat);
           String name=getCat(c1);
            jComboBox2.setSelectedIndex(getCategoryItemName(name));
            //System.out.println(getCategoryItemName());
            
            int brand1=rs.getInt("brand");
            String BName=getBrand1(brand1);
            
            jComboBox3.setSelectedIndex(getbrandItemName(BName));
           // System.out.println(getbrandItemName());
            c_text.setText(""+rs.getFloat("c_price"));
            r_text.setText(""+rs.getFloat("r_price"));
            q_text.setText(""+(rs.getInt("quantity")));
            B_text.setText(""+rs.getInt("barcode"));
            jComboBox4.setSelectedItem(rs.getString("status"));
        }
       
       
       }
       catch(SQLException e)
       {
           System.out.println(e.getMessage());
       }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
         if(username.equals("shivchandk97@gmail.com")){
            Pos p=new Pos (username);
        p.setVisible(true);
        this.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"You can't Access Beacuase your username and password is not being mathing");
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        if(username.equals("shivchandk97@gmail.com")){
             HomePage p=new HomePage(username);
        p.setVisible(true);
        this.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"You can't Access Beacuase your username and password is not being mathing");
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
         if(username.equals("shivchandk97@gmail.com")){
           category p=new category(username);
        p.setVisible(true);
        this.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"You can't Access Beacuase your username and password is not being mathing");
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        if(username.equals("shivchandk97@gmail.com")){
             Brand p=new Brand(username);
        p.setVisible(true);
        this.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"You can't Access Beacuase your username and password is not being mathing");
        }
    }//GEN-LAST:event_jLabel3MouseClicked
   
    
    String getCat(int id)
      {
         String name="";
          try
          {
          Connection con=DbConnection.getConnection();
          PreparedStatement pst=con.prepareStatement("select * from category where id=?");
          pst.setInt(1, id);
          ResultSet rs=pst.executeQuery();
          
         
          if(rs.next())
          {
            name=rs.getString("name");
          }
          
          }
          catch(SQLException e)
          {
              System.out.println("Execption"+e.getMessage());   
          }
          return name;
      }
    String getBrand1(int id)
      {
         String name="";
          try
          {
          Connection con=DbConnection.getConnection();
          PreparedStatement pst=con.prepareStatement("select * from brand where id=?");
          pst.setInt(1, id);
          ResultSet rs=pst.executeQuery();
          
         
          if(rs.next())
          {
            name=rs.getString("name");
          }
          
          }
          catch(SQLException e)
          {
              System.out.println("Execption"+e.getMessage());   
          }
          return name;
      }
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
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField B_text;
    private javax.swing.JTextField c_text;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField p_text;
    private javax.swing.JTextField q_text;
    private javax.swing.JTextField r_text;
    // End of variables declaration//GEN-END:variables
 static int index;
 static int index1;
   
  
   
  public  int getCategoryItemName(String name)
{
int category=jComboBox2.getItemCount();
         
         String []c_name=new String[category];
        int j=0; 
for(int i=0;i<category;i++)
         {
             c_name[i]=jComboBox2.getItemAt(i).toString();
            // System.out.println(c_name[i]);
             
         }
 
         while(j<category)
            {
               if(name.equals(c_name[j]))
               {
               index=j;
                //break;
                  // System.out.println("cat="+cat[j]);
               }
               
              j++;
               
               
            }
   
 return index;
}


int getbrandItemName(String BName)
{
 int brand=jComboBox3.getItemCount(); 
 String []b_name=new String[brand];
 for(int i=0;i<brand;i++)
         {
             b_name[i]=jComboBox3.getItemAt(i).toString();
            
         }
 for(int i=0;i<brand;i++)
            {
               if(BName.equalsIgnoreCase(b_name[i]))
               {
               index1=i;
              // break;
               }
              
            }
    //System.out.println("index="+index1);
     return index1;
}



}