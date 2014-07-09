package com.paynova.api.client.model;

import java.math.BigDecimal;


public class LineItem extends ApiPropertyContainer {
	
	private String id;
	
	private String articleNumber;
	
	private String name;
	
	private String description;
	
	private String productUrl;
	
	private float quantity;
	
	private String unitMeasure;
	
	private BigDecimal unitAmountExcludingTax;
	
	private float taxPercent;
	
	private BigDecimal totalLineTaxAmount;
	
	private BigDecimal totalLineAmount;
	
	private String lineItemGroupKey;
	
	private TravelData travelData;
    
	/**
	 * Class constructor.
	 * @param id	the id for this line item. This value must be unique per collection of line items.
	 * @param articleNumber		the article/product number for the item being sold. Validation: Minimum 
	 * length = 1, Maximum length = 50
	 * @param name	the name of the item being sold. Validation: Minimum length = 1, Maximum length = 255
	 * @param quantity	the number of items being sold at this price.
	 * @param unitMeasure	the unit of measure of the product/service being sold. Example Values: meters, 
	 * pieces, st., ea.
	 * @param unitAmountExcludingTax	the price of each unit, excluding tax.
	 * @param taxPercent	the tax/VAT percentage for the item being sold.
	 * @param totalLineTaxAmount	the total tax/VAT amount charged for this line.
	 * @param totalLineAmount	the total amount charged for this line, including tax/VAT (quantity * unitAmountExcludingTax + calculated tax).
	 */
	public LineItem(String id, String articleNumber, String name, float quantity, 
			String unitMeasure, BigDecimal unitAmountExcludingTax, float taxPercent, 
			BigDecimal totalLineTaxAmount, BigDecimal totalLineAmount) {
		setId(id);
		setArticleNumber(articleNumber);
		setName(name);
		setQuantity(quantity);
		setUnitMeasure(unitMeasure);
		setUnitAmountExcludingTax(unitAmountExcludingTax);
		setTaxPercent(taxPercent);
		setTotalLineTaxAmount(totalLineTaxAmount);
		setTotalLineAmount(totalLineAmount);
		
	}
	
	/**
	 * 
	 * @return the id for this LineItem
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * The id for this line item. This value must be unique per collection of line items.
	 * @param id
	 * @return the current LineItem object
	 */
	public LineItem setId(String id) {
		this.id = id;
		return this;
	}
	
	/**
	 * 
	 * @return the article article number of this LineItem
	 */
	public String getArticleNumber() {
		return articleNumber;
	}
	
