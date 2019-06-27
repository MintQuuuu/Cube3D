package cube3d;

import java.util.ArrayList;
import java.util.List;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.Timer;
import javax.vecmath.Vector3f;

public class AnimationCube extends CubeCreator {

    @Override
    void cube_move(int side, int input) {

        Transform3D gettingTransformHolder = new Transform3D();
        Transform3D rotateTransform = new Transform3D();
        Transform3D addingTransformHolder = new Transform3D();
        Transform3D tmp = new Transform3D();

        Vector3f tmpvector = new Vector3f();

        List<Integer> tmpList = new ArrayList<Integer>();

        switch (input) {
            case 1: //front
                for (int i = 0; i < 27; i++) {
                    cubies[i].getLocalToVworld(gettingTransformHolder);
                    gettingTransformHolder.get(tmpvector);
                    if (tmpvector.z == 0.22f) {
                        mainGroup.removeChild(mainGroup.indexOfChild(cubies[i].getParent().getParent()));
                        rotatingTransform.addChild(cubies[i].getParent().getParent());
                        tmpList.add(i);
                    }
                }
                rotateTransform.rotZ(side * Math.PI / 32);
                tmp.rotZ(side * Math.PI / 32);
                break;
            case 2: //right
                for (int i = 0; i < 27; i++) {
                    cubies[i].getLocalToVworld(gettingTransformHolder);
                    gettingTransformHolder.get(tmpvector);
                    if (tmpvector.x == 0.22f) {
                        mainGroup.removeChild(mainGroup.indexOfChild(cubies[i].getParent().getParent()));
                        rotatingTransform.addChild(cubies[i].getParent().getParent());
                        tmpList.add(i);
                    }
                }
                rotateTransform.rotX(side * Math.PI / 32);
                tmp.rotX(side * Math.PI / 32);
                break;
            case 3: //left
                for (int i = 0; i < 27; i++) {
                    cubies[i].getLocalToVworld(gettingTransformHolder);
                    gettingTransformHolder.get(tmpvector);
                    if (tmpvector.x == -0.22f) {
                        mainGroup.removeChild(mainGroup.indexOfChild(cubies[i].getParent().getParent()));
                        rotatingTransform.addChild(cubies[i].getParent().getParent());
                        tmpList.add(i);
                    }
                }
                rotateTransform.rotX(side * Math.PI / 32);
                tmp.rotX(side * Math.PI / 32);
                break;
            case 4: //top
                for (int i = 0; i < 27; i++) {
                    cubies[i].getLocalToVworld(gettingTransformHolder);
                    gettingTransformHolder.get(tmpvector);
                    if (tmpvector.y == 0.22f) {
                        mainGroup.removeChild(mainGroup.indexOfChild(cubies[i].getParent().getParent()));
                        rotatingTransform.addChild(cubies[i].getParent().getParent());
                        tmpList.add(i);
                    }
                }
                rotateTransform.rotY(side * Math.PI / 32);
                tmp.rotY(side * Math.PI / 32);
                break;
            case 5: //bottom
                for (int i = 0; i < 27; i++) {
                    cubies[i].getLocalToVworld(gettingTransformHolder);
                    gettingTransformHolder.get(tmpvector);
                    if (tmpvector.y == -0.22f) {
                        mainGroup.removeChild(mainGroup.indexOfChild(cubies[i].getParent().getParent()));
                        rotatingTransform.addChild(cubies[i].getParent().getParent());
                        tmpList.add(i);
                    }
                }
                rotateTransform.rotY(side * Math.PI / 32);
                tmp.rotY(side * Math.PI / 32);
                break;
            case 6: //back
                for (int i = 0; i < 27; i++) {
                    cubies[i].getLocalToVworld(gettingTransformHolder);
                    gettingTransformHolder.get(tmpvector);
                    if (tmpvector.z == -0.22f) {
                        mainGroup.removeChild(mainGroup.indexOfChild(cubies[i].getParent().getParent()));
                        rotatingTransform.addChild(cubies[i].getParent().getParent());
                        tmpList.add(i);
                    }
                }
                rotateTransform.rotZ(side * Math.PI / 32);
                tmp.rotZ(side * Math.PI / 32);
                break;

            default:

        }

        for (int i = 1; i < 16; i++) {

            try {
                Thread threadA1 = new Thread("A");
                threadA1.start();
                rotateTransform.mul(tmp);
                Thread.sleep(10);

            } catch (InterruptedException x) {

            }
            rotatingTransform.setTransform(rotateTransform);
        }

        for (int i = 0; i < tmpList.size(); i++) {
            cubies[tmpList.get(i)].getLocalToVworld(addingTransformHolder);
            transGroup[tmpList.get(i)].setTransform(addingTransformHolder);
        }

        rotatingTransform.removeAllChildren();

        for (int i = 0; i < tmpList.size(); i++) {
            mainGroup.addChild(transGroup[tmpList.get(i)].getParent());
        }

    }

    @Override
    void reset_cube() {

        for (int i = 0; i < 27; i++) {
            transGroup[i].setTransform(cubesTransform[i]);
        }

    }

}
