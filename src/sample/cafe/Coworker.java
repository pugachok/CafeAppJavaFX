package sample.cafe;

public class Coworker {

    private int idCoworker;
    private String fio;
    private int idPosition;

    public Coworker(int idCoworker, String fio, int idPosition) {
        this.idCoworker = idCoworker;
        this.fio = fio;
        this.idPosition = idPosition;
    }

    public int getIdCoworker() {
        return idCoworker;
    }

    public void setIdCoworker(int idCoworker) {
        this.idCoworker = idCoworker;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }
}
