package sample.cafe;

public class Contractors {

    private int idContractors;
    private String nameContractors;
    private String address;
    private int phoneNumber;

    public Contractors(int idContractors, String nameContractors, String address, int phoneNumber) {
        this.idContractors = idContractors;
        this.nameContractors = nameContractors;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getIdContractors() {
        return idContractors;
    }

    public void setIdContractors(int idContractors) {
        this.idContractors = idContractors;
    }

    public String getNameContractors() {
        return nameContractors;
    }

    public void setNameContractors(String nameContractors) {
        this.nameContractors = nameContractors;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
