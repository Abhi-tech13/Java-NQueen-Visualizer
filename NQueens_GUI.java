import javax.swing.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;

public class NQueens_GUI extends Thread{
        JTextField jtxt;
        JFrame jf2;
        int f=0,c=0;
        int n=0;
        JButton jb[][];
    public NQueens_GUI(){
        JFrame jf=new JFrame("PLACE N-QUEENS");
        jf.setLayout(new GridLayout(2,1));
        int i,k=0;
        JPanel jp=new JPanel();
        JPanel jp1=new JPanel();
        jp.setBackground(Color.gray);
        JLabel jlab=new JLabel("Enter total Number of Queens to be placed :");
        jtxt=new JTextField(3);
        JTextField jtxt2=new JTextField(22);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        JButton submit=new JButton("Start Algorithm");
        JButton show=new JButton("Show Chess Board");
        JLabel jl1=new JLabel("                Two Queens Cannot Be In Same Column/Row/Diagonal.                     ");
        jp.setLayout(new FlowLayout());
        jp.setSize(500,200);
        jp.add(jlab);
        jp.add(jtxt);
        jp.add(show);
        jp.add(jtxt2);
        jp.add(jl1);
        jp.add(submit);
        jf.pack();
        jp.setVisible(true);
        jf.add(jp);
        jp1.setBackground(Color.gray);
        jp1.setSize(500,400);
        jf.add(jp1);
        jf.setVisible(true);
        Thread t2=new Thread(this);
        show.setAlignmentX(Component.CENTER_ALIGNMENT);
        show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(c==0){
                    c=1;
                    n=Integer.parseInt(jtxt.getText());
                    jp1.setLayout(new GridLayout(n,n));
                    int size=400/n;
                    jb=new JButton[n][n];
                    for(int t=0;t<n;t++) for(int j=0;j<n;j++) {jb[t][j]=new JButton();
                            jb[t][j].setSize(size,size);
                        }
                    for(int t=0;t<n;t++){
                        for(int j=0;j<n;j++){
                            if((t+j)%2==1){
                                jb[t][j].setBackground(Color.black);
                            }
                            else
                                jb[t][j].setBackground(Color.white);
                            jb[t][j].setText("  ");
                            jp1.add(jb[t][j]);
                        }
                    }    jp1.setVisible(true);
                    try{ t2.sleep(500);
                        t2.sleep(200);
                       // jf.add(jp1);
                   }
                    catch(InterruptedException  E){} 
                }
            }});   
        /*    show.addKeyListener(new KeyListener(){
                public void keyPressed(KeyEvent e){
                    if(e.getKeyCode()==KeyEvent.VK_ENTER){
                        n=Integer.parseInt(jtxt.getText());
                jf2=new JFrame("Placing Queens...");
                jf2.setSize(600,600);
                jf2.setSize(30*(n+1),30*(n+1));
                jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jp.setLayout(new GridLayout(n,n));
                jp.setSize(500,500);
                int size=400/n;
                jb=new JButton[n][n];
                for(int t=0;t<n;t++) for(int j=0;j<n;j++) {jb[t][j]=new JButton();
                        jb[t][j].setSize(size,size);
                    }
                for(int t=0;t<n;t++){
                    for(int j=0;j<n;j++){
                        if((t+j)%2==1){
                            jb[t][j].setBackground(Color.black);
                        }
                        else
                            jb[t][j].setBackground(Color.white);
                        jb[t][j].setText("  ");
                        jp.add(jb[t][j]);
                    }
                }    jp.setVisible(true);
                try{ t2.sleep(500);
                    jp.setSize(400,400);
                    t2.sleep(200);
                    jf.add(jp);
                    jf.setBackground(Color.cyan);
               }
                catch(InterruptedException  E){}
            }
        }
          public void keyReleased(KeyEvent e){}
          public void keyTyped(KeyEvent e){}
      
        });     */
        while(n==0){
            try{
                //this.sleep(200);
                jp.setSize(500,300);
                jf.setSize(500,600);
                this.sleep(1000);
            }catch(InterruptedException E){}
        }
        submit.setAlignmentX(Component.CENTER_ALIGNMENT);
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            try{
                t2.sleep(200);
                f=1;
            } catch(InterruptedException E){}
        }});
        jf.setVisible(true);
        while(f==0){
            try{
                t2.sleep(200);
            } catch(InterruptedException E){}
        }
        int X []=new int[n];
        for(int s=0;s<n;s++){
            X[s]=-1;
        }
        NQueen nq=new NQueen();
        jp.setVisible(true);
        int y=nq.NQueens(jb,X,k,n);
        if(y==1){
            jtxt2.setText("Queens Placed Successfully");
        }
        else
            jtxt2.setText("Queens cannot be placed in given Board");
    }
    public static void main(String []args){
        new NQueens_GUI();
    }   
}

class NQueen extends Thread{
    JButton jb[][];
    int X[];
    int k;
    int n;
   int NQueens(JButton jb[][],int X[],int k,int n){
        int y=1;
        for(int i=0;i<n && X[n-1]==-1;i++){
            jb[k][i].setBackground(Color.yellow);
            y=-1;
            if(Place(X,k,i)){
                try{
                    this.sleep(150);
                }catch(Exception e){}
                X[k]=i;
                jb[k][i].setText(" Q ");
                jb[k][i].setBackground(Color.GREEN);
                y=NQueens(jb,X,k+1,n);
            }
            if(y!=-1){
                    break;
            }
            try{
                this.sleep(200);
            }
            catch(Exception e){}
            jb[k][i].setText(" X ");
            if((k+i)%2==0)
             jb[k][i].setBackground(Color.white);
            else
             jb[k][i].setBackground(Color.black);
        }
	return y;
    }
    boolean Place(int X[],int k,int i){
	int j;
	for(j=0;j<k;j++){
		if(X[j]==i || Math.abs(X[j]-i)==Math.abs(j-k))
			return false;
	}
		return true;
    }
   public void run(){
       NQueens(jb,X,k,n);
   }
}