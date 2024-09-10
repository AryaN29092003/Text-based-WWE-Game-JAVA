import javax.swing.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class javaProtry2form extends JFrame {
    private JTextField pcInput;

    private JTextField winner;
    private JTextField userInput;
    private JButton charge;
    private JButton dodge;
    private JButton block;
    private JButton deflect;
    private JButton jumpdodge;
    private JButton duckdodge;
    private JButton punch;
    private JPanel mainpanel;
    private JButton chop;
    private JButton sidekick;
    private JButton hookkick;
    private JButton spinkick;
    private JLabel Pcchargec;
    private JLabel Userchargec;
    private JTextField txtPCChargeC;
    private JTextField txtUserChargeC;
    private JLabel energy;
    int Pcchargecount=0,Userchargecount=0;

    int PcAtPoints=0,PcDefPoints=0;
    int UsAtPoints=0,UsDefPoints=0;



    public void WhoWins(){
    if(UsAtPoints>PcAtPoints && UsAtPoints>PcDefPoints) {
        JOptionPane.showMessageDialog(null,"You Won up for another game?");
        Userchargecount=0;
        PcAtPoints=0;
        PcDefPoints=0;
        UsAtPoints=0;
        UsDefPoints=0;
        Pcchargecount=0;
        txtPCChargeC.setText(("|0| ").repeat(Pcchargecount));
        txtUserChargeC.setText(("|0| ").repeat(Pcchargecount));
        pcInput.setText("");
        userInput.setText("");
    }else if(UsAtPoints<PcAtPoints && UsDefPoints<PcAtPoints){
        JOptionPane.showMessageDialog(null,"You Lost up for another game?");
        Userchargecount=0;
        PcAtPoints=0;
        PcDefPoints=0;
        UsAtPoints=0;
        UsDefPoints=0;
        Pcchargecount=0;
        txtUserChargeC.setText(("|0| ").repeat(Pcchargecount));
        txtPCChargeC.setText(("|0| ").repeat(Pcchargecount));
        pcInput.setText("");
        userInput.setText("");
    }

    }


    public void PCMove(){
        Random r1= new Random();
        int adc= r1.nextInt(3);


        Map<Integer, String> attacks
                = new HashMap< Integer, String>();
        attacks.put(1,"punch");
        attacks.put(2,"chop");
        attacks.put(3,"sidekick");
        attacks.put(4,"hookkick");
        attacks.put(5,"spinkick");

        Map<Integer, String> defenses
                = new HashMap< Integer, String>();
        defenses.put(1,"dodge");
        defenses.put(2,"block");
        defenses.put(3,"deflect");
        defenses.put(4,"jumpdodge");
        defenses.put(5,"duckdodge");

        if(Pcchargecount>0) {
            if (adc == 0) {
                pcInput.setText("Charge");
                Pcchargecount++;
                PcAtPoints=0;
                PcDefPoints=0;
                txtPCChargeC.setText(("|0| ").repeat(Pcchargecount));
            } else if (adc == 1) {
                Random atr= new Random();
                int flag= atr.nextInt(Pcchargecount);
                int at= atr.nextInt(Pcchargecount);
                    String attackmove =attacks.get(at+1+flag);
                pcInput.setText(attackmove);
                Pcchargecount= Pcchargecount - at - 1;
                txtPCChargeC.setText(("|0| ").repeat(Pcchargecount));
                if((at+1+flag)==1){
                    PcAtPoints=1;
                    PcDefPoints=0;
                }else if((at+1+flag)==2){
                    PcAtPoints=2;
                    PcDefPoints=0;
                }else if((at+1+flag)==3){
                    PcAtPoints=3;
                    PcDefPoints=0;
                }else if((at+1+flag)==4){
                    PcAtPoints=4;
                    PcDefPoints=0;
                }else if((at+1+flag)==5){
                    PcAtPoints=5;
                    PcDefPoints=0;
                }

            } else if (adc == 2) {
                Random der= new Random();
                int df= der.nextInt(Pcchargecount);
                String defensemove =defenses.get(df+1);
                pcInput.setText(defensemove);
                txtPCChargeC.setText(("|0| ").repeat(Pcchargecount));
                if((df+1)==1){
                    PcAtPoints=0;
                    PcDefPoints=1;
                }else if((df+1)==2){
                    PcAtPoints=0;
                    PcDefPoints=2;
                }else if((df+1)==3){
                    PcAtPoints=0;
                    PcDefPoints=3;
                }else if((df+1)==4){
                    PcAtPoints=0;
                    PcDefPoints=4;
                }else if((df+1)==5){
                    PcAtPoints=0;
                    PcDefPoints=5;
                }
            }
        }else{
            pcInput.setText("Charge");
            Pcchargecount++;
            PcAtPoints=0;
            PcDefPoints=0;
            txtPCChargeC.setText(("|0| ").repeat(Pcchargecount));
        }
    }

    public javaProtry2form(){


        Map<Integer, String> attacks
                = new HashMap< Integer, String>();
        attacks.put(1,"punch");
        attacks.put(2,"chop");
        attacks.put(3,"sidekick");
        attacks.put(4,"hookkick");
        attacks.put(5,"spinkick");

        Map<Integer, String> defenses
                = new HashMap< Integer, String>();
        defenses.put(1,"dodge");
        defenses.put(2,"block");
        defenses.put(3,"deflect");
        defenses.put(4,"jumpdodge");
        defenses.put(5,"duckdodge");



        charge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInput.setText("Charge");
                Userchargecount++;
                UsAtPoints=0;
                UsDefPoints=0;
                txtUserChargeC.setText(("|0| ").repeat(Userchargecount));
                PCMove();
                WhoWins();
            }

        });
        dodge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInput.setText("Dodge");
                UsAtPoints=0;
                UsDefPoints=1;
                PCMove();
                WhoWins();
            }
        });
        block.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInput.setText("Block");
                UsAtPoints=0;
                UsDefPoints=2;
                PCMove();
                WhoWins();
            }
        });
        deflect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInput.setText("Deflect");
                UsAtPoints=0;
                UsDefPoints=3;
                PCMove();
                WhoWins();
            }
        });
        jumpdodge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInput.setText("JumpDodge");
                UsAtPoints=0;
                UsDefPoints=4;
                PCMove();
                WhoWins();
            }
        });
        duckdodge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInput.setText("DuckDodge");
                UsAtPoints=0;
                UsDefPoints=5;
                PCMove();
                WhoWins();
            }
        });
            punch.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (Userchargecount >= 1) {
                        userInput.setText("Punch");
                        UsAtPoints = 1;
                        UsDefPoints = 0;
                        Userchargecount = Userchargecount - 1;
                        txtUserChargeC.setText(("|0| ").repeat(Userchargecount));
                        PCMove();
                        WhoWins();
                    }else {
                        JOptionPane.showMessageDialog(null,"Not Enough charge!!!");
                    }
                }
            });
                chop.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if(Userchargecount>=2) {
                            userInput.setText("Chop");
                            UsAtPoints = 2;
                            UsDefPoints = 0;
                            Userchargecount = Userchargecount - 2;
                            txtUserChargeC.setText(("|0| ").repeat(Userchargecount));
                            PCMove();
                            WhoWins();
                        }else {
                            JOptionPane.showMessageDialog(null,"Not Enough charge!!!");
                        }
                    }
                });

            sidekick.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (Userchargecount >= 2) {
                        userInput.setText("SideKick");
                        UsAtPoints = 3;
                        UsDefPoints = 0;
                        Userchargecount = Userchargecount - 2;
                        txtUserChargeC.setText(("|0| ").repeat(Userchargecount));
                        PCMove();
                        WhoWins();
                    }else {
                        JOptionPane.showMessageDialog(null,"Not Enough charge!!!");
                    }
                }
            });

            hookkick.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(Userchargecount>=3) {
                        userInput.setText("HookKick");
                        UsAtPoints = 4;
                        UsDefPoints = 0;
                        Userchargecount = Userchargecount - 3;
                        txtUserChargeC.setText(("|0| ").repeat(Userchargecount));
                        PCMove();
                        WhoWins();
                    }else {
                        JOptionPane.showMessageDialog(null,"Not Enough charge!!!");
                    }
                }
            });
            spinkick.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(Userchargecount>=3) {
                        userInput.setText("SpinKick");
                        UsAtPoints = 5;
                        UsDefPoints = 0;
                        Userchargecount = Userchargecount - 3;
                        txtUserChargeC.setText(("|0| ").repeat(Userchargecount));
                        PCMove();
                        WhoWins();
                    }else {
                        JOptionPane.showMessageDialog(null,"Not Enough charge!!!");
                    }
                }
            });

    }

    public static void main(String[] args) {
        javaProtry2form j1= new javaProtry2form();
        j1.setContentPane(j1.mainpanel);
        j1.setTitle("WWE");
        j1.setSize(550,400);
        j1.setVisible(true);
        j1.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
