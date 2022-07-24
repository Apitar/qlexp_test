public class CompositeModel {

    public String currentStatus;

    public String lastStatus;

    public CompositeModel(String currentStatus, String lastStatus) {
        this.currentStatus = currentStatus;
        this.lastStatus = lastStatus;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getLastStatus() {
        return lastStatus;
    }

    public void setLastStatus(String lastStatus) {
        this.lastStatus = lastStatus;
    }
}
