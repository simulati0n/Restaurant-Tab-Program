public class Orders {

  // Stores menu item IDs for all orders
  private String[] ordered_items;

  // Only to be used by iterator methods
  private int current_index = 0;

  // Constructor
  public Orders(int max_num_orders) {
  // ------------------------------------------------------
  // Initalizes item_numbers array to size max_num_orders
  // and initializes to all nulls.
  // ------------------------------------------------------
  // (to complete)
    ordered_items = new String [max_num_orders];
  }

  // Method
  public int numOrders() {
  // ------------------------------------------------------
  // Returns the current number of ordered items.
  // ------------------------------------------------------
  // (to complete)
    int count = 0;
    for(int i=0; i<ordered_items.length; i++){
      if(ordered_items[i] != null){
        count++;
      }
    }
    return count;
  }

  // Method
  public void add(String item_number) throws NumberOrdersExceededException {
  // ------------------------------------------------------
  // Adds item_number to next available space in array 
  // ordered_items.
  //
  // Throws NumberOrdersExceededException if ordered_items
  // array is full.
  // ------------------------------------------------------
  // (to complete)
    if(numOrders() == ordered_items.length){ //the array is full when the current number of ordered items is same as the length limit.
      throw new NumberOrdersExceededException();
    }

    for(int i=0; i<ordered_items.length; i++){
      if(ordered_items[i] == null){
        ordered_items[i] = item_number;
        break;
      }
    }
    
  }
  
  public void remove(int position){
    position -= 1; //index starts at 0 so we subtract 1 from the passed value to make the user's choice correspond to the index.
    // Shift subsequent orders to fill the gap
    for (int i = position; i < ordered_items.length - 1; i++) {
      ordered_items[i] = ordered_items[i + 1];
    }

    // Set the last element to null to remove the duplicate order
    ordered_items[ordered_items.length - 1] = null;
  }

  // ------------------------------------------------------
  // Iterator Methods
  // ------------------------------------------------------
  // These methods used to iterate over the ordered items.
  // Items may be iterated over multiple times by calling
  // reset to begin at the first menu item again.
  //
  // NOTE: These methods use instance variable current_index
  //       which no other methods should use.
  // ------------------------------------------------------

  public void reset() {
  // ------------------------------------------------------
  // Resets to first ordered item.
  // ------------------------------------------------------
  // (to complete)
    current_index = 0;
  }

  public boolean hasNext() {
  // ------------------------------------------------------
  // Returns true if there exists another ordered item to
  // retrieve. Otherwise, returns false.
  // ------------------------------------------------------
  // (to complete)
    return current_index < ordered_items.length && ordered_items[current_index] != null;
    
  }
  

  public String next() {
  // ------------------------------------------------------
  // Returns next order item in array of ordered items.
  // (Must only be called when hasNext() is true.)
  // ------------------------------------------------------
  // (to complete)
    if(hasNext()){
      return ordered_items[current_index++];
    }
    return null;
  }

}
  
