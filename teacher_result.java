package FinalPortfolio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class teacher_result extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable teacherresult;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					teacher_result frame = new teacher_result();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void displayresultteacher() {
	    DefaultTableModel resultteacherModel = (DefaultTableModel)teacherresult.getModel();
	    resultteacherModel.setRowCount(0); // Clear existing rows

	    String url = "jdbc:mysql://127.0.0.1:3306/coursemanagementsystem";
	    String username = "root";
	    String password = "";

	    try (Connection connection = DriverManager.getConnection(url, username, password)) {
	        String query = "SELECT * FROM result";
	        try (Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery(query)) {
	            while (resultSet.next()) {
	                String id = resultSet.getString(1);
	                String firstname = resultSet.getString(2);
	                String lastname = resultSet.getString(3);
	                String email = resultSet.getString(4);
	                String module = resultSet.getString(5);
	                String CourseName = resultSet.getString(6);
	                String marks = resultSet.getString(7);
	                String data[]= {id,firstname,lastname,email,module,CourseName,marks	};
	                resultteacherModel.addRow(data);
	                
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	/**
	 * Create the frame.
	 */
	public teacher_result() {
		String mode = login_page.selectMode; 
		Color color = Color.decode("#eae2d9");


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setTitle("Course Management System");

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Header Panel
        JPanel headerPanel = new JPanel(); 
        headerPanel.setBackground(SystemColor.controlHighlight);
        headerPanel.setPreferredSize(new Dimension(800, 70));
        JLabel headerLabel = new JLabel("Course Management System");
        headerLabel.setBounds(10, 16, 750, 54);
        headerLabel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(16, 10, 0, 10));
        headerPanel.setLayout(null);
        headerPanel.setLayout(null);
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        headerLabel.setForeground(SystemColor.desktop);
        headerPanel.add(headerLabel);
        
        //adding the profile button inside the headerPanel
        ImageIcon profileIcon = new ImageIcon("C:\\Users\\Surendra\\eclipse-workspace\\Tutorial\\src\\FinalPortfolio\\images\\profile.png");

	     // Scale the image to the desired dimensions
	     Image scaledImage = profileIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	
	     // Create a new ImageIcon with the scaled image
	     ImageIcon scaledProfileIcon = new ImageIcon(scaledImage);
	
	     // Create the profile label with the scaled icon
	     JLabel profileLabel = new JLabel(scaledProfileIcon);
	     profileLabel.setBounds(750, 16, 30, 54);
	     profileLabel.setHorizontalAlignment(SwingConstants.RIGHT);

	     // Add the profile label to the headerPanel
	     headerPanel.add(profileLabel);
	     
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        
        JLabel user_name = new JLabel("UserName");
        user_name.setFont(new Font("Tahoma", Font.BOLD, 15));
        user_name.setBounds(629, 16, 161, 54);
        headerPanel.add(user_name);

     // Side Panel
        JPanel sidePanel = new JPanel(new GridLayout(0, 1));
        sidePanel.setPreferredSize(new Dimension(140, 0));
        JButton home = new JButton("DASHBOARD");
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dashboard.displayDashboard();
            	dashboard db = new dashboard();
        		db.setVisible(true);
        		dashboard.displayDashboard();
        		dispose();
            }
        });
        home.setBackground(Color.decode("#eae2d9"));

        JButton AdminPanel = new JButton("Admin");
        AdminPanel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (mode.equals("students") || (mode.equals("teachers")) ) {
                    for_admin ad = new for_admin();
                    ad.displayadminforstudent();
                    ad.setVisible(true);
                    dispose();
                }else if (mode.equals("admin")) {
                    Admin admin = new Admin();
                	admin.displayadminInfo();
                    admin.setVisible(true);
                    dispose();
                }
        	}
        });
        AdminPanel.setBackground(Color.decode("#eae2d9"));
        JButton TeacherPanel = new JButton("Teacher");
        TeacherPanel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (mode.equals("students")|| mode.equals("teachers") ) {
                    for_teacher teach = new for_teacher();
                    teach.displayteachertableInfo();
                    teach.setVisible(true);
                    dispose();
                }else if (mode.equals("admin")) {
                    Teachers teach = new Teachers();
                    teach.displayteacherInfo();
                    teach.setVisible(true);
                    dispose();
                }
        	}
        });
        TeacherPanel.setBackground(Color.decode("#eae2d9"));
        JButton StudentPanel = new JButton("Students");
        StudentPanel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(mode.equals("students") || (mode.equals("teachers")) ) {
                    for_student stud = new for_student();
                    stud.setVisible(true);
                    stud.displaystudenttableInfo();
                    dispose();
                }else if(mode.equals("admin")) {
                    Students stud = new Students();
                    stud.setVisible(true);
                    stud.displaystudentInfo();
                    dispose();
                }
        	}
        });
        StudentPanel.setBackground(Color.decode("#eae2d9"));
        
        JButton SettingPanel = new JButton("Setting");
        SettingPanel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(mode.equals("students")) {
            		Setting set = new Setting();
            		set.setVisible(true);
            		dispose();
            	}else if(mode.equals("teachers")) {
            		Setting set = new Setting();
            		set.setVisible(true);
            		dispose();
            	}else if(mode.equals("admin")) {
            		Setting set = new Setting();
            		set.setVisible(true);
            		dispose();
            	}
        	}
        });
        SettingPanel.setBackground(Color.decode("#eae2d9"));
        JButton LogoutPanel = new JButton("Logout");
        LogoutPanel.setBackground(Color.decode("#eae2d9"));
        LogoutPanel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login_page login = new login_page();
                login.setVisible(true);
            }
        });

        // changing the size of the button
        Dimension buttonSize = new Dimension(100, 20);
        home.setPreferredSize(new Dimension(150, 30));
        AdminPanel.setPreferredSize(buttonSize);
        TeacherPanel.setPreferredSize(buttonSize);
        StudentPanel.setPreferredSize(buttonSize);
        SettingPanel.setPreferredSize(buttonSize);
        LogoutPanel.setPreferredSize(buttonSize);

        sidePanel.add(home);
        sidePanel.add(AdminPanel);
        sidePanel.add(TeacherPanel);
        sidePanel.add(StudentPanel);
        
        JButton ResultPanel = new JButton("Result");
        ResultPanel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (mode.equals("students")) {
                    student_result res = new student_result();
                    res.setVisible(true);
                    res.displayresultforstudent();
                    dispose();
                }else if (mode.equals("teachers")) {
                	admin_result res = new admin_result();
                    res.setVisible(true);
                    res.displayresult();
                    dispose();
                }else if (mode.equals("admin")) {
                    admin_result res = new admin_result();
                    res.setVisible(true);
                    res.displayresult();
                    dispose();
                }
            	
        	}
        });
        ResultPanel.setBackground(Color.decode("#eae2d9"));
        sidePanel.add(ResultPanel);
        sidePanel.add(SettingPanel);
        sidePanel.add(LogoutPanel);
        mainPanel.add(sidePanel, BorderLayout.WEST);

        // Content Panel
        JPanel contentPanel = new JPanel();
        contentPanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Result Information");
        lblNewLabel.setBounds(248, 10, 214, 36);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        contentPanel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------");
        lblNewLabel_1.setBounds(46, 36, 630, 22);
        contentPanel.add(lblNewLabel_1);
        
        textField = new JTextField();
        textField.setBounds(42, 78, 379, 36);
        contentPanel.add(textField);
        textField.setColumns(10);
        
        JButton btnNewButton = new JButton("Search");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton.setBounds(431, 80, 75, 30);
        contentPanel.add(btnNewButton);
        
        JButton btnViewReport = new JButton("Add Result");
        btnViewReport.setBounds(516, 80, 100, 30);
        contentPanel.add(btnViewReport);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(46, 134, 593, 232);
        contentPanel.add(scrollPane);
        
        teacherresult = new JTable();
        scrollPane.setViewportView(teacherresult);
        teacherresult.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"ID", "First Name", "Last Name", "Email", "Module", "Course Name", "Marks"
        	}
        ));
        
  
        // Footer Panel
        JPanel footerPanel = new JPanel();
        footerPanel.setToolTipText("");
        footerPanel.setBackground(Color.LIGHT_GRAY);
        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JLabel footerLabel = new JLabel("Made by Mr.Surendra Giri");
        footerLabel.setForeground(Color.BLACK);
        footerPanel.add(footerLabel);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
        setVisible(true);
	}

}
