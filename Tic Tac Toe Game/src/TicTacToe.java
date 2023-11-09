import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TicTacToe implements ActionListener {
    Random random=new Random();
    JFrame frame = new JFrame();
    JPanel titl_Panel = new JPanel();
    JPanel butto_Panel = new JPanel();
    JLabel textfill = new JLabel();
    JButton[] button =new JButton[9];    
    boolean Player1_Turn;
  
    int XWins = 0;
    int OWins = 0;
    

    // Method to play click sound
    public void playClickSound() {
      try {
          Toolkit.getDefaultToolkit().beep(); // Play default beep sound
      } catch (Exception e) {
          e.printStackTrace();
      }
    }
    TicTacToe()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,500);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);  //it set the postion of the window to the center  
        frame.getContentPane().setBackground(new Color(240, 240, 240));   // this for the Color Title Bar
        frame.setVisible(true);
        frame.setTitle("Tic TacToe");
        
        textfill .setBackground(new Color(0,128,128)); // this is for the color of Tic-Tac-Toe Background
        textfill .setForeground(new Color(255,255,255)); // this is for the color of Tic-Tac-Toe text
        textfill.setText("Tic-Tac-Toe");
        textfill.setOpaque(true);
        textfill.setHorizontalAlignment(JLabel.CENTER);
        textfill.setFont(new Font("Arial",Font.BOLD,65));
       
        titl_Panel.setLayout(new BorderLayout() );
        textfill.setBounds(0, 0, 800, 100);
           
        butto_Panel.setLayout(new GridLayout(3,3));
        //butto_Panel .setBackground(new Color(100,150,150));
        for (int i =0;i<9;i++)
        {
            button[i]=new JButton();
            butto_Panel.add(button[i]);
            button[i].setFont(new Font ("Arial",Font.BOLD,70));
            button[i].setFocusable(false);
            button[i].setBackground(new Color(245, 245, 245)); // this for the color of Button
            button[i].addActionListener(this);
        }

        titl_Panel.add(textfill);
        frame.add(titl_Panel,BorderLayout.NORTH);
        frame.add(butto_Panel);
        FirstTirn();
    }
    public void actionPerformed(ActionEvent e) 
    {
        for(int i=0;i<9;i++)
        {
            if (e.getSource()==button[i])
            {
                if(Player1_Turn)
                {
                    if(button[i].getText()=="")
                    {
                        button[i].setForeground(new Color(255,0,0));
                        button[i].setText("X");
                        Player1_Turn=false;
                        textfill.setText("O Turn");
                        chack();
                    }
                }
                else
                {
                    
                    if(button[i].getText()=="")
                    {
                        button[i].setForeground(new Color(0,0,255));
                        button[i].setText("O");
                        Player1_Turn=true;
                        textfill.setText("X Turn");
                        chack();
                    }

                }
            }

        }
        playClickSound();//sound
    }
     public void FirstTirn()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
    
            e.printStackTrace();
        }
        if(random.nextInt(2)==0)
        {
            Player1_Turn=true;
            textfill.setText("X Turn");
        }
        else
        {
            Player1_Turn=false;
            textfill.setText("O Turn");
        }
    }
    public void chack()
    {
        //       chack The condtion for "X" wins 
        if(
          (button[0].getText()=="X")&&
          (button[1].getText()=="X")&&
          (button[2].getText()=="X")
         )
          {
            Xwins(0, 1, 2);
          }
          if(
          (button[3].getText()=="X")&&
          (button[4].getText()=="X")&&
          (button[5].getText()=="X")
         )
          {
            Xwins(3, 4, 5);
          }
          if(
          (button[6].getText()=="X")&&
          (button[7].getText()=="X")&&
          (button[8].getText()=="X")
         )
          {
            Xwins(6, 7, 8);
          }
          if(
          (button[0].getText()=="X")&&
          (button[3].getText()=="X")&&
          (button[6].getText()=="X")
         )
          {
            Xwins(0, 3, 6);
          }
          if(
          (button[1].getText()=="X")&&
          (button[4].getText()=="X")&&
          (button[7].getText()=="X")
         )
          {
            Xwins(1, 4, 7);
          }
          if(
          (button[2].getText()=="X")&&
          (button[5].getText()=="X")&&
          (button[8].getText()=="X")
         )
          {
            Xwins(2, 5, 8);
          }
          if(
          (button[0].getText()=="X")&&
          (button[4].getText()=="X")&&
          (button[8].getText()=="X")
         )
          {
            Xwins(0, 4, 8);
          }
          if(
          (button[2].getText()=="X")&&
          (button[4].getText()=="X")&&
          (button[6].getText()=="X")
         )
          {
            Xwins(2, 4, 6);
          }

        //       chack the condation for "Y" wins 

        if(
          (button[0].getText()=="O")&&
          (button[1].getText()=="O")&&
          (button[2].getText()=="O")
         )
          {
            Owins(0, 1, 2);
          }
          if(
          (button[3].getText()=="O")&&
          (button[4].getText()=="O")&&
          (button[5].getText()=="O")
         )
          {
            Owins(3, 4, 5);
          }
          if(
          (button[6].getText()=="O")&&
          (button[7].getText()=="O")&&
          (button[8].getText()=="O")
         )
          {
            Owins(6, 7, 8);
          }
          if(
          (button[0].getText()=="O")&&
          (button[3].getText()=="O")&&
          (button[6].getText()=="O")
         )
          {
            Owins(0, 3, 6);
          }
          if(
          (button[1].getText()=="O")&&
          (button[4].getText()=="O")&&
          (button[7].getText()=="O")
         )
          {
            Owins(1, 4, 7);
          }
          if(
          (button[2].getText()=="O")&&
          (button[5].getText()=="O")&&
          (button[8].getText()=="O")
         )
          {
            Owins(2, 5, 8);
          }
          if(
          (button[0].getText()=="O")&&
          (button[4].getText()=="O")&&
          (button[8].getText()=="O")
         )
          {
            Owins(0, 4, 8);
          }
          if(
          (button[2].getText()=="O")&&
          (button[4].getText()=="O")&&
          (button[6].getText()=="O")
         )
          {
            Owins(2, 4, 6);
          }
          boolean isFull = true;
    for (int i = 0; i < 9; i++) {
        if (button[i].getText().equals("")) {
            isFull = false;
            break;
        }
    }
    // When No Win ------
    if (isFull) {
        int choice = JOptionPane.showOptionDialog(frame,
            "No one wins! Do you want to continue or exit?",
            "Game Over",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            new String[]{"Continue", "Exit"},
            "default");
        if (choice == JOptionPane.YES_OPTION) {
            resetGame();
        } else {
            System.exit(0);
        }
    }
    }
    public void Xwins(int a,int b,int c)
    {
      
        button[a].setBackground(Color.DARK_GRAY);
        button[b].setBackground(Color.DARK_GRAY);
        button[c].setBackground(Color.DARK_GRAY);
        for(int i=0;i<9;i++)      // This is for Disible the Button After the win 
        {
            button[i].setEnabled(false);
        }
        XWins++;
        String message = "X Wins: " + XWins + "\nO Wins: " + OWins;
        int choice = JOptionPane.showOptionDialog(frame, message + "\nX won! Do you want to continue or exit?", "Game Over",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Continue", "Exit"},
                "default");
        if (choice == JOptionPane.YES_OPTION) {
            resetGame();
        } else {
            System.exit(0);
        }
      
    }
    public void Owins(int a,int b,int c)
    {
      
        button[a].setBackground(Color.DARK_GRAY);
        button[b].setBackground(Color.DARK_GRAY);
        button[c].setBackground(Color.DARK_GRAY);
        for(int i=0;i<9;i++)      // This is for Disible the Button After the win 
        {
            button[i].setEnabled(false);
        }
        OWins++;
        String message = "X Wins: " + XWins + "\nO Wins: " + OWins;
        int choice = JOptionPane.showOptionDialog(frame, message + "\nO won! Do you want to continue or exit?", "Game Over",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Continue", "Exit"},
                "default");
        if (choice == JOptionPane.YES_OPTION) {
            resetGame();
        } else {
            System.exit(0);
        }
    }
    public void resetGame() {
      for (int i = 0; i < 9; i++) {
          button[i].setEnabled(true);
          button[i].setText("");
          button[i].setBackground(new Color(245, 245, 245)); // Reset button color
      }
      // Reset the game state
      Player1_Turn = (random.nextInt(2) == 0); // Randomly set the first turn again
      if (Player1_Turn) {
          textfill.setText("X Turn");
      } else {
          textfill.setText("O Turn");
      }
     

  }
  
        
}
