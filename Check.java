public class Check {

  private Menu menu;
  private Orders orders;
  private double tax_rate;

  // Constructor
  public Check(Menu menu, Orders orders, double tax_rate) {
  // ------------------------------------------------------
  // Initalizes orders to parameter values passed.
  // ------------------------------------------------------
  // (to complete)
  this.menu = menu;
  this.orders = orders;
  this.tax_rate = tax_rate;
  }

  // Getter Methods
 
  public Orders getOrders() { //
  // ------------------------------------------------------
  // Returns all orders on check.
  // ------------------------------------------------------
  // (to complete)
  
    return orders; 

  }

  public double getTaxRate() {
  // ------------------------------------------------------
  // Returns the tax rate applied on checks.
  // ------------------------------------------------------
  // (to complete)
    return tax_rate;
  }

  // Method
  public double tax() {
  // ------------------------------------------------------
  // Returns the amount of tax for the ordered items.
  // ------------------------------------------------------
  // (to complete)
  return subtotal() * getTaxRate();
  

  }

  // Method
  public double subtotal() {
  // ------------------------------------------------------
  // Returns total cost of orders on check (excluding tax).
  // ------------------------------------------------------
  // (to complete)
    double total = 0;
    orders.reset();
    while(orders.hasNext()){
      String itemID = orders.next();
      MenuItem menuItem = menu.getMenuItemByID(itemID);
      if(menuItem != null){
        total += Double.valueOf(menuItem.getPrice());
      }

    }
    
    return total;

  }

  // Method
  public double total() {
  // ------------------------------------------------------
  // Returns total cost of orders on check (including tax).
  // ------------------------------------------------------
  // (to complete)
    return subtotal() + tax();
  }

  public double compute_tip(int percent) {
  // ------------------------------------------------------
  // Returns the tip amount for percent given on pre-tax
  // total of the check.
  // ------------------------------------------------------
  // (to complete)
    return subtotal() * (1.0*percent/100);
  }
  
}