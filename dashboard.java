package FinalPortfolio;
import FinalPortfolio.database;
import FinalPortfolio.signup_page;
//for Admin
import FinalPortfolio_Admin.Admin_add;
import FinalPortfolio_Admin.Admin_delete;
import FinalPortfolio_Admin.Admin_display;
import FinalPortfolio_Admin.Admin_edit;
//for course
import FinalPortfolio.course.course_add;
import FinalPortfolio.course.course_edit;
import FinalPortfolio.course.course_delete;
import FinalPortfolio.course.course_display;
//for Students
import FinalPortfolio.Student.Student_add;
import FinalPortfolio.Student.Student_delete;
import FinalPortfolio.Student.Student_edit;
import FinalPortfolio.Student.Student_display;
//for Teacher
import FinalPortfolio.Teacher.Teacher_add;
import FinalPortfolio.Teacher.Teacher_edit;
import FinalPortfolio.Teacher.Teacher_delete;
import FinalPortfolio.Teacher.Teacher_display;




import java.awt.*;
import java.sql.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.JSpinner;
import javax.swing.JInternalFrame;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;



public class dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard frame = new dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public dashboard() {
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
	     profileLabel.setBounds(760, 16, 30, 54);
	     profileLabel.setHorizontalAlignment(SwingConstants.RIGHT);

	     // Add the profile label to the headerPanel
	     headerPanel.add(profileLabel);
	     
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        
        JLabel user_name = new JLabel("UserName");
        user_name.setFont(new Font("Tahoma", Font.BOLD, 15));
        user_name.setBounds(615, 16, 175, 54);
        headerPanel.add(user_name);
        
     // Side Panel
        JPanel sidePanel = new JPanel(new GridLayout(0, 1));
        sidePanel.setPreferredSize(new Dimension(140, 0));
        JButton home = new JButton("DASHBOARD");
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (mode.equals("students")) {
            		for_dashboard db = new for_dashboard();
            		db.setVisible(true);
            		dispose();
            	}
            	if(mode.equals("teachers")) {
            		for_dashboard db = new for_dashboard();
            		db.setVisible(true);
            		dispose();
            	}
            	if(mode.equals("admin")) {
            		dashboard db = new dashboard();
            		db.setVisible(true);
            		dispose();
            	}
            }
        });
        home.setBackground(Color.decode("#eae2d9"));

        JButton AdminPanel = new JButton("Admin");
        AdminPanel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (mode.equals("students")) {
            		for_admin ad = new for_admin();
            		ad.setVisible(true);
            		dispose();
            	}
            	if(mode.equals("teachers")) {
            		for_admin ad = new for_admin();
            		ad.setVisible(true);
            		dispose();
            	}
            	if(mode.equals("admin")) {
            		Admin ad = new Admin();
            		ad.setVisible(true);
            		dispose();
            	}
        	}
        });
        AdminPanel.setBackground(Color.decode("#eae2d9"));
        JButton TeacherPanel = new JButton("Teacher");
        TeacherPanel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(mode.equals("students")) {
            		for_teacher teach = new for_teacher();
            		teach.setVisible(true);
            		dispose();
            	}
            	if(mode.equals("teachers")) {
            		for_teacher teach = new for_teacher();
            		teach.setVisible(true);
            		dispose();
            	}
            	if(mode.equals("admin")) {
            		Teachers teach = new Teachers();
            		teach.setVisible(true);
            		dispose();
            	}
        	}
        });
        TeacherPanel.setBackground(Color.decode("#eae2d9"));
        JButton StudentPanel = new JButton("Students");
        StudentPanel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(mode.equals("students")) {
            		for_student stud = new for_student();
            		stud.setVisible(true);
            		dispose();
            	}
            	if(mode.equals("teachers")) {
            		Students stud = new Students();
            		stud.setVisible(true);
            		dispose();
            	}
            	if(mode.equals("admin")) {
            		Students stud = new Students();
            		stud.setVisible(true);
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
            	}
            	if(mode.equals("teachers")) {
            		Setting set = new Setting();
            		set.setVisible(true);
            		dispose();
            	}
            	if(mode.equals("admin")) {
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
        		if(mode == "students") {
            		for_result set = new for_result();
            		set.setVisible(true);
            		dispose();
            	}
            	if(mode == "teachers") {
            		Result set = new Result();
            		set.setVisible(true);
            		dispose();
            	}
            	if(mode == "admin") {
            		Result set = new Result();
            		set.setVisible(true);
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
        
        JLabel lblNewLabel = new JLabel("Welcome To Course Managment System");
        lblNewLabel.setBounds(201, 10, 288, 36);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPanel.add(lblNewLabel);
        
        JPanel for_student = new JPanel();
        for_student.setBounds(35, 52, 147, 138);
        for_student.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPanel.add(for_student);
        
        JPanel for_Teacher = new JPanel();
        for_Teacher.setBounds(241, 52, 152, 138);
        for_Teacher.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPanel.add(for_Teacher);
        
        JPanel for_course = new JPanel();
        for_course.setBounds(460, 52, 152, 130);
        for_Teacher.setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("TOTAL TEACHERS");
        lblNewLabel_2.setBounds(22, 7, 108, 16);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        for_Teacher.add(lblNewLabel_2);
        
        JLabel count_teacher = new JLabel("0");
        count_teacher.setFont(new Font("Tahoma", Font.BOLD, 20));
        count_teacher.setBounds(59, 60, 45, 25);
        for_Teacher.add(count_teacher);
        for_student.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("TOTAL STUDENT");
        lblNewLabel_1.setBounds(22, 7, 102, 16);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        for_student.add(lblNewLabel_1);
        
        JLabel count_student = new JLabel("0");
        count_student.setFont(new Font("Tahoma", Font.BOLD, 20));
        count_student.setBounds(53, 54, 52, 41);
        for_student.add(count_student);
        contentPanel.add(for_course);
        for_course.setBorder(BorderFactory.createRaisedBevelBorder());
        for_course.setLayout(null);
        
        JLabel lblNewLabel_3 = new JLabel("TOTAL COURSES");
        lblNewLabel_3.setBounds(25, 7, 101, 16);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        for_course.add(lblNewLabel_3);
        
        JLabel count_course = new JLabel("0");
        count_course.setFont(new Font("Tahoma", Font.BOLD, 20));
        count_course.setBounds(53, 57, 45, 25);
        for_course.add(count_course);
        
        table = new JTable();
        table.setBounds(113, 261, 0, 0);
        contentPanel.add(table);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(35, 211, 577, 210);
        contentPanel.add(scrollPane);
        
        table_1 = new JTable();
        scrollPane.setViewportView(table_1);
        table_1.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        			"ID"	,"Activities"
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