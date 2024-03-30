
public class Menu {
  
  private MenuItem[] menu_items;
  
  private int current_index = 0; // to only be used by
                                 // iterator methods below
  // Constructor
  public Menu() {
  // -----------------------------------------------------------
  // Creates and initializes menu_items array to size 10 with
  // all nulls.
  // -----------------------------------------------------------
  // (to complete)
  menu_items = new MenuItem[10];
  }

  // Method
  public int numItems() {
  // -----------------------------------------------------------
  // Returns the current number of items in the menu.
  // -----------------------------------------------------------
  // (to complete)
    int count = 0;
    for(int i=0; i<menu_items.length; i++){
      if(menu_items[i] != null){
        count++;
      }
    }
    return count;

  }

  // Method
  public void add(MenuItem menu_item) {
  // -----------------------------------------------------------
  // Adds menu item to next available space in array menu_items.
  //
  // Throws NumberMenuItemsExceededException if menu_items array
  // is full.
  // -----------------------------------------------------------
  // (to complete)
    // if(numItems() == menu_items.length){
    //   throw new NumberMenuItemsExceededException();
    // }

    for(int i=0; i<menu_items.length; i++){
      if(menu_items[i] == null){
        menu_items[i] = menu_item;
        break;
      }
    }

}

  // Method
  public MenuItem getMenuItemByListing(int n) throws MenuItemNotFoundException {
  // -----------------------------------------------------------
  // Returns nth MenuItem (object) from the listed menu items.
  //
  // Throws MenuItemNotFoundException if n is outside the
  // range of 1..numItems().
  // -----------------------------------------------------------
  // (to complete)
  
    n-=1; //user choices start at 1 but indexes start at 0, so decrement the parameter to make the choice equivalent to the index position.
    if(n >=0 && n < numItems()){ //Check if n is in range of numItems():
      return menu_items[n];
    }else{
      throw new MenuItemNotFoundException();
    }

  }


  // Method
  public MenuItem getMenuItemByID(String item_ID) throws MenuItemNotFoundException {
  // -----------------------------------------------------------
  // Returns MenuItem (object) for given item_ID.
  //
  // Throws MenuItemNotFoundException if menu item with item_ID
  // not found.
  // -----------------------------------------------------------
  // (to complete)
  boolean notFound = true;
  MenuItem item = null;

    for(int i=0; i<menu_items.length; i++){
      if(menu_items[i] != null){
        if(menu_items[i].getItemID().equals(item_ID)){
          item = menu_items[i];
          notFound = false;
          break;
        }
      }
    }
    
    if(notFound){
      throw new MenuItemNotFoundException();
    }else{
      return item;
    }

  }

  // -----------------------------------------------------------
  // Iterator Methods
  // -----------------------------------------------------------
  // These methods are used to iterate over the menu items.
  // Items may be iterated over multiple times by calling reset
  // to begin at the first menu item again.
  //
  // NOTE: These methods use instance variable current_index
  //       which no other methods should use.
  // -----------------------------------------------------------
  
  public void reset() {
  // -----------------------------------------------------------
  // Resets to first order of list of menu items.
  // -----------------------------------------------------------
  // (to complete)
    current_index=0;
  }

  public boolean hasNext() {
  // -----------------------------------------------------------
  // Returns true if there exists another menu item to retrieve.
  // Otherwise, returns false.
  // -----------------------------------------------------------
  // (to complete)
    
    return current_index < menu_items.length && menu_items[current_index] != null;
  }
  
  public MenuItem next() {
  // -----------------------------------------------------------
  // Returns next menu item in list of menu items.
  // (Must only be called when hasNext() is true.)
  // -----------------------------------------------------------
  // (to complete)
    if(hasNext()){
      return menu_items[current_index++];
    }else{
      return null;
    }
  }
  
}