package shengsiyuan.bytecode;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("From real subject");
    }

    @Override
    public String toString() {
        System.out.println("RealSubject toString");

        return "RealSubjectToString" ;
    }
}
