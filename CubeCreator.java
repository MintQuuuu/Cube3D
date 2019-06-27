package cube3d;

import com.sun.j3d.utils.geometry.*;
import javax.media.j3d.Appearance;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.Group;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3f;

public class CubeCreator {

    Group mainGroup = new Group();
    BranchGroup localBranch = new BranchGroup();
    TransformGroup rotatingTransform = new TransformGroup();

    private int FRONT = 0;
    private int BACK = 1;
    private int RIGHT = 2;
    private int LEFT = 3;
    private int TOP = 4;
    private int DOWN = 5;

    private Appearance frontColor = new Appearance();
    private Appearance backColor = new Appearance();
    private Appearance rightColor = new Appearance();
    private Appearance leftColor = new Appearance();
    private Appearance topColor = new Appearance();
    private Appearance downColor = new Appearance();
    private Appearance defaultApp = new Appearance();

    protected Transform3D[] cubesTransform = new Transform3D[27];
    protected TransformGroup[] transGroup = new TransformGroup[27];
    protected Box[] cubies = new Box[27];
    protected BranchGroup[] cubeBranch = new BranchGroup[27];

    public CubeCreator() {

        for (int i = 0; i < 27; i++) {

            cubesTransform[i] = new Transform3D();
            cubies[i] = new Box(0.1f, 0.1f, 0.1f, defaultApp);
            cubeBranch[i] = new BranchGroup();

            cubeBranch[i].setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
            cubeBranch[i].setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
            cubeBranch[i].setCapability(TransformGroup.ALLOW_CHILDREN_EXTEND);
            cubeBranch[i].setCapability(TransformGroup.ALLOW_CHILDREN_READ);
            cubeBranch[i].setCapability(TransformGroup.ALLOW_CHILDREN_WRITE);

        }

        mainGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        mainGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        mainGroup.setCapability(TransformGroup.ALLOW_CHILDREN_EXTEND);
        mainGroup.setCapability(TransformGroup.ALLOW_CHILDREN_READ);
        mainGroup.setCapability(TransformGroup.ALLOW_CHILDREN_WRITE);

        rotatingTransform.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        rotatingTransform.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        rotatingTransform.setCapability(TransformGroup.ALLOW_CHILDREN_EXTEND);
        rotatingTransform.setCapability(TransformGroup.ALLOW_CHILDREN_READ);
        rotatingTransform.setCapability(TransformGroup.ALLOW_CHILDREN_WRITE);

        frontColor.setColoringAttributes(new ColoringAttributes(0.0f, 0.0f, 2.0f, ColoringAttributes.NICEST));
        backColor.setColoringAttributes(new ColoringAttributes(0.0f, 2.0f, 0.0f, ColoringAttributes.NICEST));
        rightColor.setColoringAttributes(new ColoringAttributes(2.0f, 0.0f, 0.0f, ColoringAttributes.NICEST));
        leftColor.setColoringAttributes(new ColoringAttributes(1.0f, 0.271f, 0.0f, ColoringAttributes.NICEST));
        topColor.setColoringAttributes(new ColoringAttributes(1.0f, 1.0f, 0.0f, ColoringAttributes.NICEST));
        downColor.setColoringAttributes(new ColoringAttributes(2.0f, 2.0f, 2.0f, ColoringAttributes.NICEST));
        defaultApp.setColoringAttributes(new ColoringAttributes(0.412f, 0.412f, 0.412f, ColoringAttributes.NICEST));

        cubies[0].getShape(FRONT).setAppearance(frontColor);
        cubies[0].getShape(LEFT).setAppearance(leftColor);
        cubies[0].getShape(DOWN).setAppearance(downColor);
        cubies[1].getShape(FRONT).setAppearance(frontColor);
        cubies[1].getShape(DOWN).setAppearance(downColor);
        cubies[2].getShape(FRONT).setAppearance(frontColor);
        cubies[2].getShape(DOWN).setAppearance(downColor);
        cubies[2].getShape(RIGHT).setAppearance(rightColor);
        cubies[3].getShape(FRONT).setAppearance(frontColor);
        cubies[3].getShape(LEFT).setAppearance(leftColor);
        cubies[4].getShape(FRONT).setAppearance(frontColor);
        cubies[5].getShape(FRONT).setAppearance(frontColor);
        cubies[5].getShape(RIGHT).setAppearance(rightColor);
        cubies[6].getShape(FRONT).setAppearance(frontColor);
        cubies[6].getShape(LEFT).setAppearance(leftColor);
        cubies[6].getShape(TOP).setAppearance(topColor);
        cubies[7].getShape(FRONT).setAppearance(frontColor);
        cubies[7].getShape(TOP).setAppearance(topColor);
        cubies[8].getShape(FRONT).setAppearance(frontColor);
        cubies[8].getShape(RIGHT).setAppearance(rightColor);
        cubies[8].getShape(TOP).setAppearance(topColor);
        cubies[9].getShape(LEFT).setAppearance(leftColor);
        cubies[9].getShape(DOWN).setAppearance(downColor);
        cubies[10].getShape(DOWN).setAppearance(downColor);
        cubies[11].getShape(RIGHT).setAppearance(rightColor);
        cubies[11].getShape(DOWN).setAppearance(downColor);
        cubies[12].getShape(LEFT).setAppearance(leftColor);
        cubies[14].getShape(RIGHT).setAppearance(rightColor);
        cubies[15].getShape(LEFT).setAppearance(leftColor);
        cubies[15].getShape(TOP).setAppearance(topColor);
        cubies[16].getShape(TOP).setAppearance(topColor);
        cubies[17].getShape(RIGHT).setAppearance(rightColor);
        cubies[17].getShape(TOP).setAppearance(topColor);
        cubies[18].getShape(BACK).setAppearance(backColor);
        cubies[18].getShape(LEFT).setAppearance(leftColor);
        cubies[18].getShape(DOWN).setAppearance(downColor);
        cubies[19].getShape(BACK).setAppearance(backColor);
        cubies[19].getShape(DOWN).setAppearance(downColor);
        cubies[20].getShape(BACK).setAppearance(backColor);
        cubies[20].getShape(RIGHT).setAppearance(rightColor);
        cubies[20].getShape(DOWN).setAppearance(downColor);
        cubies[21].getShape(BACK).setAppearance(backColor);
        cubies[21].getShape(LEFT).setAppearance(leftColor);
        cubies[22].getShape(BACK).setAppearance(backColor);
        cubies[23].getShape(BACK).setAppearance(backColor);
        cubies[23].getShape(RIGHT).setAppearance(rightColor);
        cubies[24].getShape(BACK).setAppearance(backColor);
        cubies[24].getShape(LEFT).setAppearance(leftColor);
        cubies[24].getShape(TOP).setAppearance(topColor);
        cubies[25].getShape(BACK).setAppearance(backColor);
        cubies[25].getShape(TOP).setAppearance(topColor);
        cubies[26].getShape(BACK).setAppearance(backColor);
        cubies[26].getShape(RIGHT).setAppearance(rightColor);
        cubies[26].getShape(TOP).setAppearance(topColor);

        cubesTransform[0].set(new Vector3f(-0.22f, -0.22f, 0.22f));
        cubesTransform[1].set(new Vector3f(0.0f, -0.22f, 0.22f));
        cubesTransform[2].set(new Vector3f(0.22f, -0.22f, 0.22f));
        cubesTransform[3].set(new Vector3f(-0.22f, 0.0f, 0.22f));
        cubesTransform[4].set(new Vector3f(0.0f, 0.0f, 0.22f));
        cubesTransform[5].set(new Vector3f(0.22f, 0.0f, 0.22f));
        cubesTransform[6].set(new Vector3f(-0.22f, 0.22f, 0.22f));
        cubesTransform[7].set(new Vector3f(0.0f, 0.22f, 0.22f));
        cubesTransform[8].set(new Vector3f(0.22f, 0.22f, 0.22f));
        cubesTransform[9].set(new Vector3f(-0.22f, -0.22f, 0.0f));
        cubesTransform[10].set(new Vector3f(0.0f, -0.22f, 0.0f));
        cubesTransform[11].set(new Vector3f(0.22f, -0.22f, 0.0f));
        cubesTransform[12].set(new Vector3f(-0.22f, 0.0f, 0.0f));
        cubesTransform[13].set(new Vector3f(0.0f, 0.0f, 0.0f));
        cubesTransform[14].set(new Vector3f(0.22f, 0.0f, 0.0f));
        cubesTransform[15].set(new Vector3f(-0.22f, 0.22f, 0.0f));
        cubesTransform[16].set(new Vector3f(0.0f, 0.22f, 0.0f));
        cubesTransform[17].set(new Vector3f(0.22f, 0.22f, 0.0f));
        cubesTransform[18].set(new Vector3f(-0.22f, -0.22f, -0.22f));
        cubesTransform[19].set(new Vector3f(0.0f, -0.22f, -0.22f));
        cubesTransform[20].set(new Vector3f(0.22f, -0.22f, -0.22f));
        cubesTransform[21].set(new Vector3f(-0.22f, 0.0f, -0.22f));
        cubesTransform[22].set(new Vector3f(0.0f, 0.0f, -0.22f));
        cubesTransform[23].set(new Vector3f(0.22f, 0.0f, -0.22f));
        cubesTransform[24].set(new Vector3f(-0.22f, 0.22f, -0.22f));
        cubesTransform[25].set(new Vector3f(0.0f, 0.22f, -0.22f));
        cubesTransform[26].set(new Vector3f(0.22f, 0.22f, -0.22f));

        for (int i = 0; i < 27; i++) {
            transGroup[i] = new TransformGroup(cubesTransform[i]);

            transGroup[i].setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
            transGroup[i].setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
            transGroup[i].setCapability(TransformGroup.ALLOW_CHILDREN_EXTEND);
            transGroup[i].setCapability(TransformGroup.ALLOW_CHILDREN_READ);
            transGroup[i].setCapability(TransformGroup.ALLOW_CHILDREN_WRITE);
        }
    }

    public Group create(TransformGroup localTransform) {
        rotatingTransform = localTransform;

        for (int i = 0; i < 27; i++) {
            transGroup[i].addChild(cubies[i]);
            cubeBranch[i].addChild(transGroup[i]);
            mainGroup.addChild(cubeBranch[i]);

        }
        return mainGroup;
    }

    void cube_move(int a, int b) {
    }

    void reset_cube() {
    }
}
