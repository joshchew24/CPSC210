package model;

public class Order {

    public int ticketNum;
    public String customerName;
    public boolean status;
    public String specialInstructions = "None.";
    public String comboID;
    public double price;

    //EFFECTS: constructs an order with given number and combo ID for the named customer
    public Order(int ticketNum, String comboID, String customerName){
        this.ticketNum = ticketNum;
        this.comboID = comboID;
        this.customerName = customerName;
        autoPrice();
    }

    //MODIFIES: this
    //EFFECTS: gives the kitchen special instructions for the order
    public void giveSpecialInstructions(String specialInstructions){
        this.specialInstructions = specialInstructions;
    }

    //MODIFIES: this
    //EFFECTS: automatically sets the price of the order based on the comboID
    private void autoPrice(){
        switch (comboID) {
            case "A":
                price = 6.90;
                break;
            case "B":
                price = 4.20;
                break;
            case "C":
                price = 1.23;
                break;
            case "D":
                price = 100.00;
                break;
            case "E":
                price = 0.00;
                break;
            default:
                price = 6.66;
        }
    }

    //MODIFIES: this
    //EFFECTS: completes an order and prints the receipt
    public void completed(){
        status = true;
        System.out.println("Ticket Number: " + ticketNum);
        System.out.println(getComboName(comboID) + ": $" + getPrice());
        System.out.println("Enjoy our cock, " + customerName + "!");
    }

    //EFFECTS: returns the name of the given comboID
    public String getComboName(String comboID){
        switch (comboID) {
            case "A":
                return "69 xddddd";
            case "B":
                return "weeeeeeed";
            case "C":
                return "donation LOOOL";
            case "D":
                return "tier 3 simp";
            case "E":
                return "im fucking poor";
            default:
                return "get the fuck out of my store dumb bitch";
        }
    }



    // getters
    public int getTicketNum(){
        return ticketNum;
    }
    public String getCustomerName() {
        return customerName;
    }
    public boolean checkStatus(){
        return status;
    }
    public String getSpecialInstructions(){
        return specialInstructions;
    }

    public String getComboID(){
        return comboID;
    }

    public double getPrice(){
        return price;
    }


}
