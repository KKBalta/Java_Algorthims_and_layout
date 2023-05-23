import java.util.*;
import javax.swing.JFileChooser;
import java.io.*;
class balta_p8 
{
	private static int width = 700;
	private static int height = 350;
	private static ArrayList<Integer> rawdata = new ArrayList<>();//sorth file
	private static ArrayList<Integer> data = new ArrayList<>();// search file
	private static TreeSet<Integer> ts = new TreeSet<>();
	private static PriorityQueue<Integer> pq = new PriorityQueue<>();
	private static HashSet<Integer> set = new HashSet<>();
    private static ArrayList<Integer> arrlist = new ArrayList<>(); 
	private static int[] arr3;
	private static BinarySearchTree bst =new BinarySearchTree() ;
	private static String LocR;
	private static String LocS;
	private static boolean Enabled = true;
	public static void main(String[] args)
	{
		if( args.length != 2){
		System.err.println("Please put 2 arguments first location of Sort file second location of Search file");
		System.exit(0);
	}
		LocS = args[0];
		LocR = args[1];
		// create the window and specify the size and what to do when the window is closed
		javax.swing.JFrame f = new javax.swing.JFrame();
		f.setPreferredSize(new java.awt.Dimension(width, height));
		f.setMinimumSize(new java.awt.Dimension(width, height));
		f.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		
		// create the menu bar
		javax.swing.JMenuBar menuBar = new javax.swing.JMenuBar();
		
		// create the two menus
		javax.swing.JMenu fileMenu = new javax.swing.JMenu("File");
		
		
		// create the menu items for the two menus
		javax.swing.JMenuItem ReadSort = new javax.swing.JMenuItem("Read Sort file");
		javax.swing.JMenuItem ReadSearch = new javax.swing.JMenuItem("Read Search file");
        javax.swing.JMenuItem fileExit = new javax.swing.JMenuItem("Exit");
        

		// add the two menus to the menu bar
		menuBar.add(fileMenu);
		
		
		// add the two menu items to the two menus
		fileMenu.add(ReadSort);
        fileMenu.add(ReadSearch);
        fileMenu.add(fileExit);
        
		
		// create the panel to hold the buttons
		javax.swing.JPanel leftbuttonPanel = new javax.swing.JPanel();
		leftbuttonPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0,0,0,255), 2));
		java.awt.GridBagLayout gridBagLayoutL = new java.awt.GridBagLayout();
		leftbuttonPanel.setLayout(gridBagLayoutL);
		java.awt.GridBagConstraints leftButtonPanelConstraints = new java.awt.GridBagConstraints();
				
		
		javax.swing.JButton sortIntsButton = new javax.swing.JButton("sort ints");
		javax.swing.JLabel sortIntslabel = new javax.swing.JLabel("no result");
		javax.swing.JButton addToBstButton = new javax.swing.JButton("add to bst");
		javax.swing.JLabel addToBstlabel = new javax.swing.JLabel("no result");
		javax.swing.JButton addToTreeSetButton = new javax.swing.JButton("add to treeset");
		javax.swing.JLabel addToTreeSetlabel = new javax.swing.JLabel("no result");
		javax.swing.JButton addToPriortyqueueButton = new javax.swing.JButton("add to priorty queue");
		javax.swing.JLabel addToPriortyqueulabel = new javax.swing.JLabel("no result");
		javax.swing.JButton addToHashSetButton = new javax.swing.JButton("add to HashSet");
		javax.swing.JLabel addToHashSetlabel = new javax.swing.JLabel("no result");
		javax.swing.JButton addToArrayListButton = new javax.swing.JButton("add to Array List");
		javax.swing.JLabel  addToArrayListlabel = new javax.swing.JLabel("no result");
		javax.swing.JButton addToSortedArrayListButton = new javax.swing.JButton("add to Sorted Array List");
		javax.swing.JLabel  addToSortedArrayListlabel = new javax.swing.JLabel("no result");
		javax.swing.JButton addToArrayButton = new javax.swing.JButton("add to array");
		javax.swing.JLabel addToArraylabel = new javax.swing.JLabel("no result");
		
		leftButtonPanelConstraints.weightx = 1;
		leftButtonPanelConstraints.weighty = 1;

		leftButtonPanelConstraints.fill = java.awt.GridBagConstraints.NONE;
		leftButtonPanelConstraints.anchor = java.awt.GridBagConstraints.LINE_START;

		leftButtonPanelConstraints.gridx = 0;
		leftButtonPanelConstraints.gridy = 0;
		leftButtonPanelConstraints.gridwidth = 1;
		gridBagLayoutL.setConstraints(sortIntsButton,leftButtonPanelConstraints);
		

		leftButtonPanelConstraints.gridx = 1;
		leftButtonPanelConstraints.gridy = 0;
		leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayoutL.setConstraints(sortIntslabel,leftButtonPanelConstraints);
        
		leftButtonPanelConstraints.gridx = 0;
		leftButtonPanelConstraints.gridy = 1;
		leftButtonPanelConstraints.gridwidth = 1;
		gridBagLayoutL.setConstraints(addToBstButton,leftButtonPanelConstraints);
		

		leftButtonPanelConstraints.gridx = 1;
		leftButtonPanelConstraints.gridy = 1;
		leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;;
		gridBagLayoutL.setConstraints(addToBstlabel,leftButtonPanelConstraints);
		
		leftButtonPanelConstraints.gridx = 0;
		leftButtonPanelConstraints.gridy = 2;
		leftButtonPanelConstraints.gridwidth = 1;
		gridBagLayoutL.setConstraints(addToTreeSetButton,leftButtonPanelConstraints);
		

		leftButtonPanelConstraints.gridx = 1;
		leftButtonPanelConstraints.gridy = 2;
		leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayoutL.setConstraints(addToTreeSetlabel,leftButtonPanelConstraints);
    
		leftButtonPanelConstraints.gridx = 0;
		leftButtonPanelConstraints.gridy = 3;
		leftButtonPanelConstraints.gridwidth = 1;
		gridBagLayoutL.setConstraints(addToPriortyqueueButton,leftButtonPanelConstraints);
    	
		
		leftButtonPanelConstraints.gridx = 1;
		leftButtonPanelConstraints.gridy = 3;
		leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayoutL.setConstraints(addToPriortyqueulabel,leftButtonPanelConstraints);
    	
		
		leftButtonPanelConstraints.gridx = 0;
		leftButtonPanelConstraints.gridy = 4;
		leftButtonPanelConstraints.gridwidth = 1;
		gridBagLayoutL.setConstraints(addToHashSetButton,leftButtonPanelConstraints);
    	
		
		leftButtonPanelConstraints.gridx = 1;
		leftButtonPanelConstraints.gridy = 4;
		leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayoutL.setConstraints(addToHashSetlabel,leftButtonPanelConstraints);
    	
		leftButtonPanelConstraints.gridx = 0;
		leftButtonPanelConstraints.gridy = 5;
		leftButtonPanelConstraints.gridwidth = 1;
		gridBagLayoutL.setConstraints(addToArrayListButton,leftButtonPanelConstraints);
    	

		leftButtonPanelConstraints.gridx = 1;
		leftButtonPanelConstraints.gridy = 5;
		leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayoutL.setConstraints(addToArrayListlabel,leftButtonPanelConstraints);
    	
		leftButtonPanelConstraints.gridx = 0;
		leftButtonPanelConstraints.gridy = 6;
		leftButtonPanelConstraints.gridwidth = 1;
		gridBagLayoutL.setConstraints(addToSortedArrayListButton,leftButtonPanelConstraints);
    	

		leftButtonPanelConstraints.gridx = 1;
		leftButtonPanelConstraints.gridy = 6;
		leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayoutL.setConstraints(addToSortedArrayListlabel,leftButtonPanelConstraints);
    	
		leftButtonPanelConstraints.gridx = 0;
		leftButtonPanelConstraints.gridy = 7;
		leftButtonPanelConstraints.gridwidth = 1;
		gridBagLayoutL.setConstraints(addToArrayButton,leftButtonPanelConstraints);
    	

		leftButtonPanelConstraints.gridx = 1;
		leftButtonPanelConstraints.gridy = 7;
		leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayoutL.setConstraints(addToArraylabel,leftButtonPanelConstraints);
    	
		// add the buttons to the panel
		leftbuttonPanel.add(sortIntsButton);
		leftbuttonPanel.add(sortIntslabel);
		leftbuttonPanel.add(addToBstButton);
		leftbuttonPanel.add(addToBstlabel);
		leftbuttonPanel.add(addToTreeSetButton);
		leftbuttonPanel.add(addToTreeSetlabel);
		leftbuttonPanel.add(addToPriortyqueueButton);
		leftbuttonPanel.add(addToPriortyqueulabel);
		leftbuttonPanel.add(addToHashSetButton);
		leftbuttonPanel.add(addToHashSetlabel);
		leftbuttonPanel.add(addToArrayListButton);
		leftbuttonPanel.add(addToArrayListlabel);
		leftbuttonPanel.add(addToSortedArrayListButton);
		leftbuttonPanel.add(addToSortedArrayListlabel);
		leftbuttonPanel.add(addToArrayButton);
		leftbuttonPanel.add(addToArraylabel);
		// creat right panel 
		javax.swing.JPanel rightbuttonPanel = new javax.swing.JPanel();
		rightbuttonPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0,0,0,255), 2));
		java.awt.GridBagLayout gridBagLayoutR = new java.awt.GridBagLayout();
		rightbuttonPanel.setLayout(gridBagLayoutR);
		java.awt.GridBagConstraints rightButtonPanelConstraints = new java.awt.GridBagConstraints();

		
		
		
		javax.swing.JButton searchSortedIntsButton = new javax.swing.JButton("Search sorted ints");
		javax.swing.JLabel searchSortedIntslabel = new javax.swing.JLabel("no result");
		javax.swing.JButton searchBstButton = new javax.swing.JButton("search bst");
		javax.swing.JLabel searchBstlabel = new javax.swing.JLabel("no result");
		javax.swing.JButton searchTreeSetButton = new javax.swing.JButton("search treeset");
		javax.swing.JLabel searchTreeSetlabel = new javax.swing.JLabel("no result");
		javax.swing.JButton searchPriortyqueueButton = new javax.swing.JButton("search priorty queue");
		javax.swing.JLabel searchPriortyqueulabel = new javax.swing.JLabel("no result");
		javax.swing.JButton searchHashSetButton = new javax.swing.JButton("search HashSet");
		javax.swing.JLabel searchHashSetlabel = new javax.swing.JLabel("no result");
		javax.swing.JButton searchArrayListButton = new javax.swing.JButton("search Array List");
		javax.swing.JLabel  searchArrayListlabel = new javax.swing.JLabel("no result");
		javax.swing.JButton searchSortedArrayListButton = new javax.swing.JButton("search Sorted Array List");
		javax.swing.JLabel  searchSortedArrayListlabel = new javax.swing.JLabel("no result");
		javax.swing.JButton searchArrayButton = new javax.swing.JButton("search array");
		javax.swing.JLabel searchArraylabel = new javax.swing.JLabel("no result");

		rightButtonPanelConstraints.weightx = 1;
		rightButtonPanelConstraints.weighty = 1;

		rightButtonPanelConstraints.fill = java.awt.GridBagConstraints.NONE;
		rightButtonPanelConstraints.anchor = java.awt.GridBagConstraints.LINE_START;

		rightButtonPanelConstraints.gridx = 0;
		rightButtonPanelConstraints.gridy = 0;
		rightButtonPanelConstraints.gridwidth = 1;
		gridBagLayoutR.setConstraints(searchSortedIntsButton,rightButtonPanelConstraints);
		searchSortedIntsButton.setEnabled(Enabled);

		rightButtonPanelConstraints.gridx = 1;
		rightButtonPanelConstraints.gridy = 0;
		rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayoutR.setConstraints(searchSortedIntslabel,rightButtonPanelConstraints);
        

		rightButtonPanelConstraints.gridx = 0;
		rightButtonPanelConstraints.gridy = 1;
		rightButtonPanelConstraints.gridwidth = 1;
		gridBagLayoutR.setConstraints(searchBstButton,rightButtonPanelConstraints);
		searchBstButton.setEnabled(Enabled);

		rightButtonPanelConstraints.gridx = 1;
		rightButtonPanelConstraints.gridy = 1;
		rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayoutR.setConstraints(searchBstlabel,rightButtonPanelConstraints);
		
		rightButtonPanelConstraints.gridx = 0;
		rightButtonPanelConstraints.gridy = 2;
		rightButtonPanelConstraints.gridwidth = 1;
		gridBagLayoutR.setConstraints(searchTreeSetButton,rightButtonPanelConstraints);
		searchTreeSetButton.setEnabled(Enabled);

		rightButtonPanelConstraints.gridx = 1;
		rightButtonPanelConstraints.gridy = 2;
		rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayoutR.setConstraints(searchTreeSetlabel,rightButtonPanelConstraints);
	
		rightButtonPanelConstraints.gridx = 0;
		rightButtonPanelConstraints.gridy = 3;
		rightButtonPanelConstraints.gridwidth = 1;
		gridBagLayoutR.setConstraints(searchPriortyqueueButton,rightButtonPanelConstraints);
    	searchPriortyqueueButton.setEnabled(Enabled);
		
		rightButtonPanelConstraints.gridx = 1;
		rightButtonPanelConstraints.gridy = 3;
		rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayoutR.setConstraints(searchPriortyqueulabel,rightButtonPanelConstraints);
    	
		
		rightButtonPanelConstraints.gridx = 0;
		rightButtonPanelConstraints.gridy = 4;
		rightButtonPanelConstraints.gridwidth = 1;
		gridBagLayoutR.setConstraints(searchHashSetButton,rightButtonPanelConstraints);
    	searchHashSetButton.setEnabled(Enabled);
		
		rightButtonPanelConstraints.gridx = 1;
		rightButtonPanelConstraints.gridy = 4;
		rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayoutR.setConstraints(searchHashSetlabel,rightButtonPanelConstraints);
    	
		rightButtonPanelConstraints.gridx = 0;
		rightButtonPanelConstraints.gridy = 5;
		rightButtonPanelConstraints.gridwidth = 1;
		gridBagLayoutR.setConstraints(searchArrayListButton,rightButtonPanelConstraints);
    	searchArrayListButton.setEnabled(Enabled);

		rightButtonPanelConstraints.gridx = 1;
		rightButtonPanelConstraints.gridy = 5;
		rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayoutR.setConstraints(searchArrayListlabel,rightButtonPanelConstraints);
    	
		rightButtonPanelConstraints.gridx = 0;
		rightButtonPanelConstraints.gridy = 6;
		rightButtonPanelConstraints.gridwidth = 1;
		gridBagLayoutR.setConstraints(searchSortedArrayListButton,rightButtonPanelConstraints);
    	searchSortedArrayListButton.setEnabled(Enabled);

		rightButtonPanelConstraints.gridx = 1;
		rightButtonPanelConstraints.gridy = 6;
		rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayoutR.setConstraints(searchSortedArrayListlabel,rightButtonPanelConstraints);
    	
		rightButtonPanelConstraints.gridx = 0;
		rightButtonPanelConstraints.gridy = 7;
		rightButtonPanelConstraints.gridwidth = 1;
		gridBagLayoutR.setConstraints(searchArrayButton,rightButtonPanelConstraints);
    	searchArrayButton.setEnabled(Enabled);

		rightButtonPanelConstraints.gridx = 1;
		rightButtonPanelConstraints.gridy = 7;
		rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayoutR.setConstraints(searchArraylabel,rightButtonPanelConstraints);
    	
		// add the buttons to the panel
		rightbuttonPanel.add(searchSortedIntsButton);
		rightbuttonPanel.add(searchSortedIntslabel);
		rightbuttonPanel.add(searchBstButton);
		rightbuttonPanel.add(searchBstlabel);
		rightbuttonPanel.add(searchTreeSetButton);
		rightbuttonPanel.add(searchTreeSetlabel);
		rightbuttonPanel.add(searchPriortyqueueButton);
		rightbuttonPanel.add(searchPriortyqueulabel);
		rightbuttonPanel.add(searchHashSetButton);
		rightbuttonPanel.add(searchHashSetlabel);
		rightbuttonPanel.add(searchArrayListButton);
		rightbuttonPanel.add(searchArrayListlabel);
		rightbuttonPanel.add(searchSortedArrayListButton);
		rightbuttonPanel.add(searchSortedArrayListlabel);
		rightbuttonPanel.add(searchArrayButton);
		rightbuttonPanel.add(searchArraylabel);
		
		
		// create the panel
		javax.swing.JPanel mainPanel = new javax.swing.JPanel();
		mainPanel.setLayout(new java.awt.BorderLayout());
		mainPanel.add(menuBar, java.awt.BorderLayout.NORTH);
		mainPanel.add(leftbuttonPanel, java.awt.BorderLayout.WEST);
		mainPanel.add(rightbuttonPanel,java.awt.BorderLayout.EAST);
		
		
		
		// create the action listeners for the menu items
		MenuItemActionListener fileExitMenuItemActionListener = new MenuItemActionListener(fileExit);
        MenuItemActionListener ReadSortMenuItemActionListener = new MenuItemActionListener(ReadSort);
        MenuItemActionListener ReadSearchMenuItemActionListener = new MenuItemActionListener(ReadSearch);
		
		// create the action listeners for the buttons
		//left
		ButtonActionListener sortIntsButtonListener = new ButtonActionListener(sortIntsButton,sortIntslabel);
		ButtonActionListener addToBstButtonListener = new ButtonActionListener(addToBstButton,addToBstlabel);
		ButtonActionListener addToTreeSetButtonListener =new ButtonActionListener( addToTreeSetButton,addToTreeSetlabel);
		ButtonActionListener addToPriortyqueueButtonListener =new ButtonActionListener(addToPriortyqueueButton,addToPriortyqueulabel);
		ButtonActionListener addToHashSetButtonListener =new ButtonActionListener(addToHashSetButton,addToHashSetlabel);
		ButtonActionListener addToArrayListButtonListener =new ButtonActionListener(addToArrayListButton,addToArrayListlabel);
		ButtonActionListener addToSortedArrayListButtonListener =new ButtonActionListener(addToSortedArrayListButton,addToSortedArrayListlabel);
		ButtonActionListener addToArrayButtonListener =new ButtonActionListener(addToArrayButton,addToArraylabel);

		//right
	    ButtonActionListener searchSortedIntsButtonListener = new ButtonActionListener(searchSortedIntsButton,searchSortedIntslabel);
		ButtonActionListener searchBstButtonListener = new ButtonActionListener( searchBstButton,searchBstlabel);
		ButtonActionListener searchTreeSetButtonListener = new ButtonActionListener(searchTreeSetButton,searchTreeSetlabel);
		ButtonActionListener searchPriortyqueueButtonListener = new ButtonActionListener(searchPriortyqueueButton,searchPriortyqueulabel);
		ButtonActionListener searchHashSetButtonListener = new ButtonActionListener(searchHashSetButton,searchHashSetlabel);
		ButtonActionListener searchArrayListButtonListener = new ButtonActionListener(searchArrayListButton,searchArrayListlabel);
		ButtonActionListener searchSortedArrayListButtonListener = new ButtonActionListener(searchSortedArrayListButton,searchSortedArrayListlabel);
		ButtonActionListener searchArrayButtonListener = new ButtonActionListener(searchArrayButton,searchArraylabel);
	 
		// add the action listeners to the buttons
		//left
		sortIntsButton.addActionListener(sortIntsButtonListener);
		addToBstButton.addActionListener(addToBstButtonListener);
		addToTreeSetButton.addActionListener(addToTreeSetButtonListener);
		addToPriortyqueueButton.addActionListener(addToPriortyqueueButtonListener);
		addToHashSetButton.addActionListener(addToHashSetButtonListener);
		addToArrayListButton.addActionListener(addToArrayListButtonListener);
		addToSortedArrayListButton.addActionListener(addToSortedArrayListButtonListener);
		addToArrayButton.addActionListener(addToArrayButtonListener);

		//right
		searchSortedIntsButton.addActionListener( searchSortedIntsButtonListener);
		searchBstButton.addActionListener(searchBstButtonListener);
		searchTreeSetButton.addActionListener(searchTreeSetButtonListener);
		searchPriortyqueueButton.addActionListener(searchPriortyqueueButtonListener);
		searchHashSetButton.addActionListener(searchHashSetButtonListener);
		searchArrayListButton.addActionListener(searchArrayListButtonListener);
		searchSortedArrayListButton.addActionListener(searchSortedArrayListButtonListener);
		searchArrayButton.addActionListener(searchArrayButtonListener);
		




		// add the action listeners to the menu items
		fileExit.addActionListener(fileExitMenuItemActionListener);
		ReadSort.addActionListener(ReadSortMenuItemActionListener);
        ReadSearch.addActionListener(ReadSearchMenuItemActionListener);
		
		f.setContentPane(mainPanel);
		
		f.validate();
		f.setVisible(true);
		
	}
	
	// action listener for the buttons
	static class ButtonActionListener implements java.awt.event.ActionListener
	{
		// the button associated with the action listener, so that we can
		// share this one class with multiple buttons
		private javax.swing.JButton b;
		private javax.swing.JLabel l;
		
		ButtonActionListener(javax.swing.JButton b,javax.swing.JLabel l)
		{
			this.b = b;
			this.l = l;

		}
		
		
		public void actionPerformed(java.awt.event.ActionEvent e)
		{
			System.out.println("action performed on " + b.getText() + " button");
			// I used switchcase to perfome actions
			//b.setText
				switch(b.getText().toLowerCase())
			{	
				case "sort ints":
				long t0 = System.currentTimeMillis();
				selectionSort(rawdata);
				
				long t1 = System.currentTimeMillis();
				l.setText(String.valueOf(t1-t0)+"ms");
				
				break;
				
				case "add to bst":
				long t2 = System.currentTimeMillis();
				addToBinarySearchTree();
				long t3 = System.currentTimeMillis();
				l.setText(String.valueOf(t3-t2)+"ms");
				break;
				
				case "add to treeset":
				long t4 = System.currentTimeMillis();
				addToTreeSet();
				long t5 = System.currentTimeMillis();
				l.setText(String.valueOf(t5-t4)+"ms");
				break;
				
				case "add to priorty queue":
				long t6 = System.currentTimeMillis();
				addToPriorityQueue();
				long t7 = System.currentTimeMillis();
				l.setText(String.valueOf(t7-t6)+"ms");
				break;

				case "add to hashset":
				long t12 = System.currentTimeMillis();
				addToHashSet();
				long t13 = System.currentTimeMillis();
				l.setText(String.valueOf(t13-t12)+"ms");
				break;
				
				case "add to array list": // arrlist
				long t14 = System.currentTimeMillis();
				addToArrayList();
				long t15 = System.currentTimeMillis();
				l.setText(String.valueOf(t15-t14)+"ms");
				break;

				case "add to sorted array list":
				long t8 = System.currentTimeMillis();
				addToSortedArrayList();
				long t9 = System.currentTimeMillis();
				l.setText(String.valueOf(t9-t8)+"ms");
				break;
				
				case "add to array":
				long t10 = System.currentTimeMillis();
				addToArray();
				long t11 = System.currentTimeMillis();
				l.setText(String.valueOf(t11-t10)+"ms");
				break;
				
				case "search sorted ints":
				searchInts();
				l.setText(String.valueOf(searchInts())+"ms");
				break;

				case "search bst":
				searchbts();
				l.setText(String.valueOf(searchbts())+"ms");
				break;
				
				case "search treeset":
				searchTreeSet();
				l.setText(String.valueOf(searchTreeSet())+"ms");
				break;
				
				case "search priorty queue":
				searchPriorityQueue();
				l.setText(String.valueOf(searchPriorityQueue())+"ms");
				break;
				
				case "search hashset":
				l.setText(String.valueOf(searchHashSet())+"ms");
				break;
				
				case "search array list":
				l.setText(String.valueOf(searchArrayList())+"ms");
				break;

				case "search sorted array list":
				l.setText(String.valueOf(searchSortedArrayList())+"ms");
				break;

				case "search array":
				l.setText(String.valueOf(searchArray())+"ms");
				break;


			}

		}
	}
	
	// action listener for the menu items
	static class MenuItemActionListener implements java.awt.event.ActionListener
	{
		// the menu item associated with the action listener, so that we can
		// share this one class with multiple menu items
		private javax.swing.JMenuItem m;
		
		MenuItemActionListener(javax.swing.JMenuItem m)
		{
			this.m = m;
		}
		
		public void actionPerformed(java.awt.event.ActionEvent e)
		{
			System.out.println("action performed on " + m.getText() + " menu item");
			
			// if exit is selected from the file menu, exit the program
			if( m.getText().toLowerCase().equals("exit") )
			{
				System.exit(0);
			}
			
			// if color is selected from the edit menu, put a popup on the screen 
			// saying something 
			if( m.getText().toLowerCase().equals("read sort file") )
			{	
				readData(LocS,true);
				
				Object[] options = {"OK"};
				javax.swing.JOptionPane.showOptionDialog(null, "Read Sort file\n DONE!!", 
						"Warning", javax.swing.JOptionPane.DEFAULT_OPTION, 
						javax.swing.JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			}
            if( m.getText().toLowerCase().equals("read search file") )
			{

					readData(LocR,false);
					
				Object[] options = {"OK"};
				javax.swing.JOptionPane.showOptionDialog(null, "Read Search file\n DONE!!", 
						"Warning", javax.swing.JOptionPane.DEFAULT_OPTION, 
						javax.swing.JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			}
			
		}
	}
	
	private static void readData(String filename, boolean readSortValues)
	{
		
		try
		{
		if(readSortValues)
		{
			filename = LocS;// sort files
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		String file;
			while (((file = input.readLine())!=null))
			{
				rawdata.add(Integer.parseInt(file));

			}
			
			input.close();
		}
		else
		{filename = LocR;// search files
		
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			String file;
				while (((file = input.readLine())!=null))
				{
					data.add(Integer.parseInt(file));
				}
				input.close();	
			}


		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
			
	}

	// ### Funcitons Side ###

	private static ArrayList<Integer> selectionSort(ArrayList<Integer> arr)
	{
		
	
		int n = arr.size();
 
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr.get(j) < arr.get(min_idx))
                    min_idx = j;
 
            // Swap the found minimum element with the first
            // element
            int temp = arr.get(min_idx);
            arr.set(min_idx,arr.get(i));
            arr.set(i,temp);
        }
    return arr;
	}
	private static void addToBinarySearchTree()
	{
		
		for(int e: rawdata)
		{
			Node z = new Node(e); // error massage not converted.
			bst.insertNode(z);
		}
	}
	

	private static void addToTreeSet()
	{
		for(int e: rawdata)
		{

			ts.add(e);
		}
	}
	
	private static void addToPriorityQueue()
	{
		for(int e: rawdata)
		{
			pq.add(e);
		}
	}

	private static void addToHashSet()
	{	
		for(int e: rawdata)
		{
			set.add(e);
		}

	}

	private static void addToArrayList()
	{
		for(int e: rawdata)
		{
			arrlist.add(e);
		}
	}

	private static void addToSortedArrayList()
	{	
		
		selectionSort(rawdata);
	}

	private static void addToArray()

	{
		arr3 = new int[rawdata.size()];
		for(int e = 0; e<rawdata.size(); e++)
		{
			arr3[e] = rawdata.get(e);
		}
	}

	private static long searchInts()
	{
		long t0 = System.currentTimeMillis();
		for(int e : data)
		{
			if(rawdata.contains(e));
		}
		
		long t1 = System.currentTimeMillis();
		
		return t1-t0;
	}
	private static long searchbts()
	{
		long t0 = System.currentTimeMillis();
		/// following code here 
		for(int e:data)
		{
			Node z = new Node(e);
			bst.getNode(z,e);
		}
		long t1 = System.currentTimeMillis();
		
		return t1-t0;
	}
	
	private static long searchTreeSet()
	{	
		long t0 = System.currentTimeMillis();
		for(int e : data)
		{
			if(ts.contains(e)) ;
		}
		long t1 = System.currentTimeMillis();
	
		return t1-t0;
	}
	
	private static long searchPriorityQueue()
	{	
		long t0 = System.currentTimeMillis();
		for(int e : data)
		{
			if(pq.contains(e));
		}
		long t1 = System.currentTimeMillis();
		return t1-t0;
	}
	private static long searchHashSet()
	{	
		
		long t0 = System.currentTimeMillis();
		for(int e : data)
		{
			if(set.contains(e));
		}
		long t1 = System.currentTimeMillis();
	
		return t1-t0;

	}
	private static long searchArrayList()
	{
		long t0 = System.currentTimeMillis();
		for(int e : data)
		{
			if(arrlist.contains(e));
		}
		long t1 = System.currentTimeMillis();
		return t1-t0;
	}

	private static long searchSortedArrayList()
	{
		long t0 = System.currentTimeMillis();
		for ( int e : rawdata)
		{
			int bottom = 0;
			int top = data.size()-1;
			while(bottom<=top)
			{
				int middle =(bottom+top)/2;
				if(e < data.get(middle))
				{	
					top = middle-1;
				}
				else
				{
					if(e > data.get(middle))
					{
						bottom = middle+1;
					}
					else
					{
						break;
					}
				}
			}	
		
		}
		long t1 = System.currentTimeMillis();

		return t1-t0;
	}
	private static long searchArray()
	{
		long t0 = System.currentTimeMillis();
		for(int e : arr3)
		{
			if(data.contains(e));
		}
		
		long t1 = System.currentTimeMillis();

		return t1-t0;
	}

}

