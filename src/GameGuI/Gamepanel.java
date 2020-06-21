/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameGuI;

import crossriver.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

/**
 *
 * @author Israa Hassanin
 */
public class Gamepanel extends JPanel implements ActionListener, MouseListener, IRiverCrossingController {

    boolean Far;
    ICrossingStrategy s;
    List<ICrosser> leftarr;
    private ICrosser Fox;
    private ICrosser Farmer;
    private ICrosser Farmer2;
    private ICrosser Farmer3;
    private ICrosser Farmer4;
    private ICrosser Farmer5;
    private ICrosser Goat;

    public ICrossingStrategy getCurrentStrategy() {
        return s;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }
    List<ICrosser> boatriders = new ArrayList<ICrosser>();
    List<ICrosser> rightarr = new ArrayList<ICrosser>();
    Stack<Moves> undo = new Stack<Moves>();
    Stack<Moves> redo = new Stack<Moves>();

    public void setLeftarr(List<ICrosser> leftarr) {
        this.leftarr = leftarr;
    }

    public void setBoatriders(List<ICrosser> boatriders) {
        this.boatriders = boatriders;
    }

    public void setRightarr(List<ICrosser> rightarr) {
        this.rightarr = rightarr;
    }

    public List<ICrosser> getleftarr() {
        return leftarr;
    }

    public List<ICrosser> getrightarr() {
        return rightarr;

    }

    public List<ICrosser> getboatriders() {
        return boatriders;

    }
    boolean undob = false;
    boolean redob = false;
    boolean left = true;
    int x1 = 0;
    int m1;
    int x = 80;
    int y = 0;
    int z = 0;
    int m = 0;
    int p = 0;
    int flag = 0;
    Timer t = new Timer(100, this);
    boolean moveright = false;
    boolean moveleft = false;
    MoveRight L;
    MoveLeft M;

    public int getX() {
        return x;
    }

    public void setX(int d) {
        this.x = d;
    }

    public Gamepanel(ICrossingStrategy s) {
        setBackground(Color.white);
        this.s = s;
        leftarr = s.getInitialCrossers();
        t.start();
        addMouseListener(this);
       L=new MoveRight(this);
       M=new MoveLeft(this);
    }

    public Gamepanel() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon River = null;
        ImageIcon im = null;
        ImageIcon imageIcon;
        River = new ImageIcon("river.jpg");
        g.drawImage(River.getImage(), 0, 0, this);
        if (left == true) {
            im = new ImageIcon("boat.png");
            g.drawImage(im.getImage(), x, 450, this);
            m1 = 300;
            for (int i = 0; i < leftarr.size(); i++) {

                imageIcon = new ImageIcon(leftarr.get(i).getImages()[0]);
                int height = imageIcon.getIconHeight();

                g.drawImage(imageIcon.getImage(), x1, m1, this);
                leftarr.get(i).setXf(x1);
                leftarr.get(i).setYf(m1);
                m1 += height;

            }
            for (int i = 0; i < boatriders.size(); i++) {
                imageIcon = new ImageIcon(boatriders.get(i).getImages()[0]);
                g.drawImage(imageIcon.getImage(), x, 450, this);
                boatriders.get(i).setXf(x);
                boatriders.get(i).setYf(450);
            }
            for (int i = 0; i < rightarr.size(); i++) {
                imageIcon = new ImageIcon(rightarr.get(i).getImages()[1]);
                int height = imageIcon.getIconHeight();

                g.drawImage(imageIcon.getImage(), 695 + im.getIconWidth() + 20, m1, this);
                rightarr.get(i).setXf(x + im.getIconWidth() + 20);
                rightarr.get(i).setYf(m1);
                m1 += height;
            }
        } else {
            m1 = 300;
            im = new ImageIcon("boat.png");
            g.drawImage(im.getImage(), x, 450, this);
            for (int i = 0; i < rightarr.size(); i++) {
                imageIcon = new ImageIcon(rightarr.get(i).getImages()[1]);
                int height = imageIcon.getIconHeight();

                g.drawImage(imageIcon.getImage(), 695 + im.getIconWidth() + 20, m1, this);
                rightarr.get(i).setXf(x + im.getIconWidth() + 20);
                rightarr.get(i).setYf(m1);
                m1 += height;

            }
            for (int i = 0; i < boatriders.size(); i++) {
                imageIcon = new ImageIcon(boatriders.get(i).getImages()[1]);
                g.drawImage(imageIcon.getImage(), x, 450, this);
                boatriders.get(i).setXf(x);
                boatriders.get(i).setYf(450);
            }
            for (int i = 0; i < leftarr.size(); i++) {
                imageIcon = new ImageIcon(leftarr.get(i).getImages()[0]);
                int height = imageIcon.getIconHeight();

                g.drawImage(imageIcon.getImage(), x1, m1, this);
                leftarr.get(i).setXf(x1);
                leftarr.get(i).setYf(m1);
                m1 += height;
            }
        }

