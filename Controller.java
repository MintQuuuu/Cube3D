package cube3d;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Controller implements KeyListener, ActionListener {

    private ArrayList<Integer> moves = new ArrayList<Integer>();
    private CubeCreator cube = new CubeCreator();
    private BufferedImage recordIcon;
    private BufferedImage isRecordingIcon;
    private JButton blueUp, blueDown, yellowRight, yellowLeft, whiteRight, whiteLeft;
    private JButton orangeUp, orangeDown, redUp, redDown, greenUp, greenDown;
    private JButton scramble, reset, record, play;
    private boolean isRecording = false;
    JButton button;
    private int side = 1;
    private int lel = 0;

    public Controller(CubeCreator cube, JButton blueUp, JButton blueDown, JButton yellowRight, JButton yellowLeft, JButton whiteRight, JButton whiteLeft,
            JButton orangeUp, JButton orangeDown, JButton redUp, JButton redDown, JButton greenUp, JButton greenDown,
            JButton scramble, JButton reset, JButton record, JButton play, JButton button) {

        try {
            this.recordIcon = ImageIO.read(new File("images/record.png"));
            this.isRecordingIcon = ImageIO.read(new File("images/recordClicked.png"));
        } catch (Exception e) {
            System.out.println("nie można wczytać obrazka");
        }
        this.cube = cube;
        this.blueUp = blueUp;
        this.blueDown = blueDown;
        this.yellowRight = yellowRight;
        this.yellowLeft = yellowLeft;
        this.whiteRight = whiteRight;
        this.whiteLeft = whiteLeft;
        this.orangeUp = orangeUp;
        this.orangeDown = orangeDown;
        this.redUp = redUp;
        this.redDown = redDown;
        this.greenUp = greenUp;
        this.greenDown = greenDown;
        this.scramble = scramble;
        this.reset = reset;
        this.record = record;
        this.play = play;
        this.button = button;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'a') {
            cube.cube_move(side, 1);
        }

        if (e.getKeyChar() == 'c') {
            cube.cube_move(side, 2);
        }
        if (e.getKeyChar() == 'z') {
            cube.cube_move(side, 3);
        }

        if (e.getKeyChar() == 's') {
            cube.cube_move(side, 4);
        }
        if (e.getKeyChar() == 'x') {
            cube.cube_move(side, 5);
        }
        if (e.getKeyChar() == 'd') {
            cube.cube_move(side, 6);
        }
        if (e.getKeyCode() == VK_LEFT) {
            this.side = -1;
        }
        if (e.getKeyCode() == VK_RIGHT) {
            this.side = 1;
        }
        if (e.getKeyChar() == 'r') {
            cube.reset_cube();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == blueUp) {
            cube.cube_move(1, 1);
            if (isRecording == true) {
                moves.add(1);
                moves.add(1);
            }
        }

        if (e.getSource() == blueDown) {
            cube.cube_move(-1, 1);
            if (isRecording == true) {
                moves.add(-1);
                moves.add(1);
            }
        }
        if (e.getSource() == greenUp) {
            cube.cube_move(1, 6);

            if (isRecording == true) {
                moves.add(1);
                moves.add(6);
            }
        }

        if (e.getSource() == greenDown) {
            cube.cube_move(-1, 6);
            if (isRecording == true) {
                moves.add(-1);
                moves.add(6);
            }

        }

        if (e.getSource() == yellowRight) {
            cube.cube_move(1, 4);
            if (isRecording == true) {
                moves.add(1);
                moves.add(4);
            }
        }

        if (e.getSource() == yellowLeft) {
            cube.cube_move(-1, 4);
            if (isRecording == true) {
                moves.add(-1);
                moves.add(4);
            }
        }
        if (e.getSource() == whiteRight) {
            cube.cube_move(1, 5);
            if (isRecording == true) {
                moves.add(-1);
                moves.add(5);
            }

        }

        if (e.getSource() == whiteLeft) {
            cube.cube_move(-1, 5);
            if (isRecording == true) {
                moves.add(-1);
                moves.add(5);
            }
        }
        if (e.getSource() == redUp) {

            cube.cube_move(1, 2);
            if (isRecording == true) {
                moves.add(1);
                moves.add(2);
            }
        }

        if (e.getSource() == redDown) {
            cube.cube_move(-1, 2);
            if (isRecording == true) {
                moves.add(-1);
                moves.add(2);
            }
        }
        if (e.getSource() == orangeUp) {

            cube.cube_move(1, 3);
            if (isRecording == true) {
                moves.add(1);
                moves.add(3);
            }
        }

        if (e.getSource() == orangeDown) {
            cube.cube_move(-1, 3);
            if (isRecording == true) {
                moves.add(-1);
                moves.add(3);
            }
        }
        if (e.getSource() == reset) {
            cube.reset_cube();
        }
        if (e.getSource() == scramble) {
            Random generator = new Random();

            for (int i = 0; i < 20; i++) {
                if (generator.nextInt(100) % 5 == 0) {
                    cube.cube_move(-1, 6 - generator.nextInt(6));
                } else {
                    cube.cube_move(1, 6 - generator.nextInt(6));
                }
            }
        }

        if (e.getSource() == record) {
            if (isRecording == false) {
                isRecording = true;
                record.setIcon(new ImageIcon(isRecordingIcon));
            } else {
                isRecording = false;
                record.setIcon(new ImageIcon(recordIcon));
            }
        }

        if (e.getSource() == play) {
            for (int i = 0; i < moves.size(); i += 2) {
                cube.cube_move(moves.get(i), moves.get(i + 1));
            }
            moves.clear();
        }
    }

}
