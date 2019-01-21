package FACETIMEDETECTION;

import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

public class facetimedetection extends javax.swing.JFrame {

    private DaemonThread myThread = null;
    int count = 0;
    VideoCapture webSource = null; // instantiating the videcapture class(camera:0)
    Mat frame = new Mat(); //  ckeck if the capture is open ; a frame(a source image)
    MatOfByte mem = new MatOfByte();
    CascadeClassifier faceDetector = new CascadeClassifier(FaceDetection.class.getResource("haarcascade-fontalface_alt.xml")).getP;
    MatOfRect faceDetections = new MatOfRect();
    MatOfRect faceDetections = new MatOfRect();

    public JPanel panel1;
    public JButton button2;
    public JButton button1;


    class DaemonThread implements Runnable {

        protected volatile boolean runnable = false;


        @Override
        public void run() {
            synchronized (this) {
                while (runnable) {
                    if (webSource.grab())
                        try {
                            webSource.retrieve(frame);
                            Graphics g = JPanel.getGraphics();
                            faceDetector.detectMultiScale(frame, faceDetections);
                            for (Rect rect : faceDetections.toArray()) {

                                Core.rectangle(frame, new Point(rect.x, rect.y)), new Point(rect.x + rect.width, rect.y + rect.height

                                new Scalar(0, 255, 0));
                            }

                            HighGui.imencode(".bmp", frame, men);
                            Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));
                            BufferedImage buff = (BufferedImage) im;
                            if (g.drawImage(buff, 0, 0, getWidth(), getHeight() - 150, 0, 0, buff.getWidth(), buff.getHeight(), null)) {

                                if (runnable == false) {

                                    System.out.println("Paused .......");
                                    this.wait();
                                }
                            }
                        } catch (Exception ex) {

                            System.out.println("Error!!");
                            ex.printStackTrace();
                        }
                }
            }
        }
    }

    public facetimedetection() {

        createUIComponents();
        System.out.println(facetimedetection.class.getResource("haarcascade_frontalface_alt.xml").getPath().substring(1));
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        jPanel1 = new

    }


}


    public static void main(String args[]) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);


    }