        //  repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (moveright == true) {
            if (x < 710) {
           //     x += 15;
L.execute();
            } else {
                moveright = false;
                left = false;

            }

        } else if (moveleft == true) {

            if (x != 80) {
               // x -= 15;
               M.execute();

            } else {
                moveleft = false;
                left = true;

            }
        } else if (Far == true) {
            y = x;
            left = true;

        }

        repaint();

    }

    public void moveRight() {
        moveright = true;
        Moves m = new Moves(left);
        List<ICrosser> b = new ArrayList<>();
        List<ICrosser> n = new ArrayList<>();
        List<ICrosser> a = new ArrayList<>();
        b.addAll(boatriders);
        n.addAll(leftarr);
        a.addAll(rightarr);
        m.setBoattList(b);
        m.setLeftList(n);
        m.setRightList(a);
        undo.push(m);
    }

    public void moveLeft() {
        moveleft = true;
        Moves m = new Moves(left);
        List<ICrosser> b = new ArrayList<>();
        List<ICrosser> n = new ArrayList<>();
        List<ICrosser> a = new ArrayList<>();
        b.addAll(boatriders);
        n.addAll(leftarr);
        a.addAll(rightarr);
        m.setBoattList(b);
        m.setLeftList(n);
        m.setRightList(a);
        undo.push(m);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

        int dim1 = e.getX();
        int dim2 = e.getY();
        ImageIcon imageIcon;
        if (dim1 > 0 && dim1 < 200 && dim2 > 0 && dim2 < 200) {
            Far = true;
        } else {
            Far = false;
        }
        for (int i = 0; i < leftarr.size(); i++) {
            imageIcon = new ImageIcon(leftarr.get(i).getImages()[0]);
            if (dim1 >= leftarr.get(i).getxpos() && dim1 <= leftarr.get(i).getxpos() + imageIcon.getIconWidth() && dim2 >= leftarr.get(i).getypos() && dim2 <= leftarr.get(i).getypos() + imageIcon.getIconHeight()) {
                leftarr.get(i).setXf(x);
                leftarr.get(i).setYf(450);
                if (boatriders.size() < 2) {
                    boatriders.add(leftarr.get(i));
                    leftarr.remove(i);
                } else {
                    JOptionPane.showMessageDialog(null, "boat can't lift more than two");
                }

            }
        }
        for (int j = 0; j < boatriders.size(); j++) {
            imageIcon = new ImageIcon(boatriders.get(j).getImages()[0]);
            if (left == true) {
                if (dim1 >= boatriders.get(j).getxpos() && dim1 <= boatriders.get(j).getxpos() + imageIcon.getIconWidth() && dim2 >= boatriders.get(j).getypos() && dim2 <= boatriders.get(j).getypos() + imageIcon.getIconHeight()) {

                    boatriders.get(j).setXf(x1);
                    boatriders.get(j).setYf(m);
                    leftarr.add(boatriders.get(j));
                    boatriders.remove(j);

                }
            }
        }
        for (int k = 0; k < boatriders.size(); k++) {
            imageIcon = new ImageIcon(boatriders.get(k).getImages()[0]);
            if (left == false) {
                if (dim1 >= boatriders.get(k).getxpos() && dim1 <= boatriders.get(k).getxpos() + imageIcon.getIconWidth() && dim2 >= boatriders.get(k).getypos() && dim2 <= boatriders.get(k).getypos() + imageIcon.getIconHeight()) {

                    boatriders.get(k).setXf(400 + boatriders.get(k).getxpos());
                    boatriders.get(k).setYf(boatriders.get(k).getypos());
                    rightarr.add(boatriders.get(k));
                    System.out.println(rightarr.size());
                    boatriders.remove(k);

                }
            }
        }

        for (int i = 0; i < rightarr.size(); i++) {
            imageIcon = new ImageIcon(rightarr.get(i).getImages()[1]);

            if (dim1 >= rightarr.get(i).getxpos() && dim1 <= rightarr.get(i).getxpos() + imageIcon.getIconWidth() && dim2 >= rightarr.get(i).getypos() && dim2 <= rightarr.get(i).getypos() + imageIcon.getIconHeight()) {
                rightarr.get(i).setXf(x);
                rightarr.get(i).setYf(450);
                if (boatriders.size() < 2) {
                    boatriders.add(rightarr.get(i));
                    rightarr.remove(i);
                } else {
                    JOptionPane.showMessageDialog(null, "boat can't lift more than two");
                }
            }
        }

        repaint();
        if (s instanceof Story1) {
            if (rightarr.size() == 4) {
                JOptionPane.showMessageDialog(null, "You Won!!");
                window2 n = window2.getInstance1();
                n.setVisible(true);
                n.setSize(1000, 800);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void newGame(ICrossingStrategy gameStrategy) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resetGame() {
        rightarr.clear();
        leftarr.clear();
        boatriders.clear();
        leftarr = s.getInitialCrossers();
        x = 80;
    }

    @Override
    public String[] getInstructions() {
        return s.getInstructions();
    }

    @Override
    public List<ICrosser> getCrossersOnRightBank() {
        return rightarr;
    }

    @Override
    public List<ICrosser> getCrossersOnLeftBank() {

        return leftarr;
    }

    @Override
    public boolean isBoatOnTheLeftBank() {
        return left;
    }
    int score = 0;

    public void setnoofsales(int s) {
        score = s;
    }

    @Override
    public int getNumberOfSails() {
        if (moveleft == true) {
            score++;
        }
        if (moveright == true) {
            score++;
        }

        return score;
    }

    public void test() {
        if (canMove(leftarr, moveright)) {
            doMove(leftarr, moveright);
        }

    }

    @Override
    public boolean canMove(List<ICrosser> Crossers, boolean fromLeftToRightBank) {
        if (canMove(Crossers, fromLeftToRightBank)) {
            doMove(boatriders, moveright);
            return true;
        }
        return false;
    }

    @Override
    public void doMove(List<ICrosser> Crossers, boolean fromLeftToRightBank) {
        if (fromLeftToRightBank) {
            moveright = true;
        } else {
            moveleft = false;
        }
    }

    @Override
    public boolean canUndo() {

        if (undo.empty()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean canRedo() {
        if (redo.empty()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void undo() {
        undob = true;
        Moves r = undo.pop();
        redo.push(r);
        boatriders = r.getBoattList();
        leftarr = r.getLeftList();
        rightarr = r.getRightList();
        left = r.getBoatplace();
        if (left) {
            x = 80;
        } else {
            x = 710;
        }
        repaint();
    }

    @Override
    public void redo() {
        redob = true;
        Moves r = redo.pop();
        undo.push(r);
        boatriders = r.getBoattList();
        leftarr = r.getLeftList();
        rightarr = r.getRightList();
        left = !r.getBoatplace();
        if (left) {
            x = 80;
        } else {
            x = 710;
        }

        repaint();
    }

    @Override
    public void saveGame() {
        try {
            DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder build = dFact.newDocumentBuilder();
            Document doc = build.newDocument();

            Element root = doc.createElement("ICrossers");
            doc.appendChild(root);
            Attr attrType = doc.createAttribute("type");
            Element leftarraElement = doc.createElement("leftarray");
            root.appendChild(leftarraElement);
            Element right = doc.createElement("rightarray");
            root.appendChild(right);
            Element boatCrosser = doc.createElement("boatriders");
            root.appendChild(boatCrosser);
            Element boat = doc.createElement("boatposition");
            root.appendChild(boat);
            Element Story = doc.createElement("story");
            root.appendChild(Story);
            Element Score = doc.createElement("score");
            root.appendChild(Score);
            String x = Integer.toString(getNumberOfSails());
            Score.appendChild(doc.createTextNode(x));

            Element position = doc.createElement("postion");

            if (left == true) {
                position.appendChild(doc.createTextNode("left"));
            } else {
                position.appendChild(doc.createTextNode("right"));
            }
            root.appendChild(position);
            if (s instanceof Story1) {
                Story.appendChild(doc.createTextNode("Story1"));
            } else {
                Story.appendChild(doc.createTextNode("Story2"));
            }

            for (int i = 0; i < leftarr.size(); i++) {
                Element cname = doc.createElement("Crosser");
                if (leftarr.get(i) instanceof Carnivore) {
                    cname.appendChild(doc.createTextNode("Carnivore"));
                } else if (leftarr.get(i) instanceof Harbivore) {

                    cname.appendChild(doc.createTextNode("Harbivore"));
                } else if (leftarr.get(i) instanceof Plant) {

                    cname.appendChild(doc.createTextNode("Plant"));
                } else if (leftarr.get(i) instanceof Farmer) {

                    cname.appendChild(doc.createTextNode("Farmer"));
                } else if (leftarr.get(i) instanceof Farmer3) {

                    cname.appendChild(doc.createTextNode("Farmer3"));
                } else if (leftarr.get(i) instanceof Farmer2) {
                    cname.appendChild(doc.createTextNode("Farmer2"));
                } else if (leftarr.get(i) instanceof Farmer4) {
                    cname.appendChild(doc.createTextNode("Farmer4"));
                } else if (leftarr.get(i) instanceof Farmer5) {
                    cname.appendChild(doc.createTextNode("Farmer5"));
                }

                leftarraElement.appendChild(cname);
            }
            for (int i = 0; i < rightarr.size(); i++) {
                Element cname = doc.createElement("Crosser");
                if (rightarr.get(i) instanceof Carnivore) {
                    //cname.setValue("Carnivore");
                    cname.appendChild(doc.createTextNode("Carnivore"));
                } else if (rightarr.get(i) instanceof Harbivore) {
                    //attrType.setValue("Harbivore");
                    cname.appendChild(doc.createTextNode("Harbivore"));
                } else if (rightarr.get(i) instanceof Plant) {
                    //attrType.setValue("Plant");
                    cname.appendChild(doc.createTextNode("Plant"));
                } else if (rightarr.get(i) instanceof Farmer) {
                    //attrType.setValue("Farmer");
                    cname.appendChild(doc.createTextNode("Farmer"));
                } else if (rightarr.get(i) instanceof Farmer3) {
                    // attrType.setValue("Farmer3");
                    cname.appendChild(doc.createTextNode("Farmer3"));
                } else if (rightarr.get(i) instanceof Farmer2) {
                    cname.appendChild(doc.createTextNode("Farmer2"));
                } else if (rightarr.get(i) instanceof Farmer4) {
                    cname.appendChild(doc.createTextNode("Farmer4"));
                } else if (rightarr.get(i) instanceof Farmer5) {
                    cname.appendChild(doc.createTextNode("Farmer5"));
                }

                right.appendChild(cname);
            }
            for (int i = 0; i < boatriders.size(); i++) {
                Element cname = doc.createElement("Crosser");
                if (boatriders.get(i) instanceof Carnivore) {
                    //cname.setValue("Carnivore");
                    cname.appendChild(doc.createTextNode("Carnivore"));
                } else if (boatriders.get(i) instanceof Harbivore) {
                    //attrType.setValue("Harbivore");
                    cname.appendChild(doc.createTextNode("Harbivore"));
                } else if (boatriders.get(i) instanceof Plant) {
                    //attrType.setValue("Plant");
                    cname.appendChild(doc.createTextNode("Plant"));
                } else if (boatriders.get(i) instanceof Farmer) {
                    //attrType.setValue("Farmer");
                    cname.appendChild(doc.createTextNode("Farmer"));
                } else if (boatriders.get(i) instanceof Farmer3) {
                    // attrType.setValue("Farmer3");
                    cname.appendChild(doc.createTextNode("Farmer3"));
                } else if (boatriders.get(i) instanceof Farmer2) {
                    cname.appendChild(doc.createTextNode("Farmer2"));
                } else if (boatriders.get(i) instanceof Farmer4) {
                    cname.appendChild(doc.createTextNode("Farmer4"));
                } else if (boatriders.get(i) instanceof Farmer5) {
                    cname.appendChild(doc.createTextNode("Farmer5"));
                }

                boatCrosser.appendChild(cname);
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("crossriver.xml"));
            transformer.transform(source, result);
            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*try {
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.newDocument();

         // root element
         Element rootElement = doc.createElement("Crossers");
         doc.appendChild(rootElement);
         // supercars element
         Element left = doc.createElement("leftarray");
         rootElement.appendChild(left);
         Element right = doc.createElement("rightarray");
         rootElement.appendChild(right);
         Element riders = doc.createElement("boatridersarray");
         rootElement.appendChild(riders);

         // setting attribute to element
         for (int i = 0; i < leftarr.size(); i++) {
         Element cname = doc.createElement("Crosser");
         Attr attrType = doc.createAttribute("type");
         if (leftarr.get(i) instanceof Carnivore) {
         attrType.setValue("Carnivore");
         } else if (leftarr.get(i) instanceof Harbivore) {
         attrType.setValue("Harbivore");
         } else if (leftarr.get(i) instanceof Plant) {
         attrType.setValue("Plant");
         } else if (leftarr.get(i) instanceof Farmer) {
         attrType.setValue("Farmer");
         } else if (leftarr.get(i) instanceof Farmer3) {
         attrType.setValue("Farmer3");
         } else if (leftarr.get(i) instanceof Farmer2) {
         attrType.setValue("Farmer2");
         } else if (leftarr.get(i) instanceof Farmer4) {
         attrType.setValue("Farmer4");
         } else if (leftarr.get(i) instanceof Farmer5) {
         attrType.setValue("Farmer5");
         }

         cname.setAttributeNode(attrType);

         left.appendChild(cname);
         }

         for (int i = 0; i < rightarr.size(); i++) {
         Element cname = doc.createElement("Crosser");
         Attr attrType = doc.createAttribute("type");

         if (rightarr.get(i) instanceof Carnivore) {
         attrType.setValue("Carnivore");
         } else if (rightarr.get(i) instanceof Carnivore) {
         attrType.setValue("Carnivore");
         } else if (rightarr.get(i) instanceof Harbivore) {
         attrType.setValue("Harbivore");
         } else if (rightarr.get(i) instanceof Farmer) {
         attrType.setValue("Farmer");
         } else if (rightarr.get(i) instanceof Plant) {
         attrType.setValue("Plant");
         } else if (rightarr.get(i) instanceof Farmer3) {
         attrType.setValue("Farmer3");
         } else if (rightarr.get(i) instanceof Farmer2) {
         attrType.setValue("Farmer2");
         } else if (rightarr.get(i) instanceof Farmer4) {
         attrType.setValue("Farmer4");
         } else if (rightarr.get(i) instanceof Farmer5) {
         attrType.setValue("Farmer5");
         }
         cname.setAttributeNode(attrType);
         right.appendChild(cname);
         }

         for (int i = 0; i < boatriders.size(); i++) {
         Element cname = doc.createElement("Crosser");
         Attr attrType = doc.createAttribute("type");
         //                Element attr=null; 
         if (boatriders.get(i) instanceof Carnivore) {
         attrType.setValue("Carnivore");
         } else if (boatriders.get(i) instanceof Harbivore) {
         attrType.setValue("Harbivore");
         } else if (boatriders.get(i) instanceof Farmer) {
         attrType.setValue("Farmer");
         } else if (boatriders.get(i) instanceof Plant) {
         attrType.setValue("Plant");
         } else if (boatriders.get(i) instanceof Farmer3) {
         attrType.setValue("Farmer3");
         } else if (boatriders.get(i) instanceof Farmer2) {
         attrType.setValue("Farmer2");
         } else if (boatriders.get(i) instanceof Farmer4) {
         attrType.setValue("Farmer4");
         } else if (boatriders.get(i) instanceof Farmer5) {
         attrType.setValue("Farmer5");
         }
         cname.setAttributeNode(attrType);
         riders.appendChild(cname);
         }

         TransformerFactory transformerFactory = TransformerFactory.newInstance();
         Transformer transformer = transformerFactory.newTransformer();
         DOMSource source = new DOMSource(doc);
         StreamResult result = new StreamResult(new File("crossriver.xml"));
         transformer.transform(source, result);
         // Output to console for testing
         StreamResult consoleResult = new StreamResult(System.out);
         transformer.transform(source, consoleResult);
         } catch (Exception e) {
         e.printStackTrace();
         }*/
    }

    @Override
    public void loadGame() {
        try {
            leftarr.clear();
            rightarr.clear();
            boatriders.clear();
            File inputFile = new File("crossriver.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("leftarray");
            NodeList list=nList.item(0).getChildNodes();
            for (int temp = 0; temp < list.getLength(); temp++) {
                Node nNode = list.item(temp);
                 
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                   
                    if (eElement.getTextContent().equals("Carnivore")) {
                        leftarr.add(new Fox());
                    } else if (eElement.getTextContent().equals("Farmer")) {
                        leftarr.add(new Farmer());
                    } else if (eElement.getTextContent().equals("Farmer2")) {
                        leftarr.add(new Farmer2());
                    } else if (eElement.getTextContent().equals("Farmer3")) {
                        leftarr.add(new Farmer3());
                    } else if (eElement.getTextContent().equals("Farmer4")) {
                        leftarr.add(new Farmer4());
                    } else if (eElement.getTextContent().equals("Farmer5")) {
                        leftarr.add(new Farmer5());
                    } else if (eElement.getTextContent().equals("Harbivore")) {
                        leftarr.add(new Goat());
                    }
                    else if (eElement.getTextContent().equals("Plant")) {
                        leftarr.add(new Plant());
                    }

                }
            }
            NodeList rList = doc.getElementsByTagName("rightarray");
             NodeList rlist=rList.item(0).getChildNodes();
            for (int temp = 0; temp < rlist.getLength(); temp++) {
                Node nNode = rlist.item(temp);
                 
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                   
                    if (eElement.getTextContent().equals("Carnivore")) {
                        rightarr.add(new Fox());
                    } else if (eElement.getTextContent().equals("Farmer")) {
                        rightarr.add(new Farmer());
                    } else if (eElement.getTextContent().equals("Farmer2")) {
                        rightarr.add(new Farmer2());
                    } else if (eElement.getTextContent().equals("Farmer3")) {
                        rightarr.add(new Farmer3());
                    } else if (eElement.getTextContent().equals("Farmer4")) {
                        rightarr.add(new Farmer4());
                    } else if (eElement.getTextContent().equals("Farmer5")) {
                        rightarr.add(new Farmer5());
                    } else if (eElement.getTextContent().equals("Harbivore")) {
                        rightarr.add(new Goat());
                    }
                    else if (eElement.getTextContent().equals("Plant")) {
                       rightarr.add(new Plant());
                    }

                }
            }
            NodeList bList = doc.getElementsByTagName("boatriders");
             NodeList blist=bList.item(0).getChildNodes();
            for (int temp = 0; temp < blist.getLength(); temp++) {
                Node nNode = blist.item(temp);
                 
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                   
                    if (eElement.getTextContent().equals("Carnivore")) {
                        boatriders.add(new Fox());
                    } else if (eElement.getTextContent().equals("Farmer")) {
                        boatriders.add(new Farmer());
                    } else if (eElement.getTextContent().equals("Farmer2")) {
                        boatriders.add(Farmer2);
                    } else if (eElement.getTextContent().equals("Farmer3")) {
                        boatriders.add(Farmer3);
                    } else if (eElement.getTextContent().equals("Farmer4")) {
                        boatriders.add(Farmer4);
                    } else if (eElement.getTextContent().equals("Farmer5")) {
                        leftarr.add(Farmer5);
                    } else if (eElement.getTextContent().equals("Harbivore")) {
                        boatriders.add(new Goat());
                    }
                    else if (eElement.getTextContent().equals("Plant")) {
                        boatriders.add(new Plant());
                    }

                }
            }
                NodeList score = doc.getElementsByTagName("score");
                Node sNode = score.item(0);
                if (sNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) sNode;
                    String mString = eElement.getTextContent();
                    setnoofsales(Integer.parseInt(mString));

                }

                NodeList Story = doc.getElementsByTagName("story");
                Node SNode = Story.item(0);
                if (SNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) SNode;
                    String mString = eElement.getTextContent();
                    if (mString.equals("story1")) {
                        s = new Story1();
                    } else {
                        s = new Story2();
                    }
                }

                repaint();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*try {
         File inputFile = new File("crossriver.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
         NodeList nList = doc.getElementsByTagName("student");
         System.out.println("----------------------------");

         for (int temp = 0; temp < nList.getLength(); temp++) {
         Node nNode = nList.item(temp);
         System.out.println("\nCurrent Element :" + nNode.getNodeName());

         if (nNode.getNodeType() == Node.ELEMENT_NODE) {
         Element eElement = (Element) nNode;
         System.out.println("Student roll no : "
         + eElement.getAttribute("rollno"));
         System.out.println("First Name : "
         + eElement
         .getElementsByTagName("firstname")
         .item(0)
         .getTextContent());
         System.out.println("Last Name : "
         + eElement
         .getElementsByTagName("lastname")
         .item(0)
         .getTextContent());
         System.out.println("Nick Name : "
         + eElement
         .getElementsByTagName("nickname")
         .item(0)
         .getTextContent());
         System.out.println("Marks : "
         + eElement
         .getElementsByTagName("marks")
         .item(0)
         .getTextContent());
         }
         }
         } catch (Exception e) {
         e.printStackTrace();
         }*/
    }

    @Override
    public List<List<ICrosser>> solveGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
