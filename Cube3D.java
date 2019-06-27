package cube3d;

import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.universe.SimpleUniverse;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.media.j3d.AmbientLight;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.swing.JFrame;
import javax.vecmath.Color3f;
import javax.media.j3d.TransformGroup;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Cube3D extends JFrame {

    private JButton blueUp = new JButton();
    private JButton blueDown = new JButton(), yellowRight = new JButton(), yellowLeft = new JButton();
    private JButton whiteRight = new JButton(), whiteLeft = new JButton();
    private JButton orangeUp = new JButton(), orangeDown = new JButton(), redUp = new JButton();
    private JButton redDown = new JButton(), greenUp = new JButton(), greenDown = new JButton();
    private JButton scramble = new JButton(), reset = new JButton(), record = new JButton(), play = new JButton();
    private JButton button = new JButton("Lel");
    public BranchGroup scene;
    private Clip clip;
    private GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
    protected Canvas3D canvas = new Canvas3D(config);
    private SimpleUniverse mainUniverse = new SimpleUniverse(canvas);
    private BranchGroup localBranch = new BranchGroup();
    private TransformGroup localTransform = new TransformGroup();
    protected CubeCreator cube = new AnimationCube();
    protected BranchGroup tmpgroup = new BranchGroup();
    private Controller controller;
    private Panel guiPanelUp = new Panel();
    private Panel guiPanelDown = new Panel();
    private Panel guiPanelLeft = new Panel();
    private Panel guiPanelRight = new Panel();

    public Cube3D() {

        setAllows();
        try {
            CreateGUI();
        } catch (Exception e) {
            System.out.println("nie udało się wczytać obrazków!");
        }

        blueUp.addActionListener(controller);
        blueDown.addActionListener(controller);
        yellowRight.addActionListener(controller);
        yellowLeft.addActionListener(controller);
        whiteRight.addActionListener(controller);
        whiteLeft.addActionListener(controller);
        orangeUp.addActionListener(controller);
        orangeDown.addActionListener(controller);
        redUp.addActionListener(controller);
        redDown.addActionListener(controller);
        greenUp.addActionListener(controller);
        greenDown.addActionListener(controller);
        scramble.addActionListener(controller);
        reset.addActionListener(controller);
        record.addActionListener(controller);
        play.addActionListener(controller);

        scene = createSceneGraph();

        canvas.addKeyListener(controller);
        canvas.setPreferredSize(new Dimension(800, 600));

        OrbitBehavior orbit = new OrbitBehavior(canvas, OrbitBehavior.REVERSE_ROTATE);
        orbit.setSchedulingBounds(new BoundingSphere());

        mainUniverse.getViewingPlatform().setNominalViewingTransform();
        mainUniverse.getViewingPlatform().setViewPlatformBehavior(orbit);
        mainUniverse.addBranchGraph(scene);
        mainUniverse.addBranchGraph(localBranch);
        clip.start();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add("Center", canvas);
        add("South", guiPanelDown);
        add("North", guiPanelUp);
        add("East", guiPanelRight);
        add("West", guiPanelLeft);
        pack();
        setVisible(true);

    }

    public BranchGroup createSceneGraph() {

        AmbientLight ambientLight = new AmbientLight(new Color3f(10.0f, 10.0f, 10.0f));
        ambientLight.setInfluencingBounds(new BoundingSphere());
        tmpgroup.addChild(cube.create(localTransform));
        tmpgroup.addChild(ambientLight);
        tmpgroup.compile();
        return tmpgroup;
    }

    public void CreateGUI() throws IOException {

        BufferedImage blueUpIcon = ImageIO.read(new File("images/blueUp.png"));
        BufferedImage blueDownIcon = ImageIO.read(new File("images/blueDown.png"));
        BufferedImage yellowRightIcon = ImageIO.read(new File("images/yellowRight.png"));
        BufferedImage yellowLeftIcon = ImageIO.read(new File("images/yellowLeft.png"));
        BufferedImage whiteRightIcon = ImageIO.read(new File("images/whiteRight.png"));
        BufferedImage whiteLeftIcon = ImageIO.read(new File("images/whiteLeft.png"));
        BufferedImage orangeUpIcon = ImageIO.read(new File("images/orangeUp.png"));
        BufferedImage orangeDownIcon = ImageIO.read(new File("images/orangeDown.png"));
        BufferedImage redUpIcon = ImageIO.read(new File("images/redUp.png"));
        BufferedImage redDownIcon = ImageIO.read(new File("images/redDown.png"));
        BufferedImage greenUpIcon = ImageIO.read(new File("images/greenUp.png"));
        BufferedImage greenDownIcon = ImageIO.read(new File("images/greenDown.png"));
        BufferedImage scrambleIcon = ImageIO.read(new File("images/scramble.png"));
        BufferedImage resetIcon = ImageIO.read(new File("images/reset.png"));
        BufferedImage recordIcon = ImageIO.read(new File("images/record.png"));
        BufferedImage playIcon = ImageIO.read(new File("images/play.png"));

        blueUp.setIcon(new ImageIcon(blueUpIcon));
        blueUp.setBorderPainted(false);
        blueUp.setFocusPainted(false);
        blueUp.setContentAreaFilled(false);
        blueDown.setIcon(new ImageIcon(blueDownIcon));
        blueDown.setBorderPainted(false);
        blueDown.setFocusPainted(false);
        blueDown.setContentAreaFilled(false);
        yellowRight.setIcon(new ImageIcon(yellowRightIcon));
        yellowRight.setBorderPainted(false);
        yellowRight.setFocusPainted(false);
        yellowRight.setContentAreaFilled(false);
        yellowLeft.setIcon(new ImageIcon(yellowLeftIcon));
        yellowLeft.setBorderPainted(false);
        yellowLeft.setFocusPainted(false);
        yellowLeft.setContentAreaFilled(false);
        whiteRight.setIcon(new ImageIcon(whiteRightIcon));
        whiteRight.setBorderPainted(false);
        whiteRight.setFocusPainted(false);
        whiteRight.setContentAreaFilled(false);
        whiteLeft.setIcon(new ImageIcon(whiteLeftIcon));
        whiteLeft.setBorderPainted(false);
        whiteLeft.setFocusPainted(false);
        whiteLeft.setContentAreaFilled(false);
        orangeUp.setIcon(new ImageIcon(orangeUpIcon));
        orangeUp.setBorderPainted(false);
        orangeUp.setFocusPainted(false);
        orangeUp.setContentAreaFilled(false);
        orangeDown.setIcon(new ImageIcon(orangeDownIcon));
        orangeDown.setBorderPainted(false);
        orangeDown.setFocusPainted(false);
        orangeDown.setContentAreaFilled(false);
        redUp.setIcon(new ImageIcon(redUpIcon));
        redUp.setBorderPainted(false);
        redUp.setFocusPainted(false);
        redUp.setContentAreaFilled(false);
        redDown.setIcon(new ImageIcon(redDownIcon));
        redDown.setBorderPainted(false);
        redDown.setFocusPainted(false);
        redDown.setContentAreaFilled(false);
        greenUp.setIcon(new ImageIcon(greenUpIcon));
        greenUp.setBorderPainted(false);
        greenUp.setFocusPainted(false);
        greenUp.setContentAreaFilled(false);
        greenDown.setIcon(new ImageIcon(greenDownIcon));
        greenDown.setBorderPainted(false);
        greenDown.setFocusPainted(false);
        greenDown.setContentAreaFilled(false);
        scramble.setIcon(new ImageIcon(scrambleIcon));
        scramble.setBorderPainted(false);
        scramble.setFocusPainted(false);
        scramble.setContentAreaFilled(false);
        reset.setIcon(new ImageIcon(resetIcon));
        reset.setBorderPainted(false);
        reset.setFocusPainted(false);
        reset.setContentAreaFilled(false);
        record.setIcon(new ImageIcon(recordIcon));
        record.setBorderPainted(false);
        record.setFocusPainted(false);
        record.setContentAreaFilled(false);
        play.setIcon(new ImageIcon(playIcon));
        play.setBorderPainted(false);
        play.setFocusPainted(false);
        play.setContentAreaFilled(false);

        guiPanelDown.setBackground(Color.BLACK);

        guiPanelDown.add(scramble);
        guiPanelDown.add(record);
        guiPanelDown.add(blueUp);
        guiPanelDown.add(blueDown);
        guiPanelDown.add(whiteLeft);
        guiPanelDown.add(whiteRight);
        guiPanelDown.add(greenDown);
        guiPanelDown.add(greenUp);
        guiPanelDown.add(play);
        guiPanelDown.add(reset);

        guiPanelUp.setBackground(Color.BLACK);
        guiPanelUp.add(yellowLeft);
        guiPanelUp.add(yellowRight);

        guiPanelLeft.setBackground(Color.BLACK);
        guiPanelLeft.setLayout(new GridLayout(2, 1));
        guiPanelLeft.add(orangeDown);
        guiPanelLeft.add(orangeUp);

        guiPanelRight.setBackground(Color.BLACK);
        guiPanelRight.setLayout(new GridLayout(2, 1));
        guiPanelRight.add(redDown);
        guiPanelRight.add(redUp);

    }

    public void setAllows() {

        controller = new Controller(cube, blueUp, blueDown, yellowRight, yellowLeft, whiteRight, whiteLeft, orangeUp, orangeDown, redUp, redDown, greenUp, greenDown, scramble, reset, record, play, button);

        localBranch.setCapability(BranchGroup.ALLOW_CHILDREN_WRITE);
        localBranch.setCapability(BranchGroup.ALLOW_CHILDREN_READ);
        localBranch.setCapability(TransformGroup.ALLOW_CHILDREN_READ);
        localBranch.setCapability(TransformGroup.ALLOW_CHILDREN_WRITE);

        localTransform.setCapability(TransformGroup.ALLOW_CHILDREN_EXTEND);
        localTransform.setCapability(TransformGroup.ALLOW_CHILDREN_READ);
        localTransform.setCapability(TransformGroup.ALLOW_CHILDREN_WRITE);
        localTransform.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        localTransform.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

        tmpgroup.setCapability(TransformGroup.ALLOW_CHILDREN_EXTEND);
        tmpgroup.setCapability(TransformGroup.ALLOW_CHILDREN_READ);
        tmpgroup.setCapability(TransformGroup.ALLOW_CHILDREN_WRITE);
        tmpgroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tmpgroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        tmpgroup.setCapability(BranchGroup.ALLOW_CHILDREN_READ);
        tmpgroup.setCapability(BranchGroup.ALLOW_CHILDREN_WRITE);

        localBranch.addChild(localTransform);

        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("music.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Cube3D();

    }

}
