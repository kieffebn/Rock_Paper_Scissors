
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.*;

public class RockPaperScissorsFrame extends JFrame
{

    JPanel main = new JPanel();
    JPanel controlPnl = new JPanel();
    JPanel histPnl = new JPanel();
    JPanel statPnl = new JPanel();
    ImageIcon rockIcon = new ImageIcon("src/rock.png");
    ImageIcon paperIcon = new ImageIcon("src/rock.png");
    ImageIcon scissorsIcon = new ImageIcon("src/rock.png");
    JLabel titleLbl = new JLabel("Rock Paper Scissors!",JLabel.CENTER);
    JLabel playerWins = new JLabel("Player Wins: ");
    JLabel cpuWins = new JLabel("CPU Wins: ");
    JLabel ties = new JLabel("Ties: ");


    JButton quitBtn = new JButton("Quit");
    JButton scissorsBtn = new JButton(scissorsIcon);
    JButton paperBtn = new JButton(paperIcon);
    JButton rockBtn = new JButton(rockIcon);

    JTextArea histDisplayArea = new JTextArea(12, 40);
    JScrollPane scroller = new JScrollPane(histDisplayArea);


    public class storedValue {
        public static int wins;
        public static int losses;
        public static int ties;
        public static int cpuChoice;
    }

    private void cpuRandom() {
        Random rnd = new Random();
         storedValue.cpuChoice = rnd.nextInt(2);
    }

    public RockPaperScissorsFrame()
    {
        titleLbl.setFont(new Font("Times New Roman", Font.ITALIC, 36));
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        histDisplayArea.setFont(new Font("Arial", Font.PLAIN, 16));
        quitBtn.setFont(new Font("Sans Serif", Font.BOLD, 24));
        playerWins.setFont(new Font("Arial", Font.PLAIN, 16));
        cpuWins.setFont(new Font("Arial", Font.PLAIN, 16));
        ties.setFont(new Font("Arial", Font.PLAIN, 16));

        setTitle("Rock Paper Scissors");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createGUI();
        enableButtons();

        setVisible(true);
    }

    private void createGUI()
    {
        main.setLayout(new BorderLayout());

        controlPnl.setLayout(new GridLayout(1,4 ));  // 1 row 4 columns

        controlPnl.add(rockBtn);
        controlPnl.add(paperBtn);
        controlPnl.add(scissorsBtn);
        controlPnl.add(quitBtn);
        titleLbl.setFont(new Font("Serif", Font.PLAIN, 24));

        statPnl.add(playerWins);
        statPnl.add(cpuWins);
        statPnl.add(ties);

        histPnl.add(scroller);


        main.add(BorderLayout.NORTH, titleLbl);
        main.add(BorderLayout.WEST, statPnl);
        main.add(BorderLayout.CENTER, histPnl);
        main.add(BorderLayout.SOUTH, controlPnl);

        add(main);
    }

    private void enableButtons()
    {


        rockBtn.addActionListener
                (
                        e -> {
                            cpuRandom();
                            if (storedValue.cpuChoice == 0) {
                                storedValue.ties++;
                                String s = String.valueOf(storedValue.ties);
                                ties.setText("Ties: " + s);
                                histDisplayArea.append("Rock vs Rock, Tie!" + "\n");
                            } else if (storedValue.cpuChoice == 1) {
                                storedValue.losses++;
                                String s = String.valueOf(storedValue.losses);
                                cpuWins.setText("CPU Wins: " + s);
                                histDisplayArea.append("Paper covers Rock, CPU Wins!" + "\n");
                            } else {
                                storedValue.wins++;
                                String s = String.valueOf(storedValue.wins);
                                playerWins.setText("Player Wins: " + s);
                                histDisplayArea.append("Rock smashes Scissors, Player Wins!" + "\n");
                            }

                        }
                );
        paperBtn.addActionListener
                (
                        e -> {
                            cpuRandom();
                            if (storedValue.cpuChoice == 1) {
                                storedValue.ties++;
                                String s = String.valueOf(storedValue.ties);
                                ties.setText("Ties: " + s);
                                histDisplayArea.append("Paper vs Paper, Tie!" + "\n");
                            } else if (storedValue.cpuChoice == 2) {
                                storedValue.losses++;
                                String s = String.valueOf(storedValue.losses);
                                cpuWins.setText("CPU Wins: " + s);
                                histDisplayArea.append("Scissors cut Paper, CPU Wins!" + "\n");
                            } else {
                                storedValue.wins++;
                                String s = String.valueOf(storedValue.wins);
                                playerWins.setText("Player Wins: " + s);
                                histDisplayArea.append("Paper covers Rock, Player Wins!" + "\n");
                            }

                        }
                );
        scissorsBtn.addActionListener
                (
                        e -> {
                            cpuRandom();
                            if (storedValue.cpuChoice == 2) {
                                storedValue.ties++;
                                String s = String.valueOf(storedValue.ties);
                                ties.setText("Ties: " + s);
                                histDisplayArea.append("Scissors vs Scissors, Tie!" + "\n");
                            } else if (storedValue.cpuChoice == 0) {
                                storedValue.losses++;
                                String s = String.valueOf(storedValue.losses);
                                cpuWins.setText("CPU Wins: " + s);
                                histDisplayArea.append("Rock Smashes Scissors, CPU Wins!" + "\n");
                            } else {
                                storedValue.wins++;
                                String s = String.valueOf(storedValue.wins);
                                playerWins.setText("Player Wins: " + s);
                                histDisplayArea.append("Scissors cut Paper, Player Wins!" + "\n");
                            }

                        }
                );

        quitBtn.addActionListener
                (
                        (ActionEvent ae) -> System.exit(0)
                );
    }

}
