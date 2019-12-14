public class FoodItem
{
    private String _name;
    private long _catalogueNumber;
    private int _quantity;
    private Date _productionDate;
    private Date _expiryDate;
    private int _minTemperature;
    private int _maxTemperature;
    private int _price;

    private final int ZERO = 0;
    private final int ONE = 1;
    private final String ITEM = "item";
    private final int DEFAULT_HIGHEST_NUM = 9999;

    //constructors:

    /**
     * creates a new Date object
     *
     * @param name name of the product
     * @param catalogueNumber serial number of the product
     * @param quantity the quantity of the product
     * @param productionDate the production date of the product
     * @param expiryDate the expiry date of the product
     * @param minTemperature the minimum storage temperature
     * @param maxTemperature the maximum storage temperature
     * @param price the price of the product
     */
    public FoodItem (String name, long catalogueNumber, int quantity, Date productionDate, Date expiryDate, int minTemperature, int maxTemperature, int price)
    {
        if(expiryDate.before(productionDate))
        {
            _expiryDate  = productionDate.tomorrow();
            _productionDate = productionDate;
        }else{
            _expiryDate  = expiryDate;
            _productionDate = productionDate;
        }

        if(minTemperature!=ZERO && maxTemperature!=ZERO && minTemperature > maxTemperature )
        {
            int d = minTemperature;
            _maxTemperature = d;
            _minTemperature = maxTemperature;
        }else{
            _maxTemperature = maxTemperature;
            _minTemperature = minTemperature;
        }

        if(name == null || name.equals(""))
        {
            _name = ITEM;
        }else{
            _name = name;
        }

        if(catalogueNumber >= 1000 && catalogueNumber <= DEFAULT_HIGHEST_NUM)
        {
            _catalogueNumber = catalogueNumber;
        }else{
            _catalogueNumber = DEFAULT_HIGHEST_NUM;
        }

        if(quantity < ZERO)
        {
            _quantity = ZERO;
        }else{
            _quantity = quantity;
        }

        if(price <= ZERO)
        {
            _price = ONE;
        }else{
            _price = price;
        }

    }

    /**
     * Copy Constructor
     *
     * @param other other FoodItem  to be copied
     */
    public FoodItem ( FoodItem other)
    {
        _catalogueNumber = other._catalogueNumber;
        _name = other._name;
        _quantity = other._quantity;
        _productionDate = new Date(other._productionDate);
        _expiryDate = new Date(other._expiryDate);
        _minTemperature = other._minTemperature;
        _maxTemperature = other._maxTemperature;
        _price = other._price;
    }

    /**
     *  gets the catalogue number 
     *  @return the catalogue number
     */
    public long getCatalogueNumber()
    {
        return _catalogueNumber;
    }

    /**
     * gets the quantity 
     * @return the quantity
     */
    public int getQuantity()
    {
        return _quantity;
    }

    /**
     * gets the production date 
     * @return the production date
     */
    public Date getProductionDate()
    {
        return _productionDate;
    }

    /**
     * gets the expiry date
     * @return the expiry date
     */
    public Date getExpiryDate()
    {
        return _expiryDate;
    }

    /**
     * gets the minimum storage temperature 
     * @return the minimum storage temperature
     */
    public int getMinTemperature()
    {
        return _minTemperature;
    }

    /**
     * gets the maximum storage temperature
     * @return the maximum storage temperature
     */
    public int getMaxTemperature()
    {
        return _maxTemperature;
    }

    /**
     * gets the unit price 
     * @return the unit price
     */
    public int getPrice()
    {
        return _price;
    }

    /**
     * gets the name 
     * @return the name
     */
    public String getName()
    {
        return _name;
    }

    /**
     * set the quantity (only if not negative) 
     * 
     */
    public void setQuantity(int n)
    {
        if(n < ZERO)
        {
            _quantity = ZERO;
        }
        else 
        {
            _quantity = n;
        }
    }

    /**
     * set the production date (only if not after expiry date ) 
     */
    public void setProductionDate(Date d)
    {
        _productionDate = d;
    }

    /**
     * set the expiry date (only if not before production date ) 
     */
    public void setExpiryDate(Date d)
    {
        _expiryDate = d;
    }

    /**
     * set the price (only if positive) 
     */
    public void setPrice(int n)
    {
        if(n <= ZERO)
        {
            _price = ONE;
        }else{
            _price = n;
        }
    }  

    /**
     * check if 2 food items are the same (excluding the quantity values)
     * @param other - the food item to compare this food item to
     * @return true if the food items are the same
     */
    public boolean equals (FoodItem other)
    {
        return(_name.equals(other._name) && 
            _catalogueNumber == other._catalogueNumber && 
            _productionDate.equals(other._productionDate) &&
            _expiryDate.equals(other._expiryDate) &&
            _minTemperature == other._minTemperature &&
            _maxTemperature == other._maxTemperature &&
            _price == other._price);

    }

    /**
     * check if this food item is fresh on the date d 
     * @param d - date to check
     * @return true if this food item is fresh on the date d
     */
    public boolean isFresh(Date d)
    {
        return (_productionDate.before(d));
    }

    /**
     * returns String that represents this food item
     * 
     * @retrun
     * String that represents this food item in the following format:
     * FoodItem: milk CatalogueNumber: 1234 ProductionDate: 14/12/2019 ExpiryDate: 21/12/2019 Quantity: 3
     * 
     * 
     */
    public String toString()
    {
        return ("FoodItem: "+getName()+
            "CatalogueNumber: "+getCatalogueNumber()+
            "\t"+"ProductionDate: "+getProductionDate()+
            "\n\t"+"ExpiryDate: "+getExpiryDate()+
            "Quantity: " +getQuantity()); 
    }

    /**
     * check if this food item is older than other food item 
     * @param other - food item to compare this food item to
     * @return true if this food item is older than other date
     */
    public boolean olderFoodItem(FoodItem other)
    {
        return (_productionDate.before(other._productionDate));
    }

    /**
     * @param amount - amount to purchase
     * @return the number of units of products that can be purchased for a given amount 
     */

    public int howManyItems(int amount)   
    {   
        final int result = amount/_price;

        if(_quantity >= result){
            return result;
        }return _quantity;

    }

    /**
     * check if this food item is cheaper than other food item 
     * @param other - food item to compare this food item to
     * @return true if this food item is cheaper than other date
     */
    public boolean isCheaper(FoodItem other)
    {
        return (_price < other._price);
    }

}
