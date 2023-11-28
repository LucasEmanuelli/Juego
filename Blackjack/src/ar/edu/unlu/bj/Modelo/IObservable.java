package ar.edu.unlu.bj.Modelo;
import java.util.Observer;

public interface IObservable {
    void agregarObservable(IObserver observer);
    void removerObservable(IObserver observer);
    void notificadorObservable(String message);
}