	/**
	 * The article/product number for the item being sold. Validation: Minimum length = 1, 
	 * Maximum length = 50
	 * @param articleNumber
	 * @return the current LineItem object
	 */
	public LineItem setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber;
		return this;
	}
	
	/**
	 * 
	 * @return the name of this LineItem
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * The name of the item being sold. Validation: Minimum length = 1, Maximum length = 255
	 * @param name
	 * @return the current LineItem object
	 */
	public LineItem setName(String name) {
		this.name = name;
		return this;
	}
	
	/**
	 * 
	 * @return the description of this LineItem
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * The description of the item being sold. Validation: Minimum length (when present) = 1, 
	 * Maximum length = 255
	 * @param description
	 * @return the current LineItem object
	 */
	public LineItem setDescription(String description) {
		this.description = description;
		return this;
	}
	
	/**
	 * 
	 * @return the url to this LineItem
	 */
	public String getProductUrl() {
		return productUrl;
	}
	
	/**
	 * The URL on your website to the item being sold.
	 * @param productUrl
	 * @return the current LineItem object
	 */
	public LineItem setProductUrl(String productUrl) {
		this.productUrl = productUrl;
		return this;
	}
	
	/**
	 * 
	 * @return the quantity of this LineItem
	 */
	public float getQuantity() {
		return quantity;
	}

	/**
	 * The number of items being sold at this price.
	 * @param quantity
	 * @return the current LineItem object
	 */
	public LineItem setQuantity(float quantity) {
		this.quantity = quantity;
		return this;
	}
	
	/**
	 * 
	 * @return the unit measure of this LineItem
	 */
	public String getUnitMeasure() {
		return unitMeasure;
	}
	
	/**
	 * The unit of measure of the product/service being sold. Example Values: meters, 
	 * pieces, st., ea.
	 * @param unitMeasure
	 * @return the current LineItem object
	 */
	public LineItem setUnitMeasure(String unitMeasure) {
		this.unitMeasure = unitMeasure;
		return this;
	}
	
	/**
	 * 
	 * @return the price per unit of this LineItem
	 */
	public BigDecimal getUnitAmountExcludingTax() {
		return unitAmountExcludingTax;
	}

	/**
	 * The price of each unit, excluding tax.
	 * @param unitAmountExcludingTax
	 * @return the current LineItem object
	 */
	public LineItem setUnitAmountExcludingTax(BigDecimal unitAmountExcludingTax) {
		this.unitAmountExcludingTax = unitAmountExcludingTax;
		return this;
	}
	
	/**
	 * 
	 * @return the tax/VAT percent for this LineItem
	 */
	public float getTaxPercent() {
		return taxPercent;
	}
	
	/**
	 * The tax/VAT percentage for the item being sold.
	 * @param taxPercent
	 * @return the current LineItem object
	 */
	public LineItem setTaxPercent(float taxPercent) {
		this.taxPercent = taxPercent;
		return this;
	}
	
	/**
	 * 
	 * @return the total tax/VAT amount
	 */
	public BigDecimal getTotalLineTaxAmount() {
		return totalLineTaxAmount;
	}
	
	/**
	 * The total tax/VAT amount charged for this line.
	 * @param totalLineTaxAmount
	 * @return the current LineItem object
	 */
	public LineItem setTotalLineTaxAmount(BigDecimal totalLineTaxAmount) {
		this.totalLineTaxAmount = totalLineTaxAmount;
		return this;
	}
	
	/**
	 * 
	 * @return the total amount of this LineItem
	 */
	public BigDecimal getTotalLineAmount() {
		return totalLineAmount;
	}

	/**
	 * The total amount charged for this line, including tax/VAT 
	 * (quantity * unitAmountExcludingTax + calculated tax).
	 * @param totalLineAmount
	 * @return the current LineItem object
	 */
	public LineItem setTotalLineAmount(BigDecimal totalLineAmount) {
		this.totalLineAmount = totalLineAmount;
		return this;
	}
	
	/**
	 * 
	 * @return the group key for this LineItem
	 */
	public String getLineItemGroupKey() {
		return lineItemGroupKey;
	}

	/**
	 * A key/label on this LineItem, the LineItems will be sorted according to the key
	 * in the payment window (if LineItems are set to be shown). The enum LineItemGroupKey contains
	 * predefined constants that can be used, these are also translated to the user language.
	 * @param lineItemGroupKey
	 * @return the current LineItem object
	 */
	public LineItem setLineItemGroupKey(LineItemGroupKey lineItemGroupKey) {
		this.lineItemGroupKey = lineItemGroupKey.toString();
		return this;
	}
	
	/**
	 * See {@link #setLineItemGroupKey(LineItemGroupKey) setLineItemGroupKey}
	 * If you send in your own key make sure it is the correct user language.
	 * @param lineItemGroupKey
	 * @return the current LineItem object
	 */
	public LineItem setLineItemGroupKey(String lineItemGroupKey) {
		this.lineItemGroupKey = lineItemGroupKey;
		return this;
	}
	
	/**
	 * 
	 * @return the travel data of this LineItem
	 */
	public TravelData getTravelData() {
		return travelData;
	}

	/**
	 * Travel information, if this line item is related to a booking-of-travel. 
	 * Due to the complexity and industry-specific nature of this element it's 
	 * description is not included on this page. If you would like to provide 
	 * this information, please review the TravelData service type 
	 * description for details.
	 * @param travelData
	 * @return the current LineItem object
	 */
	public LineItem setTravelData(TravelData travelData) {
		this.travelData = travelData;
		return this;
	}
}
