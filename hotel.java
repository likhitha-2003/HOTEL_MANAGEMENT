import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.sql.*;
import javax.swing.ImageIcon;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
class coverFrame extends Frame{
	Button b,b1;
    coverFrame()
	{
		Label x=new Label("LNDD HOTEL WELCOMES YOU",Label.LEFT);
		x.setForeground(Color.blue);
		Font mf=new Font("Arial",Font.PLAIN,50);
		x.setFont(mf);
		x.setBounds(40,20,1000,100);
		add(x);
		b=new Button("ADMIN");
		b1=new Button("USER");
		b.setBounds(250,300,100,50);
		b1.setBounds(400,300,100,50);
		b.setActionCommand("admin");
		b1.setActionCommand("user");
		add(b);
		add(b1);
		coverListener cl=new coverListener(this);
	b.addActionListener(cl);
	b1.addActionListener(cl);
		this.setBackground(Color.LIGHT_GRAY);
		this.setTitle("WELCOME TO LNDD HOTEL");
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(1000,1000);
		this.addWindowListener(new NsrListener());
	}
}
class coverListener implements ActionListener{
   coverFrame x;
   coverListener(coverFrame x)
   {
	this.x=x;
   }
   public void actionPerformed(ActionEvent e)
   {
	String s= e.getActionCommand();
	Graphics g = x.getGraphics();
	g.setColor(Color.red);
	g.setFont(new Font("Arial",Font.BOLD,15));
	if(s.equals("admin"))
	{
  try{
		   g.drawString("Redirecting to admin page", 30, 500);
	   Thread.currentThread().sleep(1000);
	   new LoginFrame();
	   x.dispose();
	   }catch(Exception x){};
   }
   if(s.equals("user"))
   {
	 try{
		g.drawString("Redirecting to user page", 30, 500);
		Thread.currentThread().sleep(1000);
		new UserFrame();
		x.dispose(); 
	 } catch(Exception y)
	 { }
   }
   }
}
class LoginFrame extends Frame           //////login
{
	ImageIcon a;
   TextField name, pwd;
   Button b,b1;
   LoginFrame()	
   {
	Label ml=new Label("LOGIN FORM", Label.CENTER);
	Font mf = new Font("Arial", Font.PLAIN, 30);
	ml.setFont(mf);
	Label l1 = new Label("Name: ");
        Label l2 = new Label("Password: ");
		Font mf2 = new Font("Arial", Font.PLAIN, 20);
	l1.setFont(mf2);
	l2.setFont(mf2);
	ml.setBounds(90,30,500,40);
        l1.setBounds(20,90,100,30);
        l2.setBounds(20,140,100,30);
	name = new TextField("root",20);
	Font f = new Font("Arial", Font.PLAIN, 20);
	name.setFont(f);
	pwd = new TextField("987654321143",10);
	pwd.setEchoChar('*'); 
        name.setBounds(120,90,250,30);
        pwd.setBounds(120,140,250,30);
	b = new Button("Submit");
	b.setBounds(150,300,70,40);
	b1 = new Button("Back");
	b1.setBounds(250,300,70,40);
	b.setActionCommand("submit");
	b1.setActionCommand("back");
	add(ml);add(l1);add(l2);
 	add(name);	add(pwd);
	add(b);	add(b1);	
        LoginListener al=new LoginListener(this);
	b.addActionListener(al);
	b1.addActionListener(al);
	this.setSize(1000,1000);
	this.setTitle("WELCOME TO LNDD HOTEL");
        this.setLayout(null);
		this.setBackground(Color.LIGHT_GRAY);
	this.setVisible(true);
	this.addWindowListener(new NsrListener());	
  }
}
class LoginListener implements ActionListener
{  
   LoginFrame x; 
   boolean flag=false; 
   LoginListener(LoginFrame x)
   {  
	this.x=x;  
   }  
   public void getconnection()
   {
        String u_name=x.name.getText();
        String pass=x.pwd.getText();
	Connection con=null;
        try{  
           Class.forName("com.mysql.cj.jdbc.Driver");
           String url= "jdbc:mysql://localhost:3306/hotel"; 
           String user = u_name; 
           String pwd = pass;
           con= DriverManager.getConnection(url, user, pwd);
           flag=true;
        }
        catch(Exception ex){
	    System.out.println(ex);
        } 
            
   }
   public void actionPerformed(ActionEvent e)
   {
	String s=e.getActionCommand();
	Graphics g = x.getGraphics();
	g.setColor(Color.red);
	g.setFont(new Font("Arial",Font.BOLD,15));
	if(s.equals("submit"))
	{
	try
        {
           getconnection();
           if(flag)
           {
	      g.drawString("Login successful", 20, 250);
	      Thread.currentThread().sleep(1000);
	      new MainFrame();
	      x.dispose();
           }
           else
           {
			g.setColor(Color.red);
	g.setFont(new Font("Arial",Font.BOLD,15));
              g.drawString("Login unsuccessful.Try again", 20, 250);
	      Thread.currentThread().sleep(1000);
	      new LoginFrame();
	      x.dispose();
           }
        }catch(Exception x)
         {
          System.out.println(x);
           };
	}
	if(s.equals("back"))
	{
		g.drawString("Redirecting to cover page", 20, 250);
		//Thread.currentThread().sleep(1000);
		new coverFrame();
		x.dispose();
	}
   }
} 
class UserFrame extends Frame{
	TextField name,pwd;
	Button b1, b2;
	UserFrame()	
	{
	 this.setBackground(Color.LIGHT_GRAY);
	 Label ml=new Label("ENTER YOUR DETAILS", Label.CENTER);
	 Font mf = new Font("Arial", Font.PLAIN, 30);
	 Font mfx = new Font("Arial", Font.PLAIN, 20);
	 ml.setFont(mf);
	 Label l1 = new Label("Name: ");
	 l1.setFont(mfx);
	 Label l2 = new Label("Phone number");
	 l2.setFont(mfx);
	 ml.setBounds(20,30,450,40);
		 l1.setBounds(20,90,150,30);
		 l2.setBounds(20,140,150,30);
	 name = new TextField(10);
	 Font f = new Font("Arial", Font.PLAIN, 25);
	 name.setFont(f);
	 pwd = new TextField(10);
	 pwd.setFont(f);
		 name.setBounds(200,90,250,30);
		 pwd.setBounds(200,140,250,30);
	 b1 = new Button("Submit");
	 b2 = new Button("Back");
	 b1.setBounds(50,550,70,40);
	 b2.setBounds(150,550,70,40);
	 b1.setActionCommand("submit");
	 b2.setActionCommand("back");	 
	 add(ml);add(l1);add(l2);
	  add(name);add(pwd);	
	 add(b1);add(b2);		
		 UserListener al=new UserListener(this);
	 b1.addActionListener(al);
	 b2.addActionListener(al);
	 this.setLayout(new FlowLayout());
	 this.setSize(800,800);
	 this.setTitle("WELCOME TO LNDD HOTEL");
		 this.setLayout(null);
	 this.setVisible(true);
	 this.addWindowListener(new NsrListener());	
}
}
class UserListener implements ActionListener{
	UserFrame x;
	boolean flag=false; 
   String name,gen,dep,phno,cin,rno;
  UserListener(UserFrame x)
 {
    this.x=x;
 }
 public void getconnection()
 {
	  name=x.name.getText();
	  phno=x.pwd.getText();
  Connection con=null;
	  try{ 
  Class.forName("com.mysql.cj.jdbc.Driver");
	  String url= "jdbc:mysql://localhost:3306/hotel"; 
	  String user = "root"; 
	  String pwd = "987654321143";
	  con = DriverManager.getConnection(url, user, pwd);
	  String q="select * from customer where customer_name=? and phone_number=?";
  PreparedStatement  pst = con.prepareStatement(q);
  pst.setString(1,name);
  pst.setString(2,phno);
	  ResultSet rs=pst.executeQuery();
  Graphics g = x.getGraphics();
	  if(rs.next())
  {	
	  gen = rs.getString(2);
	  dep = rs.getString(3);
	  cin=rs.getString(5);
	  rno=rs.getString(6);
	  g.setColor(Color.blue);
  g.setFont(new Font("Arial",Font.BOLD,15));
	  g.drawString("Name:"+name, 50, 200);
	  g.drawString("Gender:"+gen, 50, 250);
	  g.drawString("State:"+dep, 50, 300);
	  g.drawString("Phone Number:"+phno,50,350);
	  g.drawString("check-in details:"+cin,50,400);
	  g.drawString("Room number:"+rno,50,450);			
  }
	  else{
	  g.setColor(Color.red);
  g.setFont(new Font("Arial",Font.BOLD,15));
	  g.drawString("No customer with the given name",50,300);}
  }catch(Exception x)
	   {
		System.out.println(x);
	   };        
 }
 public void actionPerformed(ActionEvent e)
 {
  Graphics g = x.getGraphics();
  g.setColor(Color.blue);
  g.setFont(new Font("Arial",Font.BOLD,15));
  String s = e.getActionCommand();
  if(s.equals("submit")) 
  {
	  getconnection();}
  if(s.equals("back"))
	  {
		g.drawString("Redirecting to cover frame",50,650);	
		new coverFrame();
		x.dispose(); 
	 }  
 }
 
}
class MainFrame extends Frame
{
   Button b1,b2,b3,b4,b5;
   MainFrame()	
   {
	this.setBackground(Color.LIGHT_GRAY);
	Label ml=new Label("MENU PAGE", Label.CENTER);
	Font mf = new Font("Arial", Font.PLAIN, 30);
	ml.setFont(mf);
	b1 = new Button("ROOM REGISTRATION");
        b2 = new Button("CUSTOMER DETAILS");
        b3 = new Button("SERVICES AVAILABLE");
        b4 = new Button("CHECK OUT");
		b5=new Button("ROOMS AVAILABLE");
	ml.setBounds(150,40,200,30);
	b1.setBounds(150,170,200,40);
        b2.setBounds(150,240,200,40);
        b3.setBounds(150,310,200,40);
        b4.setBounds(150,380,200,40);
		b5.setBounds(150,100,200,40);
	b1.setActionCommand("add");
	b2.setActionCommand("select");
	b3.setActionCommand("update");
	b4.setActionCommand("checkout");
	b5.setActionCommand("room");
	add(ml);add(b1);add(b2);add(b3);add(b4);add(b5);	
        MainFrameListener al=new MainFrameListener(this);
	b1.addActionListener(al);
	b2.addActionListener(al);
	b3.addActionListener(al);
	b4.addActionListener(al);
    b5.addActionListener(al);
	this.setLayout(new FlowLayout());
	this.setSize(800,800);
	this.setTitle("WELCOME TO LNDD HOTEL");
        this.setLayout(null);
	this.setVisible(true);
	this.addWindowListener(new NsrListener());	
  }
}
class MainFrameListener implements ActionListener
{  
   MainFrame x;  
   MainFrameListener(MainFrame x)
   {  
	this.x=x;  
   }  
   public void actionPerformed(ActionEvent e)	
   {
	String s= e.getActionCommand();
	Graphics g = x.getGraphics();
	if(s.equals("add"))
        { 
	   try{
		g.setColor(Color.red);
	g.setFont(new Font("Arial",Font.BOLD,15));
            	g.drawString("Redirecting to check in page", 20, 500);
	    	Thread.currentThread().sleep(1000);
	    	new AddFrame();	
	    	x.dispose();
            }catch(Exception x){};
        }
	if(s.equals("select")) 
	{ 
	   try{
		g.setColor(Color.red);
	g.setFont(new Font("Arial",Font.BOLD,15));
            	g.drawString("Redirecting to customer details page", 20, 500);
	    	Thread.currentThread().sleep(1000);
	    	new SearchFrame();
	    	x.dispose();
            }catch(Exception x){};
        }
	if(s.equals("update")) 
	{
        
			try{
				g.setColor(Color.red);
	g.setFont(new Font("Arial",Font.BOLD,15));
					 g.drawString("Redirecting to services availability  page", 20, 500);
				 Thread.currentThread().sleep(1000);
				 new serviceFrame();
				 
				 x.dispose();
				 }catch(Exception x){};
	}
	if(s.equals("checkout")) 
	{
        
			try{
				g.setColor(Color.red);
	g.setFont(new Font("Arial",Font.BOLD,15));
					 g.drawString("Redirecting to check out page", 20, 500);
				 Thread.currentThread().sleep(1000);
				 new checkoutFrame();
				 x.dispose();
				 }catch(Exception x){};
	
   }
   if(s.equals("room")) 
	{
        
			try{
				g.setColor(Color.red);
	g.setFont(new Font("Arial",Font.BOLD,15));
					 g.drawString("Redirecting to room details page", 20, 500);
				 Thread.currentThread().sleep(1000);
				 new roomFrame();
				 x.dispose();
				 }catch(Exception x){};
	
   }
}
} 
class roomFrame extends Frame{
	Button b,t;
   roomFrame()
   {
     b=new Button("AVAILABLE ROOMS");
	 b.setBounds(100,150,150,40);
	 b.setActionCommand("room");
	 t=new Button("MENU");
	 t.setBounds(350,150,150,40);
	 t.setActionCommand("menu");
	 roomListener rl=new roomListener(this);
	 b.addActionListener(rl);
	 t.addActionListener(rl);
	 this.add(b);
	 this.add(t);
	 this.setLayout(null);
	 this.setVisible(true);
	 this.setSize(1000,1000);
	 this.setTitle("WELCOME TO LNDD HOTEL");
	 this.setBackground(Color.LIGHT_GRAY);
	 this.addWindowListener(new NsrListener());	
   }
}
class roomListener implements ActionListener{
	roomFrame x;
	roomListener(roomFrame x)
	{
		this.x=x;
	}
	public void perform()
		{
		Connection con=null;
        try{ 
	Class.forName("com.mysql.cj.jdbc.Driver");   
        String url= "jdbc:mysql://localhost:3306/hotel"; 
        String user = "root"; 
        String pwd = "987654321143";
        con = DriverManager.getConnection(url, user, pwd);
        String q="select * from rooms order by room_no";
		Statement st = con.createStatement();
        ResultSet rs=st.executeQuery(q);
		Graphics g=x.getGraphics();
	   g.setColor(Color.blue);
	g.setFont(new Font("Arial",Font.BOLD,15));
        g.drawString("Details of available rooms:",50,300);
		g.drawString("\nRoom number                     Type(A/C or non)                     Cost(in rupees)",50,350);
		int i=0;
        while (rs.next()) {
                String rno = rs.getString(1);
				String type=rs.getString(2);
				int costi=rs.getInt(3);
                //1 is the column number
                g.drawString("\n"+rno+"                                          "+type+"                                          "+costi,50,400+i);
				i=i+30;
            }
	}catch(Exception x)
         {
          System.out.println(x);
         }; 
		}
	public  void actionPerformed(ActionEvent e)
	{
		Graphics g = x.getGraphics();
		String s = e.getActionCommand();
		if(s.equals("room"))
		{
			this.perform();

		}
		if(s.equals("menu"))
		{
			try{
				g.setColor(Color.red);
			g.setFont(new Font("Arial",Font.BOLD,15));
						g.drawString("Redirecting to menu page", 20, 100);
					Thread.currentThread().sleep(1000);
					new MainFrame();
					x.dispose();
					}catch(Exception x){};

		}
	}
}
class AddFrame extends Frame
{
   TextField name,phno,cin,rname;
   CheckboxGroup cbg;
   Choice ch;
   Button b1, b2, b3;
   AddFrame()	
   {
	this.setBackground(Color.LIGHT_GRAY);
	Label ml=new Label("ROOM REGISTRATION", Label.CENTER);
	Font mf = new Font("Arial", Font.PLAIN, 30);
	ml.setFont(mf);
	Font f2 = new Font("Arial", Font.PLAIN, 20);
	Label l1 = new Label("Name: ");
	l1.setFont(f2);
        Label l2 = new Label("Gender: ");
		l2.setFont(f2);
	Label l3 = new Label("state: ");
	l3.setFont(f2);
	Label l4=new Label("Ph.no:");
	l4.setFont(f2);
	Label l5=new Label("Check-in date:");
	l5.setFont(f2);
	Label l6=new Label("Room number:");
	l6.setFont(f2);	
	ml.setBounds(20,30,450,40);
        l1.setBounds(20,90,70,30);
        l2.setBounds(20,140,70,30);
	l3.setBounds(20,180,70,30);
    l4.setBounds(20,230,70,30);
	l5.setBounds(20,290,140,30);
	l6.setBounds(20,340,140,30);
	name = new TextField(10);
	Font f = new Font("Arial", Font.PLAIN, 25);
	name.setFont(f);
	cbg = new CheckboxGroup();
	Checkbox gm = new Checkbox ("Male", cbg, false);
	Checkbox gf = new Checkbox ("Female", cbg, false);
	ch = new Choice();
	ch.add("ANDHRA PRADESH");        ch.add("BENGALURU");    
        ch.add("TAMIL NADU");        ch.add("TELANGANA");
		ch.add("KERALA");          ch.add("ODISSA");
		ch.add("ANDAMAN AND NICOBAR");        ch.add("MAHARASHTRA");
		ch.add("CHATTIGARH");
		phno = new TextField(10);
		Font mf2 = new Font("Arial", Font.PLAIN, 20);
		phno.setFont(mf2);
		cin = new TextField("DD-MM-YYYY",15);
		cin.setFont(mf2);
		 rname= new TextField(15);
		rname.setFont(mf2);
        name.setBounds(150,90,250,30);
        gm.setBounds(100,140,50,30);
        gf.setBounds(170,140,100,30);
        ch.setBounds(100,180,100,50);
        phno.setBounds(150,230,250,30);
		cin.setBounds(170,290,250,30);
		rname.setBounds(170,340,250,30);
	b1 = new Button("Submit");
	b2 = new Button("Menu");
	b3 = new Button("Add one more");
	b1.setBounds(50,400,70,40);
	b2.setBounds(150,400,70,40);
	b3.setBounds(250,400,150,40);
	b1.setActionCommand("add");
	b2.setActionCommand("menu");
	b3.setActionCommand("onemore");
	add(ml);add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);
 	add(name);
	add(gm);	add(gf);
        add(ch);
		add(phno);
		add(cin);
		add(rname);	
	add(b1);add(b2);add(b3);		
        AdditionListener al=new AdditionListener(this);
	b1.addActionListener(al);
	b2.addActionListener(al);
	b3.addActionListener(al);
	this.setSize(800,800);
	this.setTitle("WELCOME TO LNDD HOTEL");
        this.setLayout(null);
	this.setVisible(true);
	this.addWindowListener(new NsrListener());	
  }
}
class AdditionListener implements ActionListener
{  
   AddFrame x; 
   boolean flag=false; 
   AdditionListener(AddFrame x)
   {  
	this.x=x;  
   }  
   public void getconnection()
   {
        String cname=x.name.getText();
        String cgen=x.cbg.getSelectedCheckbox().getLabel();
	String cstate=x.ch.getSelectedItem() ;
	String cphno=x.phno.getText();
	String cind=x.cin.getText();
	String rno=x.rname.getText();
	String rnox,rtypex;
	int rcostx;
	Connection con=null;
        try{ 
	Class.forName("com.mysql.cj.jdbc.Driver");   
        String url= "jdbc:mysql://localhost:3306/hotel"; 
        String user = "root"; 
        String pwd = "987654321143";
        con = DriverManager.getConnection(url, user, pwd);   
        String q="insert into customer values(?,?,?,?,?,?)";
	PreparedStatement  pst = con.prepareStatement(q);            
        pst.setString(1,cname);
	pst.setString(2,cgen);
	pst.setString(3,cstate);
	pst.setString(4,cphno);
	pst.setString(5,cind);
	pst.setString(6,rno);
        pst.executeUpdate();
		String q1="select * from rooms where room_no=?";
	PreparedStatement  pst1 = con.prepareStatement(q1);
	pst1.setString(1,rno);
        ResultSet rs=pst1.executeQuery();
		if(rs.next())
		{	
		 rnox = rs.getString(1);
		  rtypex = rs.getString(2);
		 rcostx=rs.getInt(3);
		 String qx="insert into usedrooms values(?,?,?)";
	PreparedStatement  pstx = con.prepareStatement(qx);            
        pstx.setString(1,rnox);
	pstx.setString(2,rtypex);
	pstx.setInt(3,rcostx);	
	pstx.executeUpdate();		
		}else 
	{
		System.out.println("NO SUCH ROOM AVAILABLE");
	}
		String q2="delete from rooms where room_no=?";
	PreparedStatement  pst2 = con.prepareStatement(q2); 
	pst2.setString(1,rno);
	pst2.executeUpdate();
        flag=true;
       }
        catch(Exception e){
	  System.out.println(e);
       }         
   }
   public void actionPerformed(ActionEvent e)
   {
	Graphics g = x.getGraphics();
	String s = e.getActionCommand();
	if(s.equals("add")) {
		g.setColor(Color.red);
	g.setFont(new Font("Arial",Font.BOLD,15));
	getconnection();
        if(flag)
	    g.drawString("ROOM BOOKED SUCCESSFULLY", 20, 480);
        else
          g.drawString("ROOM REGISTRATION UNSUCCESSFUL", 20, 480);
        }
	if(s.equals("menu"))
         {
	   try{
		g.setColor(Color.red);
	g.setFont(new Font("Arial",Font.BOLD,15));
            	g.drawString("Redirecting to menu page", 50, 520);
	    	Thread.currentThread().sleep(1000);
	    	new MainFrame();
	    	x.dispose();
            }catch(Exception x){};
        }
	if(s.equals("onemore"))
        {
		new AddFrame();        	
		x.dispose(); 
        }  
   }
} 
class SearchFrame extends Frame
{
   TextField name,pwd;
   Button b1, b2, b3;
   SearchFrame()	
   {
	this.setBackground(Color.LIGHT_GRAY);
	Label ml=new Label("SEARCH CUSTOMER DETAILS", Label.CENTER);
	Font mf = new Font("Arial", Font.PLAIN, 30);
	Font mfx = new Font("Arial", Font.PLAIN, 20);
	ml.setFont(mf);
	Label l1 = new Label("Enter Name: ");
	l1.setFont(mfx);
	Label l2 = new Label("Phone number ");
	 l2.setFont(mfx);
	ml.setBounds(20,30,450,40);
        l1.setBounds(20,90,150,30);
		l2.setBounds(20,140,150,30);
	name = new TextField(10);
	Font f = new Font("Arial", Font.PLAIN, 25);
	name.setFont(f);
	pwd = new TextField(10);
	pwd.setFont(f);
        name.setBounds(200,90,250,30);
		pwd.setBounds(200,140,250,30);
	b1 = new Button("Submit");
	b2 = new Button("Menu");
	b3 = new Button("Refresh");
	b1.setBounds(50,550,70,40);
	b2.setBounds(150,550,70,40);
	b3.setBounds(250,550,70,40);
	b1.setActionCommand("search");
	b2.setActionCommand("menu");
	b3.setActionCommand("refresh");
	add(ml);add(l1);add(l2);
 	add(name);add(pwd);
	add(b1);add(b2);add(b3);		
        SearchListener al=new SearchListener(this);
	b1.addActionListener(al);
	b2.addActionListener(al);
	b3.addActionListener(al);
	this.setLayout(new FlowLayout());
	this.setSize(800,800);
	this.setTitle("WELCOME TO LNDD HOTEL");
        this.setLayout(null);
	this.setVisible(true);
	this.addWindowListener(new NsrListener());	
  }
}
class SearchListener implements ActionListener
{  
   SearchFrame x; 
   boolean flag=false; 
   String name,gen,dep,phno,cin,rno;
   SearchListener(SearchFrame x)
   {  
	this.x=x;  
   }  
   public void getconnection()
   {
        name=x.name.getText();
		phno=x.pwd.getText();
	Connection con=null;
        try{ 
	Class.forName("com.mysql.cj.jdbc.Driver");     
        String url= "jdbc:mysql://localhost:3306/hotel"; 
        String user = "root"; 
        String pwd = "987654321143";
        con = DriverManager.getConnection(url, user, pwd);     
        String q="select * from customer where customer_name=? and phone_number=?";
	PreparedStatement  pst = con.prepareStatement(q);
	pst.setString(1,name);
	pst.setString(2,phno);
        ResultSet rs=pst.executeQuery();
	Graphics g = x.getGraphics();
        if(rs.next())
	{	
		gen = rs.getString(2);
		dep = rs.getString(3);
        cin=rs.getString(5);
		rno=rs.getString(6);
		g.setColor(Color.blue);
	g.setFont(new Font("Arial",Font.BOLD,15));
		g.drawString("Name:"+name, 50, 200);
		g.drawString("Gender:"+gen, 50, 250);
		g.drawString("State:"+dep, 50, 300);
		g.drawString("Phone Number:"+phno,50,350);
		g.drawString("check-in details:"+cin,50,400);
		g.drawString("Room number:"+rno,50,450);			
	}
        else{
		g.setColor(Color.red);
	g.setFont(new Font("Arial",Font.BOLD,15));
		g.drawString("No customer with the given name",50,300);}
	}catch(Exception x)
         {
          System.out.println(x);
         };        
   }
   public void actionPerformed(ActionEvent e)
   {
	Graphics g = x.getGraphics();
	String s = e.getActionCommand();
	if(s.equals("search")) 
		getconnection();
	if(s.equals("menu"))
        {
	   try{
		g.setColor(Color.red);
	g.setFont(new Font("Arial",Font.BOLD,15));
            	g.drawString("Redirecting to menu page", 20, 550);
	    	Thread.currentThread().sleep(1000);
	    	new MainFrame();
	    	x.dispose();
            }catch(Exception x){};
        }
	if(s.equals("refresh"))
        {
              new SearchFrame();
	      x.dispose(); 
       }  
   }
} 
class serviceFrame extends Frame
{
	Button b1,b2,b3,b4;
	serviceFrame()
	{
		this.setBackground(Color.LIGHT_GRAY);
		Label m1=new Label("HOTEL SERVICES AVAILABILITY");
		Font mf=new Font("Arial",Font.PLAIN,30);
		m1.setFont(mf);
		m1.setBounds(20,30,500,40);
		b1=new Button("Food items");
		b2=new Button("other services");
		b3=new Button("Menu");
		b4=new Button("Refresh");
		b1.setBounds(150,200,100,50);
		b2.setBounds(350,200,100,50);
		b3.setBounds(150,650,100,50);
		b4.setBounds(350,650,100,50);
		b1.setActionCommand("food");
		b2.setActionCommand("other");
		b3.setActionCommand("menu");
		b4.setActionCommand("clear");
		add(m1);add(b1);add(b2);add(b3);add(b4);
		serviceListener sl=new serviceListener(this);
		b1.addActionListener(sl);
		b2.addActionListener(sl);
		b3.addActionListener(sl);
		b4.addActionListener(sl);
		this.setSize(800,800);
		this.setTitle("WELCOME TO LNDD HOTEL");
		this.setLayout(null);
		this.setVisible(true);
		this.addWindowListener(new NsrListener());
	}
}
class serviceListener implements ActionListener
{
	serviceFrame x;
	boolean flag=false;
	serviceListener(serviceFrame x)
	{
		this.x=x;
	}
	public void getconn1()
	{
	Connection con=null;
        try{ 
	Class.forName("com.mysql.cj.jdbc.Driver");    
        String url= "jdbc:mysql://localhost:3306/hotel"; 
        String user = "root"; 
        String pwd = "987654321143";
        con = DriverManager.getConnection(url, user, pwd);   
        String q="select * from fooditems";
		Statement st = con.createStatement();
        ResultSet rs=st.executeQuery(q);
       Graphics g=x.getGraphics();
	   g.setColor(Color.blue);
	g.setFont(new Font("Arial",Font.BOLD,15));
        g.drawString("Details of food items:",50,300);
		g.drawString("\nFooditem                  veg_or_non                 type_of_item                      cost_of_item",50,320);
		int i=0;
        while (rs.next()) {
                String foodi = rs.getString(1);
				String vorn=rs.getString(2);
				String typei=rs.getString(3);
				int costi=rs.getInt(4);
                //1 is the column number
                g.drawString("\n"+foodi+"                               "+vorn+"                              "+typei+"                               "+costi,50,350+i);
				i=i+50;
            }
	}catch(Exception x)
         {
          System.out.println(x);
         };        
	}
	public void getconn2()
	{
        Connection con=null;
        try{ 
	Class.forName("com.mysql.cj.jdbc.Driver");  
        String url= "jdbc:mysql://localhost:3306/hotel"; 
        String user = "root"; 
        String pwd = "987654321143";
        con = DriverManager.getConnection(url, user, pwd);  
        String q="select * from services";
		Statement st = con.createStatement();
        ResultSet rs=st.executeQuery(q);
       Graphics g=x.getGraphics();
	   g.setColor(Color.blue);
	g.setFont(new Font("Arial",Font.BOLD,15));
        g.drawString("Details of other hotel services:",50,300);
		g.drawString("\nSevice                           type_of_service                       cost_of_service",50,320);
		int i=0;
        while (rs.next()) {
                String ser = rs.getString(1);
				String stype=rs.getString(2);
				int scost=rs.getInt(3);
                //1 is the column number
                g.drawString("\n"+ser+"                                 "+stype+"                                     "+scost,50,350+i);
				i=i+50;
            }
	}catch(Exception x)
         {
          System.out.println(x);
         };        
	}
	public void actionPerformed(ActionEvent e)
	{
		Graphics g=x.getGraphics();
		String s=e.getActionCommand();
		if(s.equals("food"))
		{
			getconn1();
		}
		if(s.equals("other"))
		{
			getconn2();
		}
		if(s.equals("menu"))
		{
			try{
				g.setColor(Color.red);
				g.setFont(new Font("Arial",Font.BOLD,15));	
			g.drawString("Redirecting to menu page",20,750);
			Thread.currentThread().sleep(1000);
			new MainFrame();
			x.dispose();}
			catch(Exception x){}
		}
		if(s.equals("clear"))
		{
			new serviceFrame();
			x.dispose();
		}
	}
}
class checkoutFrame extends Frame{
	TextField name,cout,pwd;
   Button b1, b2, b3;
   checkoutFrame()	
   {
	this.setBackground(Color.LIGHT_GRAY);
	Label ml=new Label("CHECK OUT PAGE", Label.CENTER);
	Font mf = new Font("Arial", Font.PLAIN, 30);
	Font mfx = new Font("Arial", Font.PLAIN, 20);
	ml.setFont(mf);
	Label l1 = new Label("Enter Name: ");
	Label l2= new Label("Check-out date: ");
	Label l3=new Label("Phone number: ");
	l1.setFont(mfx);
	l2.setFont(mfx);
	l3.setFont(mfx);
	ml.setBounds(20,30,450,40);
        l1.setBounds(20,90,150,30);
		l2.setBounds(20,150,150,30);
		l3.setBounds(20,200,150,30);
	name = new TextField(20);
	cout=new TextField(20);
	pwd=new TextField(20);
	Font f = new Font("Arial", Font.PLAIN, 25);
	name.setFont(f);
	cout.setFont(f);
	pwd.setFont(f);
        name.setBounds(200,90,250,30);
		cout.setBounds(200,150,250,30);
		pwd.setBounds(200,200,250,30);
	b1 = new Button("Submit");
	b2 = new Button("Menu");
	b3 = new Button("Refresh");
	b1.setBounds(50,750,70,40);
	b2.setBounds(150,750,70,40);
	b3.setBounds(250,750,70,40);
	b1.setActionCommand("submit");
	b2.setActionCommand("menu");
	b3.setActionCommand("refresh");
	add(ml);add(l1);add(l2);add(l3);
 	add(name);add(cout);add(pwd);	
	add(b1);add(b2);add(b3);		
        checkoutListener sl=new checkoutListener(this);
	b1.addActionListener(sl);
	b2.addActionListener(sl);
	b3.addActionListener(sl);
	this.setLayout(new FlowLayout());
	this.setSize(800,800);
	this.setTitle("WELCOME TO LNDD HOTEL");
        this.setLayout(null);
	this.setVisible(true);
	this.addWindowListener(new NsrListener());	
  }
}
class checkoutListener implements ActionListener
{  
   checkoutFrame x; 
   boolean flag=false; 
   String name,gen,dep,phno,coutd,cin,rno,rnox,rtypex;
   int rcostd;
   checkoutListener(checkoutFrame x)
   {  
	this.x=x;  
   }  
   public void getconnection()
   {
        name=x.name.getText();
		phno=x.pwd.getText();
		coutd=x.cout.getText();
	Connection con=null;
        try{ 
	Class.forName("com.mysql.cj.jdbc.Driver");
        String url= "jdbc:mysql://localhost:3306/hotel"; 
        String user = "root"; 
        String pwd = "987654321143";
        con = DriverManager.getConnection(url, user, pwd);
        String q="select * from customer where customer_name=? and phone_number=?";
	PreparedStatement  pst = con.prepareStatement(q);
	pst.setString(1,name);
	pst.setString(2,phno);
        ResultSet rs=pst.executeQuery();
		flag=true;
	Graphics g = x.getGraphics();
        if(rs.next())
	{	
		gen = rs.getString(2);
		dep = rs.getString(3);
		cin=rs.getString(5);
		rno=rs.getString(6);
		g.setColor(Color.blue);
	g.setFont(new Font("Arial",Font.BOLD,15));
		g.drawString("CHECK OUT DETAILS: ",50,300);
		g.drawString("Name: "+name, 50, 330);
		g.drawString("Gender: "+gen, 50, 360);
		g.drawString("State: "+dep, 50, 390);
		g.drawString("Phone Number: "+phno,50,420);
		g.drawString("Room  Number: "+rno,50,450);
		g.drawString("Check-in date: "+cin,50,480);
		g.drawString("Check-out date: "+coutd,50,510);
		String q1="select * from rooms where room_no=?";
	PreparedStatement  pst1= con.prepareStatement(q1);
	pst1.setString(1,rno);
        ResultSet rs1=pst1.executeQuery();
		String p1="select * from usedrooms where room_no=?";
		PreparedStatement  ps1 = con.prepareStatement(p1);
		ps1.setString(1,rno);
			ResultSet rsx=ps1.executeQuery();
			if(rsx.next())
			{
			 rnox = rsx.getString(1);
			  rtypex = rsx.getString(2);
			 rcostd=rsx.getInt(3);
	 }
		if(rs1.next())
		{	
		 rcostd=rs1.getInt(3);}
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
         String firstInput = cin;
         String secondInput =coutd;
		 try{
         LocalDate firstDate = LocalDate.parse(firstInput,formatter);
         LocalDate secondDate = LocalDate.parse(secondInput,formatter);
         long days =ChronoUnit.DAYS.between(firstDate, secondDate);
		 long total=rcostd*(days+1);
		 g.drawString("Total bill: "+total,50,550);
		 }
		 catch(Exception e)
		 {}
			String qx="insert into rooms values(?,?,?)";
	   PreparedStatement  pstx = con.prepareStatement(qx);            
		   pstx.setString(1,rnox);
	   pstx.setString(2,rtypex);
	   pstx.setInt(3,rcostd);	
	   pstx.executeUpdate();
		   String q2="delete from usedrooms where room_no=?";
	   PreparedStatement  pst2 = con.prepareStatement(q2); 
	   pst2.setString(1,rno);
	   pst2.executeUpdate();
	   String p2="delete from customer where customer_name=?";
	   PreparedStatement  pstt2 = con.prepareStatement(p2); 
	   pstt2.setString(1,name);
	   pstt2.executeUpdate();
		g.drawString("CHECKED OUT SUCCESSFULLY",50,600);
		g.drawString("⇛⇛⇛⇛⇛⇛⇛⇛⇛⇛  THANK YOU VISIT AGAIN  ⇚⇚⇚⇚⇚⇚⇚⇚⇚⇚",50,650);
	}
        else{
		g.setColor(Color.red);
	g.setFont(new Font("Arial",Font.BOLD,15));
		g.drawString("No customer with the given name",50,300);}
		}
	catch(Exception x)
         {
          System.out.println(x);
         }       
   }
   public void actionPerformed(ActionEvent e)
   {	
	Graphics g = x.getGraphics();
	String s = e.getActionCommand();
	if(s.equals("submit")) 
		getconnection();
	if(s.equals("menu"))
        {
	   try{
		g.setColor(Color.red);
		g.setFont(new Font("Arial",Font.BOLD,15));
            	g.drawString("Redirecting to menu page", 20, 700);
	    	Thread.currentThread().sleep(1000);
	    	new MainFrame();
	    	x.dispose();
            }catch(Exception x){};
        }
	if(s.equals("refresh"))
        {
            new checkoutFrame();
	      x.dispose(); 
       }  
   }
} 
class NsrListener extends WindowAdapter{
  public void windowClosing(WindowEvent e){
	System.exit(0); 
  }
}
class hotel
{	
   public static void main(String args[]) throws Exception
   {
	 new coverFrame();
   } 
}