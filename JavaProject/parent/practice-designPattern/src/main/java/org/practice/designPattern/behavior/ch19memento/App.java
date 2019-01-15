package org.practice.designPattern.behavior.ch19memento;

import org.practice.designPattern.behavior.ch19memento.runoob.CareTaker;
import org.practice.designPattern.behavior.ch19memento.runoob.Originator;

/**
 * 备忘录模式
 * http://www.runoob.com/design-pattern/memento-pattern.html
 */
public class App {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            runoob_memento();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void runoob_memento() {
        CareTaker careTaker = new CareTaker();
        Originator originator = new Originator();

        originator.setState("State #1");
        System.out.println("AA: " + originator.getState());

        originator.setState("State #2");
        System.out.println("BB: " + originator.getState());
        careTaker.add(originator.saveStateToMemento());

        originator.setState("State #3");
        System.out.println("CC: " + originator.getState());
        careTaker.add(originator.saveStateToMemento());

        originator.setState("State #4");
        System.out.println("DD: " + originator.getState());

        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("EE: " + originator.getState());

        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("FF: " + originator.getState());
    }
}
