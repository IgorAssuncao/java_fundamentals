public class Log {
    private int historySize;
    private int quantitySize;
    private int operationsQuantityCounter;
    private String[] operationsHistory;
    private int[] operationsQuantity;
    private String[] operationsCharacters = {"+", "-", "*", "/"};

    public Log(int historySize, int quantitySize) {
        this.historySize = historySize;
        this.quantitySize = quantitySize;
        this.operationsHistory = new String[this.historySize];
        this.operationsQuantity = new int[this.quantitySize];
        operationsQuantityCounter = 0;
    }

    public int getHistorySize() {
        return historySize;
    }

    public void setHistorySize(int historySize) {
        this.historySize = historySize;
    }

    public int getQuantitySize() {
        return quantitySize;
    }

    public void setQuantitySize(int quantity_size) {
        this.quantitySize = quantity_size;
    }

    public String[] getOperationsHistory() {
        return operationsHistory;
    }

    public void setOperationsHistory(String[] operationsHistory) {
        this.operationsHistory = operationsHistory;
    }

    public int[] getOperationsQuantity() {
        return operationsQuantity;
    }

    public void setOperationsQuantity(int[] operationsQuantity) {
        this.operationsQuantity = operationsQuantity;
    }

    public String[] getOperationsCharacters() {
        return operationsCharacters;
    }

    public void setOperationsCharacters(String[] operationsCharacters) {
        this.operationsCharacters = operationsCharacters;
    }

    public int getOperationsQuantityCounter() {
        return operationsQuantityCounter;
    }

    public void setOperationsQuantityCounter(int operationsQuantityCounter) {
        this.operationsQuantityCounter = operationsQuantityCounter;
    }

    public void insert(String[] array, char operation, double x, double y, double result) {
        int availableIndex;

        if (isFull()) {
            removeLastElement(array);
            this.setOperationsQuantityCounter(this.getOperationsQuantityCounter() - 1);
        }

        availableIndex = getAvailablePosition();

        String formattedString = String.format("%.2f %c %.2f = %.2f", x, operation, y, result);

        array[availableIndex] = formattedString;
        this.setOperationsQuantityCounter(this.getOperationsQuantityCounter() + 1);
        incrementOperation(operation);
    }

    private int getAvailablePosition() {
        if (this.getOperationsQuantityCounter() < this.getHistorySize()) {
            return this.getOperationsQuantityCounter();
        }

        return this.getOperationsQuantityCounter() - 1;
    }

    private boolean isFull() {
        return this.getOperationsQuantityCounter() == this.getHistorySize();
    }

    private void removeLastElement(String[] array) {
        for (int index = 0; index < array.length - 1; index++) array[index] = array[index + 1];

        array[array.length - 1] = null;
    }

    private void incrementOperation(char operation) {
        switch (operation) {
            case '+':
                this.operationsQuantity[0]++;
                break;
            case '-':
                this.operationsQuantity[1]++;
                break;
            case '*':
                this.operationsQuantity[2]++;
                break;
            case '/':
                this.operationsQuantity[3]++;
                break;
            default:
                break;
        }
    }

    @Override
    public String toString() {
        String formattedString = "Operations History: \n";

        for (int index = 0; index < this.getOperationsQuantityCounter(); index++)
            formattedString += this.operationsHistory[index] + "\n";

        formattedString += "\n Operations Quantity: \n";

        for (int index = 0; index < this.getOperationsQuantity().length; index++)
            formattedString += "\'" + this.operationsCharacters[index] + "\' : " + this.operationsQuantity[index] + "\n";

        return formattedString;
    }
}